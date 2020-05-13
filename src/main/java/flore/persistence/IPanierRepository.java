package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Panier;

public interface IPanierRepository extends JpaRepository<Panier, Long>{

}
