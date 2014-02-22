package org.upiita.spring.jdbc.tests;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.upiita.spring.jdbc.daos.UsuarioDAO;
import org.upiita.spring.jdbc.entidades.Usuario;

public class TestSpringHibernate {

	public static void main(String[] args) {
		//creamos el contexto de Spring
		ApplicationContext contexto = new ClassPathXmlApplicationContext("/contexto.xml");
		UsuarioDAO usuarioDAO = (UsuarioDAO) contexto.getBean("usuarioDAO");
		
		Usuario usuario = new Usuario();
		usuario.setUsuarioId(3);
		usuario.setNombre("Juan");
		usuario.setEmail("juan@email.com");
		usuario.setPassword("qwerty");
		
		usuarioDAO.crearUsuario(usuario);
		
		System.out.println(usuarioDAO.buscaUsuarioPorId(3));
		
		usuario.setPassword("12345");
		usuarioDAO.updateUsuario(usuario);
		
		System.out.println("Datos Guardados");
		System.out.println(usuarioDAO.buscaUsuarioPorId(3));
		
		System.out.println(usuarioDAO.buscarPorEmailYPassword("juan@email.com", "12345"));
		
		List<Usuario> usuarios = usuarioDAO.buscaPorNombre("z");
		System.out.println("Usuarios por nombre: ");
		System.out.println(usuarios);
	}

}
