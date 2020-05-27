package Flore;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import flore.model.Caracteristique;
import flore.persistence.ICaracteristiqueRepository;

@SpringBootTest
class FloreApplicationTests {
	@Autowired
	private ICaracteristiqueRepository caracRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void sontEllesAmies() {
		List<Caracteristique> caracFlore1 = caracRepo.findByFlore("Courge");
		List<Caracteristique> caracFlore2 = caracRepo.findByFlore("Maïs");
		List<Caracteristique> caracBonusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusNegatif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusNegatif = new ArrayList<Caracteristique>();

		for (Caracteristique carac : caracFlore1) {
			for (Caracteristique carac2 : caracFlore2) {
				System.out.println("########");
				if (carac.getBonusMalus() == null) {
					break;
				} else if (carac.getBonusMalus()) {
					if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac2.getValeur().equals(carac.getValeur())) {
						caracBonusPositif.add(carac);
					} else if (carac2.getTypeCarac() == carac.getTypeCarac()
							&& carac2.getNom().equals(carac.getNom())) {
						caracBonusNegatif.add(carac);
					}
				} else if (!carac.getBonusMalus()) {
					if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac2.getValeur().equals(carac.getValeur())) {
						caracMalusNegatif.add(carac);
					} else if (carac2.getTypeCarac() == carac.getTypeCarac()
							&& carac2.getNom().equals(carac.getNom())) {
						caracMalusPositif.add(carac);
					}
				}
			}
		}
		for (Caracteristique carac : caracBonusPositif) {
			System.out.println(
					"La carac " + carac.getNom() + " est positive car les deux plantes sont : " + carac.getValeur());
		}
		System.out.println("########");
		for (Caracteristique carac : caracBonusNegatif) {
			System.out.println(
					"La carac " + carac.getNom() + " est negatif car la plante 2 n'est pas : " + carac.getValeur());
		}
		System.out.println("########");
		for (Caracteristique carac : caracMalusNegatif) {
			System.out.println(
					"La carac " + carac.getNom() + " est negatif car les deux plantes sont : " + carac.getValeur());
		}
		System.out.println("########");
		for (Caracteristique carac : caracMalusPositif) {
			System.out.println(
					"La carac " + carac.getNom() + " est positive car la plante 2 n'est pas : " + carac.getValeur());
		}
	}

}
