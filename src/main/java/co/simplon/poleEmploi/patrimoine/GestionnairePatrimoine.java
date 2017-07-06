package co.simplon.poleEmploi.patrimoine;

import co.simplon.poleEmploi.patrimoine.dao.MonumentJpaDao;
import co.simplon.poleEmploi.patrimoine.modele.Monument;
import co.simplon.poleEmploi.patrimoine.modele.Ville;

//import Monument;

public class GestionnairePatrimoine {

	public static void main(String[] args) {
		System.out.println("Bonjour, param�tre : " + args[0]);
		Monument monument = new Monument();
		MonumentJpaDao md = new MonumentJpaDao();
		
		monument = md.getMonumentById(Integer.parseInt(args[0]));
		System.out.println("Monument : " + monument);
		
		Ville ville = new Ville( 1L, "Attignat", 2.3488, 48.85341);
		System.out.println("Ville : " + ville);
		monument = new Monument("La Grande Arche");
		System.out.println("Monument : " + monument);
		monument = md.createMonument(monument);
		System.out.println("Monument : " + monument);
	}
}
