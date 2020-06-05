package Test;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
import flore.model.ReferentielCaracteristique;
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
import flore.persistence.IReferentielCaracteristiqueRepository;
import flore.persistence.IReferentielFauneRepository;
import flore.persistence.IReferentielUtilisateurRepository;
import flore.persistence.ISelectionRepository;
import flore.persistence.IUtilisateurRepository;


@SpringBootTest 
public class TestJUnit {

	@Autowired
	private ICaracteristiqueRepository caracteristiqueDao;
	
	@Autowired
	private  ICommandeRepository commandeDao;
	
	@Autowired
	private  ICompteUtilisateurRepository compteUtilisateurDao;
	
	@Autowired
	private  IConseilRepository conseilDao;
	
	@Autowired
	private  IFauneRepository fauneDao;
	
	@Autowired
	private  IFloreRepository floreDao;
	
	@Autowired
	private  IHistoriqueRepository historiqueDao;
	
	@Autowired
	private  IPaiementRepository paiementDao;
	
	@Autowired
	private  IProduitRepository produitDao;
	
	@Autowired
	private  IReferentielCaracteristiqueRepository referentielCaracteristiqueDao;
	
	@Autowired
	private  IReferentielFauneRepository referentielFauneDao;
	
	@Autowired
	private  IReferentielUtilisateurRepository referentielUtilisateurDao;
	
	@Autowired
	private  ISelectionRepository selectionDao;
	
	@Autowired
	private  IUtilisateurRepository utilisateurDao;
	
	@Autowired
	private  IPanierRepository panierDao;
	
	@Autowired
	private  IFavorisRepository favorisDao;
	
	@Autowired
	private  IJardinRepository jardinDao;

}