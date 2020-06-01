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
	
	// Pour tous les utilisateurs
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
	
	@JsonView(Views.ViewCommon.class)
	private String identifiant;
	@JsonView(Views.ViewCommon.class)
	private String motDePasse;
	@JsonView(Views.ViewCommon.class)
	private String mail;
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
	
	
	// Pour tous les clients (Disc = "Client")
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCompteClient.class)
	private Civilite civilite;
	@JsonView(Views.ViewCompteClient.class)
	private String nom;
	@JsonView(Views.ViewCompteClient.class)
	private String prenom;
	
	// Pour tous les fournisseurs (Disc = "Fournisseur")
	@JsonView(Views.ViewCompteFournisseur.class)
	private String denomination;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCompteFournisseur.class)
	private StatutJuridique statut;
	@JsonView(Views.ViewCompteFournisseur.class)
	private String SIRET_SIREN;
	@JsonView(Views.ViewCompteFournisseur.class)
	private String RCS;
	@JsonView(Views.ViewCompteFournisseur.class)
	private String TVA;
	
	// Liens
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
	
	// Pour tous les utilisateurs
	public CompteUtilisateur(Long id, int version, TypeUtilisateur disc, String identifiant, String motDePasse,
			String mail, String rue, String complement, String codePostal, String ville, String telephone) {
		super();
		this.id = id;
		this.version = version;
		this.disc = disc;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
	}


	// Pour tous les clients (Disc = "Client")
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
	
	// Pour tous les fournisseurs (Disc = "Fournisseur")
	public CompteUtilisateur(Long id, int version, TypeUtilisateur disc, String identifiant, String motDePasse,
			String mail, String rue, String complement, String codePostal, String ville, String telephone,
			String denomination, StatutJuridique statut, String sIRET_SIREN, String rCS, String tVA) {
		super();
		this.id = id;
		this.version = version;
		this.disc = disc;
		this.identifiant = identifiant;
		this.motDePasse = motDePasse;
		this.mail = mail;
		this.rue = rue;
		this.complement = complement;
		this.codePostal = codePostal;
		this.ville = ville;
		this.telephone = telephone;
		this.denomination = denomination;
		this.statut = statut;
		SIRET_SIREN = sIRET_SIREN;
		RCS = rCS;
		TVA = tVA;
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
	
	public TypeUtilisateur getDisc() {
		return disc;
	}

	public void setDisc(TypeUtilisateur disc) {
		this.disc = disc;
	}

	public String getDenomination() {
		return denomination;
	}

	public void setDenomination(String denomination) {
		this.denomination = denomination;
	}

	public StatutJuridique getStatut() {
		return statut;
	}

	public void setStatut(StatutJuridique statut) {
		this.statut = statut;
	}

	public String getSIRET_SIREN() {
		return SIRET_SIREN;
	}

	public void setSIRET_SIREN(String sIRET_SIREN) {
		SIRET_SIREN = sIRET_SIREN;
	}

	public String getRCS() {
		return RCS;
	}

	public void setRCS(String rCS) {
		RCS = rCS;
	}

	public String getTVA() {
		return TVA;
	}

	public void setTVA(String tVA) {
		TVA = tVA;
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
