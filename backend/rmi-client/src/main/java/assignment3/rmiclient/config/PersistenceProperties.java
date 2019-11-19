package assignment3.rmiclient.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@Configuration
public class PersistenceProperties {

    @Bean
    @Primary
    public Properties loadFileProperties() throws IOException {
        Properties properties = new Properties();
        String propFileName= "persistence.properties";

        InputStream inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

        if (inputStream == null) {
            throw new FileNotFoundException(propFileName + "not found in classpath");
        }

        properties.load(inputStream);

        return properties;
    }
}
