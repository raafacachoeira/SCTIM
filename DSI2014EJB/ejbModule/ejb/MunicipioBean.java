package ejb;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dao.Municipio;


@Stateless
public class MunicipioBean implements MunicipioBeanLocal {
	
	@PersistenceContext(name="dsi2014context")
	//verifica percistence.xms
	private EntityManager em;

	@Override
	public void save(Municipio municipio) {
		if(em.find(Municipio.class, municipio.getCodigo())!=null){
			em.merge(municipio);
		}else{
			em.persist(municipio);
			
		}
		
	}

	@Override
	public List<Municipio> getAllMunicipios() {
		Query q = em.createNamedQuery("getAllMunicipios");
		List<Municipio> colMunicipios = q.getResultList();
		return colMunicipios;
	}

	@Override
	public void remove(Municipio municipio) {
		municipio = em.find(Municipio.class, municipio.getCodigo());
		if(municipio != null){
			
			em.remove(municipio);
		}
	}
}
