package SeleniumPractice.SeleniumPractice;

import java.util.List;

public class TestTeam {
	
	public static void main (String[] args) {
		
		Team m = new Team();
		
		List<String> deviceList = m.getDeviceList("dev");
		
		for (int i =0;i<=deviceList.size()-1;i++) {
			
			System.out.println(deviceList.get(i));
		}
		
	}

}
