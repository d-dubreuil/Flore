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

import flore.model.Flore;
import flore.model.TypeCarac;
import flore.model.Views;
import flore.persistence.IFloreRepository;
import flore.persistence.custom.FloreRepositoryImpl;
import flore.web.dto.FloreForm;

@RestController
@RequestMapping("/api/flore")
@CrossOrigin("*")
public class FloreRestController {
	@Autowired
	private IFloreRepository floreRepo;
	
	@Autowired
	private FloreRepositoryImpl floreRepoImpl;
	
	@GetMapping("")
	@JsonView(Views.ViewFlore.class)
	public List<Flore> findAll() {
		return floreRepo.findAll();
	}
	
	@GetMapping("/by-nom/{nom}")
	@JsonView(Views.ViewFlore.class)
	public List<Flore> findByNom(@PathVariable String nom) {
		return floreRepo.findByNom(nom);
	}
	
	@GetMapping("/by-caracteristique/{typeCarac}|{nom}|{valeur}")
	@JsonView(Views.ViewFlore.class)
	public List<Flore> findAllByCaracteristique(@PathVariable TypeCarac typeCarac, @PathVariable String nom,@PathVariable String valeur) {
		return floreRepo.findAllByCaracteristique(typeCarac,nom,valeur);
	}
	
	@PostMapping("/by-formulaire")
	@JsonView(Views.ViewFlore.class)
	public List<Flore> search(@RequestBody FloreForm floreFormulaire) {
		return floreRepoImpl.search(floreFormulaire);
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFlore.class)
	public Flore find(@PathVariable Long id) {

		Optional<Flore> optFlore = floreRepo.findById(id);

		if (optFlore.isPresent()) {
			return optFlore.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewFlore.class)
	public Flore create(@RequestBody Flore flore) {
		flore = floreRepo.save(flore);

		return flore;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFlore.class)
	public Flore update(@RequestBody Flore flore, @PathVariable Long id) {
		if (!floreRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		flore = floreRepo.save(flore);

		return flore;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		floreRepo.deleteById(id);
	}

}
