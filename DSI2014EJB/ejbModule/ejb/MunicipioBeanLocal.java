package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Municipio;


@Local
public interface MunicipioBeanLocal {
	
	public void save(Municipio municipio);
	public List<Municipio> getAllMunicipios();
	public void remove (Municipio municipio);
	//public Parcela getParcelabyCod(long codigo);

}
