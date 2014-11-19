package control;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Chamado;
import dao.StatusChamado;
import ejb.ChamadoBeanLocal;
import ejb.StatusChamadoBeanLocal;

@ManagedBean(name = "crtChamado")
@ViewScoped
public class CrtChamado {

	@EJB
	private ChamadoBeanLocal chamadoBeanLocal;
	@EJB
	private StatusChamadoBeanLocal statusChamadoBeanLocal;
	
	private Chamado model;

	private List<StatusChamado> colStatusChamado = new ArrayList<StatusChamado>();

	private List<Chamado> colChamados = new ArrayList<Chamado>();

	//postcontruct - eh chamado sempre pelo jsf, antes de montar a tela
	@PostConstruct
	public void loadData(){
		colStatusChamado.addAll(statusChamadoBeanLocal.getAllStatusChamados());
	}
	public List<Chamado> getAllChamados() {
		return chamadoBeanLocal.getAllChamados();

	}

	public void createNewChamados() {
		model = new Chamado();
	}

	public void saveChamado() {
		chamadoBeanLocal.save(model);
	}

	public void remove() {
		if (model != null)
			chamadoBeanLocal.remove(model);
	}

	public Chamado getModel() {
		return model;
	}

	public void setModel(Chamado model) {
		this.model = model;
	}

	public List<Chamado> getColChamados() {
		return colChamados;
	}

	public List<StatusChamado> getColStatusChamado() {
		return colStatusChamado;
	}

	public void setColStatusChamado(List<StatusChamado> colStatusChamado) {
		this.colStatusChamado = colStatusChamado;
	}

	public void setColChamados(List<Chamado> colChamados) {
		this.colChamados = colChamados;
	}

}
