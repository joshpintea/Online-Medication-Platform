package assignment3.rmiclient.config;


import org.springframework.context.annotation.Configuration;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class PersistenceProperties {

    private Properties properties;

    public PersistenceProperties() throws IOException {
        this.properties = new Properties();
        String propFileName= "persistence.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException(propFileName + "not found in classpath");
        }

        properties.load(inputStream);

        System.out.println(properties.getProperty("patient_id"));
    }

}
