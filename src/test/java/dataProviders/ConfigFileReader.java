package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import enums.DriverType;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "src/main/resources/Configuration.properties";

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getDriverPath() {
		String driverPath = null;
		if(properties.getProperty("browser").equalsIgnoreCase("Chrome")) {
			driverPath = properties.getProperty("driverPath");
			return driverPath;
		}else if(properties.getProperty("browser").equalsIgnoreCase("Firefox")) {
			driverPath = properties.getProperty("driverPathFirefox");
			return driverPath;
		}else
			throw new RuntimeException("driverPath not specified in the Configuration.properties file.");
	}

	
	public String getApplicationUrl() {
		String url = properties.getProperty("url");
		if (url != null)
			return url;
		else
			throw new RuntimeException("url not specified in the Configuration.properties file.");
	}

	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser");
		if (browserName == null || browserName.equals("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer"))
			return DriverType.INTERNETEXPLORER;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);
	}

	public String readTestData(String propKey) {
		String testData = properties.getProperty(propKey);
		if (testData != null) {
			return testData;
		} else {
			throw new RuntimeException("No test data available with key: " + propKey);
		}
	}

	public String getTestDataResourcePath() {
		String testDataResourcePath = "src/main/resources/testData/";
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}
	
	public void setProperty(String key,String value) {
		properties.setProperty("TotalOrderAmount", value);
	}


}
