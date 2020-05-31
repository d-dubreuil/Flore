package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Produit {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Integer refProduit;
	@JsonView(Views.ViewCommon.class)
	private Float prix;
	@JsonView(Views.ViewCommon.class)
	private String fournisseur;
	@JsonView(Views.ViewCommon.class)
	private Integer stock;
	@ManyToOne
	@JoinColumn(name = "faune_id")
	@JsonView(Views.ViewPanier.class)
	private Faune faune;
	@ManyToOne
	@JoinColumn(name = "flore_id")
	@JsonView(Views.ViewPanier.class)
	private Flore flore;
	@OneToMany(mappedBy = "produit")
	private List<Selection> selections = new ArrayList<Selection>();
	@ManyToOne
	@JoinColumn(name = "utilisateur_id")
	// @JsonView(Views.ViewProduit.class)
	private Utilisateur utilisateur;

	public Produit() {
		super();
	}

	public Produit(Integer refProduit, Float prix, String fournisseur, Integer stock) {
		super();
		this.refProduit = refProduit;
		this.prix = prix;
		this.fournisseur = fournisseur;
		this.stock = stock;
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

	public Integer getRefProduit() {
		return refProduit;
	}

	public void setRefProduit(Integer refProduit) {
		this.refProduit = refProduit;
	}

	public Float getPrix() {
		return prix;
	}

	public void setPrix(Float prix) {
		this.prix = prix;
	}

	public String getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(String fournisseur) {
		this.fournisseur = fournisseur;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public Faune getFaune() {
		return faune;
	}

	public void setFaune(Faune faune) {
		this.faune = faune;
	}

	public Flore getFlore() {
		return flore;
	}

	public void setFlore(Flore flore) {
		this.flore = flore;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public List<Selection> getSelections() {
		return selections;
	}

	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}

	public void addSelection(Selection selection) {
		this.selections.add(selection);
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", version=" + version + ", refProduit=" + refProduit + ", prix=" + prix
				+ ", fournisseur=" + fournisseur + ", stock=" + stock + "]";
	}

}
