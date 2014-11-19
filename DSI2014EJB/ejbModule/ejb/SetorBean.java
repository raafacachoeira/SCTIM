package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Setor;

@Stateless
public class SetorBean implements SetorBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Setor setor) {
		if(em.find(Setor.class, setor.getOid())!=null){
			em.merge(setor);
		}else{
			em.persist(setor);
			
		}
		
	}

	@Override
	public List<Setor> getAllSetors() {
		Query q = em.createNamedQuery("getAllSetors");
		List<Setor> colSetors = q.getResultList();
		return colSetors;
	}

	@Override
	public void remove(Setor setor) {
		setor = em.find(Setor.class, setor.getOid());
		if(setor != null){
			
			em.remove(setor);
		}
	}
}
