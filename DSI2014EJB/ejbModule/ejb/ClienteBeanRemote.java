package ejb;
import java.util.List;
import javax.ejb.Remote;

import dao.Cliente;

@Remote
public interface ClienteBeanRemote {
	public void save(Cliente cliente); //isso que permite chamar do swing, só a assinatura do metodo é necessaria
	public List<Cliente> getAllCliente();
	public Cliente getClienteByEndereco(String endereco);
}
