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


import flore.model.ReferentielUtilisateur;
import flore.model.Views;

import flore.persistence.IReferentielUtilisateurRepository;

@RestController
@RequestMapping("/referentielUtilisateur")
@CrossOrigin("*")
public class ReferentielUtilisateurRestController {

	@Autowired
	private IReferentielUtilisateurRepository refUtilisateurRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	public List<ReferentielUtilisateur> findAll(){
		return refUtilisateurRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	public ReferentielUtilisateur find(@PathVariable Long id) {
		
		Optional<ReferentielUtilisateur> optRefUtilisateur=refUtilisateurRepo.findById(id);
		if (optRefUtilisateur.isPresent()) {
			return optRefUtilisateur.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	public ReferentielUtilisateur create(@RequestBody ReferentielUtilisateur refUtilisateur) {
		refUtilisateur = refUtilisateurRepo.save(refUtilisateur);

		return refUtilisateur;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewReferentielUtilisateur.class)
	public ReferentielUtilisateur update(@RequestBody ReferentielUtilisateur refUtilisateur, @PathVariable Long id) {
		if (!refUtilisateurRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		refUtilisateur = refUtilisateurRepo.save(refUtilisateur);

		return refUtilisateur;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		refUtilisateurRepo.deleteById(id);
	}
	
}
