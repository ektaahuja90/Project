import java.io.InputStream;

public class File {
    public InputStream getFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("test.properties");
        return inputStream;
    }
}    