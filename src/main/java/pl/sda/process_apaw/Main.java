package pl.sda.process_apaw;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) {

        Process process;

        String homeDir = System.getProperty("user.home");
        String homeOs = System.getProperty("os.arch");

        System.out.println(homeDir);
        System.out.println(homeOs);

        try {
            process = Runtime.getRuntime().exec("cmd /c dir " + homeDir);
//            process = Runtime.getRuntime().exec("explorer");
//            process = Runtime.getRuntime().exec("cmd /c notepad C:\\Users\\Andy Studio\\text.txt");
            System.out.println(process.getOutputStream());

            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

           // System.out.println(reader);
            String line;
            while((line = reader.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
