package co.simplon.poleEmploi.patrimoine.dao;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.EntityNotFoundException;
import co.simplon.poleEmploi.patrimoine.modele.Ville;

public class VilleJpaDao implements VilleDao{
	EntityManager entityManager;
	
	public VilleJpaDao (){
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("BasePatrimoine");
		entityManager = emf.createEntityManager();
	}
	
	@Override
	public Ville getVilleById(long idRecherche) {
		Ville ville = entityManager.find(Ville.class, idRecherche);
		if (ville != null)
			return ville;
		else
			throw new EntityNotFoundException();
	}

	@Override
	public void deleteVilleById(long idRecherche) {
		Ville ville = entityManager.find(Ville.class, idRecherche);
		entityManager.remove(ville);
	}

	@Override
	public Ville createVille(Ville ville) {
		entityManager.getTransaction().begin();
		entityManager.persist(ville);
		entityManager.getTransaction().commit();
		return ville;
	}
}