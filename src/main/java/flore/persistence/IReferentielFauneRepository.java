package flore.persistence;


import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.ReferentielFaune;

public interface IReferentielFauneRepository extends JpaRepository<ReferentielFaune, Long>{

}
