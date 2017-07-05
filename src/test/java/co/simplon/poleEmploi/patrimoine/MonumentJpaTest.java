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
	public void le_monument_6_doit_etre_TerraNova() {
		// GIVEN
		int idRecherche = 6; 

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Monument monument =  em.find(Monument.class, idRecherche);

		// THEN
		assertEquals(idRecherche, monument.getId());
		assertEquals("Terra Nova", monument.getName());
		assertEquals(33644, monument.getCitiesId());
		assertEquals("Montreuil", monument.getVille().getNom());
//		System.out.println(monument);
	}
}
