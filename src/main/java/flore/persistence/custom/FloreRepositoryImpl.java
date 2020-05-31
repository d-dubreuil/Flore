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
		
		List<Predicate> predicatesQueries = new ArrayList<Predicate>();


		for (String carac : floreformulaire.getCaracteristiques()) {
			CriteriaQuery<Flore> criteriaQuery2 = criteriaBuilder.createQuery(Flore.class);

			Root<Flore> floreFrom2 = criteriaQuery2.from(Flore.class);
			Predicate predicate = criteriaBuilder.disjunction();

			
			Join<Flore,ReferentielCaracteristique> rc = floreFrom2.join("referentielCaracteristiques",JoinType.LEFT);
			Join<ReferentielCaracteristique,Caracteristique> c = rc.join("caracteristique", JoinType.LEFT);
			String [] caracs = carac.split(":");

			for (int i = 1; i<caracs.length;i++) {
				Predicate predicateEquivalents;
				String nomCarac = caracs[0];
				String valeurCarac = caracs[i];
				predicateEquivalents = criteriaBuilder.and(criteriaBuilder.equal(c.get("valeur"),valeurCarac),criteriaBuilder.equal(c.get("nom"),nomCarac));
				predicate=criteriaBuilder.or(predicate, predicateEquivalents);
				
			}
			criteriaQuery2.where(predicate);
			Predicate predicateGlobal = floreFrom.in(em.createQuery(criteriaQuery2).getResultList());

			predicatesQueries.add(predicateGlobal);
		}
		
		if (predicatesQueries.size() > 0) {
			criteriaQuery.where(predicatesQueries.toArray(new Predicate[0]));
		}
		criteriaQuery.orderBy(criteriaBuilder.asc(floreFrom.get("nom")));

		
		
		return em.createQuery(criteriaQuery).getResultList();
	}

}
