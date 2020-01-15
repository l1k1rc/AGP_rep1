package domain;

public class Distances {
	private static int coef_multiplicator = 15;
	
	public static int disanceBetweenPoints(int x1, int y1, int x2, int y2) {
		double distance = Math.sqrt(Math.pow(x2-x1, 2.0)+Math.pow(y2-y1, 2.0))*coef_multiplicator;
		return (int)distance;
	}
}
