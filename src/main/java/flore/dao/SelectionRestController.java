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


import flore.model.Selection;
import flore.model.Views;
import flore.persistence.ISelectionRepository;

@RestController
@RequestMapping("/selection")
@CrossOrigin("*")
public class SelectionRestController {

	@Autowired
	private ISelectionRepository selectionRepo;
	
	@GetMapping("")
	@JsonView(Views.ViewSelection.class)
	public List<Selection> findAll(){
		return selectionRepo.findAll();
	}

	@GetMapping("/{id}")
	@JsonView(Views.ViewSelection.class)
	public Selection find(@PathVariable Long id) {
		
		Optional<Selection> optSelection=selectionRepo.findById(id);
		if (optSelection.isPresent()) {
			return optSelection.get();
		} else {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}
	}
	
	@PostMapping("")
	@JsonView(Views.ViewSelection.class)
	public Selection create(@RequestBody Selection selection) {
		selection = selectionRepo.save(selection);

		return selection;
	}

	@PutMapping("/{id}")
	@JsonView(Views.ViewSelection.class)
	public Selection update(@RequestBody Selection selection, @PathVariable Long id) {
		if (!selectionRepo.existsById(id)) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find resource");
		}

		selection = selectionRepo.save(selection);

		return selection;
	}

	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		selectionRepo.deleteById(id);
	}
	
}
