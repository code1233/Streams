package Files;

import java.io.*;
import java.util.Scanner;


class ReadFileListener implements Listener {

    public void callback(File file) {
        System.out.println("Reading file..");
        FileInputStream fileInput;
        try {
            fileInput = new FileInputStream(file);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInput));
            String strLine = null, tmp;
            while ((tmp = br.readLine()) != null) {
                strLine = tmp;
            }
            String lastLine = strLine;
            System.out.println(lastLine);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}


