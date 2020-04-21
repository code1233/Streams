package Test.Files;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ReadFileListenerTest {
    private  PrintStream originalOut = System.out;
    private  PrintStream originalErr = System.err;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();



    @Test
    void callback() {
        // Given
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
        // When & Then
        FileOutput cut = new FileOutput(new ReadFileListener());
        cut.addRecords("Test");
        assertTrue(outContent.toString().contains("Test"));
        cut.addRecords("Test2");
        assertTrue(outContent.toString().contains("Test2"));

        System.setOut(originalOut);
        System.setErr(originalErr);
    }

}