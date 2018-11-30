package bin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import model.DataCenter;
import model.Serveur;

public class Gloutonne {

	public static void gloutonne() {
		System.out.println("**** Gloutonne comenc�e****");
		long debut = System.currentTimeMillis();

		// On trie les serveur par ordre d�crossant de capacit�
		Collections.sort(Serveur.listeServeur, Serveur.CAPA_COMPARATOR);

		System.out.println("Triage par capacit� des serveurs");
		System.out.println("-------");
		for (Iterator iter = Serveur.listeServeur.iterator(); iter.hasNext();) {
			Serveur p = (Serveur) iter.next();
			System.out.println("le serveur " + p.getId() + " prend " + p.getLongueur()
					+ " emplacements et a une capacit� de " + p.getCapacite());

		}

		// On affecte les serveurs dans l'ordre de la liste tri� au premier endroit
		// disponible
		int[][] matriceDC = DataCenter.getMatriceDataCenter();

		for (Serveur R : Serveur.listeServeur) {
			for (int i = 0; i < matriceDC.length; i++) {
				try {
					for (int j = 0; j < matriceDC[i].length; j++) {
						if (matriceDC[i][j] == 0 && matriceDC[i][j + R.getLongueur()] == 0) {
							for (int k = 0; k < R.getLongueur(); k++) {
								matriceDC[i][j + k] = (R.getId() + 10);
							}
							i = matriceDC.length;
							break;
						}
					}
				} catch (ArrayIndexOutOfBoundsException e) {
				}
			}
		}
		// Affichage de la matrice apr�s l'attribution des serveurs
		for (int i = 0; i < matriceDC.length; i++) {
			for (int j = 0; j < matriceDC[i].length; j++) {
				System.out.print(matriceDC[i][j]);
				System.out.print(" ");
			}
			System.out.println();
		}

		// On enregistre la matrice DC
		DataCenter.setMatriceDataCenter(matriceDC);

		System.out.println("dur�e gloutonne : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("****Gloutonne termin�e****");
		System.out.println();
	}

}
