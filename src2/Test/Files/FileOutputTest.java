package Test.Files;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

import static org.junit.jupiter.api.Assertions.*;

class ListnerMock implements Listener {
    public File callbackFile;

    @Override
    public void callback(File file) {
        callbackFile = file;
    }
}

class FileOutputTest {

    @org.junit.jupiter.api.Test
    public void fileIsCreated() {
        // Given
        File file = new File("default.dat");
        file.delete();
        assertFalse(file.exists());
        // When
        ListnerMock listenerMock = new ListnerMock();
        new FileOutput(listenerMock);
        // Then
        assertTrue(file.exists());
        file.delete();
        assertFalse(file.exists());
    }

    @org.junit.jupiter.api.Test
    public void fileIsCreatedWithCustomName() {
        // Given
        File file = new File("Test.txt");
        file.delete();
        assertFalse(file.exists());
        ListnerMock listenerMock = new ListnerMock();
        // When
       FileOutput cut = new FileOutput(listenerMock, "Test.txt");
        // Then
        assertTrue(file.exists());
        file.delete();
        assertFalse(file.exists());
    }

    @org.junit.jupiter.api.Test
    public void addRecords() {
        // Given
        ListnerMock listenerMock = new ListnerMock();
        File file = new File("default.dat");
        file.delete();
        // When
        FileOutput cut = new FileOutput(listenerMock);
        cut.addRecords("FirstLine");
        cut.addRecords("SecondLine");
        // Then
        assertTrue(listenerMock.callbackFile.exists());
        try {
            FileInputStream fileInput = new FileInputStream(listenerMock.callbackFile);
            BufferedReader br = new BufferedReader(new InputStreamReader(fileInput));
            assertEquals("FirstLine", br.readLine());
            assertEquals("SecondLine", br.readLine());
            fileInput.close();
        } catch (Exception ex) {
            assertTrue(false);
        }
        listenerMock.callbackFile.delete();
    }
}