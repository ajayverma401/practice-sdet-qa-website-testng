package com.ajay.automation.utils;

import java.io.InputStream;
import java.util.Map;

import org.yaml.snakeyaml.Yaml;

public class ConfigReaderUtils {
	
	private static Map<String, Object> config;
	
	static {
		
		try {
			InputStream inputStream = ConfigReaderUtils.class.getClassLoader().getResourceAsStream("TestData/config.yml"); 
			
			//Always keep configs in resources and load them using a classpath-relative path like "TestData/config.yml".
//			This ensures portability, avoids hardcoding, and works seamlessly across environments and CI/CD pipelines.
//			FileInputStream file = new FileInputStream("TestData/config.yml");
			
			Yaml yml = new Yaml();
			
			config = yml.load(inputStream);
				
			}
		
			catch(Exception e) {
			System.out.println("Config file not found at the given path due to: " + e.getMessage());	
		}	
	}
	public static String get(String key) {
		return config.get(key).toString();
	}
}
