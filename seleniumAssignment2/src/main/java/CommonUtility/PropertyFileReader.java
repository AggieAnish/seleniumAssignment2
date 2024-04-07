package CommonUtility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertyFileReader {

	private Properties properties;

	private final String configFilePath= "C:\\Users\\HP\\git\\seleniumAssignment\\seleniumAssignment\\src\\main\\resources\\PropertyFile\\config.properties";

	public PropertyFileReader() {

	File ConfigFile=new File(configFilePath);

	try {

	FileInputStream configFileReader=new FileInputStream(ConfigFile);

	properties = new Properties();

	try {

	properties.load(configFileReader);

	configFileReader.close();

	} catch (IOException e)

	{

	System.out.println(e.getMessage());

	}

	} catch (FileNotFoundException e)

	{

	System.out.println(e.getMessage());

	throw new RuntimeException("config.properties not found at config file path " + configFilePath);

	}
	}
	public  long getTimeout() {

		String timeout= properties.getProperty("timeout");

		if(timeout != null)

		return Long.parseLong(timeout);

		else

		throw new RuntimeException("Timeout not specified in the config.properties file.");

		}	
	public String getValue(String value) {

		String data= properties.getProperty(value);


		if(data != null)

		return data;

		else

		throw new RuntimeException ("Null");

		}
}