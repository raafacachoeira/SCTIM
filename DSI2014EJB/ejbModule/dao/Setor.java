package dao;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

@NamedQueries({
	@NamedQuery(name="getAllSetors", query="Select s from Setor s")
})

@Entity
public class Setor implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(length=50)
	private String setor;
	
	//fetch.eager - se trouxer o pai ja traz o filho, perde performance, imagina que traz um pedido com 10.000 itens, isso é ruim
	@OneToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH}, optional=false, fetch=FetchType.EAGER)
	private Contabil contabil;
	
	
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getSetor() {
		return setor;
	}
	public void setSetor(String setor) {
		this.setor = setor;
	}
	public Contabil getContabil() {
		return contabil;
	}
	public void setContabil(Contabil contabil) {
		this.contabil = contabil;
	}
	
	
	
}
