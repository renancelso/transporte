package br.com.transporteweb.service;

import br.com.transporteweb.control.dto.CalculoCustosDTO;
import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import br.com.transporteweb.padrao.GenericService;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

@Stateless
public class CalculoCustosService extends GenericService implements CalculoCustosServiceLocal {
	private static final long serialVersionUID = -4662964465441955320L;
	
	public CalculoCustosDTO calcularCustos(List<Via> listaVias, Veiculo veiculoUtilizado, Integer cargaTransportada) {
		CalculoCustosDTO calculoCustosDTO = new CalculoCustosDTO();

		Double custoTransporte = 0.0;
		
		for (Via via : listaVias) {
			Double custoVia = via.getDistanciaPercorrida() * via.getCustoKM() * veiculoUtilizado.getFator();
			
			custoTransporte = Double.valueOf(custoTransporte.doubleValue() + custoVia.doubleValue());
			
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
