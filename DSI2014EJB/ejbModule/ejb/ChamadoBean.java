package ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Chamado;
import dao.StatusChamado;


@Stateless
public class ChamadoBean implements ChamadoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Chamado chamado) {
		if(em.find(Chamado.class, chamado.getOid())!=null){
			em.merge(chamado);
		}else{
			em.persist(chamado);
			
		}
		
	}

	@Override
	public List<Chamado> getAllChamados() {
		Query q = em.createNamedQuery("getAllChamados");
		List<Chamado> colChamados = q.getResultList();
		return colChamados;
	}

	@Override
	public void remove(Chamado chamado) {
		chamado = em.find(Chamado.class, chamado.getOid());
		if(chamado != null){
			
			em.remove(chamado);
		}
	}
}
