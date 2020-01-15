package persistence.API;

public class testAPI {
	public static void main(String[] args) {
		APIDatabase apiMix = new MixOperator();
		System.out.println("Résultat final : " + apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongee"));
		apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongee");
		APIDatabase apiText = new TextualOperator();
		System.out.println(apiText.queryAPI("plongée"));
	}
}
