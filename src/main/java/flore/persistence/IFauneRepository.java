package flore.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Faune;


public interface IFauneRepository extends JpaRepository<Faune, Long>{

	List <Faune> findByNomFaune(String nomFaune);
}
