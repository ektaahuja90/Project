import java.io.IOException;
import java.util.Properties;

/**
 * Created by Eahuja on 5/8/2017.
 */
public class Main {
    public static void main(String[] args) throws IOException {

        File file = new File();
        Properties properties = new Properties();
        properties.load(file.getFile());
        properties.getProperty("url");

    }



}
