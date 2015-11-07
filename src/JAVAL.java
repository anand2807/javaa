
public class JAVAL {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "hi";
        String s2 = new String("hi").intern();
        String s3 = new String("hi");
        String s4 = new String("hi");
        String s5 = "hi";

        System.out.println (s1 == s2);
        System.out.println (s1 == s3);
        System.out.println (s1 == s5);
        System.out.println (s3 == s4);
	}
}
