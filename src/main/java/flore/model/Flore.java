package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fasterxml.jackson.annotation.JsonView;

import flore.persistence.IReferentielCaracteristiqueRepository;

@Entity
public class Flore {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(unique = true)
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@OneToMany (mappedBy = "flore")
	private List<ReferentielCaracteristique> referentielCaracteristiques = new ArrayList<ReferentielCaracteristique>();
	@OneToMany (mappedBy = "flore")
	private List<ReferentielFaune> referentielFaunes = new ArrayList<ReferentielFaune>();
	@ManyToMany(mappedBy = "flores")
	private List<Utilisateur> utilisateurs = new ArrayList<Utilisateur>();
	@OneToMany (mappedBy = "flore")
	private List<Produit> produits= new ArrayList<Produit>();
	@ManyToMany (mappedBy = "flores")
	private List<Favoris>favoris = new ArrayList<Favoris>();
	@ManyToMany (mappedBy = "flores")
	private List<Jardin>jardins = new ArrayList<Jardin>();
	
	public Flore() {
		super();
	}
	public Flore(String nom) {
		super();
		this.nom = nom;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}

	public List<ReferentielCaracteristique> getReferentielCaracteristiques() {
		return referentielCaracteristiques;
	}
	public void setReferentielCaracteristiques(List<ReferentielCaracteristique> referentielCaracteristiques) {
		this.referentielCaracteristiques = referentielCaracteristiques;
	}
	public void addReferentielCaracteristiques (ReferentielCaracteristique referentielCaracteristique) {
		this.referentielCaracteristiques.add(referentielCaracteristique);
	}
	public List<ReferentielFaune> getReferentielFaunes() {
		return referentielFaunes;
	}
	public void setReferentielFaunes(List<ReferentielFaune> referentielFaunes) {
		this.referentielFaunes = referentielFaunes;
	}
	public void addReferentielFaunes (ReferentielFaune referentielFaune) {
		this.referentielFaunes.add(referentielFaune);
	}
	public List<Utilisateur> getUtilisateurs() {
		return utilisateurs;
	}
	public void setUtilisateurs(List<Utilisateur> utilisateurs) {
		this.utilisateurs = utilisateurs;
	}
	public void addUtilisateurs (Utilisateur utilisateur) {
		this.utilisateurs.add(utilisateur);
	}
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}
	public void addProduits (Produit produit) {
		this.produits.add(produit);
	}
	
	public List<Favoris> getFavoris() {
		return favoris;
	}
	public void setFavoris(List<Favoris> favoris) {
		this.favoris = favoris;
	}
	public void addFavoris (Favoris favori) {
		this.favoris.add(favori);
	}
	public List<Jardin> getJardins() {
		return jardins;
	}
	public void setJardins(List<Jardin> jardins) {
		this.jardins = jardins;
	}
	public void addJardins (Jardin jardin) {
		this.jardins.add(jardin);
	}
	
	
	@Override
	public String toString() {
		return "Flore [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
	
}
