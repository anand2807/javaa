import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JAVALTest {
    
    @Test
    public void testStringInternComparison() {
        // Test string literal vs interned string comparison
        String s1 = "hi";
        String s2 = new String("hi").intern();
        
        // s1 and s2 should reference the same object in the string pool
        assertTrue("String literal and interned string should be the same object", s1 == s2);
    }
    
    @Test
    public void testStringObjectComparison() {
        // Test string literal vs string object comparison
        String s1 = "hi";
        String s3 = new String("hi");
        
        // s1 and s3 should be different objects but equal in value
        assertFalse("String literal and string object should be different objects", s1 == s3);
        assertTrue("String literal and string object should have equal values", s1.equals(s3));
    }
    
    @Test
    public void testStringLiteralComparison() {
        // Test string literal vs string literal comparison
        String s1 = "hi";
        String s5 = "hi";
        
        // s1 and s5 should reference the same object in the string pool
        assertTrue("String literals should be the same object", s1 == s5);
    }
    
    @Test
    public void testStringObjectsComparison() {
        // Test string object vs string object comparison
        String s3 = new String("hi");
        String s4 = new String("hi");
        
        // s3 and s4 should be different objects but equal in value
        assertFalse("Different string objects should be different objects", s3 == s4);
        assertTrue("Different string objects should have equal values", s3.equals(s4));
    }
    
    @Test
    public void testMainMethodOutput() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Call the main method
            JAVAL.main(new String[]{});
            
            // Get the output
            String output = outContent.toString().trim();
            String[] lines = output.split("\\r?\\n");
            
            // Verify the output
            assertEquals("true", lines[0]);  // s1 == s2
            assertEquals("false", lines[1]); // s1 == s3
            assertEquals("true", lines[2]);  // s1 == s5
            assertEquals("false", lines[3]); // s3 == s4
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}