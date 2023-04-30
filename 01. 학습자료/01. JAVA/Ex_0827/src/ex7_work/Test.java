package ex7_work;

public class Test implements Runnable{

	private int num;
	
	public Test(int num) {
		this.num = num;
	}
	
	
	@Override
	public void run() {
		
		// for¹® ¹Ýº¹
		for(int i=num;i>0;i--) {
			try {
				Thread.sleep(1000);
				System.out.println(i);
				
			} catch (Exception e) {
				}
		}
	}
	
	
	
}
