package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;

import managers.FileReaderManager;

public class JsonDataReader {
	private String customerFilePath;
	//private CustomerDataBean customerDataBean;

	public JsonDataReader() {
		
		//this.customerDataBean = getCustomerData();
	}

	public CustomerDataBean getCustomerData(String testDataFileName) {
		customerFilePath = FileReaderManager.getInstance().getConfigReader().getTestDataResourcePath()
				+ testDataFileName;
		Gson gson = new Gson();
		BufferedReader bufferReader = null;
		try {
			bufferReader = new BufferedReader(new FileReader(customerFilePath));
			CustomerDataBean customer = gson.fromJson(bufferReader, CustomerDataBean.class);
			return customer;
		} catch (FileNotFoundException e) {
			throw new RuntimeException("Json file not found at path : " + customerFilePath);
		} finally {
			try {
				if (bufferReader != null)
					bufferReader.close();
			} catch (IOException ignore) {
			}
		}
	}

	

}
