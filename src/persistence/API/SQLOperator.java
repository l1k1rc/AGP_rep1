package persistence.API;

import java.util.ArrayList;

import core.Site;
import persistence.jdbc.SitePersistence;

public class SQLOperator implements FacadeAPI{
	
	

	public ArrayList<String> queryAPI(String query) {
		ArrayList<Site> result = new ArrayList<Site>();
		ArrayList<String> resultFinal = new ArrayList<String>();
 		SitePersistence sitePersistence = new SitePersistence();
		result = sitePersistence.querySQL(query);
		if(result.size()!=0){
			for(Site a : result){
				resultFinal.add(Integer.toString((a.getId())));
				resultFinal.add(a.getName());
				resultFinal.add(a.getDescription());
				resultFinal.add(Float.toString((a.getPrice())));
				resultFinal.add(a.getType());
				String x = Integer.toString((a.getPosition().getX()));
				String y = Integer.toString((a.getPosition().getY()));
				resultFinal.add("["+x+","+y+"]");

			}
			}
		
	    return resultFinal;
		
	}
	

}
