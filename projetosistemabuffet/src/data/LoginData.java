package data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import models.Usuario;

public class LoginData {
    
    public static boolean incluir(Usuario usuario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}

    public static boolean alterar(Usuario usuario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.persist(usuario);
			manager.getTransaction().commit();
			return true;			
		}
		catch(Exception e){
			return false;
		}
	}

    public static boolean excluir(Usuario usuario){
		try{
			EntityManager manager = EntityManagerFactory.getInstance();
			manager.getTransaction().begin();
			manager.remove(usuario);
			manager.getTransaction().commit();
			return true;			
			
		}
		catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}

	public static Usuario procurarID(Usuario usuario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Usuario where id = :param");
		consulta.setParameter("param", usuario.getId());
		List<Usuario> ids = consulta.getResultList();
		for(Usuario item: ids){
            if(item.getId()==usuario.getId()){
                return item;
            }
        }
        return null;
	}

    public static boolean autenticarLogin(Usuario usuario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Usuario where usuario = :param");
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for(Usuario item: usuarios){
            if(item.getUsuario().equalsIgnoreCase(usuario.getUsuario())){
				if(item.getSenha().equals(usuario.getSenha())){
					return true;
				}
            }
        }
        return false;
	}

	public static Usuario retornUsuario(Usuario usuario){
		EntityManager manager = EntityManagerFactory.getInstance();
		Query consulta = manager.createQuery("from Usuario where usuario = :param");
		consulta.setParameter("param", usuario.getUsuario());
		List<Usuario> usuarios = consulta.getResultList();
		for(Usuario item: usuarios){
            if(item.getUsuario().equals(usuario.getUsuario())){
                return item;
            }
        }
        return null;
	}
	

}