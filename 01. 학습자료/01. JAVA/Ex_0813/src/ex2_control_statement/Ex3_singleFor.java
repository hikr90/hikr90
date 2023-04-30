package ex2_control_statement;

import java.util.Scanner;

public class Ex3_singleFor {

	public static void main(String[] args) {

		// 문제 키보드에서 정수n을 입력받습니다. 
		// 1부터 n까지의 합을 계산하여 결과를 출력한다.
		// 예로 5를 받았다면 1+2+3+4+5의 결과인 15가 출력되면 된다.
		// 정수 : 4
		// 결과 : 10

		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int num = sc.nextInt();
		int total = 0;


		for(int i=1;i<=num;i++) {
			total += i;
		}
		System.out.println("결과 : "+total);

	
	/* 선생님
	 Scanner sc = new Scanner(System.in);
	 System.out.print("정수 : ");
	 int n = sc.nextInt();
	 
	 // 1부터 입력값까지의 합을 저장할 변수
	 int total = 0;
	 
	 for(int i=1;i<=n;i++){
		total += i;
	 }
	 System.out.print("결과 : "+total);
	 */
	
	
	
	
	
	}
}
