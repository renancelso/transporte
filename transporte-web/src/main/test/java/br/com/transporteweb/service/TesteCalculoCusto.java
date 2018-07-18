package br.com.transporteweb.service;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Test;
import org.junit.runner.RunWith;

import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;

@RunWith(Arquillian.class)
public class TesteCalculoCusto {
	
	@Inject
	private CalculoCustosServiceLocal calculoCustosService;

	@Deployment
	public static JavaArchive createDeployment() {
//		return ShrinkWrap.create(ZipImporter.class, "transporte-web.war")
//				.importFrom(new File("target/transporte-web.war"))
//				.as(WebArchive.class);
		
		JavaArchive jar = ShrinkWrap.create(JavaArchive.class).addClass(CalculoCustosServiceLocal.class)
		        .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
		
		System.out.println(jar.toString(true));
		
		return jar;
	}

	@Test
	public final void testCalcularCustos() {
		List<Via> listasVias = new ArrayList<Via>();

		Via viaPavimentada = new Via();
		viaPavimentada.setId(Long.valueOf(1));
		viaPavimentada.setTipoVia("Via pavimentada");
		viaPavimentada.setCustoKM(0.54);
		viaPavimentada.setDistanciaPercorrida(Long.valueOf(80));

		Via viaNaoPavimentada = new Via();
		viaNaoPavimentada.setId(Long.valueOf(2));
		viaPavimentada.setTipoVia("Via não-pavimentada");
		viaPavimentada.setCustoKM(0.62);
		viaPavimentada.setDistanciaPercorrida(Long.valueOf(20));

		listasVias.add(viaPavimentada);
		listasVias.add(viaNaoPavimentada);

		Veiculo veiculoUtilizado = new Veiculo();
		veiculoUtilizado.setId(Long.valueOf(1));
		veiculoUtilizado.setTipoVeiculo("Caminhão baú");
		veiculoUtilizado.setFator(1.00);

		Integer cargaTransportada = 6;

		Double expected = 57.60;

		assertEquals(expected, calculoCustosService.calcularCustos(listasVias, 
																   veiculoUtilizado, 
																   cargaTransportada).getCustoTransporte());
	}

}
