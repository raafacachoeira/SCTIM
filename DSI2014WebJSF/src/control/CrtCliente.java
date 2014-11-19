package control;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import dao.Cliente;
import ejb.ClienteBeanLocal;

@ManagedBean(name="crtCliente")
public class CrtCliente {
	private Cliente clienteModel;
	
	@EJB
	private ClienteBeanLocal clienteBean;
	
	public Cliente getClienteModel() {
		return clienteModel;
	}
	public void setClienteModel(Cliente clienteModel) {
		this.clienteModel = clienteModel;
	}
	
	public List<Cliente> getAllClientes(){
		return clienteBean.getAllCliente();
	}
}
