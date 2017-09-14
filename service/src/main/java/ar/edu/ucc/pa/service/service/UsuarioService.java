package ar.edu.ucc.pa.service.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.ucc.pa.service.dao.GenericDao;
import ar.edu.ucc.pa.service.dto.UsuarioDto;
import ar.edu.ucc.pa.service.model.Usuario;
import ar.edu.ucc.pa.service.utils.MappingUtils;

@Service
@Transactional
public class UsuarioService {
	
	@Autowired
	GenericDao<Usuario, Long> daoGenerico;

	public UsuarioDto agregarUsuario(UsuarioDto dto){
		
		Usuario usuario = MappingUtils.translate(dto, Usuario.class);
		
		daoGenerico.add(usuario);
		
		dto.setId(usuario.getId());
		
		return dto;
	}
	
	public UsuarioDto actualizarUsuario(UsuarioDto dto){
		
		if (dto.getId() == null){
			//TODO Aca debería lanzar un error ya que estamos actualizando un Usuario
		}
		
		
        Usuario usuario = daoGenerico.load(dto.getId());
        	
        MappingUtils.translate(dto, usuario);
        daoGenerico.update(usuario);
        
        return dto;
	}
	
	public UsuarioDto buscarPorId(Long id){
		
		Usuario usuario = daoGenerico.load(id);
		UsuarioDto dto = MappingUtils.translate(usuario, UsuarioDto.class);
		
		return dto;
	}
}
