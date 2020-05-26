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

import flore.model.Conseil;
import flore.model.Views;
import flore.persistence.IConseilRepository;

@RestController
@RequestMapping("/api/conseil")
@CrossOrigin("*")
public class ConseilRestController {

	@Autowired
	private IConseilRepository conseilRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewConseil.class)
	public List<Conseil> findAll() {
		return conseilRepo.findAll();
	}
	
	@GetMapping("/{id}")
	@JsonView(Views.ViewConseil.class)
	public Conseil find(@PathVariable Long id) {

		Optional<Conseil> optConseil = conseilRepo.findById(id);

		if (optConseil.isPresent()) {
			return optConseil.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@GetMapping("/by-theme/{theme}")
	@JsonView(Views.ViewConseil.class)
	public List<Conseil> findByTheme(@PathVariable String theme) {
		return conseilRepo.findByTheme(theme);	
	}
	
	@PostMapping("")
	@JsonView(Views.ViewConseil.class)
	public Conseil create(@RequestBody Conseil conseil) {
		conseil = conseilRepo.save(conseil);

		return conseil;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewConseil.class)
	public Conseil update(@RequestBody Conseil conseil, @PathVariable Long id) {
		if (!conseilRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		conseil = conseilRepo.save(conseil);

		return conseil;
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		conseilRepo.deleteById(id);
	}
	
}
