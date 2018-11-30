package bin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import model.DataCenter;
import model.EmplacementIndisponible;
import model.Serveur;

public class Lecture {

	public static void lecture(String path) {

		long debut = System.currentTimeMillis();
		System.out.println("****Lecture démarrée****");
		File file = new File(path);
		int nombreRangees = 0;
		int nombreEmplacements = 0;
		int nombreIndisponible = 0;
		int nombreGroupes = 0;
		int nombreServeurs = 0;
		int numeroLigne = 0;

		ArrayList<String> maLigne = new ArrayList<String>();
		ArrayList<EmplacementIndisponible> indispo = new ArrayList<EmplacementIndisponible>();
		ArrayList<Serveur> server = new ArrayList<Serveur>();

		try {
			InputStream flux = new FileInputStream(file);
			InputStreamReader lecture = new InputStreamReader(flux);
			BufferedReader buff = new BufferedReader(lecture);
			String ligne;

			while ((ligne = buff.readLine()) != null) {
				// *******DESCRIPTION*******\\
				if (numeroLigne == 0) {
					int[] ligneLocale1 = new int[5];
					ligneLocale1 = getIntegers(ligne);

					nombreRangees = ligneLocale1[0];
					nombreEmplacements = ligneLocale1[1];
					nombreIndisponible = ligneLocale1[2];
					nombreGroupes = ligneLocale1[3];
					nombreServeurs = ligneLocale1[4];
					numeroLigne++;

				}
				maLigne.add(ligne);

			}
			buff.close();
		} catch (Exception e) {
			System.out.println(e.toString());
		}

		// for (int i = 0 ; i<maLigne.size(); i++) {
		// System.out.println(maLigne.get(i));
		// }

		// **** AFFICHAGE DESCRIPTION****\\
		System.out.println(nombreRangees + " Rangées de " + nombreEmplacements + " emplacements " + nombreIndisponible
				+ " emplacements indisponibles, " + nombreGroupes + " groupes et " + nombreServeurs + " serveurs");

		DataCenter.setNbrerangee(nombreRangees);
		DataCenter.setNbreslots(nombreEmplacements);
		Serveur.setNombreTotalServeur(nombreServeurs);
		EmplacementIndisponible.setNombreTotalIndispo(nombreIndisponible);

		int ligneLocale = 1;

		// *************EMPLACEMENTS INDISPONIBLES***************\\
		for (int i = 0; i < nombreIndisponible; i++) {

			int[] ligneLocaleIndispo = new int[2];
			ligneLocaleIndispo = getIntegers(maLigne.get(ligneLocale));
			int ligne2 = ligneLocaleIndispo[0];
			int colonne = ligneLocaleIndispo[1];

			System.out
					.println("L'emplacement indisponible " + i + " a pour coordonnée (" + ligne2 + "," + colonne + ")");

			EmplacementIndisponible e = new EmplacementIndisponible(ligne2, colonne);
			ligneLocale++;

		}

		// *****SERVEURS*****\\

		for (int i = 0; i < nombreServeurs; i++) {

			int[] ligneLocaleServeur = new int[2];
			ligneLocaleServeur = getIntegers(maLigne.get(ligneLocale));
			int emplacement = ligneLocaleServeur[0];
			int capacite = ligneLocaleServeur[1];

			System.out.println(
					"le serveur " + i + " prend " + emplacement + " emplacements et a une capacité de " + capacite);

			ArrayList<Serveur> listeServeur = new ArrayList<Serveur>();
			Serveur s = new Serveur(i, emplacement, capacite, listeServeur);
			ligneLocale++;

		}

		System.out.println("durée lecture : " + (System.currentTimeMillis() - debut) + " ms");
		System.out.println("Nombre de Lignes : " + ligneLocale);
		System.out.println("****Lecture terminée****");
		System.out.println();

	}

	public static int[] getIntegers(String str) {

		ArrayList<Integer> list = new ArrayList<Integer>();

		// découper la phrase en mots
		String[] splited = str.split(" ");

		// parcourir les mots
		for (String current : splited) {
			try {
				// tenter de convertir le mot en int
				int parsedInt = Integer.parseInt(current);
				// ajouter l Integer à la list
				list.add(parsedInt); // un "auto boxing", une instance de Integer est créée à partir d'un int
			} catch (NumberFormatException e) {
				// c est pas un int
			}
		}

		// construire le résultat
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			// parcourir la list de Integer créée
			result[i] = list.get(i);
		}
		return result;
	}

}
