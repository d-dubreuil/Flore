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

import flore.model.ReferentielCaracteristique;
import flore.model.Views;
import flore.persistence.IReferentielCaracteristiqueRepository;

@RestController
@RequestMapping("/referentiel-caracteristique")
@CrossOrigin("*")
public class ReferentielCaracteristiqueRestController {
	@Autowired
	private IReferentielCaracteristiqueRepository refCaracRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewReferentielCaracteristique.class)
	public List<ReferentielCaracteristique> findAll() {
		return refCaracRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReferentielCaracteristique.class)
	public ReferentielCaracteristique find(@PathVariable Long id) {

		Optional<ReferentielCaracteristique> optRefCarac = refCaracRepo.findById(id);

		if (optRefCarac.isPresent()) {
			return optRefCarac.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewReferentielCaracteristique.class)
	public ReferentielCaracteristique create(@RequestBody ReferentielCaracteristique referentielCaracteristique) {
		referentielCaracteristique = refCaracRepo.save(referentielCaracteristique);

		return referentielCaracteristique;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewReferentielCaracteristique.class)
	public ReferentielCaracteristique update(@RequestBody ReferentielCaracteristique referentielCaracteristique, @PathVariable Long id) {
		if (!refCaracRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		referentielCaracteristique = refCaracRepo.save(referentielCaracteristique);

		return referentielCaracteristique;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		refCaracRepo.deleteById(id);
	}
}
