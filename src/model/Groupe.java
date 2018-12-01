package model;

import java.util.ArrayList;
import java.util.List;

public class Groupe {
	
	private List<Serveur> ListServeur = new ArrayList<Serveur>();
	
	public static List<Groupe> listeGroupe = new ArrayList<Groupe>();
	
	{
		Groupe.listeGroupe.add(this);
	}
	
	public Groupe(ArrayList<Serveur> listeServeur, ArrayList<Groupe> listeGroupe) {
		super();
		
	}


	public List<Serveur> getListServeur() {
		return ListServeur;
	}

	public void setListServeur(List<Serveur> listServeur) {
		ListServeur = listServeur;
	}

	public static List<Groupe> getListeGroupe() {
		return listeGroupe;
	}

	public static void setListeGroupe(List<Groupe> listeGroupe) {
		Groupe.listeGroupe = listeGroupe;
	}
	
	

}
