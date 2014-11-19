package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Empresa;


@Local
public interface EmpresaBeanLocal {
	
	public void save(Empresa empresa);
	public List<Empresa> getAllEmpresas();
	public void remove (Empresa empresa);
	//public Parcela getParcelabyCod(long codigo);

}
