/**
 * 
 */
package fr.eni.encheres.dal;

import java.util.Properties;

/**
 * @author jpicard22
 *
 */
public class Settings {
	private static Properties properties;
	
	static {
		try {
			properties = new Properties();
			properties.load(Settings.class.getResourceAsStream("settings.properties"));
			//properties.loadFromXML(Settings.class.getResourceAsStream("settings.xml"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String getProperty(String key){
		String parametre = properties.getProperty(key,null);
		return parametre;
	}

}
