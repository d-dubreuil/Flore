package flore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Commande {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Integer reference;
	@JsonView(Views.ViewCommon.class)
	private String typeEnvoi;
	@JsonView(Views.ViewCommon.class)
	private Float total;
	
	@OneToOne
	@JoinColumn(name = "paiement_id")
	private Paiement paiement;
	@OneToOne
	@JoinColumn(name = "panier_id")
	private Panier panier;

	
	public Commande() {
		super();
	}
	public Commande(Integer reference, String typeEnvoi, Float total) {
		super();
		this.reference = reference;
		this.typeEnvoi = typeEnvoi;
		this.total = total;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Integer getReference() {
		return reference;
	}
	public void setReference(Integer reference) {
		this.reference = reference;
	}
	public String getTypeEnvoi() {
		return typeEnvoi;
	}
	public void setTypeEnvoi(String typeEnvoi) {
		this.typeEnvoi = typeEnvoi;
	}
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	
	public Paiement getPaiement() {
		return paiement;
	}
	public void setPaiement(Paiement paiement) {
		this.paiement = paiement;
	}
	public Panier getPanier() {
		return panier;
	}
	public void setPanier(Panier panier) {
		this.panier = panier;
	}
	@Override
	public String toString() {
		return "Commande [id=" + id + ", version=" + version + ", reference=" + reference + ", typeEnvoi=" + typeEnvoi
				+ ", total=" + total + "]";
	}
	
	
}
