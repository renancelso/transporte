package br.com.transporteweb.control;

import br.com.transporteweb.control.dto.CalculoCustosDTO;
import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import br.com.transporteweb.padrao.BaseControl;
import br.com.transporteweb.service.CalculoCustosServiceLocal;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean(name = "calculoCustosControl")
@ViewScoped
public class CalculoCustosControl extends BaseControl {
	private static final long serialVersionUID = -8538482750406234881L;
	@EJB
	private CalculoCustosServiceLocal calculoCustosService;
	private Veiculo veiculoUtilizado;
	private Integer cargaTransportada;
	private List<Via> listasVias;
	private List<Veiculo> listaVeiculos;
	private List<CalculoCustosDTO> listaCalculoCustosDTO;
	private CalculoCustosDTO calculoCustosDTO;
		
	@SuppressWarnings("unchecked")
	@PostConstruct
	public void init() {
		listaCalculoCustosDTO = new ArrayList<>();
		calculoCustosDTO = new CalculoCustosDTO();
		cargaTransportada = null;
		veiculoUtilizado = new Veiculo();

		setListasVias(new ArrayList<Via>());
		setListasVias((List<Via>) calculoCustosService.consultarTodos(Via.class));

		setListaVeiculos(new ArrayList<Veiculo>());
		setListaVeiculos((List<Veiculo>) calculoCustosService.consultarTodos(Veiculo.class," order by o.tipoVeiculo asc "));
	}

	public String calcularCustos() {
		listaCalculoCustosDTO = new ArrayList<>();
		calculoCustosDTO = new CalculoCustosDTO();
		
		if(listasVias == null || listasVias.isEmpty()){
			addErrorMessage("Informe pelo menos uma via percorrida");	
			return null;
		}
		
		if(veiculoUtilizado == null){
			addErrorMessage("Informe um veículo utilizado");	
			return null;
		}
		
		if(cargaTransportada == null){
			addErrorMessage("Informe a carga transportada");	
			return null;
		}		

		calculoCustosDTO = calculoCustosService.calcularCustos(listasVias, veiculoUtilizado, cargaTransportada);

		listaCalculoCustosDTO.add(calculoCustosDTO);	

		return null;
	}

	public Veiculo getVeiculoUtilizado() {
		return veiculoUtilizado;
	}

	public void setVeiculoUtilizado(Veiculo veiculoUtilizado) {
		this.veiculoUtilizado = veiculoUtilizado;
	}

	public Integer getCargaTransportada() {
		return cargaTransportada;
	}

	public void setCargaTransportada(Integer cargaTransportada) {
		this.cargaTransportada = cargaTransportada;
	}

	public List<Via> getListasVias() {
		return listasVias;
	}

	public void setListasVias(List<Via> listasVias) {
		this.listasVias = listasVias;
	}

	public List<Veiculo> getListaVeiculos() {
		return listaVeiculos;
	}

	public void setListaVeiculos(List<Veiculo> listaVeiculos) {
		this.listaVeiculos = listaVeiculos;
	}

	public List<CalculoCustosDTO> getListaCalculoCustosDTO() {
		return listaCalculoCustosDTO;
	}

	public void setListaCalculoCustosDTO(List<CalculoCustosDTO> listaCalculoCustosDTO) {
		this.listaCalculoCustosDTO = listaCalculoCustosDTO;
	}

	public CalculoCustosDTO getCalculoCustosDTO() {
		return calculoCustosDTO;
	}

	public void setCalculoCustosDTO(CalculoCustosDTO calculoCustosDTO) {
		this.calculoCustosDTO = calculoCustosDTO;
	}
}