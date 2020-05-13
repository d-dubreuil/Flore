package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Selection;

public interface ISelectionRepository extends JpaRepository<Selection, Long>{

}
