package flore.persistence.custom;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import flore.model.Caracteristique;
import flore.persistence.ICaracteristiqueRepository;
import flore.persistence.ISimulateurUnRepositoryCustom;
import flore.web.dto.Bonus;

import flore.web.dto.Malus;
import flore.web.dto.SimulateurUn;

@Repository
public class SimulateurUnRepositorylmpl implements ISimulateurUnRepositoryCustom{
	

	
	
	@Autowired
	private ICaracteristiqueRepository caracRepo;

	@Override
	public SimulateurUn synergieUn(String nomFlore1, String nomFlore2) {
		SimulateurUn simu1 = new SimulateurUn();
		
		////////////On récupère les nom des deux plantes à comparer. ////////////
		////////////On Récupère ensuite les caractéristiques qui leur sont associées et qui vont nous permettre de définir si il y a synergie ou non pour chaque caractéristique.////////////
		///////////Pour chaque synergie bonus ou malus déterminée, on sauvegarde la caractéristique des plantes 1 et 2 ainsi qu'un message décrivant la synergie.////////////
		///////////On affecte à un objet Bonus (de même pour Malus) la caractéristique 1 via son attribut codeUn, la caractéristique 2 via son attribut codeDeux et le message via son attribut message.////////////
		///////////On affecte ensuite la liste des objets Bonus et la liste des objets Malus à un objet Simulateur1 qui sera renvoyé à la partie web.////////////
		
//		String nomFlore1 = "Oignon";
//		String nomFlore2 = "Carotte";

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

		List<Caracteristique> predaFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Attraction");
		List<Caracteristique> predaFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Attraction");

		List<Caracteristique> repulsFlore1 = caracRepo.findByFloreCarac(nomFlore1, "Répulsion");
		List<Caracteristique> repulsFlore2 = caracRepo.findByFloreCarac(nomFlore2, "Répulsion");

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

			else if (stratnb.getValeur() == "Grimpante") {
				nbrstrat1.add(3);
			}

			else if (stratnb.getValeur() == "Herbacée Haute") {
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

			else if (stratnb2.getValeur() == "Grimpante") {
				nbrstrat2.add(3);
			}

			else if (stratnb2.getValeur() == "Herbacée Haute") {
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
		// On déclare la liste des objets bonus et malus.//
		/////////////////////////
		List<Bonus> bonusList = new ArrayList<Bonus>();
		List<Malus> malusList = new ArrayList<Malus>();
		
		

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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

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
						
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Les deux plantes se développent de manière optimale sur une plage de température similaire.";
						System.out.println(message);
						bonus.setPoint(3);
						bonus.setMessage(message);
						bonusList.add(bonus);
					} else {
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Pour se développer de manière optimale, les deux plantes nécessitent une plage de température assez différente.";
						malus.setPoint(-3);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);

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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac.getValeur().equals("Peu Résistant") || carac2.getValeur().equals("Peu Résistant")) {

					for (Caracteristique strat : stratFlore1) {
						if ((strat.getValeur().equals("Canopée") || strat.getValeur().equals("Petits Arbres")
								|| strat.getValeur().equals("Arbustive") || carac.getValeur().equals("Haie Brise-Vent"))
								&& carac2.getValeur().equals("Peu Résistant")) {
							
							bonus.setCaracUn(carac);
							bonus.setCaracDeux(carac2);
							message="Il existe une synergie autour du "+ carac.getNom() + " car "+ nomFlore1 +" peut protéger " + nomFlore2 + " du vent.";
							bonus.setMessage(message);
							bonus.setPoint(1);
							bonusList.add(bonus);	
							System.out.println(message);

						}
					}
					for (Caracteristique strat2 : stratFlore2) {
						if ((strat2.getValeur().equals("Canopée") || strat2.getValeur().equals("Petits Arbres")
								|| strat2.getValeur().equals("Arbustive")
								|| carac2.getValeur().equals("Haie Brise-Vent"))
								&& carac.getValeur().equals("Peu Résistant")) {
							
							bonus.setCaracUn(carac);
							bonus.setCaracDeux(carac2);
							message="Il existe une synergie autour du "+ carac.getNom() + " car "+ nomFlore2 +" peut protéger " + nomFlore1 + " du vent.";
							bonus.setMessage(message);
							bonus.setPoint(1);
							bonusList.add(bonus);	
							System.out.println(message);

						}
					}

				}
			}
		}

		else if (!ventFlore1.isEmpty() && !ventFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques vent");
		}

		/////////////////////////
		//// Ensoleillement////
		/////////////////////////
		int ensolCount = 0;
		for (Caracteristique carac : ensolFlore1) {
			for (Caracteristique carac2 : ensolFlore2) {
				Bonus bonus = new Bonus();
				String message;

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Ensoleillement")) {
					System.out.println("########");
					if (carac2.getValeur().equals(carac.getValeur())) {
						ensolCount++;
						
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive autour de l'ensoleillement car " + nomFlore1 +" et " + nomFlore2 + " ont besoin de "+ carac.getValeur()+".";
						bonus.setMessage(message);
						bonus.setPoint(1);
						bonusList.add(bonus);	
						System.out.println(message);

						
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
								
								bonus.setCaracUn(carac);
								bonus.setCaracDeux(carac2);
								message="Il existe une synergie positive autour de l'ensoleillement car " + nomFlore1 +" a besoin de "+carac.getValeur()+" et est plus haute que " + nomFlore2 + " qui, elle, a besoin de mi-ombre.";
								bonus.setMessage(message);
								bonus.setPoint(3);
								bonusList.add(bonus);	
								System.out.println(message);
								
							} else if (nb1 < nb2 && carac.getValeur().equals("Mi Ombre")) {
								ensolCount++;
								
								bonus.setCaracUn(carac);
								bonus.setCaracDeux(carac2);
								message="Il existe une synergie positive autour de l'ensoleillement car " + nomFlore2 +" a besoin de "+carac2.getValeur()+" et est plus haute que " + nomFlore1 + " qui, elle, a besoin de mi-ombre.";
								bonus.setMessage(message);
								bonus.setPoint(3);
								bonusList.add(bonus);	
								System.out.println(message);

							}
						}
					}

				}

			}
		}

		if (ensolCount == 0 && !ensolFlore1.isEmpty() && !ensolFlore2.isEmpty()) {
			for (Caracteristique carac : ensolFlore1) {
				for (Caracteristique carac2 : ensolFlore2) {
					Malus malus = new Malus();
					String message;
					if (!carac2.getValeur().equals(carac.getValeur())) {
						
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Les deux plantes ont besoin d'ensoleillement différent.";
						malus.setPoint(-1);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
						
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
				Bonus bonus = new Bonus();
				String message;
				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("pH") && carac2.getValeur().equals(carac.getValeur())) {
					pHCount++;
					
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont besoin d'un sol "+carac.getValeur()+".";
					bonus.setMessage(message);
					bonus.setPoint(3);
					bonusList.add(bonus);
					System.out.println(message);
					
					
				}
			}
		}

		if (pHCount == 0 && !pHFlore1.isEmpty() && !pHFlore2.isEmpty()) {
			for (Caracteristique carac : pHFlore1) {
				for (Caracteristique carac2 : pHFlore2) {
					Malus malus = new Malus();
					String message;
					if (!carac2.getValeur().equals(carac.getValeur())) {
						
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Les deux plantes ont besoin d'un sol au pH différent.";
						malus.setPoint(-3);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
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
				Bonus bonus = new Bonus();
				String message;
				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Texture") && carac2.getValeur().equals(carac.getValeur())) {
					textCount++;
					
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont besoin d'un sol "+carac.getValeur()+".";
					bonus.setMessage(message);
					bonus.setPoint(5);
					bonusList.add(bonus);	
					System.out.println(message);

				}
			}
		}

		if (textCount == 0 && !pHFlore1.isEmpty() && !pHFlore2.isEmpty()) {
			for (Caracteristique carac : pHFlore1) {
				for (Caracteristique carac2 : pHFlore2) {
					Malus malus = new Malus();
					String message;
					if (!carac2.getValeur().equals(carac.getValeur())) {

						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Les deux plantes ont besoin d'un sol à la texture différente.";
						malus.setPoint(-5);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);

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
				Bonus bonus = new Bonus();
				String message;
				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Humidité") && carac2.getValeur().equals(carac.getValeur())) {
					humCount++;
					
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont besoin d'un sol "+carac.getValeur()+".";
					bonus.setMessage(message);
					bonus.setPoint(5);
					bonusList.add(bonus);
					System.out.println(message);
					
				}
			}
		}

		if (humCount == 0 && !humFlore1.isEmpty() && !humFlore2.isEmpty()) {
			for (Caracteristique carac : humFlore1) {
				for (Caracteristique carac2 : humFlore2) {
					Malus malus = new Malus();
					String message;
					if (!carac2.getValeur().equals(carac.getValeur())) {
						
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Les deux plantes ont besoin d'une humidité de sol distincte.";
						malus.setPoint(-5);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
						

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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Arrosage") && carac2.getValeur().equals(carac.getValeur())) {
					
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont besoin d'un arrosage "+carac.getValeur()+".";
					bonus.setMessage(message);
					bonus.setPoint(3);
					bonusList.add(bonus);
					System.out.println(message);

				} else if (!carac2.getValeur().equals(carac.getValeur())) {

					malus.setCaracUn(carac);
					malus.setCaracDeux(carac2);
					message="Les deux plantes ont besoin d'un arrosage différent";
					malus.setPoint(-3);
					malus.setMessage(message);
					malusList.add(malus);
					System.out.println(message);
					
				}

			}
		} else if (!arroFlore1.isEmpty() && !arroFlore2.isEmpty()) {
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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Strate") && !carac2.getValeur().equals(carac.getValeur())) {
				
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont une hauteur différente et peuvent donc se développer sans rentrer en compétition.";
					bonus.setMessage(message);
					bonus.setPoint(5);
					bonusList.add(bonus);
					System.out.println(message);

				} else if (carac2.getValeur().equals(carac.getValeur())) {
					
					if((carac2.getValeur().equals("Grimpante")&& nbrstrat1.get(0)>nbrstrat2.get(0))||(carac.getValeur().equals("Grimpante")&& nbrstrat2.get(0)>nbrstrat1.get(0))) {
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive car la plante grimpante peut se fixer sur la seconde.";
						bonus.setMessage(message);
						bonus.setPoint(5);
						bonusList.add(bonus);
						System.out.println(message);
					}
					else {
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="Les deux plantes ont une hauteur de développement similaire et rentrent donc en compétition.";
						malus.setPoint(-5);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
					}

					

				}

			}
		} else if (!stratFlore1.isEmpty() && !stratFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques strate");
		}

		/////////////////////////
		//// Racines////
		/////////////////////////

		if (racFlore1.size() <= 1 && racFlore2.size() <= 1) {

			if (!racFlore1.isEmpty() && !racFlore2.isEmpty()) {
				Caracteristique carac = racFlore1.get(0);
				Caracteristique carac2 = racFlore2.get(0);
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Racines") && !carac2.getValeur().equals(carac.getValeur())) {
					
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont une profondeur de racine différente et sont, par conséquent, moins en concurrence pour se nourrir avec les nutriments du sol.";
					bonus.setMessage(message);
					bonus.setPoint(5);
					bonusList.add(bonus);
					System.out.println(message);

				} else if (carac2.getValeur().equals(carac.getValeur())) {

					malus.setCaracUn(carac);
					malus.setCaracDeux(carac2);
					message="Les deux plantes ont une profondeur de racine similaire et sont donc en compétition pour se nourrir.";
					malus.setPoint(-5);
					malus.setMessage(message);
					malusList.add(malus);
					System.out.println(message);
					
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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;
				if (azoCountInhi >= 1 && azoCountFixa >= 1) {
					if (carac2.getValeur().equals("Inhibiteur") && carac.getValeur().equals("Fixateur")) {
						
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="La plante "+ nomFlore1 +" est fixatrice d'azote et la plante "+ nomFlore2 +" est un inhibiteur de croissance des bactéries fixatrices d'azote.";
						malus.setPoint(-5);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
						
						break;
					} else if (carac.getValeur().equals("Inhibiteur") && carac2.getValeur().equals("Fixateur")) {
						malus.setCaracUn(carac);
						malus.setCaracDeux(carac2);
						message="La plante "+ nomFlore2 +" est fixatrice d'azote et la plante"+ nomFlore1 +" est un inhibiteur de croissance des bactéries fixatrices d'azote.";
						malus.setPoint(-5);
						malus.setMessage(message);
						malusList.add(malus);
						System.out.println(message);
						
						break;
					}
				} else if (carac.getValeur().equals("Fixateur") && (carac2.getValeur().equals("Dévoreur")||carac2.getValeur().equals("Neutre"))||
						carac2.getValeur().equals("Fixateur") && (carac.getValeur().equals("Dévoreur")||carac.getValeur().equals("Neutre"))) {

					if(carac.getValeur().equals("Fixateur")) {
						
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive car la plante "+nomFlore1+" est fixatrice d'azote et peut potentiellement fournir de l'azote à la plante "+nomFlore2+".";
						bonus.setMessage(message);
						bonus.setPoint(5);
						bonusList.add(bonus);
						System.out.println(message);
						
					}
					else {
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive car la plante "+nomFlore2+" est fixatrice d'azote et peut potentiellement fournir de l'azote à la plante "+nomFlore1+".";
						bonus.setMessage(message);
						bonus.setPoint(5);
						bonusList.add(bonus);
						System.out.println(message);
						
					}
				
				} else if (carac2.getValeur().equals(carac.getValeur())&& carac.getValeur().equals("Dévoreur")) {

					malus.setCaracUn(carac);
					malus.setCaracDeux(carac2);
					message="Les deux plantes ont un besoin en azote très important et sont donc en compétition.";
					malus.setPoint(-5);
					malus.setMessage(message);
					malusList.add(malus);
					System.out.println(message);
					

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
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac.getValeur().equals("Fixateur") && (carac2.getValeur().equals("Dévoreur")||carac2.getValeur().equals("Neutre"))||
						carac2.getValeur().equals("Fixateur") && (carac.getValeur().equals("Dévoreur")||carac.getValeur().equals("Neutre"))) {
					if(carac.getValeur().equals("Fixateur")) {
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive car la plante "+nomFlore1+" aide à enrichir le sol en nutriment et peut potentiellement en fournir à la plante "+nomFlore2+".";
						bonus.setMessage(message);
						bonus.setPoint(5);
						bonusList.add(bonus);
						System.out.println(message);
					}
					
					else {
						bonus.setCaracUn(carac);
						bonus.setCaracDeux(carac2);
						message="Il existe une synergie positive car la plante "+nomFlore2+" aide à enrichir le sol en nutriment et peut potentiellement en fournir à la plante "+nomFlore1+".";
						bonus.setMessage(message);
						bonus.setPoint(5);
						bonusList.add(bonus);
						System.out.println(message);
						
					}
				} else if (carac2.getValeur().equals(carac.getValeur())&&carac.getValeur().equals("Dévoreur")) {

					malus.setCaracUn(carac);
					malus.setCaracDeux(carac2);
					message="Les deux plantes ont un besoin en nutriment très important et sont donc en compétition.";
					malus.setPoint(-5);
					malus.setMessage(message);
					malusList.add(malus);
					System.out.println(message);
				}

			}
		} else if (!nutriFlore1.isEmpty() && !nutriFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques nutriment");
		}

		/////////////////////////
		//// Croissance////
		/////////////////////////

		if (croiFlore1.size() <= 1 && croiFlore2.size() <= 1) {

			if (!croiFlore1.isEmpty() && !croiFlore2.isEmpty()) {
				Caracteristique carac = croiFlore1.get(0);
				Caracteristique carac2 = croiFlore2.get(0);
				Bonus bonus = new Bonus();
				Malus malus = new Malus();
				String message;

				if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
						&& carac.getNom().equals("Croissance") && !carac2.getValeur().equals(carac.getValeur())) {
					bonus.setCaracUn(carac);
					bonus.setCaracDeux(carac2);
					message="Il existe une synergie positive car les deux plantes ont des vitesses de croissance différentes.";
					bonus.setMessage(message);
					bonus.setPoint(3);
					bonusList.add(bonus);
					System.out.println(message);
					
				} else if (carac2.getValeur().equals(carac.getValeur())) {

					malus.setCaracUn(carac);
					malus.setCaracDeux(carac2);
					message="Les deux plantes ont une même vitesse de croissance.";
					malus.setPoint(-5);
					malus.setMessage(message);
					malusList.add(malus);
					System.out.println(message);
					
				}

			}
		} else if (!croiFlore1.isEmpty() && !croiFlore2.isEmpty()) {
			System.out.println("Une même flore ne peut contenir 2 caractéristiques croissance");
		}

		/////////////////////////
		//// Prédateur-Repulsif////
		/////////////////////////
		for (Caracteristique caracPreda : predaFlore1) {
			for (Caracteristique caracPreda2 : predaFlore2) {
				for (Caracteristique caracRepuls : repulsFlore1) {
					for (Caracteristique caracRepuls2 : repulsFlore2) {
						Bonus bonus = new Bonus();
						Malus malus = new Malus();
						String message;
						
						if(caracPreda.getValeur().equals(caracRepuls2.getValeur())) {
							bonus.setCaracUn(caracPreda);
							bonus.setCaracDeux(caracRepuls2);
							message="Il existe une synergie positive car la plante "+ nomFlore2 +" repousse la faune "+caracPreda.getValeur()+" qui est un nuisible de la plante "+ nomFlore1 +".";
							bonus.setMessage(message);
							bonus.setPoint(5);
							bonusList.add(bonus);
							System.out.println(message);
							
						}
						
						else if(caracPreda2.getValeur().equals(caracRepuls.getValeur())) {
							bonus.setCaracUn(caracRepuls);
							bonus.setCaracDeux(caracPreda2);
							message="Il existe une synergie positive car la plante "+ nomFlore1 +" repousse la faune "+caracPreda.getValeur()+" qui est un nuisible de la plante "+ nomFlore2 +".";
							bonus.setMessage(message);
							bonus.setPoint(5);
							bonusList.add(bonus);
							System.out.println(message);
						}	
						
						
					}
				}
			}
		}

		simu1.setBonus(bonusList);
		simu1.setMalus(malusList);
		System.out.println(simu1.getBonus());
		return simu1;
	
	}

}
