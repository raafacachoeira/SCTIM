package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Municipio;
import ejb.MunicipioBeanLocal;

@ManagedBean(name="crtMunicipio")
@ViewScoped
public class CrtMunicipio {
	
	@EJB
	private MunicipioBeanLocal municipioBeanLocal;
	
	private Municipio model;
	
	private List<Municipio> colMunicipios = new ArrayList<Municipio>();
	
	public List<Municipio> getAllMunicipios(){
		return municipioBeanLocal.getAllMunicipios();
		
	}
	
	public void createNewMunicipios(){
		model = new Municipio();
	}
	public void saveMunicipio(){
		municipioBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			municipioBeanLocal.remove(model);
	}
	public Municipio getModel() {
		return model;
	}
	public void setModel(Municipio model) {
		this.model = model;
	}
	public List<Municipio> getColMunicipios() {
		return colMunicipios;
	}
	public void setColMunicipios(List<Municipio> colMunicipios) {
		this.colMunicipios = colMunicipios;
	}
	
	
}
