package bin;

import model.DataCenter;

public class Main {

	static String path = "D:\\HalfPeter\\Cours\\Master 2\\Projet_Optimisation\\poly.txt";

	public static void main(String[] args) {

		Lecture.lecture(path);
		
		MatriceDataCenter.MatriceDataCenter();
		
		Gloutonne.gloutonne();
	}

}
