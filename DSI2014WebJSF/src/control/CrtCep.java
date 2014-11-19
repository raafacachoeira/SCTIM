package control;

import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import dao.Cep;
import ejb.CepBeanLocal;

@ManagedBean(name="crtCep")
@ViewScoped
public class CrtCep {
	
	@EJB
	private CepBeanLocal cepBeanLocal;
	private Cep model;
	
	public void createNewCep(){
		model = new Cep();
		
	}
	
	public void remove(){
		if(model != null){
			cepBeanLocal.remove(model);
			FacesContext.getCurrentInstance().addMessage("qualquer", new FacesMessage("Excluindo..."));
		}
		FacesContext.getCurrentInstance().addMessage("qualquer", new FacesMessage("Excluido com sucesso"));
	}
	
	public void saveCep(){
		cepBeanLocal.save(model);
	}
	
	public List<Cep> getAllCeps(){
		return cepBeanLocal.getAllCep();
	}

	public Cep getModel() {
		return model;
	}

	public void setModel(Cep model) {
		this.model = model;
	}	
}