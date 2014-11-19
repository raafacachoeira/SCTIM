package ejb;

import java.util.List;
import javax.ejb.Local;
import dao.StatusChamado;


@Local
public interface StatusChamadoBeanLocal {
	
	public void save(StatusChamado statusChamado);
	public List<StatusChamado> getAllStatusChamados();
	public void remove (StatusChamado statusChamado);
	//public Parcela getParcelabyCod(long codigo);

}
