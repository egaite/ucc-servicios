package ar.edu.ucc.pa.service.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.pa.service.model.TipoDocumento;
import ar.edu.ucc.pa.service.model.Usuario;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/app-context.xml",
		"file:src/main/resources/hibernate-context.xml" })
public class UsuarioDaoTest {

	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	GenericDao<Usuario, Long> usuarioDao;

	Usuario usuarioTest;

	@Before
	public void init() {
		log.info("Inicializando Test de Usuario DAO");
		usuarioTest = new Usuario();
		usuarioTest.setApellido("Apellido Test");
		usuarioTest.setNombre("Nombre Test");
		usuarioTest.setDocumento("111111111");
		usuarioTest.setEmail("test@gmail.com");
		usuarioTest.setTipoDocumento(TipoDocumento.PASAPORTE);
	}

	@Transactional
	@Test
	public void insert() {
		log.info("Starting insert DAO Test .... ");
		usuarioDao.add(usuarioTest);
	}

	@Transactional
	@Test
	public void getUsuarios() {

		log.info("Starting getUsuarios DAO Test .... ");
		usuarioDao.add(usuarioTest);
		
		List<Usuario> clientes = usuarioDao.getAll();
		log.info("Size: " + clientes.size());

		Assert.assertEquals(1, clientes.size());
		log.info("finishing getUsuarios DAO Test ..... ");
	}

}
