package ejb;

import java.util.List;
import javax.ejb.Local;
import dao.Setor;


@Local
public interface SetorBeanLocal {
	
	public void save(Setor setor);
	public List<Setor> getAllSetors();
	public void remove (Setor setor);
	//public Parcela getParcelabyCod(long codigo);

}
