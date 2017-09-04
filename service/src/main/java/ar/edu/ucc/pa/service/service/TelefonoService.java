package ar.edu.ucc.pa.service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.pa.service.dao.GenericDao;
import ar.edu.ucc.pa.service.dao.ITelefonoDao;
import ar.edu.ucc.pa.service.dto.TelefonoDto;
import ar.edu.ucc.pa.service.model.Telefono;
import ar.edu.ucc.pa.service.model.Usuario;
import ar.edu.ucc.pa.service.utils.MappingUtils;

@Service
@Transactional
public class TelefonoService {

	@Autowired
	ITelefonoDao telDao;
	
	@Autowired
	GenericDao<Usuario, Long> daoUsuario;
	

	public TelefonoDto agregarTelefono(TelefonoDto dto){
		
		Usuario usuario = daoUsuario.load(dto.getUsuarioDto().getId());
		Telefono telefono = MappingUtils.translate(dto, Telefono.class);
		
		telefono.setUsuario(usuario);
		
		telDao.add(telefono);
		
		return dto;
	}
	
	public TelefonoDto actualizarSaldo(TelefonoDto dto){
		
		Telefono telefono = telDao.getTelefonoByNumber(dto.getNumero());
		
		telefono.setSaldo(dto.getSaldo());
		
		telDao.saveOrUpdate(telefono);
		
		return dto;
	}
}
