package ex8_work;
/* 1~100사이의 난수 두개를 더하는 문제를 출제
 * 키보드에서 출제된 문제의 정답을 입력받고
 * 총 다섯문제가 정답처리되면 프로그램을 종료하며
 * 몇초가 걸렸는지를 화면에 출력
 * 
 * 23 + 45 = 68(입력)
 * 정답!!
 * 35 + 100 = 1
 * 오답..
 * 53 + 28 = 81
 * 정답!!
 * 
 * 결과 : 25초
 * 
 * 프로그램 완전히 종료 
 * */

import java.util.Random;
import java.util.Scanner;

public class Test implements Runnable{

	int i = 0; 
	Test2 t2 = new Test2();
	
	
	@Override
	public void run() {
		
					t2.start();
					
					for(int i=0;i<5;) {
						 
						int num1 = new Random().nextInt(10)+1;
						int num2 = new Random().nextInt(10)+1;
						
						Scanner sc = new Scanner(System.in);
						System.out.print(num1+" + "+num2+" = ");
						int select = sc.nextInt();
						
						
						if(num1+num2==select) {
							System.out.println("정답!!");
							i++;
							
						}else {
							System.out.println("오답..");
							continue;
						}
					}
					
					System.out.println("결과 : "+t2.cnt);
		
		
		
			
			
		}
	}

	
		
		
	