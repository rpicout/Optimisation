package bin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import model.DataCenter;
import model.Serveur;
import model.ServeurSortie;

public class Sortie {

	/**
	 * Description : sortie conforme à celle attendue par le google hash Code
	 * 
	 * Prend la matrice DataCenter et formate le contenu en fonction de la sortie
	 * attendue
	 * 
	 * 
	 * @author Pierre Lautrédou
	 */
	public static void sortie() {

		System.out.println("****AFFICHAGE DE LA SORTIE*****");

		Serveur[][] matriceDC = DataCenter.getMatriceDataCenter();
		List<Serveur> liste = new ArrayList<Serveur>();
		List<ServeurSortie> listeServeur = new ArrayList<ServeurSortie>();

		for (int i = 0; i < matriceDC.length; i++) {
			for (int j = 0; j < matriceDC[i].length; j++) {
				if (!liste.contains(matriceDC[i][j]) && matriceDC[i][j].getId() != 100000) {
					liste.add(matriceDC[i][j]);
					listeServeur.add(new ServeurSortie(matriceDC[i][j].getId(), i, j, matriceDC[i][j].getGroupe()));
				}
			}
		}

		Collections.sort(listeServeur, ServeurSortie.ID_COMPARATOR);

		for (ServeurSortie R : listeServeur) {
			System.out.println(R.getRow() + " " + R.getSlot() + " " + R.getGroupe());
		}
		System.out.println();
	}
}
