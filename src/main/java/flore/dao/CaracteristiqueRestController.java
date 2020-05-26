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

import flore.model.Caracteristique;
import flore.model.TypeCarac;
import flore.model.Views;
import flore.persistence.ICaracteristiqueRepository;

@RestController
@RequestMapping("/api/caracteristique")
@CrossOrigin("*")
public class CaracteristiqueRestController {

	@Autowired
	private ICaracteristiqueRepository caracteristiqueRepo;

	@GetMapping("")
	@JsonView(Views.ViewCaracteristique.class)
	public List<Caracteristique> findAll() {
		return caracteristiqueRepo.findAll();
	}
	
	@GetMapping("/bonus-flores/{nomFlore1}|{nomFlore2}")
	@JsonView(Views.ViewCaracteristique.class)
	public List<Caracteristique> findAllByBonusFl1Fl2(@PathVariable String nomFlore1, @PathVariable String nomFlore2) {
		return caracteristiqueRepo.findAllByBonusFl1Fl2(nomFlore1,nomFlore2);
	}
	
	@GetMapping("/by-attribut/{typeCarac}|{nom}|{valeur}")
	@JsonView(Views.ViewCaracteristique.class)
	public Caracteristique findByAttribut(@PathVariable TypeCarac typeCarac, @PathVariable String nom,@PathVariable String valeur) {
		return caracteristiqueRepo.findByAttribut(typeCarac,nom,valeur);
	}
	
	@GetMapping("/by-flore/{nom}")
	@JsonView(Views.ViewCaracteristique.class)
	public List<Caracteristique> findByFlore(@PathVariable String nom) {
		return caracteristiqueRepo.findByFlore(nom);
	}

	@GetMapping("/by-type/{typeCarac}")
	@JsonView(Views.ViewCaracteristique.class)
	public List<Caracteristique> findByType(@PathVariable TypeCarac typeCarac) {
		return caracteristiqueRepo.findByType(typeCarac);
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewCaracteristique.class)
	public Caracteristique find(@PathVariable Long id) {

		Optional<Caracteristique> optCarac = caracteristiqueRepo.findById(id);

		if (optCarac.isPresent()) {
			return optCarac.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewCaracteristique.class)
	public Caracteristique create(@RequestBody Caracteristique caracteristique) {
		caracteristique = caracteristiqueRepo.save(caracteristique);

		return caracteristique;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewCaracteristique.class)
	public Caracteristique update(@RequestBody Caracteristique caracteristique, @PathVariable Long id) {
		if (!caracteristiqueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		caracteristique = caracteristiqueRepo.save(caracteristique);

		return caracteristique;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		caracteristiqueRepo.deleteById(id);
	}
}
