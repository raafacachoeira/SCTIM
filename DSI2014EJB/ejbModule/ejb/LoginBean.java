package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Login;


@Stateless
public class LoginBean implements LoginBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Login usuario) {
		if(em.find(Login.class, usuario.getOid())!=null){
			em.merge(usuario);
		}else{
			em.persist(usuario);
			
		}
		
	}

	@Override
	public List<Login> getAllUsuarios() {
		Query q = em.createNamedQuery("getAllUsuarios");
		List<Login> colUsuarios = q.getResultList();
		return colUsuarios;
	}

	@Override
	public void remove(Login login) {
		login = em.find(Login.class, login.getOid());
		if(login != null){
			
			em.remove(login);
		}
	}
}
