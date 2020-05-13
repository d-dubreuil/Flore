package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Utilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeUtilisateur disc;
	@OneToOne
	@JoinColumn(name = "compteUtilisateurId")
	@JsonView(Views.ViewUtilisateur.class)
	private CompteUtilisateur compteUtilisateur;
	@OneToMany(mappedBy = "utilisateur")
	private List<Conseil> conseils = new ArrayList<Conseil>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Panier> paniers = new ArrayList<Panier>();
	@OneToMany(mappedBy = "utilisateur")
	private List<Produit> produits = new ArrayList<Produit>();
	@ManyToMany
	@JoinTable(name = "recherches", joinColumns = @JoinColumn(name = "utilisateur_id"), inverseJoinColumns = @JoinColumn(name = "flore_id"))
	private List<Flore> flores = new ArrayList<Flore>();

	public Utilisateur() {
		super();
	}
	public Utilisateur(TypeUtilisateur disc) {
		super();
		this.disc = disc;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public TypeUtilisateur getDisc() {
		return disc;
	}

	public void setDisc(TypeUtilisateur disc) {
		this.disc = disc;
	}

	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}

	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<Conseil> getConseils() {
		return conseils;
	}

	public void setConseils(List<Conseil> conseils) {
		this.conseils = conseils;
	}

	public List<Panier> getPaniers() {
		return paniers;
	}

	public void setPaniers(List<Panier> paniers) {
		this.paniers = paniers;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	public void addFlores(Flore flore) {
		this.flores.add(flore);
	}

	public List<Flore> getFlores() {
		return flores;
	}

	public void setFlores(List<Flore> flores) {
		this.flores = flores;
	}

	public void addConseil(Conseil conseil) {
		this.conseils.add(conseil);
	}

	public void addProduit(Produit produit) {
		this.produits.add(produit);
	}

	public void addPanier(Panier panier) {
		this.paniers.add(panier);
	}

	@Override
	public String toString() {
		return "Utilisateur [id=" + id + ", disc=" + disc + "]";
	}

}
