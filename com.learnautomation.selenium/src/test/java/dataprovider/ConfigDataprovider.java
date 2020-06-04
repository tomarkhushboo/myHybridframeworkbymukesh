package dataprovider;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigDataprovider {
	Properties pro;

	public ConfigDataprovider() {

		File src = new File("./Configuration/config.properties");
		try {
			FileInputStream fls = new FileInputStream(src);

			pro = new Properties();
			pro.load(fls);


		} catch (Exception e) {

			System.out.println("not able to load config file " +e.getMessage());
		}

	}
	//get url from config file
	public String getApplicationURL() {
		return pro.getProperty("URL");
		
	}
	//get chromepath
	public String getChromePath() {
		return  pro.getProperty("chromePath");
	
	}

	//egde path
	public String getEdgePath() {
		return  pro.getProperty("edgePath");
		
	}

	// mozzila path
	public String getGeckoPath() {
		return  pro.getProperty("geckoPath");
		
	}


}
