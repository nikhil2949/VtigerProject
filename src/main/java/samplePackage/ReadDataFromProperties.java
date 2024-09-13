package samplePackage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class ReadDataFromProperties {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
FileInputStream fis = new FileInputStream("C:\\Selenium\\TestData.properties");
Properties pobj = new Properties();
pobj.load(fis);
String URL = pobj.getProperty("url");
String USERNAME = pobj.getProperty("username");
String PASSWORD = pobj.getProperty("password");
System.out.println(URL);
System.out.println(USERNAME);
System.out.println(PASSWORD);


	}

}
