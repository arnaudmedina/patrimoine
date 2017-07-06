package co.simplon.poleEmploi.patrimoine;

import javax.persistence.EntityNotFoundException;

import co.simplon.poleEmploi.patrimoine.dao.MonumentJpaDao;
import co.simplon.poleEmploi.patrimoine.dao.VilleJpaDao;
import co.simplon.poleEmploi.patrimoine.modele.Monument;
import co.simplon.poleEmploi.patrimoine.modele.Ville;

//import Monument;

public class GestionnairePatrimoine {

	public static void main(String[] args) {
		System.out.println("Bonjour, paramètre : " + args[0]);
		Monument monument = new Monument();
		MonumentJpaDao monumentData = new MonumentJpaDao();
		try {
			monument = monumentData.getMonumentById(Integer.parseInt(args[0]));
			System.out.println("Monument : " + monument);
		} catch (EntityNotFoundException e) {
			System.out.println("!!!! /!\\ /!\\  Monument " + args[0] + " non trouvé  /!\\ /!\\ !!!!");
			System.out.println(e);
		}

		Ville dreamland = new Ville("Dreamland", 2.3488, 48.85341);
		VilleJpaDao villeData = new VilleJpaDao();
		villeData.createVille(dreamland);

		System.out.println("Ville : " + dreamland);
		monument = new Monument("La Grande Arche");
		monument.setVille(dreamland);
		System.out.println("Monument : " + monument);
		monument = monumentData.createMonument(monument);
		System.out.println("Monument : " + monument);
	}
}
