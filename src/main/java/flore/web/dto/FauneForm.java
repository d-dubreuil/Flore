package flore.web.dto;

import java.util.ArrayList;
import java.util.List;

public class FauneForm {
	private List<String> caracteristiques = new ArrayList<String>();

	public FauneForm() {
		super();
	}

	public List<String> getCaracteristiques() {
		return caracteristiques;
	}

	public void setCaracteristiques(List<String> caracteristiques) {
		this.caracteristiques = caracteristiques;
	}
	
}



