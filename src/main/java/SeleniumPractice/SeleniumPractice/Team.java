package SeleniumPractice.SeleniumPractice;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	public List<String> getDeviceList(String teamname) {
		
		
		List<String> devicelist = new ArrayList<String>();
		
		 if(teamname.equals("QA")) {
			 
			 devicelist.add("Selenium");
			 devicelist.add("RestAssured");
		 }else if (teamname.equals("dev")) {
			 devicelist.add("dot.net");
			 devicelist.add("API");
			 
		 }
		
		 return devicelist;
	}

}
