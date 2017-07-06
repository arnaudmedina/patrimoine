package co.simplon.poleEmploi.patrimoine;

import static org.junit.Assert.assertEquals;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

import co.simplon.poleEmploi.patrimoine.modele.Ville;

public class VilleJpaTest {

	@Test
	public void la_ville_d_identifiant_25925_doit_etre_Forstfeld() {
		// GIVEN
		long idRecherche = 25925L;

		// WHEN
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		EntityManager em = emf.createEntityManager();
		Ville ville = em.find(Ville.class, idRecherche);

		// THEN
		assertEquals(idRecherche, ville.getId());
		assertEquals("Forstfeld", ville.getNom());
		assertEquals(48.85, ville.getLatitude(),0.1);
		assertEquals(8.03333, ville.getLongitude(),0.1);
	}
}
