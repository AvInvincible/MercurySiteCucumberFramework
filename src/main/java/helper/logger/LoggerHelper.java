package helper.logger;

import java.io.FileNotFoundException;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

import utils.ResourcePathHelper;


/* Created on 10 Oct, 2017, Author- Ajit Vijayee Yadav, This class file 
 * Initialize the logger file properties stored in resource/logger diretory
 */
public class LoggerHelper {
	
	private static boolean root = false;
	
	public static Logger getLogger(@SuppressWarnings("rawtypes") Class tclass) {
		if(root) {
			return Logger.getLogger(tclass);
		}
		
		try {
			PropertyConfigurator.configure(ResourcePathHelper.getFileInputStream("/src/main/resources/logger/log4j.properties"));
			root = true;
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return getLogger(tclass);
	}
	
//	public static void main(String args[]) {
//		getLogger(LoggerHelper.class);
//	}
	

}
