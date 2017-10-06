package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class ResourcePathHelper {
	
	public static String getResourcePath(String res) {
		
		String path = System.getProperty("user.dir")+res; 
		//System.out.println(path);
		return path;
	}
	
	public static InputStream getFileInputStream(String path) throws FileNotFoundException {
		return new FileInputStream(getResourcePath(path));
	}
	
	public static void main(String args[]) {
		String test = "\\src\\test\\resources\\testData\\config.properties";
		getResourcePath(test);
	}

}
