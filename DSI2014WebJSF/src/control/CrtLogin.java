package control;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import dao.Login;
import ejb.LoginBeanLocal;

@ManagedBean(name="crtLogin")
public class CrtLogin {
	private Login loginModel;
	
	@EJB
	private LoginBeanLocal loginBean;
	
	public Login getLoginModel() {
		return loginModel;
	}
	public void setLoginModel(Login loginModel) {
		this.loginModel = loginModel;
	}
	
	public List<Login> getAllLogins(){
		return loginBean.getAllUsuarios();
	}
}
