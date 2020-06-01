package flore.dao;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import flore.model.TypeCarac;
import flore.model.Views;

import flore.persistence.custom.SimulateurUnRepositorylmpl;
import flore.web.dto.Bonus;

import flore.web.dto.Malus;
import flore.web.dto.SimulateurUn;


@RestController
@RequestMapping("/api/synergie")
@CrossOrigin("*")
public class SynergieRestController {
	
	@Autowired
	private SimulateurUnRepositorylmpl simulateurUnRepolmpl;
	
	@GetMapping("/by-simulateur-un/{nomFlore1}|{nomFlore2}")
	@JsonView(Views.ViewCaracteristique.class)
	public SimulateurUn synergieUn(@PathVariable String nomFlore1,@PathVariable String nomFlore2 ) {
		return simulateurUnRepolmpl.synergieUn(nomFlore1, nomFlore2);
	}
	
	@GetMapping("/type-caracs")
	public TypeCarac[] getTypeCaracs() {
		return TypeCarac.values();
	}

}
