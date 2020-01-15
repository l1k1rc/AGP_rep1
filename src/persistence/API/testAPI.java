package persistence.API;

public class testAPI {
	public static void main(String[] args) {
		APIDatabase apiMix = new MixOperator();
		//System.out.println("Résultat final : " + apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongee"));
		long startTime = System.nanoTime();
		apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongee");
		long stopTime = System.nanoTime();
		System.out.println(stopTime - startTime);
	}
}
