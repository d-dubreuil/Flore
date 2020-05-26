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

import flore.model.ReferentielFaune;
import flore.model.Views;
import flore.persistence.IReferentielFauneRepository;


@RestController
@RequestMapping("/referentielFaune")
@CrossOrigin("*")
public class ReferentielFauneRestController {


	@Autowired
	private IReferentielFauneRepository refFauneRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewReferentielFaune.class)
	public List<ReferentielFaune> findAll(){
		return refFauneRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewReferentielFaune.class)
	public ReferentielFaune find(@PathVariable Long id) {
		
		Optional<ReferentielFaune> optRefFaune=refFauneRepo.findById(id);
		if (optRefFaune.isPresent()) {
			return optRefFaune.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewReferentielFaune.class)
	public ReferentielFaune create(@RequestBody ReferentielFaune refFaune) {
		refFaune = refFauneRepo.save(refFaune);

		return refFaune;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewReferentielFaune.class)
	public ReferentielFaune update(@RequestBody ReferentielFaune refFaune, @PathVariable Long id) {
		if (!refFauneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		refFaune = refFauneRepo.save(refFaune);

		return refFaune;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		refFauneRepo.deleteById(id);
	}
}
