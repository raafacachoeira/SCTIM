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

@NamedQueries({ @NamedQuery(name = "getAllEquipamentos", query = "Select e from Equipamento e") })
@Entity
public class Equipamento implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int oid;

	@Column(length = 20)
	private String modelo;

	@Column(length = 20)
	private String numeroSerie;

	@Column(length = 15)
	private String memoria;

	@Column(length = 20)
	private String hd;

	@Column(length = 50)
	private String fonte;

	@Column(length = 50)
	private String placaMae;

	@Column(length = 20)
	private String marca;

	@Column(length = 12)
	private String mac;

	@Column(length = 12)
	private String ip;

	@Column(length = 15)
	private String nomePc;

	@Column(length = 15)
	private String dominio;

	@Column(length = 100)
	private String impInstaladas;

	@Column(nullable = false)
	private int pastasMapeadas;

	@Column(nullable = false)
	private int numPatrimonio;

	@OneToMany(cascade = CascadeType.ALL)
	// oque fizer no pai implica nos filhos
	@JoinColumn(name = "EmquipamentoDepreciacao_OID")
	// para chave estrangeira, nao cria assim uma tabela associativa
	private Depreciacao colDepreciacao;

	@OneToMany(cascade = CascadeType.ALL)
	// oque fizer no pai implica nos filhos
	@JoinColumn(name = "EmquipamentoChamado_OID")
	// para chave estrangeira, nao cria assim uma tabela associativa
	private List<Chamado> colChamado = new ArrayList<Chamado>();

	// GETTERS AND SETTERS

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getNumeroSerie() {
		return numeroSerie;
	}

	public void setNumeroSerie(String numeroSerie) {
		this.numeroSerie = numeroSerie;
	}

	public String getMemoria() {
		return memoria;
	}

	public void setMemoria(String memoria) {
		this.memoria = memoria;
	}

	public String getHd() {
		return hd;
	}

	public void setHd(String hd) {
		this.hd = hd;
	}

	public String getFonte() {
		return fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	public String getPlacaMae() {
		return placaMae;
	}

	public void setPlacaMae(String placaMae) {
		this.placaMae = placaMae;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMac() {
		return mac;
	}

	public void setMac(String mac) {
		this.mac = mac;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getNomePc() {
		return nomePc;
	}

	public void setNomePc(String nomePc) {
		this.nomePc = nomePc;
	}

	public String getDominio() {
		return dominio;
	}

	public void setDominio(String dominio) {
		this.dominio = dominio;
	}

	public String getImpInstaladas() {
		return impInstaladas;
	}

	public void setImpInstaladas(String impInstaladas) {
		this.impInstaladas = impInstaladas;
	}

	public int getPastasMapeadas() {
		return pastasMapeadas;
	}

	public void setPastasMapeadas(int pastasMapeadas) {
		this.pastasMapeadas = pastasMapeadas;
	}

	public int getNumPatrimonio() {
		return numPatrimonio;
	}

	public void setNumPatrimonio(int numPatrimonio) {
		this.numPatrimonio = numPatrimonio;
	}

	public List<Chamado> getColChamado() {
		return colChamado;
	}

	public void setColChamado(List<Chamado> colChamado) {
		this.colChamado = colChamado;
	}

}
