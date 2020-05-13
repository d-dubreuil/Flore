package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.ReferentielUtilisateur;

public interface IReferentielUtilisateurRepository extends JpaRepository<ReferentielUtilisateur, Long>{

}
