package flore.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Paiement {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeCarte typeCarte;
	@JsonView(Views.ViewCommon.class)
	private String numeroCarte;
	@JsonView(Views.ViewCommon.class)
	private String dtValidite;
	@JsonView(Views.ViewCommon.class)
	private String cryptogramme;
	@JsonView(Views.ViewCommon.class)
	private Float montant;
	@OneToOne(mappedBy = "paiement")
	private Commande commande;

	public Paiement() {
		super();
	}

	public Paiement(TypeCarte typeCarte, String numeroCarte, String dtValidite, String cryptogramme, Float montant) {
		super();
		this.typeCarte = typeCarte;
		this.numeroCarte = numeroCarte;
		this.dtValidite = dtValidite;
		this.cryptogramme = cryptogramme;
		this.montant = montant;
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

	public TypeCarte getTypeCarte() {
		return typeCarte;
	}

	public void setTypeCarte(TypeCarte typeCarte) {
		this.typeCarte = typeCarte;
	}

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}

	public String getDtValidite() {
		return dtValidite;
	}

	public void setDtValidite(String dtValidite) {
		this.dtValidite = dtValidite;
	}

	public String getCryptogramme() {
		return cryptogramme;
	}

	public void setCryptogramme(String cryptogramme) {
		this.cryptogramme = cryptogramme;
	}

	public Float getMontant() {
		return montant;
	}

	public void setMontant(Float montant) {
		this.montant = montant;
	}

	public Commande getCommande() {
		return commande;
	}

	public void setCommande(Commande commande) {
		this.commande = commande;
	}

	@Override
	public String toString() {
		return "Paiement [id=" + id + ", version=" + version + ", typeCarte=" + typeCarte + ", numeroCarte="
				+ numeroCarte + ", dtValidite=" + dtValidite + ", cryptogramme=" + cryptogramme + ", montant=" + montant
				+ "]";
	}

}
