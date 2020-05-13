package flore.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flore.model.Flore;
import flore.model.TypeCarac;

public interface IFloreRepository extends JpaRepository<Flore, Long>{
	List <Flore> findByNom(String nom);
	
	@Query("select fl from Flore fl join fl.referentielCaracteristiques rc join rc.caracteristique c where c.typeCarac = :type AND c.nom= :nom AND c.valeur=:valeur")
	List<Flore> findAllByCaracteristique(@Param("type")TypeCarac typeCarac,@Param("nom") String nom,@Param("valeur") String valeur );
}
