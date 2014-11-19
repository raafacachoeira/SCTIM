package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.TipoChamado;


@Local
public interface TipoChamadoBeanLocal {
	
	public void save(TipoChamado tipoChamado);
	public List<TipoChamado> getAllTipoChamados();
	public void remove (TipoChamado tipoChamado);
	//public Parcela getParcelabyCod(long codigo);

}
