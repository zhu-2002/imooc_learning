package reflect.i18n;

import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Properties;

public class Aplication {
    public static void say(){
        Properties properties = new Properties() ;
        String configPath = Aplication.class.getResource("/reflect/i18n/config.properties").getPath() ;
        try {
            configPath = URLDecoder.decode(configPath,"UTF-8") ;
            properties.load(new FileInputStream(configPath));
            String language = properties.getProperty("language");
            i18N n = (i18N) Class.forName(language).getConstructor().newInstance();
            System.out.println(n.say());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Aplication.say();
    }
}
