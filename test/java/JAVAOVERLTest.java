import org.junit.Test;
import static org.junit.Assert.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JAVAOVERLTest {
    
    @Test
    public void testBaseClassFields() {
        JAVAOVERL base = new JAVAOVERL();
        assertEquals("Base class x field should be 10", 10, base.x);
        assertEquals("Base class y field should be 20", 20, base.y);
    }
    
    @Test
    public void testBaseClassMethods() {
        JAVAOVERL base = new JAVAOVERL();
        assertEquals("Base class x method should return 'method base class x'", 
                    "method base class x", base.x());
        assertEquals("Base class y method should return 'method base class y'", 
                    "method base class y", base.y());
    }
    
    @Test
    public void testSubClassFields() {
        JAVAOVERLSC sub = new JAVAOVERLSC();
        assertEquals("Sub class x field should be 100", 100, sub.x);
        assertEquals("Sub class y field should be 200", 200, sub.y);
    }
    
    @Test
    public void testSubClassMethods() {
        JAVAOVERLSC sub = new JAVAOVERLSC();
        assertEquals("Sub class x method should return 'method sub class x'", 
                    "method sub class x", sub.x());
        assertEquals("Sub class y method should return 'method sub class y'", 
                    "method sub class y", sub.y());
    }
    
    @Test
    public void testPolymorphism() {
        // When a subclass object is referenced by a base class reference,
        // fields are resolved at compile time (base class fields are used),
        // but methods are resolved at runtime (subclass methods are used)
        JAVAOVERL baseRef = new JAVAOVERLSC();
        
        // Fields are resolved at compile time
        assertEquals("Field access uses compile-time type (base class)", 10, baseRef.x);
        assertEquals("Field access uses compile-time type (base class)", 20, baseRef.y);
        
        // Methods are resolved at runtime
        assertEquals("Method call uses runtime type (sub class)", 
                    "method sub class x", baseRef.x());
        assertEquals("Method call uses runtime type (sub class)", 
                    "method sub class y", baseRef.y());
    }
    
    @Test
    public void testMainMethodOutput() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Call the main method
            JAVAOVERLSC.main(new String[]{});
            
            // Get the output
            String output = outContent.toString().trim();
            String[] lines = output.split("\\r?\\n");
            
            // Verify the output
            assertEquals("10", lines[0]);  // b.x - field from base class
            assertEquals("20", lines[1]);  // b.y - field from base class
            assertEquals("method sub class x", lines[2]);  // b.x() - method from sub class
            assertEquals("method sub class x", lines[3]);  // b.x() - method from sub class
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}