package ar.edu.ucc.pa.service.dao;

import static org.junit.Assert.assertEquals;

import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.pa.service.model.Telefono;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/app-context.xml",
		"file:src/main/resources/hibernate-context.xml" })
public class TelefonoDaoTest {
	
	private Logger log = Logger.getLogger(this.getClass());

	
	@Autowired
	ITelefonoDao telDao;


	
	@Transactional
	@Test
	public void getTelefonoByNumber() {

		log.info("Starting Telefono DAO Test .... ");
		
		Telefono telefono = telDao.getTelefonoByNumber("34567777");
		
		assertEquals(1, telefono.getNumero());
	}
	
}
