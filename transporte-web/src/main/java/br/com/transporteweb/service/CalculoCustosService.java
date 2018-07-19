package br.com.transporteweb.service;

import java.util.List;

import javax.ejb.Stateless;

import br.com.transporteweb.control.dto.CalculoCustosDTO;
import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import br.com.transporteweb.padrao.GenericService;
import br.com.transporteweb.service.calculos.CalculoCustos;

@Stateless
public class CalculoCustosService extends GenericService implements CalculoCustosServiceLocal {
	private static final long serialVersionUID = -4662964465441955320L;
	
	public CalculoCustosDTO calcularCustos(List<Via> listaVias, Veiculo veiculoUtilizado, Integer cargaTransportada) {
		CalculoCustos calculo = new CalculoCustos();		
		return calculo.calcularCustos(listaVias, veiculoUtilizado, cargaTransportada);
	}
}
