package SeleniumPractice.SeleniumPractice;

public class Browser {
	
	
	private String Name;

	private double Version;
	
	private String[] plugins;
	
	
	
	public Browser(String Name,double Version,String[] plugins) {
		
		this.Name = Name;
		
		this.Version = Version;
		
		this.plugins = plugins;
		
	}
	
	public String getName() {
		return Name;
	}



	public void setName(String name) {
		Name = name;
	}



	public double getVersion() {
		return Version;
	}



	public void setVersion(double version) {
		Version = version;
	}



	public String[] getPlugins() {
		return plugins;
	}



	public void setPlugins(String[] plugins) {
		this.plugins = plugins;
	}
	
	

}
