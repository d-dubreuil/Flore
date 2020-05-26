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

import flore.model.Favoris;
import flore.model.Views;
import flore.persistence.IFavorisRepository;

@RestController
@RequestMapping("/favoris")
@CrossOrigin("*")
public class FavorisRestController {

	@Autowired
	private IFavorisRepository favoriRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewFavoris.class)
	public List<Favoris> findAll() {
		return favoriRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewFavoris.class)
	public Favoris find(@PathVariable Long id) {

		Optional<Favoris> optFavoris = favoriRepo.findById(id);

		if (optFavoris.isPresent()) {
			return optFavoris.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewFavoris.class)
	public Favoris create(@RequestBody Favoris favoris) {
		favoris = favoriRepo.save(favoris);

		return favoris;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewFavoris.class)
	public Favoris update(@RequestBody Favoris favoris, @PathVariable Long id) {
		if (!favoriRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		favoris = favoriRepo.save(favoris);

		return favoris;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		favoriRepo.deleteById(id);
	}
}
