package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Jardin;

public interface IJardinRepository extends JpaRepository<Jardin, Long>{

}
