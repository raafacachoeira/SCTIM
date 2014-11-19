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
	@NamedQuery(name="getAllEmpresas", query="Select e from Empresa e")
})

@Entity
public class Empresa implements Serializable{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(length=100)
	private String nome;
	
	@Column(length=14)
	private String cnpj;

	@Column(length=100)
	private String razaoSocial;
	
	@Column(length=500)
	private String endereco;
	 
	@Column(nullable=false)
	private int fone;
	 
	@Column(length=50)
	private String email;

	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="EmpresaTipoEquipamento_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<TipoEquipamento> colTipoEquipamento = new ArrayList<TipoEquipamento>();
	 
	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="EmpresaSetor_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Setor> colSetor = new ArrayList<Setor>();

	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="EmpresaUsuario_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Login> colUsuario = new ArrayList<Login>();

	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="EmpresaTipoChamado_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<TipoChamado> colTipoChamado = new ArrayList<TipoChamado>();

	//GETTERS AND SETTERS
	
	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public int getFone() {
		return fone;
	}

	public void setFone(int fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public List<TipoEquipamento> getColTipoEquipamento() {
		return colTipoEquipamento;
	}

	public void setColTipoEquipamento(List<TipoEquipamento> colTipoEquipamento) {
		this.colTipoEquipamento = colTipoEquipamento;
	}

	public List<Setor> getColSetor() {
		return colSetor;
	}

	public void setColSetor(List<Setor> colSetor) {
		this.colSetor = colSetor;
	}

	public List<Login> getColUsuario() {
		return colUsuario;
	}

	public void setColUsuario(List<Login> colUsuario) {
		this.colUsuario = colUsuario;
	}

	public List<TipoChamado> getColTipoChamado() {
		return colTipoChamado;
	}

	public void setColTipoChamado(List<TipoChamado> colTipoChamado) {
		this.colTipoChamado = colTipoChamado;
	} 
}
 
