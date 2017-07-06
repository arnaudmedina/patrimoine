package co.simplon.poleEmploi.patrimoine.dao;
import co.simplon.poleEmploi.patrimoine.modele.Monument;

public interface MonumentDao {
	Monument getMonumentById(long id);
	void deleteMonumentById(long id);
	Monument createMonument(Monument monument);
}
