package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@NamedQueries({
	@NamedQuery(name="getAllDepreciacaos", query="Select d from Depreciacao d")
})

@Entity
public class Depreciacao implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(nullable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataInstalacao;
	 
	@Temporal(TemporalType.TIMESTAMP)
	private Date dataPrevistaSubstituicao;
	 
	@Column(length=5000)
	private String garantia;
	 
	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="DepreciacaoContabil_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Contabil> colContabeis = new ArrayList<Contabil>();
	
	//fetch.eager - se trouxer o pai ja traz o filho, perde performance, imagina que traz um pedido com 10.000 itens, isso é ruim
	//@OneToOne(cascade={CascadeType.MERGE, CascadeType.REFRESH}, optional=false, fetch=FetchType.EAGER)
	private Setor setor;
	
	//GETTERS AND SETTERS
	
	public Setor getSetor() {
		return setor;
	}

	public void setSetor(Setor setor) {
		this.setor = setor;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public Date getDataInstalacao() {
		return dataInstalacao;
	}

	public void setDataInstalacao(Date dataInstalacao) {
		this.dataInstalacao = dataInstalacao;
	}

	public Date getDataPrevistaSubstituicao() {
		return dataPrevistaSubstituicao;
	}

	public void setDataPrevistaSubstituicao(Date dataPrevistaSubstituicao) {
		this.dataPrevistaSubstituicao = dataPrevistaSubstituicao;
	}

	public String getGarantia() {
		return garantia;
	}

	public void setGarantia(String garantia) {
		this.garantia = garantia;
	}

	public List<Contabil> getColContabeis() {
		return colContabeis;
	}

	public void setColContabeis(List<Contabil> colContabeis) {
		this.colContabeis = colContabeis;
	}	 
}
 
