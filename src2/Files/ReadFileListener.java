import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

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
            fileInput.close();
            br.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}