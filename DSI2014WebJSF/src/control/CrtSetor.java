package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Setor;
import ejb.SetorBeanLocal;

@ManagedBean(name="crtSetor")
@ViewScoped
public class CrtSetor {
	
	@EJB
	private SetorBeanLocal setorBeanLocal;
	
	private Setor model;
	
	private List<Setor> colSetors = new ArrayList<Setor>();
	
	public List<Setor> getAllSetors(){
		return setorBeanLocal.getAllSetors();
		
	}
	
	public void createNewSetors(){
		model = new Setor();
	}
	public void saveSetor(){
		setorBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			setorBeanLocal.remove(model);
	}
	public Setor getModel() {
		return model;
	}
	public void setModel(Setor model) {
		this.model = model;
	}
	public List<Setor> getColSetors() {
		return colSetors;
	}
	public void setColSetors(List<Setor> colSetors) {
		this.colSetors = colSetors;
	}
	
	
}
