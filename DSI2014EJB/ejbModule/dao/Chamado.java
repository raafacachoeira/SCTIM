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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@NamedQueries({
	@NamedQuery(name="getAllChamados", query="Select c from Chamado c")
})

@Entity
public class Chamado implements Serializable{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(nullable=false)
	private int numPatrimonio;
	
	@Column(length=5000)
	private String defeito; 
	
	@Column(length=30)
	private String solicitante;
	
	@Column(length=20)
	private String urgencia;
	 
	@ManyToOne(cascade={CascadeType.MERGE,CascadeType.REFRESH})
	private StatusChamado status;
	
	public StatusChamado getStatus() {
		return status;
	}

	public void setStatus(StatusChamado status) {
		this.status = status;
	}

	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="ChamadoMovimentacao_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Movimentacao> colMovimentacao = new ArrayList<Movimentacao>();

	//GETTERS AND SETTERS
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public int getNumPatrimonio() {
		return numPatrimonio;
	}

	public void setNumPatrimonio(int numPatrimonio) {
		this.numPatrimonio = numPatrimonio;
	}

	public String getDefeito() {
		return defeito;
	}

	public void setDefeito(String defeito) {
		this.defeito = defeito;
	}

	public String getSolicitante() {
		return solicitante;
	}

	public void setSolicitante(String solicitante) {
		this.solicitante = solicitante;
	}

	public String getUrgencia() {
		return urgencia;
	}

	public void setUrgencia(String urgencia) {
		this.urgencia = urgencia;
	}

//	public List<StatusChamado> getColStatus() {
//		return colStatus;
//	}
//
//	public void setColStatus(List<StatusChamado> colStatus) {
//		this.colStatus = colStatus;
//	}

	public List<Movimentacao> getColMovimentacao() {
		return colMovimentacao;
	}

	public void setColMovimentacao(List<Movimentacao> colMovimentacao) {
		this.colMovimentacao = colMovimentacao;
	}
}
 
