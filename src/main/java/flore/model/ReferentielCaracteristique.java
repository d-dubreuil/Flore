package flore.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class ReferentielCaracteristique {
	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@ManyToOne
	@JoinColumn (name = "caracteristique_Id")
	@JsonView({Views.ViewCaracteristiqueFlore.class,Views.ViewFloreWithRefCarac.class,Views.ViewPanier.class})
	private Caracteristique caracteristique;
	@ManyToOne
	@JoinColumn (name = "flore_id")
	@JsonView({Views.ViewCaracteristiqueFlore.class})
	private Flore flore;
	
	public Caracteristique getCaracteristique() {
		return caracteristique;
	}
	public void setCaracteristique(Caracteristique caracteristique) {
		this.caracteristique = caracteristique;
	}
	public Flore getFlore() {
		return flore;
	}
	public void setFlore(Flore flore) {
		this.flore = flore;
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
