package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Jardin {
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
	@JoinTable(name = "Plante_Jardin", joinColumns = @JoinColumn(name = "jardin_id"), inverseJoinColumns = @JoinColumn(name = "flore_id"))
	//@JsonView(Views.ViewJardin.class)
	private List<Flore> flores = new ArrayList<Flore>();
	@OneToOne
	@JoinColumn(name = "compteUtilisateur_id")
	//@JsonView(Views.ViewJardin.class)
	private CompteUtilisateur compteUtilisateur;

	public Jardin(String nom) {
		super();
		this.nom = nom;
	}

	public Jardin() {
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

	public List<Flore> getFlores() {
		return flores;
	}

	public void setFlores(List<Flore> flores) {
		this.flores = flores;
	}

	public void addFlores(Flore flore) {
		this.flores.add(flore);
	}

	public CompteUtilisateur getCompteUtilisateur() {
		return compteUtilisateur;
	}

	public void setCompteUtilisateur(CompteUtilisateur compteUtilisateur) {
		this.compteUtilisateur = compteUtilisateur;
	}

	@Override
	public String toString() {
		return "Jardin [id=" + id + ", nom=" + nom + "]";
	}

}
