package persistence.API;

import java.util.ArrayList;

import org.apache.commons.lang.StringUtils;

import persistence.jdbc.Mixrequest;

public class MixOperator implements APIDatabase {
	public ArrayList<String> result = new ArrayList<String>();

	@Override
	public ArrayList<String> queryAPI(String request) {
		// TODO Auto-generated method stub
		ArrayList<String> result = new ArrayList<String>();
		Mixrequest mixrequest = new Mixrequest();
		String str = request;
		if (!StringUtils.substringBetween(str, "SELECT", "FROM").contains("*"))
			System.err.println("Error : only [SELECT * FROM] allowed ");
		else
			result = mixrequest.getIndexFileNumberForMixRequest(request);

		return result;
	}
}
