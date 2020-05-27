package Flore;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import flore.model.Caracteristique;
import flore.persistence.ICaracteristiqueRepository;

@SpringBootTest
class FloreSynergiesTests2 {
	@Autowired
	private ICaracteristiqueRepository caracRepo;

	@Test
	void contextLoads() {
	}

	@Test
	void sontEllesAmies() {
		
		String nomFlore1="Courge";
		String nomFlore2="Maïs";
		
		/////////////////////////
		//On appelle les caractéristiques des plantes 1 et 2 qui vont être comparées afin de définir les synergies si elles existent
		/////////////////////////
		
		List<Caracteristique> stratFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Strate");
		List<Caracteristique> stratFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Strate");
		
		List<Caracteristique> caracFlore1 = caracRepo.findByFlore(nomFlore1);
		List<Caracteristique> caracFlore2 = caracRepo.findByFlore(nomFlore2);
		
		List<Caracteristique> tempFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Température");
		List<Caracteristique> tempFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Température");
		
		List<Caracteristique> ensolFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Ensoleillement");
		List<Caracteristique> ensollore2 = caracRepo.findByFloreCarac(nomFlore2,"Ensoleillement");
		
		List<Caracteristique> ventFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Vent");
		List<Caracteristique> ventlore2 = caracRepo.findByFloreCarac(nomFlore2,"Vent");
		
		List<Caracteristique> pHFlore1 = caracRepo.findByFloreCarac(nomFlore1,"pH");
		List<Caracteristique> pHFlore2 = caracRepo.findByFloreCarac(nomFlore2,"pH");
		
		List<Caracteristique> textFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Texture");
		List<Caracteristique> textFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Texture");
		
		List<Caracteristique> humFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Humidité");
		List<Caracteristique> humFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Humidité");
		
		List<Caracteristique> aroFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Arrosage");
		List<Caracteristique> aroFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Arrosage");
		
		List<Caracteristique> racFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Racines");
		List<Caracteristique> racFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Racines");
		
		List<Caracteristique> croiFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Croissance");
		List<Caracteristique> croiFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Croissance");
		
		List<Caracteristique> azoFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Azote");
		List<Caracteristique> azoFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Azote");
		
		List<Caracteristique> nutriFlore1 = caracRepo.findByFloreCarac(nomFlore1,"Nutriment");
		List<Caracteristique> nutriFlore2 = caracRepo.findByFloreCarac(nomFlore2,"Nutriment");
		
		System.out.println(stratFlore1);
		System.out.println(stratFlore2);
		
		/////////////////////////
		//On affecte une valeur pour chacune des strat récupérée pour pouvoir les comparer plus facilement par la suite
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
		//On déclare les listes de caractéristiques que l'on récupéréra si synergie positive ou négative il y a
		/////////////////////////
		
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
				} 
				else if (carac.getBonusMalus()) {
					// on définie une synergie particulière pour la caractéristique de type température
					if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom().equals("Température")) {
						System.out.println("########");
						
						// On sépare la valeur de la carac type température "t°Cmin - t°Cmax" en temps= ["t°Cmin", t°Cmax]
						String[] temps1 = carac.getValeur().split("/");
						String[] temps2 = carac2.getValeur().split("/");
						System.out.println(temps1.length);
						
						if (temps1.length==2 && temps2.length==2 && temps1[0]!="#" && temps1[1]!="#" && temps2[0]!="#" && temps2[1]!="#") {
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
										
						
							// on considère un bonus en synergie si les plages de températures des deux plantes sont similaires(+-5°C) ou si les plages se recouvrent
							if ((temp1Min >= temp2Min && temp1Max <= temp2Max) || (temp1Min <= temp2Min && temp1Max >= temp2Max)
								|| (diffMin <= 5 && diffMax <= 5)) {
							caracBonusPositif.add(carac);
							caracBonusPositif2.add(carac2);
							System.out.println(
									"La carac " + carac.getNom() + " est positive car les deux plantes ont une plage de température similaire");

							} else {
							caracBonusNegatif.add(carac);
							caracBonusNegatif2.add(carac2);
							System.out.println(
									"La carac " + carac.getNom() + " est négative car les deux plantes ont des différences de températures optimales");

							}
						}
						else {
							System.out.println("Une des caractéristiques température est incomplète ou mal renseignée dans la base de donnée");
						}

						
						

						
					}
					// on définie une synergie particulière pour la caractéristique de type Vent
					else if ((carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom().equals("Vent"))
							&& (carac.getValeur().equals("Peu Résistant")  || carac2.getValeur().equals("Peu Résistant"))) {
						System.out.println("########");
						System.out.println(stratFlore1.size());
						System.out.println(stratFlore2.size());
						for (Caracteristique strat : stratFlore1) {
							if ((strat.getValeur().equals("Canopée") || strat.getValeur().equals("Petits Arbres") 
									|| strat.getValeur().equals("Arbustive")||carac.getValeur().equals("Haie Brise-Vent")) && carac2.getValeur().equals("Peu Résistant")) {
								caracBonusPositif.add(carac2);
								
								System.out.println(
										"La carac " + carac.getNom() + " est positive car la plante 2 est " + carac2.getValeur() +" et la plante 1 est résistante au vent");
							}
						}
						for (Caracteristique strat2 : stratFlore2) {
							if ((strat2.getValeur().equals("Canopée") || strat2.getValeur().equals("Petits Arbres")
									|| strat2.getValeur().equals("Arbustive")||carac2.getValeur().equals("Haie Brise-Vent")) && carac.getValeur().equals("Peu Résistant")) {
								caracBonusPositif.add(carac);
								System.out.println(
										"La carac " + carac.getNom() + " est positive car la plante 1 est " + carac.getValeur() +" et la plante 2 est résistante au vent");
							}
						}

					}
					// on définie une synergie particulière pour la caractéristique de type Ensoleillement
					else if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac.getNom().equals("Ensoleillement")) {
						System.out.println("########");
						if (carac2.getValeur().equals(carac.getValeur())) {
							caracBonusPositif.add(carac);
							caracBonusPositif2.add(carac2);
							System.out.println(
									"La carac " + carac.getNom() + " est positive car les deux plantes sont : " + carac.getValeur());
						}

						else if ((carac2.getValeur().equals("Mi Ombre")
								&& (carac.getValeur().equals("Plein Soleil") || carac.getValeur().equals("Soleil")))
								|| (carac.getValeur().equals("Mi Ombre")
										&& (carac2.getValeur().equals("Plein Soleil") || carac2.getValeur().equals("Soleil")))) {
							for (Integer nb1 : nbrstrat1) {
								for (Integer nb2 : nbrstrat2) {
									if ((nb1 > nb2 && carac2.getValeur().equals("Mi Ombre"))) {
										caracBonusPositif2.add(carac2);
										System.out.println(
												"La carac " + carac.getNom() + " est positive car la plante 1 est plus haute que la plante 2 et aime le soleil et peut lui procurer du mi-ombre");
									} else if (nb1 < nb2 && carac.getValeur().equals("Mi Ombre")) {
										caracBonusPositif.add(carac);
										System.out.println(
												"La carac " + carac.getNom() + " est positive car la plante 2 est plus haute que la plante 1 et aime le soleil et peut lui procurer du mi-ombre");
									}
								}
							}

						}
						else {
							caracBonusNegatif.add(carac);
							caracBonusNegatif2.add(carac2);
							System.out.println(
									"La carac " + carac.getNom() + " est négative car la plante 2 et la plante 1 ont des demandes d'ensoleillement différentes");
						}

						
					}

					//Caractéristiques pH, texture
					else if (carac2.getTypeCarac() == carac.getTypeCarac() && carac2.getNom().equals(carac.getNom())
							&& carac2.getValeur().equals(carac.getValeur())) {
						caracBonusPositif.add(carac);
					} 
					else if (carac2.getTypeCarac() == carac.getTypeCarac()
							&& carac2.getNom().equals(carac.getNom())) {
						caracBonusNegatif.add(carac);
						caracBonusNegatif2.add(carac2);

					}
				} 
				else if (!carac.getBonusMalus()) {
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

	}

}
