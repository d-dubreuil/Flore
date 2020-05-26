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

import flore.model.Commande;
import flore.model.Views;
import flore.persistence.ICommandeRepository;

@RestController
@RequestMapping("/commande")
@CrossOrigin("*")
public class CommandeRestController {

	@Autowired
	private ICommandeRepository commandeRepo; 
	
	
	@GetMapping("")
	@JsonView(Views.ViewCommande.class)
	public List<Commande> findAll() {
		return commandeRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande find(@PathVariable Long id) {

		Optional<Commande> optCommande = commandeRepo.findById(id);

		if (optCommande.isPresent()) {
			return optCommande.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewCommande.class)
	public Commande create(@RequestBody Commande commande) {
		commande = commandeRepo.save(commande);

		return commande;
	}
	
	@PutMapping("/{id}")
	@JsonView(Views.ViewCommande.class)
	public Commande update(@RequestBody Commande commande, @PathVariable Long id) {
		if (!commandeRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		commande = commandeRepo.save(commande);

		return commande;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		commandeRepo.deleteById(id);
	}
	
}
