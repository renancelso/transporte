package br.com.transporteweb.service;

import br.com.transporteweb.control.dto.CalculoCustosDTO;
import br.com.transporteweb.model.Veiculo;
import br.com.transporteweb.model.Via;
import br.com.transporteweb.padrao.GenericServiceInterface;
import java.util.List;
import javax.ejb.Local;

@Local
public abstract interface CalculoCustosServiceLocal extends GenericServiceInterface {
	public CalculoCustosDTO calcularCustos(List<Via> listasVias, Veiculo veiculoUtilizado, Integer cargaTransportada);
}