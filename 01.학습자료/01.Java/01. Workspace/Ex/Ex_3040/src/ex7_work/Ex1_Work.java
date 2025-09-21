package ex7_work;

import java.util.Random;
import java.util.Scanner;

public class Ex1_Work implements Runnable{
	// 문제
	// - 1 ~ 100 사이의 난수를 두번 구해서 더하는 문제를 생성
	// - 키보드에서 문제의 정답을 입력하여
	// - 총 다섯문제가 정답처리되면 프로그램을 종료하고 몇 초가 걸렸는지를 화면에 보여주세요.
	
	// - 입력 : 23 + 45 = 68
	// - 정답!!
	// - 입력 : 35 + 100 = 1
	// - 오답...
	// - 53 + 28 = 81
	// - 정답!!
	// .....
	// 결과 : 25초
	// 프로그램 완전히 종료
	int i = 0; 
	Ex2_Work t2 = new Ex2_Work();
	
	
	@Override
	public void run() {
		//
		t2.start();
		//
		for(int i=0;i<5;) {
			// 
			int num1 = new Random().nextInt(10)+1;
			int num2 = new Random().nextInt(10)+1;
			//
			Scanner sc = new Scanner(System.in);
			System.out.print(num1+" + "+num2+" = ");
			int select = sc.nextInt();
			//
			if(num1+num2==select) {
				System.out.println("정답!!");
				i++;
				
			} else {
				//
				System.out.println("오답..");
				continue;
			}
		}
		//
		System.out.println("결과 : "+t2.cnt);
	}
}
