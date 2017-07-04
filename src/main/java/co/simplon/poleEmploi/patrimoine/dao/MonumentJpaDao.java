package co.simplon.poleEmploi.patrimoine.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import co.simplon.poleEmploi.patrimoine.modele.Ville;

public class MonumentJpaDao implements MonumentDao{

	@Override
	public Ville getVilleById(Long idRecherche) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Ville ville = em.find(Ville.class, idRecherche);
		return ville;
	}

}
