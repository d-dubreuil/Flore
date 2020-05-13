package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Utilisateur;

public interface IUtilisateurRepository extends JpaRepository<Utilisateur, Long>{

}
