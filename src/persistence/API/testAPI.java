package persistence.API;

public class testAPI {
	public static void main(String[] args) {
		APIDatabase apiMix = new MixOperator();
		System.out.println("Résultat MIX : " + apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongée"));

		APIDatabase apiSql = new SQLOperator();
		System.out.println("Résultat SQL : " + apiSql.queryAPI("SELECT * FROM site WHERE price=50"));

		APIDatabase apiText = new TextualOperator();
		System.out.println("Résultat Textuel : " + apiText.queryAPI("plongée"));

	}
}
