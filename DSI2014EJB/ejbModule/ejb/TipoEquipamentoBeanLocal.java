package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.TipoEquipamento;


@Local
public interface TipoEquipamentoBeanLocal {
	
	public void save(TipoEquipamento tipoEquipamento);
	public List<TipoEquipamento> getAllTipoEquipamentos();
	public void remove (TipoEquipamento tipoEquipamento);
	//public Parcela getParcelabyCod(long codigo);

}
