package model;

public class DataCenter {

	private static int nbrerangee;
	private static int nbreslots;
	private static int nbreGroupe;
	
	public static int getNbreGroupe() {
		return nbreGroupe;
	}

	public static void setNbreGroupe(int nbreGroupe) {
		DataCenter.nbreGroupe = nbreGroupe;
	}

	private static Serveur[][] matriceDataCenter;

	public static Serveur[][] getMatriceDataCenter() {
		return matriceDataCenter;
	}

	public static void setMatriceDataCenter(Serveur[][] matriceDataCenter) {
		DataCenter.matriceDataCenter = matriceDataCenter;
	}

	public static int getNbrerangee() {
		return nbrerangee;
	}

	public static void setNbrerangee(int nbrerangee) {
		DataCenter.nbrerangee = nbrerangee;
	}

	public static int getNbreslots() {
		return nbreslots;
	}

	public static void setNbreslots(int nbreslots) {
		DataCenter.nbreslots = nbreslots;
	}

}
