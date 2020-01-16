package persistence.API;

public class testAPI {
	public static void main(String[] args) {
		FacadeAPI apiMix = new MixOperator();
		//System.out.println("Résultat MIX : " + apiMix.queryAPI("SELECT * FROM site WHERE price=50 with plongée"));
		//System.out.println("Résultat MIX2 : " + apiMix.queryAPI("SELECT * FROM site with Fuerteventura"));
		//System.out.println("Résultat MIX3 : " + apiMix.queryAPI("SELECT * FROM site with plongée Fuerteventura"));
		//System.out.println("Résultat MIX2 : " + apiMix.queryAPI("Fuerteventura"));
		
		FacadeAPI apiSql = new SQLOperator();
		//System.out.println("Résultat SQL : " + apiSql.queryAPI("SELECT * FROM site AS a WHERE a.island_id = (SELECT id FROM island WHERE name='Tenerife')"));
		//System.out.println("Résultat SQL : " + apiSql.queryIslandAPI("Tenerife"));
		//System.out.println("Résultat SQL : " + apiSql.queryAPI("SELECT * FROM site WHERE price=50"));
		System.out.println("Résultat SQL : " + apiSql.queryAPI("Tenerife"));
		
		FacadeAPI apiText = new TextualOperator();
		//System.out.println("Résultat Textuel : " + apiText.queryAPI("plongée"));

	}
}
