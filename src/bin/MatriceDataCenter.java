package bin;

import model.DataCenter;
import model.EmplacementIndisponible;
import model.Serveur;

public class MatriceDataCenter {

	public static void MatriceDataCenter() {
		long debut = System.currentTimeMillis();
		System.out.println("****Création de la matrice DataCenter démarrée****");

		int slots = DataCenter.getNbreslots();
		int row = DataCenter.getNbrerangee();

		Serveur[][] matrice_DataCenter = new Serveur[row][slots];

		for (EmplacementIndisponible E : EmplacementIndisponible.listeDispo) {
			matrice_DataCenter[E.getRangee()][E.getEmplacement()] = new Serveur(100000, 0, 100000, 0, null);

		}
		int size = Serveur.listeServeur.size();
		Serveur.listeServeur.remove(size - 1);

		DataCenter.setMatriceDataCenter(matrice_DataCenter);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < slots; j++) {
				try {
					System.out.print(matrice_DataCenter[i][j].getId());
				} catch (NullPointerException e) {
					System.out.print(matrice_DataCenter[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("durée Matrice DataCenter : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("****Création de la matrice DataCenter terminée****");
		System.out.println();

	}
}
