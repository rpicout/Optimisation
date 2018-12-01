package bin;

import model.DataCenter;

public class Main {

	static String path = "C:\\Users\\Lautredou\\git\\Optimisation2\\Google_HashCode_215\\dc.txt";

	public static void main(String[] args) {

		Lecture.lecture(path);
		
		MatriceDataCenter.MatriceDataCenter();
		
		Gloutonne.gloutonne();
		
		Sortie.sortie();
		
		Scoring.scoring();
	}

}
