package flore.web.dto;

import java.util.ArrayList;
import java.util.List;

import flore.model.Caracteristique;

public class FloreForm {
	private List<Caracteristique> caracteristiques = new ArrayList<Caracteristique>();

	public FloreForm() {
		super();
	}

	public List<Caracteristique> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<Caracteristique> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
	
}
