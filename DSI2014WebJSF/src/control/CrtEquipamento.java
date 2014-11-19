package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Equipamento;
import ejb.EquipamentoBeanLocal;

@ManagedBean(name="crtEquipamento")
@ViewScoped
public class CrtEquipamento {
	
	@EJB
	private EquipamentoBeanLocal equipamentoBeanLocal;
	
	private Equipamento model;
	
	private List<Equipamento> colEquipamentos = new ArrayList<Equipamento>();
	
	public List<Equipamento> getAllEquipamentos(){
		return equipamentoBeanLocal.getAllEquipamentos();
		
	}
		
	public void createNewEquipamentos(){
		model = new Equipamento();
	}
	public void saveEquipamento(){
		equipamentoBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			equipamentoBeanLocal.remove(model);
	}
	public Equipamento getModel() {
		return model;
	}
	public void setModel(Equipamento model) {
		this.model = model;
	}
	public List<Equipamento> getColEquipamentos() {
		return colEquipamentos;
	}
	public void setColEquipamentos(List<Equipamento> colEquipamentos) {
		this.colEquipamentos = colEquipamentos;
	}
	
	
}
