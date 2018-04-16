package W6_Web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class W6 {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://www.google.com.ua");
        HttpURLConnection con =(HttpURLConnection) url.openConnection();
        con.setRequestMethod("GET");

        InputStream inputStream = con.getInputStream();
        InputStreamReader reader = new InputStreamReader(inputStream);

        int b=0;
        while ((b=reader.read())!=-1){
            System.out.print((char)b);
        }
    }
}
