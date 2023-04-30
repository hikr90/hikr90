package ex7_work;

import java.util.Scanner;

public class TestMain {
	public static void main(String[] args) {
				
		/* 문제
		  	키보드에서 정수값을 입력받고 Test클래스로 전달하면 
		 
		 run메서드에서 입력받은 숫자를 1씩 감소시키다가 
		 0이 되었을 때, 스레드를 빠져나오도록 처리
		 */
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		int num = sc.nextInt();
				
		Test t = new Test(num);
		Thread th = new Thread(t);
		th.start();
		
		
		
		
		
		
		
		
	}
}
