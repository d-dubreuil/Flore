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

import flore.model.Faune;
import flore.model.Views;
import flore.persistence.IFauneRepository;

@RestController
@RequestMapping("/api/faune")
@CrossOrigin("*")
public class FauneRestController {
	
	@Autowired
	private IFauneRepository fauneRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewFaune.class)
	public List<Faune> findAll(){
		return fauneRepo.findAll();
	}
	
	@GetMapping("/by-nom/{nomFaune}")
	@JsonView(Views.ViewFaune.class)
	public List<Faune> findByNomFaune(@PathVariable String nomFaune){
		return fauneRepo.findByNomFaune(nomFaune);
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFaune.class)
	public Faune find(@PathVariable Long id) {
		
		Optional<Faune> optFaune=fauneRepo.findById(id);
		if (optFaune.isPresent()) {
			return optFaune.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewFaune.class)
	public Faune create(@RequestBody Faune faune) {
		faune = fauneRepo.save(faune);

		return faune;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFaune.class)
	public Faune update(@RequestBody Faune faune, @PathVariable Long id) {
		if (!fauneRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		faune = fauneRepo.save(faune);

		return faune;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		fauneRepo.deleteById(id);
	}
	
}
