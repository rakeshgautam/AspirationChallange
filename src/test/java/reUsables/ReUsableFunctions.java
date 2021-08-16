package reUsables;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;

public class ReUsableFunctions {
	
	public String readPomProperty(String readData) throws Exception {
		Properties prop = new Properties();
		InputStream input = null;
		input = new FileInputStream("./target/my.properties");
			// load a properties file
			prop.load(input);
		return prop.getProperty(readData).toString();
	}
	
public String loadURLUsernamePassword(String readData) throws IOException {
	Properties prop = new Properties();
	InputStream input = null;
	input = new FileInputStream("./URL_username_Password.properties");
		// load a properties file
		prop.load(input);
		// get the property value and print it out
		return(prop.getProperty(readData).toString());
	}

public String loadinputData(String readData) throws IOException {
	Properties prop = new Properties();
	InputStream input = null;
	input = new FileInputStream("./inputData.properties");
		// load a properties file
		prop.load(input);
		// get the property value and print it out
		return(prop.getProperty(readData).toString());
	}

public void setData(String name, String value) throws IOException, ConfigurationException {
try {
    PropertiesConfiguration properties = new PropertiesConfiguration("./inputData.properties");
    properties.setProperty(name, value);
    properties.save();
   // System.out.println("config.properties updated Successfully!!");
} catch (ConfigurationException e) {
    throw e;}
}


}
