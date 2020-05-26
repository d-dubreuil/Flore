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

import flore.model.Paiement;
import flore.model.Views;
import flore.persistence.IPaiementRepository;

@RestController
@RequestMapping("/api/paiement")
@CrossOrigin("*")
public class PaiementRestController {

	@Autowired
	private IPaiementRepository paiementRepo;

	@GetMapping("")
	@JsonView(Views.ViewPaiement.class)
	public List<Paiement> findAll() {
		return paiementRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewPaiement.class)
	public Paiement find(@PathVariable Long id) {

		Optional<Paiement> optPaiement = paiementRepo.findById(id);

		if (optPaiement.isPresent()) {
			return optPaiement.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewPaiement.class)
	public Paiement create(@RequestBody Paiement paiement) {
		paiement = paiementRepo.save(paiement);

		return paiement;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewPaiement.class)
	public Paiement update(@RequestBody Paiement paiement, @PathVariable Long id) {
		if (!paiementRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		paiement = paiementRepo.save(paiement);

		return paiement;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		paiementRepo.deleteById(id);
	}
}
