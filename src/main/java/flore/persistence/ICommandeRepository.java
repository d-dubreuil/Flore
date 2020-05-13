package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Commande;

public interface ICommandeRepository extends JpaRepository<Commande, Long>{

}
