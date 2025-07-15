
public class JAVAREF {
	 private int x, y;
     public JAVAREF(int x, int y) {
             x = x;
     }
      
     public String toString() {
             return "[" + x + ", " + y + "]";
     }
     
     static void rev (Integer x, Integer y) {
         Integer t = x;
         x = y;
         y = t;
     }
     
     // Getter methods for testing
     public int getX() {
         return x;
     }
     
     public int getY() {
         return y;
     }
     
	public static void main(String[] args) {
		
		// TODO Auto-generated method stub
		JAVAREF point = new JAVAREF(10, 20);
         System.out.println(point);
         
         
         Integer a = 1;
         Integer b = 2;
         rev(a, b);
         System.out.println("a=" + a + " b=" + b);
	}
	
	
}
