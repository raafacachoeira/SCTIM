package ejb;

import java.util.List;
import javax.ejb.Local;
import dao.Depreciacao;


@Local
public interface DepreciacaoBeanLocal {
	
	public void save(Depreciacao depreciacao);
	public List<Depreciacao> getAllDepreciacaos();
	public void remove (Depreciacao depreciacao);
	//public Parcela getParcelabyCod(long codigo);

}
