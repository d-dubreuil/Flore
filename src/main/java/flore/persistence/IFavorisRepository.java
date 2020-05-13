package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Favoris;

public interface IFavorisRepository extends JpaRepository<Favoris, Long>{

}
