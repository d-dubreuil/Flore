package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Paiement;

public interface IPaiementRepository extends JpaRepository<Paiement, Long>{

}
