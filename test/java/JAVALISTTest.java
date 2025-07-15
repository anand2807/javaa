import org.junit.Test;
import static org.junit.Assert.*;
import java.util.*;
import java.util.concurrent.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class JAVALISTTest {
    
    @Test
    public void testListCreation() {
        // Test that Arrays.asList creates a list with the expected elements
        List<Integer> list = Arrays.asList(10, 5, 10, 20);
        
        assertEquals("List should have 4 elements", 4, list.size());
        assertEquals("First element should be 10", Integer.valueOf(10), list.get(0));
        assertEquals("Second element should be 5", Integer.valueOf(5), list.get(1));
        assertEquals("Third element should be 10", Integer.valueOf(10), list.get(2));
        assertEquals("Fourth element should be 20", Integer.valueOf(20), list.get(3));
    }
    
    @Test
    public void testHashSetCreation() {
        // Test that HashSet removes duplicates
        List<Integer> list = Arrays.asList(10, 5, 10, 20);
        Set<Integer> hashSet = new HashSet<>(list);
        
        assertEquals("HashSet should have 3 elements (duplicates removed)", 3, hashSet.size());
        assertTrue("HashSet should contain 10", hashSet.contains(10));
        assertTrue("HashSet should contain 5", hashSet.contains(5));
        assertTrue("HashSet should contain 20", hashSet.contains(20));
    }
    
    @Test
    public void testTreeSetCreation() {
        // Test that TreeSet sorts elements
        List<Integer> list = Arrays.asList(10, 5, 10, 20);
        Set<Integer> treeSet = new TreeSet<>(list);
        
        // Convert to array for easier assertion of order
        Integer[] sortedArray = treeSet.toArray(new Integer[0]);
        
        assertEquals("TreeSet should have 3 elements (duplicates removed)", 3, treeSet.size());
        assertEquals("First element should be 5 (sorted)", Integer.valueOf(5), sortedArray[0]);
        assertEquals("Second element should be 10 (sorted)", Integer.valueOf(10), sortedArray[1]);
        assertEquals("Third element should be 20 (sorted)", Integer.valueOf(20), sortedArray[2]);
    }
    
    @Test
    public void testConcurrentSkipListSetCreation() {
        // Test that ConcurrentSkipListSet sorts elements and removes duplicates
        List<Integer> list = Arrays.asList(10, 5, 10, 20);
        Set<Integer> concurrentSet = new ConcurrentSkipListSet<>(list);
        
        // Convert to array for easier assertion of order
        Integer[] sortedArray = concurrentSet.toArray(new Integer[0]);
        
        assertEquals("ConcurrentSkipListSet should have 3 elements (duplicates removed)", 3, concurrentSet.size());
        assertEquals("First element should be 5 (sorted)", Integer.valueOf(5), sortedArray[0]);
        assertEquals("Second element should be 10 (sorted)", Integer.valueOf(10), sortedArray[1]);
        assertEquals("Third element should be 20 (sorted)", Integer.valueOf(20), sortedArray[2]);
    }
    
    @Test
    public void testMainMethodOutput() {
        // Redirect System.out to capture output
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outContent));
        
        try {
            // Call the main method
            JAVALIST.main(new String[]{});
            
            // Get the output
            String output = outContent.toString().trim();
            String[] lines = output.split("\\r?\\n");
            
            // Verify the output
            String listOutput = lines[0];
            assertTrue("List output should contain 10", listOutput.contains("10"));
            assertTrue("List output should contain 5", listOutput.contains("5"));
            assertTrue("List output should contain 20", listOutput.contains("20"));
            
            // For HashSet, we can't guarantee order, so we check that it contains all expected elements
            // and doesn't contain duplicates
            String hashSetOutput = lines[1];
            assertTrue("HashSet output should contain 5", hashSetOutput.contains("5"));
            assertTrue("HashSet output should contain 10", hashSetOutput.contains("10"));
            assertTrue("HashSet output should contain 20", hashSetOutput.contains("20"));
            assertFalse("HashSet output should not contain duplicates", 
                        hashSetOutput.indexOf("10") != hashSetOutput.lastIndexOf("10"));
            
            // Get the actual output for TreeSet and ConcurrentSkipListSet
            String treeSetOutput = lines[2];
            String concurrentSetOutput = lines[3];
            
            // Check that TreeSet and ConcurrentSkipListSet contain all expected elements
            assertTrue("TreeSet output should contain 5", treeSetOutput.contains("5"));
            assertTrue("TreeSet output should contain 10", treeSetOutput.contains("10"));
            assertTrue("TreeSet output should contain 20", treeSetOutput.contains("20"));
            
            assertTrue("ConcurrentSkipListSet output should contain 5", concurrentSetOutput.contains("5"));
            assertTrue("ConcurrentSkipListSet output should contain 10", concurrentSetOutput.contains("10"));
            assertTrue("ConcurrentSkipListSet output should contain 20", concurrentSetOutput.contains("20"));
        } finally {
            // Restore original System.out
            System.setOut(originalOut);
        }
    }
}