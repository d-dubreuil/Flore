package Test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import flore.model.Caracteristique;
import flore.model.Commande;
import flore.model.CompteUtilisateur;
import flore.model.Conseil;
import flore.model.Faune;
import flore.model.Favoris;
import flore.model.Flore;
import flore.model.Historique;
import flore.model.Jardin;
import flore.model.Paiement;
import flore.model.Panier;
import flore.model.Produit;
import flore.model.ReferentielFaune;
import flore.model.ReferentielUtilisateur;
import flore.model.Selection;
import flore.model.TypeCarac;
import flore.model.TypeUtilisateur;
import flore.model.Utilisateur;
import flore.persistence.ICaracteristiqueRepository;
import flore.persistence.ICommandeRepository;
import flore.persistence.ICompteUtilisateurRepository;
import flore.persistence.IConseilRepository;
import flore.persistence.IFauneRepository;
import flore.persistence.IFavorisRepository;
import flore.persistence.IFloreRepository;
import flore.persistence.IHistoriqueRepository;
import flore.persistence.IJardinRepository;
import flore.persistence.IPaiementRepository;
import flore.persistence.IPanierRepository;
import flore.persistence.IProduitRepository;
import flore.persistence.IReferentielFauneRepository;
import flore.persistence.IReferentielUtilisateurRepository;
import flore.persistence.ISelectionRepository;
import flore.persistence.IUtilisateurRepository;

@SpringBootTest
public class Test_vide {

	@Autowired
	private ICaracteristiqueRepository caracteristiqueDao;

	@Autowired
	private ICommandeRepository commandeDao;

	@Autowired
	private ICompteUtilisateurRepository compteUtilisateurDao;

	@Autowired
	private IConseilRepository conseilDao;

	@Autowired
	private IFauneRepository fauneDao;

	@Autowired
	private IFloreRepository floreDao;

	@Autowired
	private IHistoriqueRepository historiqueDao;

	@Autowired
	private IPaiementRepository paiementDao;

	@Autowired
	private IProduitRepository produitDao;

	@Autowired
	private IReferentielFauneRepository referentielFauneDao;

	@Autowired
	private IReferentielUtilisateurRepository referentielUtilisateurDao;

	@Autowired
	private ISelectionRepository selectionDao;

	@Autowired
	private IUtilisateurRepository utilisateurDao;

	@Autowired
	private IPanierRepository panierDao;

	@Autowired
	private IFavorisRepository favorisDao;

	@Autowired
	private IJardinRepository jardinDao;

