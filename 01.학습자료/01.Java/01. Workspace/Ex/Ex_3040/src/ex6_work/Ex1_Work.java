package ex6_work;

import java.util.Scanner;

public class Ex1_Work {
	public static void main(String[] args) {
			
		// 문제
		// - 키보드에서 정수 값을 입력받고 Test 클래스로 전달하여
		// - run 메소드에서 입력받은 값을 1씩 감소시키다가 0이 되었을 때 스레드를 나오도록 처리해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("입력 : ");
		int num = sc.nextInt();
		//
		Ex2_Work t = new Ex2_Work(num);
		Thread th = new Thread(t);
		th.start();
	}
}
