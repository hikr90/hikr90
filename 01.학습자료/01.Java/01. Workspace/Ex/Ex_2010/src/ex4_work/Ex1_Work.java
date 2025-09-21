package ex4_work;

import java.util.Scanner;

public class Ex1_Work {
	public static void main(String[] args) {
		
		// 정답 여부 알려주는 메서드 호출
		Ex2_Work game = new Ex2_Work();
		Scanner sc = new Scanner(System.in);
		
		// 키보드에서 정답이라고 생각되는 값을 main에서 받아서 
		// game클래스에서 10이 정답인지 아닌지 체크
		// 정답이면 main에서 알려주고 무한 반복하는 while문을 나오도록 한다.
		
		boolean bool = true;
		
		while(bool) {
			
			System.out.print("정답은??");
			int select = sc.nextInt();
			
			if(game.number(select)==bool) {
				break;
			}
			
		}
		
		
		
		
		
	}
}
