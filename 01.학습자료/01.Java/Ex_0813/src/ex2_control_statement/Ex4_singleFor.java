package ex2_control_statement;

import java.util.Scanner;

public class Ex4_singleFor {

	public static void main(String[] args) {

		// 문제 키보드에서 n1과 n2의 정수값을 입력받는다.
		// n1 ~ n2까지의 합을 계산하여 결과를 출력
		// 2와 5를 입력받았다면 14를 출력
		// 단, n1과 n2의 값이 반대로 입력되어도 결과는 똑같이 나오도록 처리

		// 수1 : 2
		// 수2 : 5
		// 결과 : 14

		// for문 2개로 작성
		// Scanner sc = new Scanner(System.in);
		// System.out.println("수1 : ");
		// int num1 = sc.nextInt();
		//
		// System.out.println("수2 : ");
		// int num2 = sc.nextInt();
		//
		// int total = 0;
		//	
		// if(num1<num2) {
		// for(int i = num1;i<=num2;i++) {
		// total += i;
		// 	}
		// }else if(num1>num2) {
		// for(int j = num1;j>=num2;j--) {
		// total += j;
		// 	}
		// }
		// System.out.println("결과 : "+total);

		// 변수의 전환을 통한 작성
		Scanner sc = new Scanner(System.in);
		System.out.println("수1 : ");
		int num1 = sc.nextInt();

		System.out.println("수2 : ");
		int num2 = sc.nextInt();
		int num3 = 0;
		int total = 0;

		// 변수의 전환 (1을 3으로, 2를 1로, 3을 2로 이동
		if (num1 > num2) {
			num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		for (int i = num1; i <= num2; i++) {
			total += i;
		}
		System.out.println(total);

		/*선생님
	 Scanner sc = new Scanner(System.in);
	 System.out.print("수1 : ");
	 int su1 = sc.nextInt();

	 System.out.print("수2 : ");
	 int su2 = sc.nextInt();
	 int su3 = 0;

	 int total = 0;

	 if(su1>su2){
	 	su3 = su1
	 	su1 = su2
	 	su2 = su3
	 }


	 for(int i = su1; i<=su2;i++){
	 	total += i;
	 }
	 System.out.print("결과 : "+total);
		 */


	}

}
