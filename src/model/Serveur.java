package model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Serveur {

	private int id;
	private int longueur;
	private int capacite;
	private int groupe;
	private static int nombreTotalServeur;
	public static List<Serveur> listeServeur = new ArrayList<Serveur>();

	{
		Serveur.listeServeur.add(this);
	}

	public Serveur(int id, int longueur, int capacite, int groupe, ArrayList<Serveur> listeServeur) {
		super();
		this.id = id;
		this.longueur = longueur;
		this.capacite = capacite;
		this.groupe = groupe;
	}

	public int getNombreTotalServeur() {
		return nombreTotalServeur;
	}

	public static void setNombreTotalServeur(int nombreTotalServeur) {
		Serveur.nombreTotalServeur = nombreTotalServeur;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getLongueur() {
		return longueur;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public int getCapacite() {
		return capacite;
	}

	public void setCapacite(int capacite) {
		this.capacite = capacite;
	}

	public int getGroupe() {
		return groupe;
	}

	public void setGroupe(int groupe) {
		this.groupe = groupe;
	}

	public static final Comparator<Serveur> CAPA_COMPARATOR = new Comparator<Serveur>() {

		@Override
		public int compare(Serveur arg0, Serveur arg1) {
			// TODO Auto-generated method stub
			Serveur p = (Serveur) arg0;
			Serveur q = (Serveur) arg1;
			if (p.capacite < q.capacite)
				return 1;
			else
				return -1;
		}

	};
	
	
}
