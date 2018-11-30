package model;

import java.util.ArrayList;
import java.util.List;

public class EmplacementIndisponible {

	private int rangee;
	private int emplacement;
	private static int nombreTotalIndispo;
	public static List<EmplacementIndisponible> listeDispo = new ArrayList<EmplacementIndisponible>();

	{
		EmplacementIndisponible.listeDispo.add(this);
	}
	
	


	public EmplacementIndisponible(int rangee, int emplacement) {
		this.rangee = rangee;
		this.emplacement = emplacement;
	}
	
	public static int getNombreTotalIndispo() {
		return nombreTotalIndispo;
	}


	public static void setNombreTotalIndispo(int nombreTotalIndispo) {
		EmplacementIndisponible.nombreTotalIndispo = nombreTotalIndispo;
	}
	
	public int getRangee() {
		return rangee;
	}
	public void setRangee(int rangee) {
		this.rangee = rangee;
	}
	public int getEmplacement() {
		return emplacement;
	}
	public void setEmplacement(int emplacement) {
		this.emplacement = emplacement;
	}
}
