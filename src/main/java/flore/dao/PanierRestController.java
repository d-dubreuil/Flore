package flore.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

import flore.model.Panier;
import flore.model.Views;
import flore.persistence.IPanierRepository;

@RestController
@RequestMapping("/panier")
public class PanierRestController {

	@Autowired
	private IPanierRepository panierRepo;

	@GetMapping("")
	@JsonView(Views.ViewPanier.class)
	public List<Panier> findAll() {
		return panierRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPanier.class)
	public Panier find(@PathVariable Long id) {

		Optional<Panier> optPanier = panierRepo.findById(id);

		if (optPanier.isPresent()) {
			return optPanier.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPanier.class)
	public Panier create(@RequestBody Panier panier) {
		panier = panierRepo.save(panier);

		return panier;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPanier.class)
	public Panier update(@RequestBody Panier panier, @PathVariable Long id) {
		if (!panierRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		panier = panierRepo.save(panier);

		return panier;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		panierRepo.deleteById(id);
	}
}
