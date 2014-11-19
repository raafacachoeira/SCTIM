package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Equipamento;


@Local
public interface EquipamentoBeanLocal {
	
	public void save(Equipamento equipamento);
	public List<Equipamento> getAllEquipamentos();
	public void remove (Equipamento equipamento);
	//public Parcela getParcelabyCod(long codigo);

}
