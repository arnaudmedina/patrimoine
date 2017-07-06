package co.simplon.poleEmploi.patrimoine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityNotFoundException;

import co.simplon.poleEmploi.patrimoine.modele.Monument;

public class MonumentJpaDao implements MonumentDao{
	EntityManager entityManager;
	
	public MonumentJpaDao (){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		entityManager = emf.createEntityManager();
	}
	
	@Override
	public Monument getMonumentById(long idRecherche) throws EntityNotFoundException{
		Monument monument = entityManager.find(Monument.class, idRecherche);
		if (monument != null)
			return monument;
		else
			throw new EntityNotFoundException();
	}

	@Override
	public void deleteMonumentById(long idRecherche) {
		Monument monument = entityManager.find(Monument.class, idRecherche);
		entityManager.remove(monument);
	}

	@Override
	public Monument createMonument(Monument monument) {
		entityManager.getTransaction().begin();
		entityManager.persist(monument);
		entityManager.getTransaction().commit();
		return monument;
	}
}