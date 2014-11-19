package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Login;
import ejb.LoginBeanLocal;

@ManagedBean(name="crtUsuario")
@ViewScoped
public class CrtUsuario {
	
	@EJB
	private LoginBeanLocal usuarioBeanLocal;
	
	private Login model;
	
	private List<Login> colUsuarios = new ArrayList<Login>();
	
	public List<Login> getAllUsuarios(){
		return usuarioBeanLocal.getAllUsuarios();
		
	}
		
	public void createNewUsuarios(){
		model = new Login();
	}
	public void saveUsuario(){
		usuarioBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			usuarioBeanLocal.remove(model);
	}
	public Login getModel() {
		return model;
	}
	public void setModel(Login model) {
		this.model = model;
	}
	public List<Login> getColUsuarios() {
		return colUsuarios;
	}
	public void setColUsuarios(List<Login> colUsuarios) {
		this.colUsuarios = colUsuarios;
	}
	
	
}
