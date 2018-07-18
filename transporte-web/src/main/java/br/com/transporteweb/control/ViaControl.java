package br.com.transporteweb.control;

import br.com.transporteweb.model.Via;
import br.com.transporteweb.padrao.BaseControl;
import br.com.transporteweb.service.ViaServiceLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "viaControl")
@ViewScoped
public class ViaControl extends BaseControl {
	private static final long serialVersionUID = -3921524600766098868L;
	@EJB
	private ViaServiceLocal viaService;
	private List<Via> listaVias;
	private Long idVia;
	private String tipoVia;
	private Double custoKM;
	private Via viaSelecionada;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		viaSelecionada = new Via();
		idVia = null;
		tipoVia = null;
		custoKM = null;
		setListaVias(new ArrayList<Via>());
		setListaVias((List<Via>) viaService.consultarTodos(Via.class));
	}

	public String cadastrarVia() {
		viaSelecionada = new Via();
		viaSelecionada.setTipoVia(tipoVia.trim());
		viaSelecionada.setCustoKM(custoKM);

		if ((viaSelecionada.getCustoKM() == null) || (viaSelecionada.getCustoKM().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o custo do KM rodado.");
			return null;
		}

		if (viaSelecionada.getTipoVia() == null) {
			addErrorMessage("Informe o tipo de via");
			return null;
		}

		viaService.atualizar(viaSelecionada);

		addInfoMessage("Via " + viaSelecionada.getTipoVia() + " cadastrada com sucesso.");

		init();

		return null;
	}

	public String selecionar() {
		idVia = viaSelecionada.getId();
		tipoVia = viaSelecionada.getTipoVia();
		custoKM = viaSelecionada.getCustoKM();

		return null;
	}

	public String alterarVia() {
		viaSelecionada.setId(idVia);
		viaSelecionada.setTipoVia(tipoVia.trim());
		viaSelecionada.setCustoKM(custoKM);

		if ((viaSelecionada.getCustoKM() == null) || (viaSelecionada.getCustoKM().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o custo do KM rodado.");
			return null;
		}

		if (viaSelecionada.getTipoVia() == null) {
			addErrorMessage("Informe o tipo de via");
			return null;
		}

		viaService.atualizar(viaSelecionada);

		addInfoMessage("Via " + viaSelecionada.getTipoVia() + " alterada com sucesso.");

		init();

		return null;
	}

	public String excluirVia() {
		viaSelecionada.setId(idVia);
		viaSelecionada.setTipoVia(tipoVia.trim());
		viaSelecionada.setCustoKM(custoKM);

		if ((viaSelecionada.getCustoKM() == null) || (viaSelecionada.getCustoKM().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o custo do KM rodado.");
			return null;
		}

		if (viaSelecionada.getTipoVia() == null) {
			addErrorMessage("Informe o tipo de via");
			return null;
		}

		viaService.remover(viaSelecionada);

		addInfoMessage("Via " + tipoVia.trim() + " excluída com sucesso.");

		init();

		return null;
	}

	public List<Via> getListaVias() {
		return listaVias;
	}

	public void setListaVias(List<Via> listaVias) {
		this.listaVias = listaVias;
	}

	public Via getViaSelecionada() {
		return viaSelecionada;
	}

	public void setViaSelecionada(Via viaSelecionada) {
		this.viaSelecionada = viaSelecionada;
	}

	public String getTipoVia() {
		return tipoVia;
	}

	public void setTipoVia(String tipoVia) {
		this.tipoVia = tipoVia;
	}

	public Double getCustoKM() {
		return custoKM;
	}

	public void setCustoKM(Double custoKM) {
		this.custoKM = custoKM;
	}

	public Long getIdVia() {
		return idVia;
	}

	public void setIdVia(Long idVia) {
		this.idVia = idVia;
	}
}
