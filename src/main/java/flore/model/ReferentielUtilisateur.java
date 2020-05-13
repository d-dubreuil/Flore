package flore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class ReferentielUtilisateur {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@ManyToOne
	@JoinColumn (name = "compteUtilisateurId")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	private CompteUtilisateur compteUtilisateur;
	@ManyToOne
	@JoinColumn (name = "caracteristiqueId")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	private Caracteristique caracteristique;
	
	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}
	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}
	public Caracteristique getCaracteristique() {
		return caracteristique;
	}
	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
}
