package bin;

import model.DataCenter;
import model.EmplacementIndisponible;

public class MatriceDataCenter {

	public static void MatriceDataCenter() {
		long debut = System.currentTimeMillis();
		System.out.println("****Cr�ation de la matrice DataCenter d�marr�e****");

		int slots = DataCenter.getNbreslots();
		int row = DataCenter.getNbrerangee();

		int[][] matrice_DataCenter = new int[row][slots];

		for (EmplacementIndisponible E : EmplacementIndisponible.listeDispo) {
			matrice_DataCenter[E.getRangee()][E.getEmplacement()] = 1;

		}

		DataCenter.setMatriceDataCenter(matrice_DataCenter);

		for (int i = 0; i < row; i++) {
			for (int j = 0; j < slots; j++) {
				System.out.print(matrice_DataCenter[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		System.out.println("dur�e Matrice DataCenter : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("****Cr�ation de la matrice DataCenter termin�e****");
		System.out.println();

	}
}
