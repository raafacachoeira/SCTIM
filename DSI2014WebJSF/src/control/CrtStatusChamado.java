package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.StatusChamado;
import ejb.StatusChamadoBeanLocal;

@ManagedBean(name="crtStatusChamado")
@ViewScoped
public class CrtStatusChamado {
	
	@EJB
	private StatusChamadoBeanLocal statusChamadoBeanLocal;
	
	private StatusChamado model;
	
	private List<StatusChamado> colStatusChamados = new ArrayList<StatusChamado>();
	
	public List<StatusChamado> getAllStatusChamados(){
		return statusChamadoBeanLocal.getAllStatusChamados();
		
	}
	
	public void createNewStatusChamados(){
		model = new StatusChamado();
	}
	public void saveStatusChamado(){
		statusChamadoBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			statusChamadoBeanLocal.remove(model);
	}
	public StatusChamado getModel() {
		return model;
	}
	public void setModel(StatusChamado model) {
		this.model = model;
	}
	public List<StatusChamado> getColStatusChamados() {
		return colStatusChamados;
	}
	public void setColStatusChamados(List<StatusChamado> colStatusChamados) {
		this.colStatusChamados = colStatusChamados;
	}
	
	
}
