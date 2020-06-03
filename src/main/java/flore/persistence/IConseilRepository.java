package flore.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import flore.model.Conseil;

public interface IConseilRepository extends JpaRepository<Conseil, Long> {
	@Query("select c from Conseil c where c.theme = :theme")
	List<Conseil> findByTheme(@Param("theme") String theme);

	@Query("select c from Conseil c where c.nom = :nom")
	List<Conseil> findByNom(@Param("nom") String nom);

	/*
	 * @Query ("select c.nom from Conseil c") String findName ();
	 */
}
