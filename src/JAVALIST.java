import java.util.*;
import java.util.concurrent.*;
public class JAVALIST {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List list = Arrays.asList(10, 5, 10, 20);   // LINE A
        System.out.println(list);
        System.out.println(new HashSet(list));
        System.out.println(new TreeSet(list));
        System.out.println(new ConcurrentSkipListSet(list));
	}

}
