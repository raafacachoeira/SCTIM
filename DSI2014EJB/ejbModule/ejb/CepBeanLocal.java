package ejb;



import java.util.List;

import javax.ejb.Local;
import javax.persistence.NoResultException;

import dao.Cep;

@Local
public interface CepBeanLocal {
	public void save(Cep cep);
	public List<Cep> getAllCep();
	public void remove (Cep cep);
	public Cep getCepByNumber(long number);
}
