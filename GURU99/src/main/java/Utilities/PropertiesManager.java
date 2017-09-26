package Utilities;


	import java.io.File;
	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.Properties;

	public enum PropertiesManager {
	 PROPERTIES;
	 
	private Properties props = new Properties();
	 
	 private PropertiesManager() {
	  try {
		  /*File f = new File("");
		  FileInputStream ft=new FileInputStream(f);
		  props.load(ft);
		  instead of these 3 lines, we can havve the below 1 line*/
	   props.load(new FileInputStream(new File("./src/resources/configuration.properties")));
	  } catch (IOException e) {
	   e.printStackTrace();
	  }
	 }
	 
	 public String getProperty(String propertyName) {
	  return props.getProperty(propertyName);
	 }
	}


