package br.com.transporteweb.control.dto;

import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import java.io.Serializable;
import java.util.List;

public class CalculoCustosDTO implements Serializable {
	
	private static final long serialVersionUID = -8359382139237445869L;
	
	private List<Via> listaVias;
	private Veiculo veiculoUtilizado;
	private Integer cargaTransportada;
	private Double custoTransporte;

	public List<Via> getListaVias() {
		return listaVias;
	}

	public void setListaVias(List<Via> listaVias) {
		this.listaVias = listaVias;
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

	public Double getCustoTransporte() {
		return custoTransporte;
	}

	public void setCustoTransporte(Double custoTransporte) {
		this.custoTransporte = custoTransporte;
	}
}