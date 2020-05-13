package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.CompteUtilisateur;

public interface ICompteUtilisateurRepository extends JpaRepository<CompteUtilisateur, Long> {

}
