package ar.edu.ucc.pa.service.dao;

import java.util.HashMap;
import java.util.List;
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
	
	
	public Telefono getTelefonoByNumberHql(String number) {
		
		
		// SIN PARAMETROS 
		//String hql = "from Telefono where numero = '" + number + "'";
		//List<Telefono> telefonos = this.executeQuery(hql);
		
		// CON PARAMETROS
		String hql = "from Telefono where numero = :number";
		Map<String, Object> hqlParam = new HashMap<String, Object>();
		hqlParam.put("number", number);
		List<Telefono> telefonos = this.executeQuery(hql, hqlParam);
		
		if (telefonos.size() > 0){
			return telefonos.get(0);
		} else {
			return new Telefono();
		}
	}

	
	@Override
	public Telefono load(Long key) {
		// TODO Auto-generated method stub
		System.out.println("Sobrescritura");
		return null;
	}	
}
