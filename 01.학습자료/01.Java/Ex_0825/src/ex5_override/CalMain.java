package ex5_override;

public class CalMain {
	
	public static void main(String[] args) {
		
		CalPlus cp = new CalPlus();
		cp.getResult(10,20);
		
		System.out.println("---");
		
		CalMinus cm = new CalMinus();
		cm.getResult(50,10);
	}
}
