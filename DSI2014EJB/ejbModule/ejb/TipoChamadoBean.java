package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.TipoChamado;

@Stateless
public class TipoChamadoBean implements TipoChamadoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(TipoChamado tipoChamado) {
		if(em.find(TipoChamado.class, tipoChamado.getOid())!=null){
			em.merge(tipoChamado);
		}else{
			em.persist(tipoChamado);
			
		}
		
	}

	@Override
	public List<TipoChamado> getAllTipoChamados() {
		Query q = em.createNamedQuery("getAllTipoChamados");
		List<TipoChamado> colTipoChamados = q.getResultList();
		return colTipoChamados;
	}

	@Override
	public void remove(TipoChamado tipoChamado) {
		tipoChamado = em.find(TipoChamado.class, tipoChamado.getOid());
		if(tipoChamado != null){
			
			em.remove(tipoChamado);
		}
	}
}
