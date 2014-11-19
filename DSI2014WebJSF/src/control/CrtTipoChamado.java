package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.TipoChamado;
import ejb.TipoChamadoBeanLocal;

@ManagedBean(name="crtTipoChamado")
@ViewScoped
public class CrtTipoChamado {
	
	@EJB
	private TipoChamadoBeanLocal tipoChamadoBeanLocal;
	
	private TipoChamado model;
	
	private List<TipoChamado> colTipoChamados = new ArrayList<TipoChamado>();
	
	public List<TipoChamado> getAllTipoChamados(){
		return tipoChamadoBeanLocal.getAllTipoChamados();
		
	}
	
	public void createNewTipoChamados(){
		model = new TipoChamado();
	}
	public void saveTipoChamado(){
		tipoChamadoBeanLocal.save(model);
	}
	public void remove(){
		if(model != null)
			tipoChamadoBeanLocal.remove(model);
	}
	public TipoChamado getModel() {
		return model;
	}
	public void setModel(TipoChamado model) {
		this.model = model;
	}
	public List<TipoChamado> getColTipoChamados() {
		return colTipoChamados;
	}
	public void setColTipoChamados(List<TipoChamado> colTipoChamados) {
		this.colTipoChamados = colTipoChamados;
	}
	
	
}
