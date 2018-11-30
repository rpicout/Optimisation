package model;

public class DataCenter {

	private static int nbrerangee;
	private static int nbreslots;
	
	private static int[][] matriceDataCenter;

	public static int[][] getMatriceDataCenter() {
		return matriceDataCenter;
	}

	public static void setMatriceDataCenter(int[][] matriceDataCenter) {
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
