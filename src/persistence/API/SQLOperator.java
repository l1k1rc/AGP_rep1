package persistence.API;

import java.util.ArrayList;

import core.Site;
import persistence.jdbc.SitePersistence;

public class SQLOperator implements FacadeAPI{
	
	

	public ArrayList<String> queryAPI(String query) {
		//select * from site where price=50
		//select * from site where island_id=1
		
		ArrayList<Site> result = new ArrayList<Site>();
		ArrayList<String> resultFinal = new ArrayList<String>();
		//if(query.matches("val1|val2|val3")) {
 		if(query.matches("(.*)SELECT(.*)")) {
 	 		result = SitePersistence.querySQL(query);
 		}
 		else {
 			result = SitePersistence.searchSiteByIsland(query);
 		}
 			if(result.size()!=0){
 				for(Site a : result){
 					resultFinal.add(Integer.toString((a.getId())));
 					resultFinal.add(a.getName());
 					resultFinal.add(Float.toString((a.getPrice())));
 					resultFinal.add(Boolean.toString(a.getHist_act()));
 					String x = Integer.toString((a.getPosition().getX()));
 					String y = Integer.toString((a.getPosition().getY()));
 					resultFinal.add("["+x+","+y+"]");
 					resultFinal.add(Integer.toString((a.getIsland())));
 				}
 			}
 		
	    return resultFinal;
		
	}
	
	/*public ArrayList<String> queryIslandAPI(String island) {
		ArrayList<Site> result = new ArrayList<Site>();
		ArrayList<String> resultFinal = new ArrayList<String>();
 		result = SitePersistence.searchSiteByIsland(island);
		if(result.size()!=0){
			for(Site a : result){
				resultFinal.add(Integer.toString((a.getId())));
				resultFinal.add(a.getName());
				resultFinal.add(Float.toString((a.getPrice())));
				resultFinal.add(Boolean.toString(a.getHist_act()));
				String x = Integer.toString((a.getPosition().getX()));
				String y = Integer.toString((a.getPosition().getY()));
				resultFinal.add("["+x+","+y+"]");
			}
		}
		
	    return resultFinal;
		
	}*/
	

}
