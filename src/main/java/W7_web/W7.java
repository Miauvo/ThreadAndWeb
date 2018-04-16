package W7_web;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.*;

public class W7 {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        Callable<String> httpRequest=() -> {
            URL url = new URL("https://www.google.com.ua");
            HttpURLConnection con =(HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            InputStream inputStream = con.getInputStream();
            InputStreamReader reader = new InputStreamReader(inputStream);

            String html ="";
            int b=0;
            while ((b=reader.read())!=-1){
                html+=(char)b;
            }
            return html;
        };

        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Future<String> future = executorService.submit(httpRequest);
        System.out.println(future.get());
    }
}
