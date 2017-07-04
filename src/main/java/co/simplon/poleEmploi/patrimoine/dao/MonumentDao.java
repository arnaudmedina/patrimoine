package co.simplon.poleEmploi.patrimoine.dao;
import co.simplon.poleEmploi.patrimoine.modele.Ville;

public interface MonumentDao {
	Ville getVilleById(Long id);
}
