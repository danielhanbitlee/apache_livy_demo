import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//code modified from https://github.com/eugenp/tutorials/blob/master/core-java-modules/core-java/src/main/java/com/baeldung/urlconnection/PostJSONWithHttpURLConnection.java

public class PostToLivy {

    public static void main (String []args) throws IOException{

        URL url = new URL ("http://localhost:8998/batches");

        HttpURLConnection con = (HttpURLConnection)url.openConnection();
        con.setRequestMethod("POST");

        con.setRequestProperty("Content-Type", "application/json; utf-8");
        con.setRequestProperty("Accept", "application/json");

        con.setDoOutput(true);

        //construct JSON String
        String jsonInputString = "{\"file\": \"file:/home/daniel/Documents/GitHub/livy_example/spark_example.py\"," +
                "\"args\": [\"test_arg_1\"]," +
                "\"pyFiles\": [\"file:/home/daniel/Documents/GitHub/livy_example/spark_example_utils.zip\"]}";
        try(OutputStream os = con.getOutputStream()){
            byte[] input = jsonInputString.getBytes("utf-8");
            os.write(input, 0, input.length);
        }

        int code = con.getResponseCode();
        System.out.println(code);

        try(BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"))){
            StringBuilder response = new StringBuilder();
            String responseLine = null;
            while ((responseLine = br.readLine()) != null) {
                response.append(responseLine.trim());
            }
            System.out.println(response.toString());
        }
    }

}

///usr/local/java/lib/*:/home/daniel/Documents/GitHub/incubator-livy/api/src/main/java:/opt/spark/spark-2.4.3-bin-hadoop2.7/jars/*:.