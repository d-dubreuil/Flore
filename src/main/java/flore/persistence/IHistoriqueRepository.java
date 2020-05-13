package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Historique;

public interface IHistoriqueRepository extends JpaRepository<Historique, Long>{

}
