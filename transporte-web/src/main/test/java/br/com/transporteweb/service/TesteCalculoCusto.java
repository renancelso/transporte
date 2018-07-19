package br.com.transporteweb.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.jboss.arquillian.junit.Arquillian;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import br.com.transporteweb.service.calculos.CalculoCustos;

@RunWith(Arquillian.class)
public class TesteCalculoCusto {		
	
	@Test
	public final void testCalcularCustos() {
		List<Via> listasVias = new ArrayList<Via>();

		Via viaPavimentada = new Via();
		viaPavimentada.setId(Long.valueOf(1));
		viaPavimentada.setTipoVia("Via pavimentada");
		viaPavimentada.setCustoKM(0.54);
		viaPavimentada.setDistanciaPercorrida(Long.valueOf(80));
		listasVias.add(viaPavimentada);		
		
		Via viaNaoPavimentada = new Via();
		viaNaoPavimentada.setId(Long.valueOf(2));
		viaNaoPavimentada.setTipoVia("Via não-pavimentada");
		viaNaoPavimentada.setCustoKM(0.62);
		viaNaoPavimentada.setDistanciaPercorrida(Long.valueOf(20));
		
		listasVias.add(viaNaoPavimentada);

		Veiculo veiculoUtilizado = new Veiculo();
		veiculoUtilizado.setId(Long.valueOf(1));
		veiculoUtilizado.setTipoVeiculo("Caminhão baú");
		veiculoUtilizado.setFator(1.00);

		Integer cargaTransportada = 6;

		Double valorEsperado = 57.60;

		CalculoCustos calculo = new CalculoCustos();
		assertEquals(valorEsperado, calculo.calcularCustos(listasVias, 
													  	   veiculoUtilizado, 
													  	   cargaTransportada).getCustoTransporte());		
	}

}
