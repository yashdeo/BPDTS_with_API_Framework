package com.BPDTS.test.framework.hooks.Screenshot;


import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class SetAPI {

    private static Properties properties;
    private static String BaseURL;

    public static String getBaseURL(){
        return BaseURL;
    }

    //This method will run before running the suite and will prepare the framework by initializing the values for the API tests

    @Before
    public static void setAPI() {
        Properties prop = loadPropertiesFile("environment.properties");
        String profile = prop.getProperty("profile.path");

        if(profile.contains("api")){
            properties= loadPropertiesFile("profile/api/config.properties");
        }

         BaseURL = properties.getProperty("BaseURL");
    }


    //read the strings from the property files
        private static Properties loadPropertiesFile(String filePath) {
        Properties prop = new Properties();
        try (InputStream resourceAsStream = SetAPI.class.getClassLoader().getResourceAsStream(filePath)) {
            prop.load(resourceAsStream);
        } catch (IOException e) {
            System.err.println("Unable to load properties file : " + filePath);
        }

        return prop;

    }

    //This hook for capturing the results/screenshots

    @After
    public static void writeExtentReport() {
        Reporter.loadXMLConfig("src/extent-config.xml");
    }

}
