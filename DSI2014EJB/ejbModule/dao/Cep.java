package dao;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

@NamedQueries({
	@NamedQuery(name="queryAllCeps", query="Select c from Cep c")
})

@Entity
public class Cep implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int codigoCep;
		
	@Column(nullable=false)
	private long numero;
	
	@Column(length=5000)
	private String descricao;

	//GETTERS AND SETTERS
	
	public int getCodigoCep() {
		return codigoCep;
	}

	public void setCodigoCep(int codigoCep) {
		this.codigoCep = codigoCep;
	}

	public long getNumero() {
		return numero;
	}

	public void setNumero(long numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
