package flore.persistence.custom;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import flore.model.Caracteristique;
import flore.model.Flore;
import flore.model.ReferentielCaracteristique;
import flore.persistence.IFloreRepositoryCustom;
import flore.web.dto.FloreForm;

@Repository
public class FloreRepositoryImpl implements IFloreRepositoryCustom{
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Flore> search(FloreForm floreformulaire) {
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		CriteriaQuery<Flore> criteriaQuery = criteriaBuilder.createQuery(Flore.class);
		
		Root<Flore> floreFrom = criteriaQuery.from(Flore.class);
		
		Join<Flore,ReferentielCaracteristique> rc = floreFrom.join("referentielCaracteristiques",JoinType.LEFT);
		
		Join<ReferentielCaracteristique,Caracteristique> c = rc.join("caracteristique", JoinType.LEFT);

		List<Predicate> predicates = new ArrayList<Predicate>();

		for (String carac : floreformulaire.getCaracteristiques()) 
		{ 
			String [] caracs = carac.split("|");
			String typeCarac = caracs[0];
			String nomCarac = caracs[1];
			String valeurCarac = caracs[2];
			predicates.add(criteriaBuilder.equal(c.get("typeCarac"),typeCarac));
			predicates.add(criteriaBuilder.equal(c.get("nom"),nomCarac));
			predicates.add(criteriaBuilder.equal(c.get("valeur"),valeurCarac));
		}
		
		if (predicates.size() > 0) {
			criteriaQuery.where(predicates.toArray(new Predicate[0]));
		}
		
		return em.createQuery(criteriaQuery).getResultList();
	}

}
