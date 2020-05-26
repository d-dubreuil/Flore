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

import flore.model.Jardin;
import flore.model.Views;
import flore.persistence.IJardinRepository;

@RestController
@RequestMapping("/jardin")
@CrossOrigin("*")
public class JardinRestController {

	@Autowired
	private IJardinRepository jardinRepo;

	@GetMapping("")
	@JsonView(Views.ViewJardin.class)
	public List<Jardin> findAll() {
		return jardinRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewJardin.class)
	public Jardin find(@PathVariable Long id) {

		Optional<Jardin> optJardin = jardinRepo.findById(id);

		if (optJardin.isPresent()) {
			return optJardin.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}

	@PostMapping("")
	@JsonView(Views.ViewJardin.class)
	public Jardin create(@RequestBody Jardin jardin) {
		jardin = jardinRepo.save(jardin);

		return jardin;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewJardin.class)
	public Jardin update(@RequestBody Jardin jardin, @PathVariable Long id) {
		if (!jardinRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		jardin = jardinRepo.save(jardin);

		return jardin;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		jardinRepo.deleteById(id);
	}
}
