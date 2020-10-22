package ActionsRepository;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class GetProperty {

    public static String loadProperty(String propertyKey)
    {
        String property = null;

        try (
            InputStream input = new FileInputStream("./src/test/resources/test.properties")) {
            Properties prop = new Properties();
            prop.load(input);
            property = prop.getProperty(propertyKey);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return property;
    }
}
