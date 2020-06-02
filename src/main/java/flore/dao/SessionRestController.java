package flore.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flore.model.CompteUtilisateur;
import flore.model.Session;
import flore.model.TypeUtilisateur;
import flore.persistence.ICompteUtilisateurRepository;

@RestController
@RequestMapping("/api/session")
@CrossOrigin("*")
public class SessionRestController {
	@Autowired
	private ICompteUtilisateurRepository compteUtilisateurRepo; 

	@PostMapping ("/connexion")
	public List<String> connexion(@RequestBody Session session) {
		List<CompteUtilisateur> comptesExistants = compteUtilisateurRepo.findAll();
		List<String> resp = new ArrayList<String>();
		for(CompteUtilisateur compte: comptesExistants) {
			if(session.getUsername().equals(compte.getIdentifiant())&&session.getPassword().equals(compte.getMotDePasse())) {
				resp.add("OK");
				resp.add(compte.getId().toString());
				resp.add(compte.getDisc().toString());
				return resp;
			}
		}
		resp.add("nonOK");
		return resp;
		
	}
	
	@PostMapping("/creation")
	public List<String> creation(@RequestBody Session session){
		List<CompteUtilisateur> comptesExistants = compteUtilisateurRepo.findAll();
		List<String> resp = new ArrayList<String>();
		CompteUtilisateur nouveauCompte = new CompteUtilisateur();
		if(session.getPassword()==""||session.getUsername()=="" ||session.getPassword()==null||session.getUsername()==null) {
			resp.add("Vide");
			return resp;
		} else {
		for(CompteUtilisateur compte: comptesExistants) {
			if(session.getUsername().equals(compte.getIdentifiant())) {
				resp.add("nonOK");
				return resp;
			}
		}
		nouveauCompte.setIdentifiant(session.getUsername());
		nouveauCompte.setMotDePasse(session.getPassword());
		nouveauCompte.setDisc(TypeUtilisateur.Client);
		nouveauCompte = compteUtilisateurRepo.save(nouveauCompte);
		resp.add("OK");
		resp.add(nouveauCompte.getId().toString());
		resp.add(nouveauCompte.getDisc().toString());
		return resp;
		}
	}
}
