package flore.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Version;

import com.fasterxml.jackson.annotation.JsonView;

@Entity
public class Faune {

	@Id
	@GeneratedValue
	@JsonView(Views.ViewCommon.class)
	private Long id;
	@Version
	@JsonView(Views.ViewCommon.class)
	private int version;
	@Column(unique = true)
	@JsonView(Views.ViewCommon.class)
	private String nomFaune;
	@OneToMany(mappedBy = "faune", fetch = FetchType.EAGER)
	@JsonView(Views.ViewFaune.class)
	private List<ReferentielFaune> referentielFaunes = new ArrayList<ReferentielFaune>();
	
	public Faune() {
		super();
	}
	public Faune(String nomFaune) {
		super();
		this.nomFaune = nomFaune;
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
	public String getNomFaune() {
		return nomFaune;
	}
	public void setNomFaune(String nomFaune) {
		this.nomFaune = nomFaune;
	}
	public void addReferentielFaune (ReferentielFaune referentielFaune) {
		this.referentielFaunes.add(referentielFaune);
	}
	
	public List<ReferentielFaune> getReferentielFaunes() {
		return referentielFaunes;
	}
	public void setReferentielFaunes(List<ReferentielFaune> referentielFaunes) {
		this.referentielFaunes = referentielFaunes;
	}
	@Override
	public String toString() {
		return "Faune [id=" + id + ", version=" + version + ", nomFaune=" + nomFaune + "]";
	}
	
	
}
