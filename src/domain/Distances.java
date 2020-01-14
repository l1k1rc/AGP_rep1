package domain;

public class Distances {
	
	public static int disanceBetweenPoints(int x1, int y1, int x2, int y2) {
		double distance = Math.sqrt(Math.pow(x2-x1, 2.0)+Math.pow(y2-y1, 2.0));
		return (int)distance;
	}
}
