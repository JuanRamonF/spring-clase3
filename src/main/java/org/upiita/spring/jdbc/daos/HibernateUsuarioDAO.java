package org.upiita.spring.jdbc.daos;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.upiita.spring.jdbc.entidades.Usuario;

// Hola mundo

@Component("usuarioDAO")
public class HibernateUsuarioDAO implements UsuarioDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	public Usuario buscaUsuarioPorId(Integer usuarioId) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Usuario usuario = (Usuario) session.get(Usuario.class, usuarioId);
		
		session.getTransaction().commit();
		session.close();

		return usuario;
	}

	public void crearUsuario(Usuario usuario) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.save(usuario);
		
		session.getTransaction().commit();
		session.close();
	}
	
	public void updateUsuario(Usuario usuario){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(usuario);
		
		session.getTransaction().commit();
		session.close();
	
	}

	public Usuario buscarPorEmailYPassword(String email, String password) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.eq("email", email));
		criteria.add(Restrictions.eq("password", password));
		
		// Condición OR
		// criteria.add(Restrictions.or(Restrictions.eq("email", email), Restrictions.eq("password", password)));
		
		Usuario usuario = (Usuario) criteria.uniqueResult();
		
		session.getTransaction().commit();
		session.close();
		return usuario;
	}

	public List<Usuario> buscaPorNombre(String nombre) {
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		
		Criteria criteria = session.createCriteria(Usuario.class);
		criteria.add(Restrictions.like("nombre", "%" + nombre + "%"));
		
		List<Usuario> list = criteria.list();
		
		session.getTransaction().commit();
		session.close();
		
		return list;
	}

}
