package flore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Historique {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String recherche;
	@JsonView(Views.ViewCommon.class)
	private String nomRecherche;
	@ManyToOne
	@JoinColumn (name ="compteUtilisateurId")
	//@JsonView(Views.ViewHistorique.class)
	private CompteUtilisateur compte;
	
	public Historique() {
		super();
	}
	public Historique(String recherche, String nomRecherche) {
		super();
		this.recherche = recherche;
		this.nomRecherche = nomRecherche;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getRecherche() {
		return recherche;
	}
	public void setRecherche(String recherche) {
		this.recherche = recherche;
	}
	public String getNomRecherche() {
		return nomRecherche;
	}
	public void setNomRecherche(String nomRecherche) {
		this.nomRecherche = nomRecherche;
	}
	public CompteUtilisateur getCompte() {
		return compte;
	}
	public void setCompte(CompteUtilisateur compte) {
		this.compte = compte;
	}
	
	public int getVersion() {
		return version;
	}
	public void setVersion(int version) {
		this.version = version;
	}
	@Override
	public String toString() {
		return "Historique [id=" + id + ", recherche=" + recherche + ", nomRecherche=" + nomRecherche + "]";
	}
	

}
