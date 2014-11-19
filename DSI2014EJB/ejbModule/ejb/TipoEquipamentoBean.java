package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.TipoEquipamento;


@Stateless
public class TipoEquipamentoBean implements TipoEquipamentoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(TipoEquipamento tipoEquipamento) {
		if(em.find(TipoEquipamento.class, tipoEquipamento.getOid())!=null){
			em.merge(tipoEquipamento);
		}else{
			em.persist(tipoEquipamento);
			
		}
		
	}

	@Override
	public List<TipoEquipamento> getAllTipoEquipamentos() {
		Query q = em.createNamedQuery("getAllTipoEquipamentos");
		List<TipoEquipamento> colTipoEquipamentos = q.getResultList();
		return colTipoEquipamentos;
	}

	@Override
	public void remove(TipoEquipamento tipoEquipamento) {
		tipoEquipamento = em.find(TipoEquipamento.class, tipoEquipamento.getOid());
		if(tipoEquipamento != null){
			
			em.remove(tipoEquipamento);
		}
	}
}
