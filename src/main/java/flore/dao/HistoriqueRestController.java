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

import flore.model.Historique;
import flore.model.Views;
import flore.persistence.IHistoriqueRepository;

@RestController
@RequestMapping("/api/historique")
@CrossOrigin("*")
public class HistoriqueRestController {

	@Autowired
	private IHistoriqueRepository historiqueRepo;

	@GetMapping("")
	@JsonView(Views.ViewHistorique.class)
	public List<Historique> findAll() {
		return historiqueRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewHistorique.class)
	public Historique find(@PathVariable Long id) {

		Optional<Historique> optHistorique = historiqueRepo.findById(id);

		if (optHistorique.isPresent()) {
			return optHistorique.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewHistorique.class)
	public Historique create(@RequestBody Historique historique) {
		historique = historiqueRepo.save(historique);

		return historique;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewHistorique.class)
	public Historique update(@RequestBody Historique historique, @PathVariable Long id) {
		if (!historiqueRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		historique = historiqueRepo.save(historique);

		return historique;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		historiqueRepo.deleteById(id);
	}
}
