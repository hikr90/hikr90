package ex6_runnable;

public class RunnableMain {
	public static void main(String[] args) {
		
		RunnableTest rt = new RunnableTest();
		
		Thread t = new Thread(rt); 
		t.start();
		
		
		
		
		
	}
}
