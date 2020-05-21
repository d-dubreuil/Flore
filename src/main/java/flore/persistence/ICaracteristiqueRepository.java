package flore.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flore.model.Caracteristique;
import flore.model.Flore;
import flore.model.TypeCarac;


public interface ICaracteristiqueRepository extends JpaRepository<Caracteristique, Long> {
	@Query("select c from Caracteristique c where c.typeCarac = :type and c.nom = :nom and c.valeur = :valeur")
	Caracteristique findByAttribut(@Param("type") TypeCarac typeCarac, @Param("nom") String nom,
			@Param("valeur") String valeur);

	@Query("select c from Caracteristique c join c.referentielCaracteristiques rc join rc.flore fl where fl.nom = :nom")
	List<Caracteristique> findByFlore(@Param("nom") String nom);

	@Query("select c from Caracteristique c where c.typeCarac = :type")
	List<Caracteristique> findByType(@Param("type") TypeCarac typeCarac);
	
	List <Caracteristique> findByNom(String nom);

	//alternative à Intercept
	@Query("select c from Caracteristique c join c.referentielCaracteristiques rc join rc.flore fl where fl.nom = :nomFlore1 AND c.bonusMalus='true' AND c in (select c2 from Caracteristique c2 join c2.referentielCaracteristiques rc2 join rc2.flore fl2 where fl2.nom = :nomFlore2)")
	List<Caracteristique> findAllByBonusFl1Fl2(@Param("nomFlore1") String nom1, @Param("nomFlore2") String nom2);

	//alternative à Union
	@Query ("select c from Caracteristique c where c.id in(select c1.id from Caracteristique c1 join c1.referentielCaracteristiques rc1 join rc1.flore fl1 where fl1.nom = :nomFlore1 AND c1.bonusMalus='false' AND c1.nom= :nomCarac) or c.id in ( select c2.id from Caracteristique c2 join c2.referentielCaracteristiques rc2 join rc2.flore fl2 where fl2.nom = :nomFlore2 AND c2.bonusMalus='false' AND c2.nom= :nomCarac)")
	List<Caracteristique> findAllByMalusFl1FL2Carac(@Param("nomFlore1") String nom1, @Param("nomFlore2") String nom2,@Param("nomCarac") String nomC);
}
