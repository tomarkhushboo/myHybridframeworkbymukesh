package factory;

//object of config dataprovider

import dataprovider.ConfigDataprovider;
import dataprovider.ExcelDataProvider;

public class DataProviderFactory {

	//this will return object of config dataprovider
	public static ConfigDataprovider getconfig() {
		ConfigDataprovider config = new ConfigDataprovider();
		return config;
	}
	
	
	public static ExcelDataProvider getExcel() throws Exception {
		ExcelDataProvider excl = new ExcelDataProvider();
		return excl;
	}
}
