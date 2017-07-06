package co.simplon.poleEmploi.patrimoine;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import co.simplon.poleEmploi.patrimoine.modele.Monument;
//import co.simplon.poleEmploi.patrimoine.modele.Ville;

public class MonumentJpaTest {

	@Test
	public void l_ensemble_des_monuments_de_Paris_est_accessible(){
		// GIVEN
		long idRecherche = 7L;
		
		// WHEN
		
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Monument monument =  em.find(Monument.class, idRecherche);

		// THEN
		assertEquals(idRecherche, monument.getId());
		System.out.println("Monument trouvé : " + monument);
		System.out.println("Ville trouvée : " + monument.getVille());
		assertEquals("Notre-Dame", monument.getName());
//		assertEquals(idRecherche, monument.getCitiesId());
		assertEquals("Sainte-Foi", monument.getVille().getNom());
	}
	
	@Test
	public void le_monument_6_doit_etre_TerraNova() {
		// GIVEN
		long idRecherche = 6L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Monument monument =  em.find(Monument.class, idRecherche);

		// THEN
		assertEquals(idRecherche, monument.getId());
		assertEquals("Terra Nova", monument.getName());
//		assertEquals(33644L, monument.getCitiesId());
		assertEquals("Montreuil", monument.getVille().getNom());
//		System.out.println(monument);
	}
}
