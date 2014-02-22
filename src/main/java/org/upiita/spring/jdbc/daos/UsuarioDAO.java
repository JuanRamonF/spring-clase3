package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.upiita.spring.jdbc.entidades.Usuario;

public interface UsuarioDAO {

	public Usuario buscaUsuarioPorId(Integer usuarioId);

	public void crearUsuario(Usuario usuario);
	
	public void updateUsuario(Usuario usuario);
	
	public Usuario buscarPorEmailYPassword(String email, String password);
	
	public List<Usuario> buscaPorNombre(String nombre);

}
