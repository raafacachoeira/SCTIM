package ejb;

import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Cliente;

/**
 * Session Bean implementation class ClienteBean
 */
@Stateless
@LocalBean
public class ClienteBean implements ClienteBeanLocal, ClienteBeanRemote {
	@PersistenceContext(name="dsi2014context")
	private EntityManager em;

    public ClienteBean() {

    }
	
	public void save(Cliente cliente){
		if(em.find(Cliente.class, cliente.getOid()) == null){
			em.persist(cliente);//INSERT
		}else{
			em.merge(cliente); //UPDATE
		}
	}
	
	public List<Cliente> getAllCliente(){
		Query q = em.createNamedQuery("getAllClientes");
		return q.getResultList();
	}
	
	public Cliente getClienteByEndereco(String endereco){
		Query q = em.createNamedQuery("getClienteByEnd");
		q.setParameter("ender", endereco);
		q.setMaxResults(1); //TOP 1 DO SQL SERVER E LIMIT DO MYSQL
		return (Cliente)q.getSingleResult(); //SO TRAZ UM RESULTADO, MAS PRECISA DEFINIR ACIMA QUEM VC QUER SENAO DA BUG
	}

}
