package ar.edu.ucc.pa.service.service;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.pa.service.dto.UsuarioDto;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/resources/app-context.xml",
		"file:src/main/resources/hibernate-context.xml" })

public class UsuarioServiceTest {
	
	
	private Logger log = Logger.getLogger(this.getClass());

	@Autowired
	UsuarioService usuarioService;

	UsuarioDto usuarioDto;

	@Before
	public void init() {
		log.info("Inicializando Test de Usuario Service");
		usuarioDto = new UsuarioDto();
		
		usuarioDto.setApellido("aaaaaaaaaa");
		usuarioDto.setDocumento("222222222");
		usuarioDto.setTipoDocumento("PASAPORTE");
		usuarioDto.setEmail("email");
		usuarioDto.setNombre("Nombre");
		
	}

	@Transactional
	@Test
	public void agregarUsuario() {
		log.info("Starting insert Service Test .... ");
		usuarioDto = usuarioService.agregarUsuario(usuarioDto);
		log.info("ID" + usuarioDto.getId());
		Assert.assertNotNull(usuarioDto.getId());
	}
	
	

}
