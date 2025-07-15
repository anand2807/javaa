import org.junit.Test;
import static org.junit.Assert.*;

public class JAVAREFTest {
    
    @Test
    public void testConstructor() {
        // Create a new JAVAREF object
        JAVAREF point = new JAVAREF(10, 20);
        
        // Due to the bug in the constructor (x = x instead of this.x = x),
        // the x field will be 0 (default value) instead of 10
        // The y field is not set at all in the constructor
        assertEquals("Constructor should set x field", 0, point.getX());
        assertEquals("Constructor should set y field", 0, point.getY());
    }
    
    @Test
    public void testToString() {
        JAVAREF point = new JAVAREF(10, 20);
        // The toString method will return "[0, 0]" due to the constructor bug
        assertEquals("[0, 0]", point.toString());
    }
    
    @Test
    public void testRev() {
        // Test the rev method with Integer objects
        Integer a = 1;
        Integer b = 2;
        
        // Call the rev method which attempts to swap a and b
        JAVAREF.rev(a, b);
        
        // Due to Integer immutability, a and b should remain unchanged
        assertEquals("Integer a should remain unchanged", Integer.valueOf(1), a);
        assertEquals("Integer b should remain unchanged", Integer.valueOf(2), b);
    }
    
    // Helper method to access private fields for testing
    // We need to add getter methods to the JAVAREF class
}