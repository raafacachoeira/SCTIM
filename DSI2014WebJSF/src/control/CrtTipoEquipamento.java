package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.TipoEquipamento;
import ejb.TipoEquipamentoBeanLocal;

@ManagedBean(name="crtTipoEquipamento")
@ViewScoped
public class CrtTipoEquipamento {
	
	@EJB
	private TipoEquipamentoBeanLocal tipoEquipamentoBeanLocal;
	
	private TipoEquipamento model;
	
	private List<TipoEquipamento> colTipoEquipamentos = new ArrayList<TipoEquipamento>();
	
	public List<TipoEquipamento> getAllTipoEquipamentos(){
		return tipoEquipamentoBeanLocal.getAllTipoEquipamentos();
		
	}
		
	public void createNewTipoEquipamentos(){
		model = new TipoEquipamento();
	}
	public void saveTipoEquipamento(){
		tipoEquipamentoBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			tipoEquipamentoBeanLocal.remove(model);
	}
	public TipoEquipamento getModel() {
		return model;
	}
	public void setModel(TipoEquipamento model) {
		this.model = model;
	}
	public List<TipoEquipamento> getColTipoEquipamentos() {
		return colTipoEquipamentos;
	}
	public void setColTipoEquipamentos(List<TipoEquipamento> colTipoEquipamentos) {
		this.colTipoEquipamentos = colTipoEquipamentos;
	}
	
	
}
