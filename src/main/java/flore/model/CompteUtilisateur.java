package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class CompteUtilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String identifiant;
	@JsonView(Views.ViewCommon.class)
	private String motDePasse;
	@JsonView(Views.ViewCommon.class)
	private String mail;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private Civilite civilite;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String prenom;
	@JsonView(Views.ViewCommon.class)
	private String rue;
	@JsonView(Views.ViewCommon.class)
	private String complement;
	@JsonView(Views.ViewCommon.class)
	private String codePostal;
	@JsonView(Views.ViewCommon.class)
	private String ville;
	@JsonView(Views.ViewCommon.class)
	private String telephone;
	
	@OneToMany (mappedBy = "compte")
	private List<Historique> historiques = new ArrayList<Historique>();
	@OneToOne (mappedBy = "compteUtilisateur")
	private Utilisateur utilisateur;
	@OneToMany (mappedBy = "compteUtilisateur")
	private List <ReferentielUtilisateur> referentielUtiliseurs = new ArrayList<ReferentielUtilisateur>();
	@OneToMany (mappedBy = "compteUtilisateur")
	private List <Favoris> favoris = new ArrayList<Favoris>();
	@OneToOne (mappedBy = "compteUtilisateur")
	private Jardin jardin;	
	
	
	public CompteUtilisateur() {
		super();
	}
	public CompteUtilisateur(String identifiant, String motDePasse, String mail, Civilite civilite, String prenom,String nom, String rue,
			String complement, String codePostal, String ville, String telephone) {
		super();
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.civilite = civilite;
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public Civilite getCivilite() {
		return civilite;
	}
	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public List<Historique> getHistoriques() {
		return historiques;
	}
	public void setHistoriques(List<Historique> historiques) {
		this.historiques = historiques;
	}
	public List<ReferentielUtilisateur> getReferentielUtiliseurs() {
		return referentielUtiliseurs;
	}
	public void setReferentielUtiliseurs(List<ReferentielUtilisateur> referentielUtiliseurs) {
		this.referentielUtiliseurs = referentielUtiliseurs;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getComplement() {
		return complement;
	}
	public void setComplement(String complement) {
		this.complement = complement;
	}
	public String getCodePostal() {
		return codePostal;
	}
	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public List<Historique> getHistorique() {
		return historiques;
	}
	public void setHistorique(List<Historique> historique) {
		this.historiques = historique;
	}
	public void addHistorique (Historique historique) {
		this.historiques.add(historique);
	}
	public List<ReferentielUtilisateur> getReferentielUtilisateur() {
		return referentielUtiliseurs;
	}
	public void setReferentielUtilisateur(List<ReferentielUtilisateur> referentielUtilisateur) {
		this.referentielUtiliseurs = referentielUtilisateur;
	}
	public void addReferentielUtilisateur (ReferentielUtilisateur referentielUtiliseur) {
		this.referentielUtiliseurs.add(referentielUtiliseur);
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
	public Jardin getJardin() {
		return jardin;
	}
	public void setJardin(Jardin jardin) {
		this.jardin = jardin;
	}
	@Override
	public String toString() {
		return "CompteUtilisateur [id=" + id + ", version=" + version + ", identifiant=" + identifiant + ", motDePasse="
				+ motDePasse + ", mail=" + mail + ", civilite=" + civilite + ", nom=" + nom + ", prenom=" + prenom
				+ ", rue=" + rue + ", complement=" + complement + ", codePostal=" + codePostal + ", ville=" + ville
				+ ", telephone=" + telephone + ", jardin=" + jardin
				+ "]";
	}
	
}
