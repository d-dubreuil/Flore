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

		String nomFlore1 = "Menthe Poivrée";
		String nomFlore2 = "Haricot";

		/////////////////////////
		// On appelle les caractéristiques des plantes 1 et 2 qui vont être comparées
		///////////////////////// afin de définir les synergies si elles existent
		/////////////////////////

		List<Caracteristique> stratFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Strate");
		List<Caracteristique> stratFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Strate");

		List<Caracteristique> tempFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Température");
		List<Caracteristique> tempFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Température");

		List<Caracteristique> ensolFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Ensoleillement");
		List<Caracteristique> ensolFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Ensoleillement");

		List<Caracteristique> ventFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Vent");
		List<Caracteristique> ventFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Vent");

		List<Caracteristique> pHFlore1 = caracRepo.findByFloreCarac(nomFlore1, "pH");
		List<Caracteristique> pHFlore2 = caracRepo.findByFloreCarac(nomFlore2, "pH");

		List<Caracteristique> textFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Texture");
		List<Caracteristique> textFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Texture");

		List<Caracteristique> humFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Humidité");
		List<Caracteristique> humFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Humidité");

		List<Caracteristique> arroFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Arrosage");
		List<Caracteristique> arroFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Arrosage");

		List<Caracteristique> racFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Racines");
		List<Caracteristique> racFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Racines");

		List<Caracteristique> croiFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Croissance");
		List<Caracteristique> croiFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Croissance");

		List<Caracteristique> azoFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Azote");
		List<Caracteristique> azoFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Azote");

		List<Caracteristique> nutriFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Nutriment");
		List<Caracteristique> nutriFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Nutriment");

		/////////////////////////
		// On affecte une valeur pour chacune des strat récupérée pour pouvoir les
		///////////////////////// comparer plus facilement par la suite
		/////////////////////////

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

		/////////////////////////
		// On déclare les listes de caractéristiques que l'on récupéréra si synergie
		///////////////////////// positive ou négative il y a
		/////////////////////////

		List<Caracteristique> caracBonusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusPositif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusNegatif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracBonusNegatif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusPositif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusPositif2 = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusNegatif = new ArrayList<Caracteristique>();
		List<Caracteristique> caracMalusNegatif2 = new ArrayList<Caracteristique>();

		//////////////////////////////////////////////////////
		//// Synergies avec valeur similaire////
		//////////////////////////////////////////////////////

		/////////////////////////
		//// Température////
		/////////////////////////
		if (tempFlore1.size() <= 1 && tempFlore2.size() <= 1) {
			if (!tempFlore1.isEmpty() && !tempFlore2.isEmpty()) {
				Caracteristique carac = tempFlore1.get(0);
				Caracteristique carac2 = tempFlore2.get(0);

				System.out.println("########");

				// On sépare la valeur de la carac type température "t°Cmin - t°Cmax" en temps=
				// ["t°Cmin", t°Cmax]
				String[] temps1 = carac.getValeur().split("/");
				String[] temps2 = carac2.getValeur().split("/");
				System.out.println(temps1.length);

				if (temps1.length == 2 && temps2.length == 2 && temps1[0] != "#" && temps1[1] != "#" && temps2[0] != "#"
						&& temps2[1] != "#") {
					// try + catch à insérer?ou géré par springboot?
					Integer temp1Min;
					Integer temp1Max;
					Integer temp2Min;
					Integer temp2Max;
					temp1Min = Integer.parseInt(temps1[0]);
					temp1Max = Integer.parseInt(temps1[1]);
					temp2Min = Integer.parseInt(temps2[0]);
					temp2Max = Integer.parseInt(temps2[1]);

					Integer diffMin = Math.abs(temp1Min - temp2Min);
					System.out.println(diffMin);
					Integer diffMax = Math.abs(temp1Max - temp2Max);
					System.out.println(diffMax);

					// on considère un bonus en synergie si les plages de températures des deux
					// plantes sont similaires(+-5°C) ou si les plages se recouvrent
					if ((temp1Min >= temp2Min && temp1Max <= temp2Max) || (temp1Min <= temp2Min && temp1Max >= temp2Max)
							|| (diffMin <= 5 || diffMax <= 5)) {
						caracBonusPositif.add(carac);
						caracBonusPositif2.add(carac2);
						System.out.println("La carac " + carac.getNom()
								+ " est positive car les deux plantes ont une plage de température similaire");

					} else {
						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);
						System.out.println("La carac " + carac.getNom()
								+ " est négative car les deux plantes ont des différences de températures optimales");

					}
				} else {
					System.out.println(
							"Une des caractéristiques température est incomplète ou mal renseignée dans la base de donnée");
				}
			}
		} else if (!tempFlore1.isEmpty() && !tempFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques température");
		}

		/////////////////////////
		//// Vent////
		/////////////////////////
		if (ventFlore1.size() <= 1 && ventFlore2.size() <= 1) {
			if (!ventFlore1.isEmpty() && !ventFlore2.isEmpty()) {

				Caracteristique carac = ventFlore1.get(0);
				Caracteristique carac2 = ventFlore2.get(0);

				if (carac.getValeur().equals("Peu Résistant") || carac2.getValeur().equals("Peu Résistant")) {
					System.out.println("########");
					for (Caracteristique strat : stratFlore1) {
						if ((strat.getValeur().equals("Canopée") || strat.getValeur().equals("Petits Arbres")
								|| strat.getValeur().equals("Arbustive") || carac.getValeur().equals("Haie Brise-Vent"))
								&& carac2.getValeur().equals("Peu Résistant")) {
							caracBonusPositif.add(carac2);

							System.out.println("La carac " + carac.getNom() + " est positive car la plante 2 est "
									+ carac2.getValeur() + " et la plante 1 est résistante au vent");
						}
					}
					for (Caracteristique strat2 : stratFlore2) {
						if ((strat2.getValeur().equals("Canopée") || strat2.getValeur().equals("Petits Arbres")
								|| strat2.getValeur().equals("Arbustive")
								|| carac2.getValeur().equals("Haie Brise-Vent"))
								&& carac.getValeur().equals("Peu Résistant")) {
							caracBonusPositif.add(carac);
							System.out.println("La carac " + carac.getNom() + " est positive car la plante 1 est "
									+ carac.getValeur() + " et la plante 2 est résistante au vent");
						}
					}

				}
			}
		}

		else if (!ventFlore1.isEmpty() && !ventFlore2.isEmpty()){
			System.out.println("Une même flore ne peut contenir 2 caractéristiques vent");
		}

		/////////////////////////
		//// Ensoleillement////
		/////////////////////////
		int ensolCount = 0;
		for (Caracteristique carac : ensolFlore1) {
			for (Caracteristique carac2 : ensolFlore2) {

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Ensoleillement")) {
					System.out.println("########");
					if (carac2.getValeur().equals(carac.getValeur())) {
						ensolCount++;
						caracBonusPositif.add(carac);
						caracBonusPositif2.add(carac2);
						System.out.println("La carac " + carac.getNom() + " est positive car les deux plantes sont : "
								+ carac.getValeur());
					}
				}

				else if ((carac2.getValeur().equals("Mi Ombre")
						&& (carac.getValeur().equals("Plein Soleil") || carac.getValeur().equals("Soleil")))
						|| (carac.getValeur().equals("Mi Ombre") && (carac2.getValeur().equals("Plein Soleil")
								|| carac2.getValeur().equals("Soleil")))) {
					for (Integer nb1 : nbrstrat1) {
						for (Integer nb2 : nbrstrat2) {
							if ((nb1 > nb2 && carac2.getValeur().equals("Mi Ombre"))) {
								ensolCount++;
								caracBonusPositif2.add(carac2);
								System.out.println("########");
								System.out.println("La carac " + carac.getNom()
										+ " est positive car la plante 1 est plus haute que la plante 2 et aime le soleil et peut lui procurer du mi-ombre");
							} else if (nb1 < nb2 && carac.getValeur().equals("Mi Ombre")) {
								caracBonusPositif.add(carac);
								ensolCount++;
								System.out.println("########");
								System.out.println("La carac " + carac.getNom()
										+ " est positive car la plante 2 est plus haute que la plante 1 et aime le soleil et peut lui procurer du mi-ombre");
							}
						}
					}

				}

			}
		}

		if (ensolCount == 0 && !ensolFlore1.isEmpty() && !ensolFlore2.isEmpty()) {
			for (Caracteristique carac : ensolFlore1) {
				for (Caracteristique carac2 : ensolFlore2) {
					if (!carac2.getValeur().equals(carac.getValeur())) {

						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);
						System.out.println("########");
						System.out.println("La carac " + carac.getNom()
								+ " est négative car les deux plantes ont besoin d'ensoleillement différent.");
					}
				}
			}
		}
		/////////////////////////
		//// pH////
		/////////////////////////
		int pHCount = 0;
		for (Caracteristique carac : pHFlore1) {
			for (Caracteristique carac2 : pHFlore2) {

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("pH") && carac2.getValeur().equals(carac.getValeur())) {
					pHCount++;
					System.out.println("########");
					caracBonusPositif.add(carac);
					caracBonusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom() + " est positive car les deux plantes sont : "
							+ carac.getValeur());
				}
			}
		}

		if (pHCount == 0 && !pHFlore1.isEmpty() && !pHFlore2.isEmpty()) {
			for (Caracteristique carac : pHFlore1) {
				for (Caracteristique carac2 : pHFlore2) {
					if (!carac2.getValeur().equals(carac.getValeur())) {

						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);
						System.out.println("########");
						System.out.println("La carac " + carac.getNom()
								+ " est négative car les deux plantes ont besoin de pH différents.");
					}
				}
			}
		}

		/////////////////////////
		//// Texture////
		/////////////////////////
		int textCount = 0;
		for (Caracteristique carac : textFlore1) {
			for (Caracteristique carac2 : textFlore2) {

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Texture") && carac2.getValeur().equals(carac.getValeur())) {
					textCount++;
					System.out.println("########");
					caracBonusPositif.add(carac);
					caracBonusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom() + " est positive car les deux plantes sont : "
							+ carac.getValeur());
				}
			}
		}

		if (textCount == 0 && !pHFlore1.isEmpty() && !pHFlore2.isEmpty()) {
			for (Caracteristique carac : pHFlore1) {
				for (Caracteristique carac2 : pHFlore2) {
					if (!carac2.getValeur().equals(carac.getValeur())) {

						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);
						System.out.println("########");
						System.out.println("La carac " + carac.getNom()
								+ " est négative car les deux plantes ont besoin de texture du sol différentes.");
					}
				}
			}
		}

		/////////////////////////
		//// Humidité////
		/////////////////////////
		int humCount = 0;
		for (Caracteristique carac : humFlore1) {
			for (Caracteristique carac2 : humFlore2) {

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Humidité") && carac2.getValeur().equals(carac.getValeur())) {
					humCount++;
					System.out.println("########");
					caracBonusPositif.add(carac);
					caracBonusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom() + " est positive car les deux plantes sont : "
							+ carac.getValeur());
				}
			}
		}

		if (humCount == 0 && !humFlore1.isEmpty() && !humFlore2.isEmpty()) {
			for (Caracteristique carac : humFlore1) {
				for (Caracteristique carac2 : humFlore2) {
					if (!carac2.getValeur().equals(carac.getValeur())) {
						System.out.println("########");
						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);

						System.out.println("La carac " + carac.getNom()
								+ " est négative car les deux plantes ont besoin d'humidité du sol différentes.");
					}
				}
			}
		}

		/////////////////////////
		//// Arrosage////
		/////////////////////////

		if (arroFlore1.size() <= 1 && arroFlore2.size() <= 1) {

			if (!arroFlore1.isEmpty() && !arroFlore2.isEmpty()) {
				Caracteristique carac = arroFlore1.get(0);
				Caracteristique carac2 = arroFlore2.get(0);

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Arrosage") && carac2.getValeur().equals(carac.getValeur())) {
					System.out.println("########");
					caracBonusPositif.add(carac);
					caracBonusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom() + " est positive car les deux plantes sont : "
							+ carac.getValeur());
				} else if (!carac2.getValeur().equals(carac.getValeur())) {

					caracBonusNegatif.add(carac);
					caracBonusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont besoin d'arrosage différent.");
				}

			}
		} else if(!arroFlore1.isEmpty() && !arroFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques arrosage");
		}

		//////////////////////////////////////////////////////
		//// Synergies avec valeur différente////
		//////////////////////////////////////////////////////

		/////////////////////////
		//// Strate////
		/////////////////////////

		if (stratFlore1.size() <= 1 && stratFlore2.size() <= 1) {

			if (!stratFlore1.isEmpty() && !stratFlore2.isEmpty()) {
				Caracteristique carac = stratFlore1.get(0);
				Caracteristique carac2 = stratFlore2.get(0);

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Strate") && !carac2.getValeur().equals(carac.getValeur())) {
					System.out.println("########");
					caracMalusPositif.add(carac);
					caracMalusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom()
							+ " est positive car les deux plantes ont une strate différente");
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					caracMalusNegatif.add(carac);
					caracMalusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont la strate : " + carac.getValeur());
				}

			}
		} else if(!stratFlore1.isEmpty() && !stratFlore2.isEmpty()){
			System.out.println("Une même flore ne peut contenir 2 caractéristiques strate");
		}

		/////////////////////////
		//// Racines////
		/////////////////////////

		if (racFlore1.size() <= 1 && racFlore2.size() <= 1) {

			if (!racFlore1.isEmpty() && !racFlore2.isEmpty()) {
				Caracteristique carac = racFlore1.get(0);
				Caracteristique carac2 = racFlore2.get(0);

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Racines") && !carac2.getValeur().equals(carac.getValeur())) {
					System.out.println("########");
					caracMalusPositif.add(carac);
					caracMalusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom()
							+ " est positive car les deux plantes ont une profondeur de racine différente");
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					caracMalusNegatif.add(carac);
					caracMalusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont la même caractéristique : " + carac.getValeur());
				}

			}
		} else if (!racFlore1.isEmpty() && !racFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques racines");
		}

		/////////////////////////
		//// Azote////
		/////////////////////////

		// On regarde si une des deux plantes est fixatrice d'azote et l'autre
		// inhibitrice//
		int azoCountFixa = 0;
		int azoCountInhi = 0;
		for (Caracteristique carac : azoFlore1) {
			for (Caracteristique carac2 : azoFlore2) {
				if (carac.getValeur().equals("Inhibiteur") || carac2.getValeur().equals("Inhibiteur")) {
					azoCountInhi++;
				} else if (carac.getValeur().equals("Fixateur") || carac2.getValeur().equals("Fixateur")) {
					azoCountFixa++;
				}
			}
		}

		for (Caracteristique carac : azoFlore1) {
			for (Caracteristique carac2 : azoFlore2) {
				if (azoCountInhi >= 1 && azoCountFixa >= 1) {
					if (carac2.getValeur().equals("Inhibiteur") && carac.getValeur().equals("Fixateur")) {
						caracMalusNegatif2.add(carac2);
						System.out.println("########");
						System.out.println("La carac " + carac.getNom()
								+ " est négative car une des deux plantes est fixatrice d'azote et la seconde est un inhibiteur de croissance des bactéries fixatrices d'azote");
						break;
					} else if (carac.getValeur().equals("Inhibiteur") && carac2.getValeur().equals("Fixateur")) {
						caracMalusNegatif.add(carac);
						System.out.println("########");
						System.out.println("La carac " + carac.getNom()
								+ " est négative car une des deux plantes est fixatrice d'azote et la seconde est un inhibiteur de croissance des bactéries fixatrices d'azote");
						break;
					}
				} else if ((!carac2.getValeur().equals("Inhibiteur") && !carac.getValeur().equals("Inhibiteur"))
						&& !carac2.getValeur().equals(carac.getValeur()) && !azoFlore1.isEmpty()
						&& !azoFlore2.isEmpty()) {

					System.out.println("########");
					caracMalusPositif.add(carac);
					caracMalusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom()
							+ " est positive car les deux plantes ont des demandes d'azote différentes");
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					caracMalusNegatif.add(carac);
					caracMalusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont la même caractéristique : " + carac.getValeur());

				}
			}
		}

		/////////////////////////
		//// Autre Nutriments////
		/////////////////////////

		if (nutriFlore1.size() <= 1 && nutriFlore2.size() <= 1) {

			if (!nutriFlore1.isEmpty() && !nutriFlore2.isEmpty()) {
				Caracteristique carac = nutriFlore1.get(0);
				Caracteristique carac2 = nutriFlore2.get(0);

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Nutriment") && !carac2.getValeur().equals(carac.getValeur())) {
					System.out.println("########");
					caracMalusPositif.add(carac);
					caracMalusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom()
							+ " est positive car les deux plantes ont des demandes de nutriments disctintes");
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					caracMalusNegatif.add(carac);
					caracMalusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont le même besoin en nutriment : "
							+ carac.getValeur());
				}

			}
		} else if (!nutriFlore1.isEmpty() && !nutriFlore2.isEmpty()){
			System.out.println("Une même flore ne peut contenir 2 caractéristiques nutriment");
		}

		/////////////////////////
		//// Croissance////
		/////////////////////////

		if (croiFlore1.size() <= 1 && croiFlore2.size() <= 1) {

			if (!croiFlore1.isEmpty() && !croiFlore2.isEmpty()) {
				Caracteristique carac = croiFlore1.get(0);
				Caracteristique carac2 = croiFlore2.get(0);

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Croissance") && !carac2.getValeur().equals(carac.getValeur())) {
					System.out.println("########");
					caracMalusPositif.add(carac);
					caracMalusPositif2.add(carac2);
					System.out.println("La carac " + carac.getNom()
							+ " est positive car les deux plantes ont des croissances disctintes");
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					caracMalusNegatif.add(carac);
					caracMalusNegatif2.add(carac2);
					System.out.println("########");
					System.out.println("La carac " + carac.getNom()
							+ " est négative car les deux plantes ont la même vitesse de croissance : "
							+ carac.getValeur());
				}

			}
		} else if (!croiFlore1.isEmpty() && !croiFlore2.isEmpty()){
			System.out.println("Une même flore ne peut contenir 2 caractéristiques croissance");
		}

	}
}

//		for (Caracteristique carac : caracBonusPositif) {
//			System.out.println(
//					"La carac " + carac.getNom() + " est positive car les deux plantes sont : " + carac.getValeur());
//		}
//		System.out.println("########");
//		for (Caracteristique carac : caracBonusNegatif) {
//			System.out.println(
//					"La carac " + carac.getNom() + " est negatif car la plante 2 n'est pas : " + carac.getValeur());
//		}
//		System.out.println("########");
//		for (Caracteristique carac : caracMalusNegatif) {
//			System.out.println(
//					"La carac " + carac.getNom() + " est negatif car les deux plantes sont : " + carac.getValeur());
//		}
//		System.out.println("########");
//		for (Caracteristique carac : caracMalusPositif) {
//			System.out.println(
//					"La carac " + carac.getNom() + " est positive car la plante 2 n'est pas : " + carac.getValeur());
//		}
