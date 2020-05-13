package flore.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import flore.model.Produit;

public interface IProduitRepository extends JpaRepository<Produit, Long>{

}
