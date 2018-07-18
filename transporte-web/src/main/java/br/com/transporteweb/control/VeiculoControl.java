package br.com.transporteweb.control;

import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.padrao.BaseControl;
import br.com.transporteweb.service.VeiculoServiceLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "veiculoControl")
@ViewScoped
public class VeiculoControl extends BaseControl {
	private static final long serialVersionUID = -8283118125526273167L;
	@EJB
	private VeiculoServiceLocal veiculoService;
	private List<Veiculo> listaVeiculos;
	private Long idVeiculo;
	private String tipoVeiculo;
	private Double fatorVeiculo;
	private Veiculo veiculoSelecionado;

	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		veiculoSelecionado = new Veiculo();
		idVeiculo = null;
		tipoVeiculo = null;
		fatorVeiculo = null;
		setListaVeiculos(new ArrayList<Veiculo>());
		setListaVeiculos((List<Veiculo>) veiculoService.consultarTodos(Veiculo.class));
	}

	public String cadastrarVeiculo() {
		veiculoSelecionado = new Veiculo();
		veiculoSelecionado.setTipoVeiculo(tipoVeiculo);
		veiculoSelecionado.setFator(fatorVeiculo);

		if ((veiculoSelecionado.getFator() == null) || (veiculoSelecionado.getFator().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o fator multiplicador do veículo");
			return null;
		}

		if (veiculoSelecionado.getTipoVeiculo() == null) {
			addErrorMessage("Informe o tipo do veículo");
			return null;
		}

		veiculoService.atualizar(veiculoSelecionado);

		addInfoMessage("Veiculo " + veiculoSelecionado.getTipoVeiculo() + " cadastrado com sucesso.");

		init();

		return null;
	}

	public String selecionar() {
		idVeiculo = veiculoSelecionado.getId();
		tipoVeiculo = veiculoSelecionado.getTipoVeiculo();
		fatorVeiculo = veiculoSelecionado.getFator();

		return null;
	}

	public String alterarVeiculo() {
		veiculoSelecionado.setId(idVeiculo);
		veiculoSelecionado.setTipoVeiculo(tipoVeiculo.trim());
		veiculoSelecionado.setFator(fatorVeiculo);

		if ((veiculoSelecionado.getFator() == null) || (veiculoSelecionado.getFator().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o fator multiplicador do veículo");
			return null;
		}

		if (veiculoSelecionado.getTipoVeiculo() == null) {
			addErrorMessage("Informe o tipo do veículo");
			return null;
		}

		veiculoService.atualizar(veiculoSelecionado);

		addInfoMessage("Veículo " + veiculoSelecionado.getTipoVeiculo() + " alterado com sucesso.");

		init();

		return null;
	}

	public String excluirVeiculo() {
		veiculoSelecionado.setId(idVeiculo);
		veiculoSelecionado.setTipoVeiculo(tipoVeiculo.trim());
		veiculoSelecionado.setFator(fatorVeiculo);

		if ((veiculoSelecionado.getFator() == null) || (veiculoSelecionado.getFator().doubleValue() == 0.0D)) {
			addErrorMessage("Informe o fator multiplicador do veículo");
			return null;
		}

		if (veiculoSelecionado.getTipoVeiculo() == null) {
			addErrorMessage("Informe o tipo do veículo");
			return null;
		}

		veiculoService.remover(veiculoSelecionado);

		addInfoMessage("Veículo " + veiculoSelecionado.getTipoVeiculo() + " excluido com sucesso.");

		init();

		return null;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public Long getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Long idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public Double getFatorVeiculo() {
		return fatorVeiculo;
	}

	public void setFatorVeiculo(Double fatorVeiculo) {
		this.fatorVeiculo = fatorVeiculo;
	}

	public Veiculo getVeiculoSelecionado() {
		return veiculoSelecionado;
	}

	public void setVeiculoSelecionado(Veiculo veiculoSelecionado) {
		this.veiculoSelecionado = veiculoSelecionado;
	}
}
