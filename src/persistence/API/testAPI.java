package persistence.API;

public class testAPI {
	public static void main(String[] args) {
		APIDatabase apiMix = new MixOperator();
		System.out.println(apiMix.queryAPI());
	}
}
