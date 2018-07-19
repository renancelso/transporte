package br.com.transporteweb.service.calculos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import br.com.transporteweb.control.dto.CalculoCustosDTO;
import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;

public class CalculoCustos implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2314956881588307609L;

	public CalculoCustosDTO calcularCustos(List<Via> listaVias, Veiculo veiculoUtilizado, Integer cargaTransportada) {
		CalculoCustosDTO calculoCustosDTO = new CalculoCustosDTO();

		Double custoTransporte = 0.0;
		
		for (Via via : listaVias) {
			
			if(via.getDistanciaPercorrida() == null){
				via.setDistanciaPercorrida(Long.valueOf(0));					
			}
			
			Double custoVia = via.getDistanciaPercorrida() == null ? 0.0 : via.getDistanciaPercorrida()
							   * via.getCustoKM() * veiculoUtilizado.getFator();
			
			custoTransporte += custoVia.doubleValue();
			
			if (cargaTransportada.intValue() > 5) {
				Integer excedente = Integer.valueOf(cargaTransportada.intValue() - 5);
				for (int i = 1; i <= excedente.intValue(); i++) {
					custoTransporte += 0.02 * via.getDistanciaPercorrida();
				}
			}
			
		}

		calculoCustosDTO.setListaVias(new ArrayList<Via>());
		calculoCustosDTO.setListaVias(listaVias);
		calculoCustosDTO.setVeiculoUtilizado(veiculoUtilizado);
		calculoCustosDTO.setCargaTransportada(cargaTransportada);
		calculoCustosDTO.setCustoTransporte(custoTransporte);

		return calculoCustosDTO;
	}
	
}
