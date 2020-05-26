package flore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import flore.model.CompteUtilisateur;
import flore.model.Views;
import flore.persistence.ICompteUtilisateurRepository;

@RestController
@RequestMapping("/api/compteUtilisateur")
@CrossOrigin("*")
public class CompteUtilisateurRestController {

	@Autowired
	private ICompteUtilisateurRepository compteUtilisateurRepo; 
	
	@GetMapping("")
	@JsonView(Views.ViewCompteUtilisateur.class)
	public List<CompteUtilisateur> findAll() {
		return compteUtilisateurRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCompteUtilisateur.class)
	public CompteUtilisateur find(@PathVariable Long id) {

		Optional<CompteUtilisateur> optCompteUtilisateur = compteUtilisateurRepo.findById(id);

		if (optCompteUtilisateur.isPresent()) {
			return optCompteUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCompteUtilisateur.class)
	public CompteUtilisateur create(@RequestBody CompteUtilisateur compteUtilisateur) {
		compteUtilisateur = compteUtilisateurRepo.save(compteUtilisateur);

		return compteUtilisateur;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCaracteristique.class)
	public CompteUtilisateur update(@RequestBody CompteUtilisateur compteUtilisateur, @PathVariable Long id) {
		if (!compteUtilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		compteUtilisateur = compteUtilisateurRepo.save(compteUtilisateur);

		return compteUtilisateur;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		compteUtilisateurRepo.deleteById(id);
	}
	
}
