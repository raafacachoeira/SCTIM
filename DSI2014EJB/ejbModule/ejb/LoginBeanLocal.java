package ejb;

import java.util.List;

import javax.ejb.Local;

import dao.Login;


@Local
public interface LoginBeanLocal {
	
	public void save(Login login);
	public List<Login> getAllUsuarios();
	public void remove (Login login);
	//public Parcela getParcelabyCod(long codigo);

}
