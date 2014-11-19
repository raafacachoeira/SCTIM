package ejb;

import java.util.List;
import javax.ejb.Local;
import dao.Chamado;


@Local
public interface ChamadoBeanLocal {
	public void save(Chamado chamado);
	public List<Chamado> getAllChamados();
	public void remove (Chamado chamado);
}
