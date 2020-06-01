package flore.web.dto;

import com.fasterxml.jackson.annotation.JsonView;

import flore.model.Caracteristique;
import flore.model.Views;

public class Malus {
	@JsonView (Views.ViewCaracteristique.class)
	private Caracteristique caracUn;
	@JsonView (Views.ViewCaracteristique.class)
	private Caracteristique caracDeux;
	@JsonView (Views.ViewCaracteristique.class)
	private String message;
	@JsonView (Views.ViewCaracteristique.class)
	private Integer point;

	public Malus() {
		super();
	}

	public Malus(Caracteristique caracUn, Caracteristique caracDeux, String message, Integer point) {
		super();
		this.caracUn = caracUn;
		this.caracDeux = caracDeux;
		this.message = message;
		this.point = point;
	}

	public Caracteristique getCaracUn() {
		return caracUn;
	}

	public void setCaracUn(Caracteristique caracUn) {
		this.caracUn = caracUn;
	}

	public Caracteristique getCaracDeux() {
		return caracDeux;
	}

	public void setCaracDeux(Caracteristique caracDeux) {
		this.caracDeux = caracDeux;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Integer getPoint() {
		return point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	

	

	

}
