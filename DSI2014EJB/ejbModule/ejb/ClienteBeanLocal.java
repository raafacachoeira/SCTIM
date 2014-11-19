package ejb;

import java.util.List;
import javax.ejb.Local; //LOCAL USA QUANDO O CARA QUE VAI CONSUMIR ESTA DENTRO DO SERVIDOR, APLICACOES WEB POR EXEMPLO
import dao.Cliente;

@Local
public interface ClienteBeanLocal {
	public void save(Cliente cliente);
	public List<Cliente> getAllCliente();
	public Cliente getClienteByEndereco(String endereco);
	

}
