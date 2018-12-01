package bin;

import model.DataCenter;
import model.EmplacementIndisponible;
import model.Serveur;

public class MatriceDataCenter {

	/**
	 * Description : cr�ation de la matrice DataCenter qui nous servira pour la
	 * suite du probleme.
	 * 
	 * 
	 * la matrice est cr��e avec la taille indiqu�e dans le fichier de donn�es et
	 * les serveurs indisponibles sont indiqu�s de la mani�re suivante : 
	 * new Serveur(100000, 0, 100000, 0, null)
	 * 
	 * 
	 * 
	 * @author Pierre Lautr�dou
	 */
	public static void MatriceDataCenter() {
		long debut = System.currentTimeMillis();
		System.out.println("****Cr�ation de la matrice DataCenter d�marr�e****");

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

		System.out.println("dur�e Matrice DataCenter : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("****Cr�ation de la matrice DataCenter termin�e****");
		System.out.println();

	}
}
