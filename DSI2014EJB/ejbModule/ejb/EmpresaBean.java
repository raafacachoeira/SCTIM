package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import dao.Empresa;


@Stateless
public class EmpresaBean implements EmpresaBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Empresa empresa) {
		if(em.find(Empresa.class, empresa.getOid())!= null){
			em.merge(empresa);
		}else{
			em.persist(empresa);
			
		}
		
	}

	@Override
	public List<Empresa> getAllEmpresas() {
		Query q = em.createNamedQuery("getAllEmpresas");
		List<Empresa> colEmpresas = q.getResultList();
		return colEmpresas;
	}

	@Override
	public void remove(Empresa empresa) {
		empresa = em.find(Empresa.class, empresa.getOid());
		if(empresa != null){
			
			em.remove(empresa);
		}
	}
}
