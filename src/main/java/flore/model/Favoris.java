package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Favoris {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private String nom;
	@ManyToMany
	@JoinTable (name = "Plante_Favories",joinColumns = @JoinColumn(name="favori_id"),inverseJoinColumns = @JoinColumn(name="flore_id"))
	private List<Flore> flores = new ArrayList<Flore>();
	@ManyToOne
	@JoinColumn (name = "compteUtilisateur_id")
	@JsonView(Views.ViewFavoris.class)
	private CompteUtilisateur compteUtilisateur;
	public Favoris(String nom) {
		super();
		this.nom = nom;
	}
	public Favoris() {
		super();
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
	public void addFlore (Flore flore) {
		this.flores.add(flore);
	}
	public List<Flore> getFlores() {
		return flores;
	}
	public void setFlores(List<Flore> flore) {
		this.flores = flore;
	}
	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}
	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}
	@Override
	public String toString() {
		return "Favoris [id=" + id + ", nom=" + nom + "]";
	}
	
	

}
