package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Equipamento;


@Stateless
public class EquipamentoBean implements EquipamentoBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Equipamento equipamento) {
		if(em.find(Equipamento.class, equipamento.getOid())!=null){
			em.merge(equipamento);
		}else{
			em.persist(equipamento);
			
		}
		
	}

	@Override
	public List<Equipamento> getAllEquipamentos() {
		Query q = em.createNamedQuery("getAllEquipamentos");
		List<Equipamento> colEquipamentos = q.getResultList();
		return colEquipamentos;
	}

	@Override
	public void remove(Equipamento equipamento) {
		equipamento = em.find(Equipamento.class, equipamento.getOid());
		if(equipamento != null){
			
			em.remove(equipamento);
		}
	}
}
