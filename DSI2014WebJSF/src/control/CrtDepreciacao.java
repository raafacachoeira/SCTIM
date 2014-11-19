package control;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.primefaces.context.RequestContext;
import org.primefaces.event.SelectEvent;

import dao.Depreciacao;
import ejb.DepreciacaoBeanLocal;

@ManagedBean(name = "crtDepreciacao")
@ViewScoped
public class CrtDepreciacao {

	@EJB
	private DepreciacaoBeanLocal depreciacaoBeanLocal;

	private Depreciacao model;

	private List<Depreciacao> colDepreciacaos = new ArrayList<Depreciacao>();

	public List<Depreciacao> getAllDepreciacaos() {
		return depreciacaoBeanLocal.getAllDepreciacaos();

	}

	public void createNewDepreciacaos() {
		model = new Depreciacao();
	}

	public void saveDepreciacao() {
		depreciacaoBeanLocal.save(model);
	}

	public void remove() {
		if (model != null)
			depreciacaoBeanLocal.remove(model);
	}

	public void onDateSelect(SelectEvent event) {
		FacesContext facesContext = FacesContext.getCurrentInstance();
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		facesContext.addMessage(null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected",
						format.format(event.getObject())));
	}

	public void click() {
		RequestContext requestContext = RequestContext.getCurrentInstance();

		requestContext.update("form:display");
		requestContext.execute("PF('dlg').show()");
	}

	// gets e sets

	public Depreciacao getModel() {
		return model;
	}

	public void setModel(Depreciacao model) {
		this.model = model;
	}

	public List<Depreciacao> getColDepreciacaos() {
		return colDepreciacaos;
	}

	public void setColDepreciacaos(List<Depreciacao> colDepreciacaos) {
		this.colDepreciacaos = colDepreciacaos;
	}

}
