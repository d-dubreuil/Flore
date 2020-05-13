package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Caracteristique {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@JsonView(Views.ViewCommon.class)
	@Version
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@JsonView(Views.ViewCommon.class)
	private String valeur;
	@JsonView(Views.ViewCommon.class)
	private Boolean bonusMalus;
	@Enumerated(EnumType.STRING)
	@JsonView(Views.ViewCommon.class)
	private TypeCarac typeCarac;
	@OneToMany(mappedBy = "caracteristique")
	private List<ReferentielUtilisateur> referentielUtilisateurs = new ArrayList<ReferentielUtilisateur>();
	@OneToMany(mappedBy = "caracteristique")
	@JsonView(Views.ViewCaracteristiqueFlore.class)
	private List<ReferentielCaracteristique> referentielCaracteristiques = new ArrayList<ReferentielCaracteristique>();
	@OneToMany(mappedBy = "caracteristique")
	private List<ReferentielFaune> referentielFaunes = new ArrayList<ReferentielFaune>();

	public Caracteristique() {
		super();
	}

	

	public Boolean getBonusMalus() {
		return bonusMalus;
	}



	public void setBonusMalus(Boolean bonusMalus) {
		this.bonusMalus = bonusMalus;
	}



	public Caracteristique(String nom, String valeur, TypeCarac typeCarac) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.typeCarac = typeCarac;
	}
	public Caracteristique(String nom, String valeur, TypeCarac typeCarac, Boolean bonusMalus) {
		super();
		this.nom = nom;
		this.valeur = valeur;
		this.typeCarac = typeCarac;
		this.bonusMalus = bonusMalus;
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

	public String getValeur() {
		return valeur;
	}

	public void setValeur(String valeur) {
		this.valeur = valeur;
	}

	public TypeCarac getTypeCarac() {
		return typeCarac;
	}

	public void setTypeCarac(TypeCarac typeCarac) {
		this.typeCarac = typeCarac;
	}

	public int getVersion() {
		return version;
	}

	public void setVersion(int version) {
		this.version = version;
	}

	public List<ReferentielUtilisateur> getReferentielUtilisateur() {
		return referentielUtilisateurs;
	}

	public void setReferentielUtilisateur(List<ReferentielUtilisateur> referentielUtilisateur) {
		this.referentielUtilisateurs = referentielUtilisateur;
	}

	public void addReferentielUtilisateur(ReferentielUtilisateur referentielUtilisateur) {
		this.referentielUtilisateurs.add(referentielUtilisateur);
	}

	public List<ReferentielCaracteristique> getReferentielCaracteristique() {
		return referentielCaracteristiques;
	}

	public void setReferentielCaracteristique(List<ReferentielCaracteristique> referentielCaracteristique) {
		this.referentielCaracteristiques = referentielCaracteristique;
	}

	public void addReferentielCaracteristique(ReferentielCaracteristique referentielCaracteristique) {
		this.referentielCaracteristiques.add(referentielCaracteristique);
	}

	public List<ReferentielFaune> getReferentielFaune() {
		return referentielFaunes;
	}

	public void setReferentielFaune(List<ReferentielFaune> referentielFaune) {
		this.referentielFaunes = referentielFaune;
	}

	public void addReferentielFaune(ReferentielFaune referentielFaune) {
		this.referentielFaunes.add(referentielFaune);
	}



	@Override
	public String toString() {
		return "Caracteristique [id=" + id + ", version=" + version + ", nom=" + nom + ", valeur=" + valeur
				+ ", bonusMalus=" + bonusMalus + ", typeCarac=" + typeCarac + "]";
	}
	
	

}
