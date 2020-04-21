

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutput implements Output {
    private FileOutputStream fileOutPut;
    private Listener listner;
    private String fileName = "default.dat";
    public File file;

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


    @Override
    public void addRecords(String line) {
            line = line + "\n";
            byte b[] = line.getBytes();
            try {
                this.fileOutPut = new FileOutputStream(this.file, true);
                this.fileOutPut.write(b);
                this.fileOutPut.close();
                this.listner.callback(this.file);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

    }

