package ex1_quiz;

import java.util.Random;
import java.util.Scanner;

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

public class Quiz extends Thread{

	int su1, su2;
	int timmer = 0;
	int playCount = 0;
	boolean isCheck = true;
	Random rnd = new Random();
	
	
	Scanner sc = new Scanner(System.in);
	
	
	public void startGame() {
		while(isCheck) {
			// 문제 출제 및 정답 확인
			// 5문제가 정답처리되면 break를 통해서 while문 빠져나가기
			su1 = rnd.nextInt(100) + 1;
			su2 = rnd.nextInt(100) + 1;
			
			System.out.printf("%d + %d = ",su1,su2);
			
			int result = sc.nextInt();
			
			
			if(result==su1+su2) {
				System.out.println("정답!!");
				playCount++;
			}else {
				System.out.println("오답");
			}
			
			// 게임 종료 판단
			if(playCount==5) {				
				System.out.println("결과 : "+timmer+"초");
				isCheck = false;
			}
		}

	}
	
	
	
	
	@Override
	// run에서는 시간만 계산
	public void run() {
		
		while(isCheck) {
			try {
				Thread.sleep(1000);
				timmer++;
			} catch (Exception e) {
			}
		}
		
	}

		
	
	
}
