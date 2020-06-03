package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Version;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Panier {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@JsonView(Views.ViewCommon.class)
	private Float total;
	@OneToOne(mappedBy = "panier")
	@JsonView(Views.ViewPanier.class)
	private Commande commande;
	@OneToMany(mappedBy = "panier")
	@JsonView(Views.ViewPanier.class)
	@LazyCollection(LazyCollectionOption.FALSE)
	private List<Selection> selections= new ArrayList<Selection>();
	@ManyToOne
	@JoinColumn(name= "utilisateur_id")
	@JsonView(Views.ViewPanier.class)
	private Utilisateur utilisateur;
	
	
	public Panier() {
		super();
	}
	public Panier(Float total) {
		super();

		this.total = total;
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
	public Float getTotal() {
		return total;
	}
	public void setTotal(Float total) {
		this.total = total;
	}
	
	


	public Commande getCommande() {
		return commande;
	}
	public void setCommande(Commande commande) {
		this.commande = commande;
	}
	public List<Selection> getSelections() {
		return selections;
	}
	public void setSelections(List<Selection> selections) {
		this.selections = selections;
	}
	public Utilisateur getUtilisateur() {
		return utilisateur;
	}
	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}
	
	public void addSelection(Selection selection) {
		this.selections.add(selection);
	}

	@Override
	public String toString() {
		return "Panier [id=" + id + ", version=" + version + ", total=" + total + "]";
	}
	
}
