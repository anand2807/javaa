
public class JAVAOVERLSC extends JAVAOVERL{
	  int x = 100 ;
	  int y = 200;
	  public String x(){
		  return new String("method sub class x");
	  }
	  public String y(){
		  return new String("method sub class y");
	  }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JAVAOVERL b=new JAVAOVERLSC();

		System.out.println(b.x);
		System.out.println(b.y);
		System.out.println(b.x());
		System.out.println(b.x());
		
    
	}

}
