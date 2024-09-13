package genericLibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class PropertiesUtility {
/**
 * This class is a generic method to read data from properties
 * @author Nikhil A
 * @return 
 * @throws Exception 
 */
	
	public String readDataFromProperties(String data) throws Exception {
		FileInputStream fis = new FileInputStream(IconstantUtility.propertiesPath);
		Properties pobj = new Properties();
		pobj.load(fis);
		String value = pobj.getProperty(data);
		return value;
	}
}
