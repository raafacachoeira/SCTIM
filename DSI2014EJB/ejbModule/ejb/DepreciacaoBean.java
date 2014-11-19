package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Depreciacao;

@Stateless
public class DepreciacaoBean implements DepreciacaoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Depreciacao depreciacao) {
		if(em.find(Depreciacao.class, depreciacao.getOid())!=null){
			em.merge(depreciacao);
		}else{
			em.persist(depreciacao);
			
		}
		
	}

	@Override
	public List<Depreciacao> getAllDepreciacaos() {
		Query q = em.createNamedQuery("getAllDepreciacaos");
		List<Depreciacao> colDepreciacaos = q.getResultList();
		return colDepreciacaos;
	}

	@Override
	public void remove(Depreciacao depreciacao) {
		depreciacao = em.find(Depreciacao.class, depreciacao.getOid());
		if(depreciacao != null){
			
			em.remove(depreciacao);
		}
	}
}
