package ActionsRepository;

import org.apache.commons.lang3.StringUtils;

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

    public static String getIp () {
        String property;
        String prefix = System.getenv("configIp");
        if(prefix==null){
          property = "setDefault";
        }
        else {
            property = System.getenv("configIp");
        }
        return property;
    }

    public static String getApiKey () {
        String property;
        String prefix = System.getenv("apiKey");
        if(prefix==null){
            property = "?access_key=setDefault";
        }
        else {
            String key = System.getenv("apiKey");
            property = StringUtils.join("?access_key=",key);
        }
        return property;
    }


}
