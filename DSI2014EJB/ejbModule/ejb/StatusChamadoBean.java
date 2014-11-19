package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.StatusChamado;

@Stateless
public class StatusChamadoBean implements StatusChamadoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(StatusChamado statusChamado) {
		if(em.find(StatusChamado.class, statusChamado.getOid())!=null){
			em.merge(statusChamado);
		}else{
			em.persist(statusChamado);
			
		}
		
	}

	@Override
	public List<StatusChamado> getAllStatusChamados() {
		Query q = em.createNamedQuery("getAllStatusChamados");
		List<StatusChamado> colStatusChamados = q.getResultList();
		return colStatusChamados;
	}

	@Override
	public void remove(StatusChamado statusChamado) {
		statusChamado = em.find(StatusChamado.class, statusChamado.getOid());
		if(statusChamado != null){
			
			em.remove(statusChamado);
		}
	}
}
