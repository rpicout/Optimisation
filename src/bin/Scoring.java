package bin;

import java.util.ArrayList;
import java.util.List;

import model.DataCenter;
import model.Serveur;

public class Scoring {
	
	/**
	 * Description : Calcul du score
	 * 
	 * Calcul du score en fonction de la matrice DataCenter
	 * (à vérifier car j'ai pas tout compris)
	 * 
	 * 
	 * 
	 * @author Pierre Lautrédou
	 */
	public static void scoring() {

		// Creation de la matrice de Scoring
		int nombreGroupe = DataCenter.getNbreGroupe();
		int nombreRangee = DataCenter.getNbrerangee();
		int Score = 100000;
		List<Serveur> CurrentServeur = new ArrayList<Serveur>();

		Serveur[][] matriceDC = DataCenter.getMatriceDataCenter();
		int[][] matriceScoring = new int[nombreGroupe][nombreRangee];
		for (int k = 0; k < nombreGroupe; k++) {
			List<Integer> currentCapa = new ArrayList<Integer>();
			for (int i = 0; i < matriceDC.length; i++) {

				for (int j = 0; j < matriceDC[i].length; j++) {
					if (matriceDC[i][j].getGroupe() == k && matriceDC[i][j].getId() != 100000
							&& !CurrentServeur.contains(matriceDC[i][j])) {
						CurrentServeur.add(matriceDC[i][j]);
						currentCapa.add(matriceDC[i][j].getCapacite());
						matriceScoring[k][i] = matriceDC[i][j].getCapacite();
						if (Score > matriceDC[i][j].getCapacite()) {
							Score = matriceDC[i][j].getCapacite();
						}
					}
				}

			}
			// for (int l = 0; l < currentCapa.size(); l++) {
			// System.out.println(
			// "la capacité du groupe " + k + " est de " + currentCapa.get(l));
			// }

		}
		System.out.println(" ");
		// Affichage de la matrice Scoring
		System.out.println("***MATRICE SCORING*** ");
		for (int i = 0; i < nombreGroupe; i++) {
			for (int j = 0; j < nombreRangee; j++) {
				System.out.print(matriceScoring[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}
		for (Serveur R : Serveur.listeServeur) {

		}
		System.out.println(" ");

		System.out.println("Score Total = " + Score);
	}

}
