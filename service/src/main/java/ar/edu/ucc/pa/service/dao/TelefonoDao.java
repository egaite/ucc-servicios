package ar.edu.ucc.pa.service.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import ar.edu.ucc.pa.service.model.Telefono;

@Repository(value="telDao")
public class TelefonoDao extends GenericDaoImp<Telefono, Long> implements ITelefonoDao{

	public Telefono getTelefonoByNumber(String number) {
		
		Map<String, Object> properties = new HashMap<String, Object>();
		properties.put("numero", number);
		
		return this.getByProperties(properties).get(0);
	}
}
