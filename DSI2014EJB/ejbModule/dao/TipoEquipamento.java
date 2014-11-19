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
	@NamedQuery(name="getAllTipoEquipamentos", query="Select t from TipoEquipamento t")
})

@Entity
public class TipoEquipamento implements Serializable{
 
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int oid;
	
	@Column(length=500)
	private String descTipoEquipamento;
	
	@OneToMany(cascade=CascadeType.ALL) //oque fizer no pai implica nos filhos
	@JoinColumn(name="TipoEquipamentoEquipamento_OID") //para chave estrangeira, nao cria assim uma tabela associativa
	private List<Equipamento> colEquipamento = new ArrayList<Equipamento>();
	 
	
	//GETTERS AND SETTERS

	public String getDescTipoEquipamento() {
		return descTipoEquipamento;
	}

	public void setDescTipoEquipamento(String descTipoEquipamento) {
		this.descTipoEquipamento = descTipoEquipamento;
	}

	public List<Equipamento> getColEquipamento() {
		return colEquipamento;
	}

	public void setColEquipamento(List<Equipamento> colEquipamento) {
		this.colEquipamento = colEquipamento;
	}

	public int getOid() {
		return oid;
	}

	public void setOid(int oid) {
		this.oid = oid;
	}

	
}
 
