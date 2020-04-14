package Files;

import java.io.*;
import java.lang.*;

public class FileOutput {
    private FileOutputStream fileOutPut;
    private Listener listner;
    private String fileName = "default.txt";
    private File file;

    FileOutput(Listener listner) {
        this.listner = listner;
        this.init();
    }

    FileOutput(Listener listner, String fileName) {
        this.listner = listner;
        this.fileName = fileName;
        this.init();

    }

    private void init() {
        this.createFile();
        try {
            this.fileOutPut = new FileOutputStream(this.file, true);
        } catch (Exception e) {
            System.out.println("Exception: " + e.getMessage());
        }
    }


    private void createFile() {
        this.file = new File(this.fileName);
        try {
            // create the file
            if (file.createNewFile()) {
                System.out.println("File is created!");
            } else {
                System.out.println(this.fileName + " File already exists!");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }


    public void addRecords(String line) {
        line = "\n" + line;
        byte b[] = line.getBytes();
        try {
            this.fileOutPut.write(b);
            this.listner.callback(this.file);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }


}
