package ex8_work;

import java.util.Random;
import java.util.Scanner;

public class Ex2_Work extends Thread{
	//
	int su1, su2;
	int timmer = 0;
	int playCount = 0;
	boolean isCheck = true;
	Random rnd = new Random();
	//
	Scanner sc = new Scanner(System.in);
	
	public void startGame() {
		//
		while(isCheck) {
			//
			su1 = rnd.nextInt(100) + 1;
			su2 = rnd.nextInt(100) + 1;
			
			System.out.printf("%d + %d = ",su1,su2);
			//
			int result = sc.nextInt();
			//
			if(result==su1+su2) {
				System.out.println("정답!!");
				playCount++;
			} else {
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
