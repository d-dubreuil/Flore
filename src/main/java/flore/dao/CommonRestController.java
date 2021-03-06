package flore.dao;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import flore.model.TypeCarac;
import flore.model.TypeCarte;
import flore.model.Civilite;

@RestController
@RequestMapping ("/api")
@CrossOrigin("*")
public class CommonRestController {
	
	@GetMapping("/typeCarac")
	public TypeCarac[] getTypeCarac() {
		return TypeCarac.values();
	}
	
	@GetMapping("/typeCarte")
	public TypeCarte[] getTypeCarte() {
		return TypeCarte.values();
	}
	
	@GetMapping("/civilites")
	public Civilite[] getCivilites() {
		return Civilite.values();
	}
	
	@GetMapping("/statuts")
	public Civilite[] getStatuts() {
		return Civilite.values();
	}
}
