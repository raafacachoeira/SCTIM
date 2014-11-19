package dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Movimentacao implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(length=255)
	private String descSituacao;
	 
	@Column(length=50)
	private String ultimoTecnico;
	 
	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="MovimentacaoStatus_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<StatusChamado> colStatus = new ArrayList<StatusChamado>();
	
	@Temporal(TemporalType.TIMESTAMP)
	private Date ultimaExecucao;
	 

	//GETTERS AND SETTERS

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getDescSituacao() {
		return descSituacao;
	}

	public void setDescSituacao(String descSituacao) {
		this.descSituacao = descSituacao;
	}

	public String getUltimoTecnico() {
		return ultimoTecnico;
	}

	public void setUltimoTecnico(String ultimoTecnico) {
		this.ultimoTecnico = ultimoTecnico;
	}

	public Date getUltimaExecucao() {
		return ultimaExecucao;
	}

	public void setUltimaExecucao(Date ultimaExecucao) {
		this.ultimaExecucao = ultimaExecucao;
	}

	public List<StatusChamado> getColStatus() {
		return colStatus;
	}

	public void setColStatus(List<StatusChamado> colStatus) {
		this.colStatus = colStatus;
	}
	
}
 
