package no.uib.inf101.sem2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

// test to see if all files can be read
public class filetest {

    @Test
    public void test() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/Test.txt"));
            assertNotNull(lines);
            assertFalse(lines.isEmpty());
        } catch (IOException e) {
            fail("Failed to read file: " + e.getMessage());
        }
    }
    @Test
    public void easy() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/Easy.txt"));
            assertNotNull(lines);
            assertFalse(lines.isEmpty());
        } catch (IOException e) {
            fail("Failed to read file: " + e.getMessage());
        }
    }
    @Test
    public void medium() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/Medium.txt"));
            assertNotNull(lines);
            assertFalse(lines.isEmpty());
        } catch (IOException e) {
            fail("Failed to read file: " + e.getMessage());
        }
    }
    @Test
    public void hard() {
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/Hard.txt"));
            assertNotNull(lines);
            assertFalse(lines.isEmpty());
        } catch (IOException e) {
            fail("Failed to read file: " + e.getMessage());
        }
    }
}