	public void load() {

		Historique historique1 = new Historique("faune", "fraises");

		historique1 = historiqueDao.save(historique1);

		CompteUtilisateur compte1 = new CompteUtilisateur("manoncharles", "mdp", "charles.manon@yahoo.com", "Charles",
				"21 avenue Colonel Pierre Bourgoin", "Maison D10", "33127", "Martignas sur Jalle", "06.35.24.43.32");

		compte1 = compteUtilisateurDao.save(compte1);

		historique1.setCompte(compte1);
		historique1 = historiqueDao.save(historique1);

		Utilisateur contrib1 = new Utilisateur(TypeUtilisateur.Contributeur);

		contrib1 = utilisateurDao.save(contrib1);

		contrib1.setCompteUtilisateur(compte1);
		contrib1 = utilisateurDao.save(contrib1);

		Conseil cons1 = new Conseil("La bouillie bordelaise en traitement de certaines maladies");
		cons1.setUtilisateur(contrib1);
		cons1 = conseilDao.save(cons1);

		Caracteristique cycle1 = creationUnique("Cycle de vie", "vivace", TypeCarac.Flore, context);
		Caracteristique type1 = creationUnique("Type de fraisier", "remontant", TypeCarac.Flore, context);
		Caracteristique plantation1 = creationUnique("Plantation", "automne", TypeCarac.Flore, context);
		Caracteristique recolte1 = creationUnique("Récolte", "mi-juin à fin juillet", TypeCarac.Flore, context);
		Caracteristique usage1 = creationUnique("Usage", "comestible", TypeCarac.Utilisation, context);
		Caracteristique predateur1 = creationUnique("Prédateurs", "limaces", TypeCarac.Faune, context);
		Caracteristique ensoleillement1 = creationUnique("Ensoleillement", "plein soleil", TypeCarac.Meteo, context);
		Caracteristique temperature1 = creationUnique("Température idéale", "entre 10 et 25°C", TypeCarac.Meteo,
				context);
		Caracteristique texture1 = creationUnique("Type de sol", "sol humifère meuble et sableux", TypeCarac.Sol,
				context);
		Caracteristique pH1 = creationUnique("pH du sol", "5,5 à 7,5 : acide à neutre", TypeCarac.Sol, context);
		Caracteristique arrosage1 = creationUnique("Arrosage", "arrosage sans excès", TypeCarac.Sol, context);

		cycle1 = caracteristiqueDao.save(cycle1);
		type1 = caracteristiqueDao.save(type1);
		plantation1 = caracteristiqueDao.save(plantation1);
		recolte1 = caracteristiqueDao.save(recolte1);
		usage1 = caracteristiqueDao.save(usage1);
		predateur1 = caracteristiqueDao.save(predateur1);
		ensoleillement1 = caracteristiqueDao.save(ensoleillement1);
		temperature1 = caracteristiqueDao.save(temperature1);
		texture1 = caracteristiqueDao.save(texture1);
		pH1 = caracteristiqueDao.save(pH1);
		arrosage1 = caracteristiqueDao.save(arrosage1);

		Flore fraisier = new Flore("Fraisier mariguette");
		fraisier = floreDao.save(fraisier);
		fraisier.addCaracteristiqueAvecRef(cycle1, context);
		fraisier.addCaracteristiqueAvecRef(type1, context);
		fraisier.addCaracteristiqueAvecRef(plantation1, context);
		fraisier.addCaracteristiqueAvecRef(recolte1, context);
		fraisier.addCaracteristiqueAvecRef(usage1, context);
		fraisier.addCaracteristiqueAvecRef(predateur1, context);
		fraisier.addCaracteristiqueAvecRef(ensoleillement1, context);
		fraisier.addCaracteristiqueAvecRef(temperature1, context);
		fraisier.addCaracteristiqueAvecRef(texture1, context);
		fraisier.addCaracteristiqueAvecRef(pH1, context);
		fraisier.addCaracteristiqueAvecRef(arrosage1, context);

		fraisier.addUtilisateurs(contrib1);
		fraisier = floreDao.save(fraisier);

		ReferentielUtilisateur refuti1 = new ReferentielUtilisateur();
		refuti1.setCompteUtilisateur(compte1);
		refuti1.setCaracteristique(texture1);
		refuti1.setCaracteristique(pH1);
		refuti1 = referentielUtilisateurDao.save(refuti1);

		Faune limace = new Faune("Limace");
		limace = fauneDao.save(limace);
		ReferentielFaune ref2 = new ReferentielFaune();
		ref2 = referentielFauneDao.save(ref2);
		ref2.setFaune(limace);
		ref2.setCaracteristique(predateur1);
		ref2.setFlore(fraisier);
		ref2 = referentielFauneDao.save(ref2);

		Produit prod1 = new Produit(123, 29.99f, "Gamm Vert", 25);
		prod1 = produitDao.save(prod1);
		prod1.setFlore(fraisier);
		prod1.setFaune(limace);
		prod1.setUtilisateur(contrib1);
		prod1 = produitDao.save(prod1);

		Selection s1 = new Selection(1);
		s1.setProduit(prod1);
		s1 = selectionDao.save(s1);

		Panier panier1 = new Panier(29.99f);
		panier1 = panierDao.save(panier1);
		s1.setPanier(panier1);
		panier1.setUtilisateur(contrib1);
		panier1 = panierDao.save(panier1);
		Commande com1 = new Commande(4561, "postal", 29.99f);
		com1 = commandeDao.save(com1);
		com1.setPanier(panier1);
		Paiement pai1 = new Paiement("1234 1234 1234 1234", "04/22", "913", 29.99f);
		pai1 = paiementDao.save(pai1);
		com1.setPaiement(pai1);
		panier1 = panierDao.save(panier1);
		s1 = selectionDao.save(s1);
		com1 = commandeDao.save(com1);
		pai1 = paiementDao.save(pai1);

		Favoris fav1 = new Favoris("Fraises mariguette");
		fav1 = favorisDao.save(fav1);
		fav1.setCompteUtilisateur(compte1);
		fav1.addFlore(fraisier);
		fav1 = favorisDao.save(fav1);

		Jardin jar1 = new Jardin("Mon petit jardin");
		jar1 = jardinDao.save(jar1);
		jar1.setCompteUtilisateur(compte1);
		jar1.addFlores(fraisier);
		jar1 = jardinDao.save(jar1);

		contrib1.addFlores(fraisier);
		contrib1 = utilisateurDao.save(contrib1);

		Caracteristique cycleAnnuelle = creationUnique("cycleDeVie", "annuelle", TypeCarac.Flore, context);
		Caracteristique typeGrimpant = creationUnique("strate", "grimpant", TypeCarac.Flore, context);
		Caracteristique debutPlantationAvril = creationUnique("debutPlantation", "avril", TypeCarac.Flore, context);
		Caracteristique finPlantationAout = creationUnique("finPlantation", "aout", TypeCarac.Flore, context);
		Caracteristique debutRecolteJuin = creationUnique("debutRecolte", "juin", TypeCarac.Flore, context);
		Caracteristique finRecolteSeptembre = creationUnique("finRecolte", "septembre", TypeCarac.Flore, context);
		Caracteristique usageComestible = creationUnique("usage", "comestible", TypeCarac.Utilisation, context);
		Caracteristique predateurPuceron = creationUnique("predateurs", "puceron", TypeCarac.Faune, context);
		Caracteristique ensoleillementPleinSoleil = creationUnique("ensoleillement", "soleil", TypeCarac.Meteo,
				context);
		Caracteristique resistanceAuFroidFragile = creationUnique("resistanceAuFroid", "fragile", TypeCarac.Meteo,
				context);
		Caracteristique typeDeSolSableux = creationUnique("typeDeSol", "sableux", TypeCarac.Sol, context);
		Caracteristique phNeutre = creationUnique("ph", "neutre", TypeCarac.Sol, context);
		Caracteristique arrosageMoyen = creationUnique("arrosage", "moyen", TypeCarac.Sol, context);
		Caracteristique entretienModere = creationUnique("entretien", "modere", TypeCarac.Flore, context);

		cycleAnnuelle = caracteristiqueDao.save(cycleAnnuelle);
		typeGrimpant = caracteristiqueDao.save(typeGrimpant);
		debutPlantationAvril = caracteristiqueDao.save(debutPlantationAvril);
		finPlantationAout = caracteristiqueDao.save(finPlantationAout);
		debutRecolteJuin = caracteristiqueDao.save(debutRecolteJuin);
		finRecolteSeptembre = caracteristiqueDao.save(finRecolteSeptembre);
		usageComestible = caracteristiqueDao.save(usageComestible);
		predateurPuceron = caracteristiqueDao.save(predateurPuceron);
		ensoleillementPleinSoleil = caracteristiqueDao.save(ensoleillementPleinSoleil);
		resistanceAuFroidFragile = caracteristiqueDao.save(resistanceAuFroidFragile);
		typeDeSolSableux = caracteristiqueDao.save(typeDeSolSableux);
		phNeutre = caracteristiqueDao.save(phNeutre);
		arrosageMoyen = caracteristiqueDao.save(arrosageMoyen);
		entretienModere = caracteristiqueDao.save(entretienModere);

		Flore haricot = new Flore("haricot");
		haricot = floreDao.save(haricot);

		haricot.addCaracteristiqueAvecRef(cycleAnnuelle, context);
		haricot.addCaracteristiqueAvecRef(typeGrimpant, context);
		haricot.addCaracteristiqueAvecRef(debutPlantationAvril, context);
		haricot.addCaracteristiqueAvecRef(finPlantationAout, context);
		haricot.addCaracteristiqueAvecRef(debutRecolteJuin, context);
		haricot.addCaracteristiqueAvecRef(finRecolteSeptembre, context);
		haricot.addCaracteristiqueAvecRef(usageComestible, context);
		haricot.addCaracteristiqueAvecRef(predateurPuceron, context);
		haricot.addCaracteristiqueAvecRef(ensoleillementPleinSoleil, context);
		haricot.addCaracteristiqueAvecRef(resistanceAuFroidFragile, context);
		haricot.addCaracteristiqueAvecRef(typeDeSolSableux, context);
		haricot.addCaracteristiqueAvecRef(phNeutre, context);
		haricot.addCaracteristiqueAvecRef(arrosageMoyen, context);
		haricot.addCaracteristiqueAvecRef(entretienModere, context);

		Caracteristique typeCouvrant = creationUnique("strate", "couvrant", TypeCarac.Flore, context);
		Caracteristique debutPlantationMai = creationUnique("debutPlantation", "mai", TypeCarac.Flore, context);
		Caracteristique finPlantationJuin = creationUnique("finPlantation", "juin", TypeCarac.Flore, context);
		Caracteristique debutRecolteJuillet = creationUnique("debutRecolte", "juillet", TypeCarac.Flore, context);
		Caracteristique finRecolteOctobre = creationUnique("finRecolte", "octobre", TypeCarac.Flore, context);
		Caracteristique predateurPunaise = creationUnique("predateurs", "punaise", TypeCarac.Faune, context);
		Caracteristique typeDeSolHumus = creationUnique("typeDeSol", "humus", TypeCarac.Sol, context);
		Caracteristique arrosageImportant = creationUnique("arrosage", "important", TypeCarac.Sol, context);
		Caracteristique entretienFacile = creationUnique("entretien", "facile", TypeCarac.Flore, context);

		typeCouvrant = caracteristiqueDao.save(typeCouvrant);
		predateurPunaise = caracteristiqueDao.save(predateurPunaise);
		debutPlantationMai = caracteristiqueDao.save(debutPlantationMai);
		finPlantationJuin = caracteristiqueDao.save(finPlantationJuin);
		debutRecolteJuillet = caracteristiqueDao.save(debutRecolteJuillet);
		finRecolteOctobre = caracteristiqueDao.save(finRecolteOctobre);
		predateurPuceron = caracteristiqueDao.save(predateurPuceron);
		typeDeSolHumus = caracteristiqueDao.save(typeDeSolHumus);
		arrosageImportant = caracteristiqueDao.save(arrosageImportant);
		entretienFacile = caracteristiqueDao.save(entretienFacile);

		Flore courge = new Flore("courge");
		courge = floreDao.save(courge);

		courge.addCaracteristiqueAvecRef(cycleAnnuelle, context);
		courge.addCaracteristiqueAvecRef(typeCouvrant, context);
		courge.addCaracteristiqueAvecRef(debutPlantationMai, context);
		courge.addCaracteristiqueAvecRef(finPlantationJuin, context);
		courge.addCaracteristiqueAvecRef(debutRecolteJuillet, context);
		courge.addCaracteristiqueAvecRef(finRecolteOctobre, context);
		courge.addCaracteristiqueAvecRef(usageComestible, context);
		courge.addCaracteristiqueAvecRef(predateurPunaise, context);
		courge.addCaracteristiqueAvecRef(ensoleillementPleinSoleil, context);
		courge.addCaracteristiqueAvecRef(resistanceAuFroidFragile, context);
		courge.addCaracteristiqueAvecRef(typeDeSolHumus, context);
		courge.addCaracteristiqueAvecRef(phNeutre, context);
		courge.addCaracteristiqueAvecRef(arrosageImportant, context);
		courge.addCaracteristiqueAvecRef(entretienFacile, context);

		Caracteristique typeHerbaceeHaute = creationUnique("strate", "herbaceeHaute", TypeCarac.Flore, context);
		Caracteristique debutPlantationMars = creationUnique("debutPlantation", "mars", TypeCarac.Flore, context);
		Caracteristique predateurMoucheSemis = creationUnique("predateurs", "moucheSemis", TypeCarac.Faune, context);

		typeHerbaceeHaute = caracteristiqueDao.save(typeHerbaceeHaute);
		debutPlantationMars = caracteristiqueDao.save(debutPlantationMars);
		predateurMoucheSemis = caracteristiqueDao.save(predateurMoucheSemis);

		Flore mais = new Flore("mais");
		mais = floreDao.save(mais);

		mais.addCaracteristiqueAvecRef(cycleAnnuelle, context);
		mais.addCaracteristiqueAvecRef(typeHerbaceeHaute, context);
		mais.addCaracteristiqueAvecRef(debutPlantationMars, context);
		mais.addCaracteristiqueAvecRef(finPlantationJuin, context);
		mais.addCaracteristiqueAvecRef(debutRecolteJuillet, context);
		mais.addCaracteristiqueAvecRef(finRecolteOctobre, context);
		mais.addCaracteristiqueAvecRef(usageComestible, context);
		mais.addCaracteristiqueAvecRef(predateurMoucheSemis, context);
		mais.addCaracteristiqueAvecRef(ensoleillementPleinSoleil, context);
		mais.addCaracteristiqueAvecRef(resistanceAuFroidFragile, context);
		mais.addCaracteristiqueAvecRef(typeDeSolSableux, context);
		mais.addCaracteristiqueAvecRef(phNeutre, context);
		mais.addCaracteristiqueAvecRef(arrosageMoyen, context);

//		List <Faune>limacefind=fauneDao.findByNomFaune("Limace");
//		System.out.println(limacefind);

		List<Caracteristique> caracMais = caracteristiqueDao.findByFlore("mais");
		System.out.println(caracMais);

		context.close();
	}

	public static Caracteristique creationUnique(String nom, String valeur, TypeCarac typeCarac,
			ClassPathXmlApplicationContext context) {
		ICaracteristiqueRepository caracteristiqueDao = context.getBean(ICaracteristiqueRepository.class);
		if (caracteristiqueDao.findByAttribut(typeCarac, nom, valeur) == null) {
			Caracteristique carac = new Caracteristique(nom, valeur, typeCarac);
			carac = caracteristiqueDao.save(carac);
			return carac;
		}
		Caracteristique carac = caracteristiqueDao.findByAttribut(typeCarac, nom, valeur);
		return carac;
	}
}
