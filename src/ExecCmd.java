import java.io.*;


//code from https://www.linglom.com/programming/java/how-to-run-command-line-or-execute-external-application-from-java/
public class ExecCmd {

    public static void main(String args[]) {

        try {
            Runtime rt = Runtime.getRuntime();
            Process pr = rt.exec("/home/daniel/Documents/GitHub/incubator-livy/bin/livy-server stop");

            BufferedReader input = new BufferedReader(new InputStreamReader(pr.getInputStream()));

            String line=null;

            while((line=input.readLine()) != null) {
                System.out.println(line);
            }

            int exitVal = pr.waitFor();
            System.out.println("Exited with error code "+exitVal);

        } catch(Exception e) {
            System.out.println(e.toString());
            e.printStackTrace();
        }
    }
}