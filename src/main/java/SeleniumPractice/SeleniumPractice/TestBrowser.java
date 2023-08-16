package SeleniumPractice.SeleniumPractice;

public class TestBrowser {

	public static void main(String[] args) {
		
		
		String[] Chromeplugins = new String[3];
		
		Chromeplugins[0] = "78.1";
		
		Chromeplugins[1] = "78.2";
		Chromeplugins[2] = "78.3";
		
		
		Browser b = new Browser("Chrome",80.2,Chromeplugins);
		
		String[] plugins = b.getPlugins();
		
		
		for (int i=0;i<=plugins.length-1;i++) {
			
			System.out.println(plugins[i]);
		}
		
		

	}

}
