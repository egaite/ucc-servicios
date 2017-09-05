package ar.edu.ucc.pa.service.dao;

import ar.edu.ucc.pa.service.model.Telefono;

public interface ITelefonoDao extends GenericDao<Telefono, Long>{
	
	public Telefono getTelefonoByNumber(String number);
	
	public Telefono getTelefonoByNumberHql(String number);

}
