package control;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import dao.Empresa;
import ejb.EmpresaBeanLocal;

@ManagedBean(name = "crtEmpresa")
@ViewScoped
public class CrtEmpresa {

	@EJB
	private EmpresaBeanLocal empresaBeanLocal;

	private Empresa model;

	private List<Empresa> colEmpresas = new ArrayList<Empresa>();

	public List<Empresa> getAllEmpresas() {
		return empresaBeanLocal.getAllEmpresas();

	}

	public void createNewEmpresas() {
		model = new Empresa();
	}

	public void saveEmpresa() {
		empresaBeanLocal.save(model);
	}

	public void remove() {
		if (model != null)
			empresaBeanLocal.remove(model);
	}

	public Empresa getModel() {
		return model;
	}

	public void setModel(Empresa model) {
		this.model = model;
	}

	public List<Empresa> getColEmpresas() {
		return colEmpresas;
	}

	public void setColEmpresas(List<Empresa> colEmpresas) {
		this.colEmpresas = colEmpresas;
	}

}
