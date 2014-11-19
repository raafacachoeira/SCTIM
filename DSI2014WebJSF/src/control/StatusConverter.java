package control;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

@ManagedBean(name="statusConverter")
@RequestScoped
public class StatusConverter implements Converter, Serializable{

	@ManagedProperty(value="#{crtChamado}")
	private CrtChamado crtChamado;
	
	@Override
	public Object getAsObject(FacesContext arg0, UIComponent arg1, String arg2) {
		int posicao = Integer.parseInt(arg2);
		return crtChamado.getColStatusChamado().get(posicao);
	}

	@Override
	public String getAsString(FacesContext arg0, UIComponent arg1, Object arg2) {
		return String.valueOf(crtChamado.getColStatusChamado().indexOf(arg2));
	}

	public CrtChamado getCrtChamado() {
		return crtChamado;
	}

	public void setCrtChamado(CrtChamado crtChamado) {
		this.crtChamado = crtChamado;
	}

}
