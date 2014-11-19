package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Cep;

@Stateless
public class CepBean implements CepBeanLocal{

	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Cep cep) {
		if(em.find(Cep.class, cep.getCodigoCep())!= null){
			System.out.println("UPDATEEEEEEEE!!!..." + cep.getCodigoCep());
			em.merge(cep);
		}else{
			em.persist(cep);
			System.out.println("SALVANDOOOOOO!!!..." + cep.getCodigoCep());
		}

	}


	@Override
	public Cep getCepByNumber(long number){
		try{
			Query q = em.createNamedQuery("queryCepsByNumber");
			q.setParameter("numero", number);
			return (Cep)q.getSingleResult();
		}catch(NoResultException e){
			return null;
		}
	}

	@Override
	public List<Cep> getAllCep() {
		Query q = em.createNamedQuery("queryAllCeps");
		List<Cep> colCeps = q.getResultList();
		return colCeps;
	}

	@Override
	public void remove(Cep cep) {
		//System.out.println("BATEU!!!..." + cep.getCodigoCep());
		cep = em.find(Cep.class, cep.getCodigoCep());
		if(cep != null){
			System.out.println("Removendo....");
			em.remove(cep);
		}

	}

}
