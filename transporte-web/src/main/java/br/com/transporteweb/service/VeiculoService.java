package br.com.transporteweb.service;

import br.com.transporteweb.padrao.GenericService;
import javax.ejb.Stateless;

@Stateless
public class VeiculoService extends GenericService implements VeiculoServiceLocal {
	private static final long serialVersionUID = -8395865190972327944L;

	public VeiculoService() {
	}
}