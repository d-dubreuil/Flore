package Flore;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import flore.model.Caracteristique;
import flore.persistence.ICaracteristiqueRepository;

@SpringBootTest
class FloreSynergiesTests {
	@Autowired
	private ICaracteristiqueRepository caracRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void sontEllesAmies() {
		List<Caracteristique> caracFlore1 = caracRepo.findByFlore("courge");
		List<Caracteristique> caracFlore2 = caracRepo.findByFlore("mais");

		List<Caracteristique> stratFlore1 = caracRepo.findByNom("Strate");
		List<Caracteristique> stratFlore2 = caracRepo.findByNom("Strate");

		
		//On affecte une valeur pour chacune des strat récupérée pour pouvoir les comparer par la suite
		ArrayList<Integer> nbrstrat1 = new ArrayList<>();

		for (Caracteristique stratnb : stratFlore1) {
			if (stratnb.getValeur() == "Rhizosphère") {
				nbrstrat1.add(0);
			}

			else if (stratnb.getValeur() == "Couvre-Sol") {
				nbrstrat1.add(1);
			}

			else if (stratnb.getValeur() == "Herbacée Basse") {
				nbrstrat1.add(2);
			}

			else if (stratnb.getValeur() == "Herbacée Haute") {
				nbrstrat1.add(3);
			}

			else if (stratnb.getValeur() == "Grimpante") {
				nbrstrat1.add(4);
			}

			else if (stratnb.getValeur() == "Arbustive") {
				nbrstrat1.add(5);
			}

			else if (stratnb.getValeur() == "Petits Arbres") {
				nbrstrat1.add(6);
			}

			else if (stratnb.getValeur() == "Canopée") {
				nbrstrat1.add(7);
			}

		}

		ArrayList<Integer> nbrstrat2 = new ArrayList<>();

		for (Caracteristique stratnb2 : stratFlore2) {
			if (stratnb2.getValeur() == "Rhizosphère") {
				nbrstrat2.add(0);
			}

			else if (stratnb2.getValeur() == "Couvre-Sol") {
				nbrstrat2.add(1);
			}

			else if (stratnb2.getValeur() == "Herbacée Basse") {
				nbrstrat2.add(2);
			}

			else if (stratnb2.getValeur() == "Herbacée Haute") {
				nbrstrat2.add(3);
			}

			else if (stratnb2.getValeur() == "Grimpante") {
				nbrstrat1.add(4);
			}

			else if (stratnb2.getValeur() == "Arbustive") {
				nbrstrat2.add(5);
			}

			else if (stratnb2.getValeur() == "Petits Arbres") {
				nbrstrat2.add(6);
			}

			else if (stratnb2.getValeur() == "Canopée") {
				nbrstrat2.add(7);
			}

		}

		//On déclare les listes de caractéristiques que l'on récupéréra si synergie positive ou négative il y a
		List<Caracteristique> caracBonusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusPositif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusNegatif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusNegatif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusPositif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusNegatif = new ArrayList<Caracteristique>();

		for (Caracteristique carac : caracFlore1) {
			for (Caracteristique carac2 : caracFlore2) {
				if (carac.getBonusMalus() == null) {
					break;
				} else if (carac.getBonusMalus()) {
					// on définie une synergie particulière pour la caractéristique de type température
					if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom() == "Temperature") {
						// On sépare la valeur de la carac type température "t°Cmin - t°Cmax" en temps= ["t°Cmin", t°Cmax]

						String[] temps1 = carac.getValeur().split("-");
						// try + catch à insérer?ou géré par springboot?
						Integer temp1Min = Integer.parseInt(temps1[0]);
						Integer temp1Max = Integer.parseInt(temps1[1]);

						String[] temps2 = carac2.getValeur().split("-");
						// try + catch à insérer?ou géré par springboot?
						Integer temp2Min = Integer.parseInt(temps2[0]);
						Integer temp2Max = Integer.parseInt(temps2[1]);
						Integer diffMin = Math.abs(temp1Min - temp2Min);
						Integer diffMax = Math.abs(temp1Max - temp2Max);

						// on considère un bonus en synergie si les plages de températures des deux plantes sont similaires(+-5°C) ou si les plages se recouvrent
						if ((temp1Min > temp2Min && temp1Max < temp2Max) || (temp1Min < temp2Min && temp1Max > temp2Max)
								|| (diffMin <= 5 && diffMax <= 5)) {
							caracBonusPositif.add(carac);
							caracBonusPositif2.add(carac2);

						} else {
							caracBonusNegatif.add(carac);
							caracBonusNegatif2.add(carac2);

						}
					}
					// on définie une synergie particulière pour la caractéristique de type Vent
					else if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom() == "Vent"
							&& (carac.getValeur() == "Peu Résistant" || carac2.getValeur() == "Peu Résistant")) {
						for (Caracteristique strat : stratFlore1) {
							if ((strat.getValeur() == "Canopée" || strat.getValeur() == "Petits Arbres"
									|| strat.getValeur() == "Arbustive") && carac2.getValeur() == "Peu Résistant") {
								caracBonusPositif.add(carac2);
							}
						}
						for (Caracteristique strat2 : stratFlore2) {
							if ((strat2.getValeur() == "Canopée" || strat2.getValeur() == "Petits Arbres"
									|| strat2.getValeur() == "Arbustive") && carac.getValeur() == "Peu Résistant") {
								caracBonusPositif.add(carac);
							}
						}

					}
					// on définie une synergie particulière pour la caractéristique de type Ensoleillement
					else if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom() == "Ensoleillement") {
						if (carac2.getTypeCarac() == carac.getTypeCarac()) {
							caracBonusPositif.add(carac);
							caracBonusPositif2.add(carac2);
						}

						else if ((carac2.getValeur() == "Mi Ombre"
								&& (carac.getValeur() == "Plein Soleil" || carac.getValeur() == "Soleil"))
								|| (carac.getValeur() == "Mi Ombre"
										&& (carac2.getValeur() == "Plein Soleil" || carac2.getValeur() == "Soleil"))) {
							for (Integer nb1 : nbrstrat1) {
								for (Integer nb2 : nbrstrat2) {
									if ((nb1 > nb2 && carac2.getValeur() == "Mi Ombre")) {
										caracBonusPositif2.add(carac2);
									} else if (nb1 < nb2 && carac.getValeur() == "Mi Ombre") {
										caracBonusPositif.add(carac);
									}
								}
							}

						}

						
						}


					else if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac2.getValeur().equals(carac.getValeur())) {
						caracBonusPositif.add(carac);
					} else if (carac2.getTypeCarac() == carac.getTypeCarac()
							&& carac2.getNom().equals(carac.getNom())) {
						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);

					}
				} else if (!carac.getBonusMalus()) {
					if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac2.getValeur().equals(carac.getValeur())) {
						caracMalusNegatif.add(carac);
					} else if (carac2.getTypeCarac() == carac.getTypeCarac()
							&& carac2.getNom().equals(carac.getNom())) {
						caracMalusPositif.add(carac);
						caracMalusPositif2.add(carac2);
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
