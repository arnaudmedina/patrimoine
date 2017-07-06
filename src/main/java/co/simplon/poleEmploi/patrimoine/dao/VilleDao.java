package co.simplon.poleEmploi.patrimoine.dao;
import co.simplon.poleEmploi.patrimoine.modele.Ville;

public interface VilleDao {
	Ville getVilleById(long id);
	void deleteVilleById(long id);
	Ville createVille(Ville ville);
}
