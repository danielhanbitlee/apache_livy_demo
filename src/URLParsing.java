import java.net.*;
//import java.net.MalformedURLException;
//import java.io.IOException;
import java.io.*;

public class URLParsing {
    public static void main(String[] args) throws IOException {

        String link = "http://localhost:8998";
        System.out.println(link);

        URL url = null;
        URI uri = null;
//
        url = new URL(link);
        System.out.println(url);
        try {
            uri = new URI(url.toString());
            System.out.println(uri);
        } catch(URISyntaxException e) {
            System.out.println("URL" + url + "is a malformed URL");
        }
//        URI uri = new URI("/home/daniel/Documents/GitHub/livy_example/spark_example.py")
//        try {
//            url = new URL(link);
//        } catch(MalformedURLException e) {
//            e.printStackTrace();
//        }
//
//        try{
//            uri = new URI(url.toString());
//        } catch(URISyntaxException e) {
//            try {
//                uri = new URI(url.getProtocol(), url.getUserInfo(), url.getHost(),
//                        url.getPort(), url.getPath(), url.getQuery(),
//                        url.getRef());
//            } catch(URISyntaxException e1) {
//                e1.printStackTrace();
//            }
//        }
//        try {
//            url = uri.toURL();
//        } catch(MalfomedURLException e) {
//            e.printStackTrace();
//        }
//
//        String encodedLink = url.toString();
//        System.out.println(encodedLink);
    }
}
