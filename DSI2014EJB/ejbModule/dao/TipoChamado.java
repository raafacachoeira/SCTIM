package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="getAllTipoChamados", query="Select t from TipoChamado t")
})



@Entity
public class TipoChamado implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(length=40)
	private String descTipoChamado;
	
	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="TipoChamadoChamado_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Chamado> colChamado = new ArrayList<Chamado>();

	
	//GETTERS AND SETTERS

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	

	public String getDescTipoChamado() {
		return descTipoChamado;
	}

	public void setDescTipoChamado(String descTipoChamado) {
		this.descTipoChamado = descTipoChamado;
	}

	public List<Chamado> getColChamado() {
		return colChamado;
	}

	public void setColChamado(List<Chamado> colChamado) {
		this.colChamado = colChamado;
	}

		 
	 
	
	 
}
 
