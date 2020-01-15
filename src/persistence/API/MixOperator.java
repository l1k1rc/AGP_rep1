package persistence.API;

import java.util.ArrayList;

import persistence.jdbc.Mixrequest;

public class MixOperator implements APIDatabase {
	public ArrayList<String> result = new ArrayList<String>();

	@Override
	public ArrayList<String> queryAPI() {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		Mixrequest mixrequest = new Mixrequest();
		result = mixrequest.getIndexFileNumberForMixRequest();

		return result;
	}
}
