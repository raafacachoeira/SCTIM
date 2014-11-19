package dao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//SE QUISER USAR CONSTRUTOR, DEVE-SE TER UM CONSTRUTOR VAZIO SÓ PARA O JPA
//E AI CRIAR O SEU
@Entity
public class Contabil implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long oid;
	
	@Column(precision=4, scale=2)
	private float valorEquip;
	
	
	
	public long getOid() {
		return oid;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public float getValorEquip() {
		return valorEquip;
	}

	public void setValorEquip(float valorEquip) {
		this.valorEquip = valorEquip;
	}
	
	
}
