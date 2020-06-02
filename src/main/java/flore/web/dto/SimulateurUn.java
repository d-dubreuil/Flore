package flore.web.dto;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonView;

import flore.model.Views;

public class SimulateurUn {
	@JsonView (Views.ViewCaracteristique.class)
	private List<Bonus> bonus = new ArrayList<Bonus>();
	@JsonView (Views.ViewCaracteristique.class)
	private List<Malus> malus = new ArrayList<Malus>();

	public SimulateurUn() {
		super();
	}

	public List<Bonus> getBonus() {
		return bonus;
	}

	public void setBonus(List<Bonus> bonus) {
		this.bonus = bonus;
	}

	public List<Malus> getMalus() {
		return malus;
	}

	public void setMalus(List<Malus> malus) {
		this.malus = malus;
	}

}
