package bin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

import model.DataCenter;
import model.Serveur;

public class Gloutonne {

	/**
	 * Description : r�cup�re la matrice DataCenter et positionne les serveur selon
	 * une m�thode gloutonne
	 * 
	 * les serveurs sont tri�s par ordre d�croisant de capacit�, sont attribu� au
	 * datacenter en de haut en bas et de gauche � droite. L'attribution des groupe
	 * est effectu� alternativement
	 * 
	 * 
	 * 
	 * @author Pierre Lautr�dou
	 */
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

		Serveur indispo = new Serveur(100000, 0, 0, 0, null);
		int size = Serveur.listeServeur.size();
		Serveur.listeServeur.remove(size - 1);

		// On affecte les serveurs dans l'ordre de la liste tri� au premier endroit
		// disponible
		Serveur[][] matriceDC = DataCenter.getMatriceDataCenter();

		for (Serveur R : Serveur.listeServeur) {
			for (int i = 0; i < matriceDC.length; i++) {
				for (int j = 0; j < matriceDC[i].length; j++) {
					if (verification(R, i, j)) {
						for (int k = 0; k < R.getLongueur(); k++) {
							matriceDC[i][j + k] = R;
						}
						i = matriceDC.length;
						break;
					}
				}
			}
		}
		// Affichage de la matrice apr�s l'attribution des serveurs
		for (int i = 0; i < matriceDC.length; i++) {
			for (int j = 0; j < matriceDC[i].length; j++) {
				try {
					System.out.print(matriceDC[i][j].getId());
				} catch (NullPointerException e) {
					System.out.print(matriceDC[i][j]);
				}
				System.out.print(" ");
			}
			System.out.println();
		}

		// On enregistre la matrice DC
		DataCenter.setMatriceDataCenter(matriceDC);

		// Attribution des groupes
		int nombregroupe = DataCenter.getNbreGroupe();
		List<Integer> listeGroupe = new ArrayList<Integer>();
		List<Integer> listeGroupe2 = new ArrayList<Integer>();
		List<Serveur> listeServeur = new ArrayList<Serveur>();
		for (int i = 0; i < nombregroupe; i++) {
			listeGroupe.add(i);
		}

		for (int i = 0; i < 600; i++) {
			listeGroupe2.addAll(listeGroupe);
		}

		for (int i = 0; i < matriceDC.length; i++) {
			for (int j = 0; j < matriceDC[i].length; j++) {
				if (!listeServeur.contains(matriceDC[i][j]) && matriceDC[i][j].getId() != 100000) {
					listeServeur.add(matriceDC[i][j]);
				}
			}
		}
		int k = 0;
		// System.out.println("d�but du test");
		for (Serveur R : listeServeur) {
			// System.out.println(R.getId());
			R.setGroupe(listeGroupe2.get(k));
			k++;
		}

		System.out.println("dur�e gloutonne : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("****Gloutonne termin�e****");
		System.out.println();
	}

	// Verifie qu'un serveur S ne rentre pas en conflit avec un emplacement
	// indisponible
	public static boolean verification(Serveur serveur, int row, int slot) {
		int longueur = serveur.getLongueur();
		Serveur[][] matriceDC = DataCenter.getMatriceDataCenter();
		boolean bool = true;

		try {
			for (int i = 0; i < longueur; i++) {
				if (matriceDC[row][slot + i] != null) {
					bool = false;
					break;
				} else {
					bool = true;
				}

			}
		} catch (ArrayIndexOutOfBoundsException e) {
			bool = false;
		}

		return bool;
	}
}
