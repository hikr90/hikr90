package ex2_control_statement;

import java.util.Scanner;

public class Ex4_singleFor {

	public static void main(String[] args) {
		
		// 문제
		// - 키보드에서 n1과 n2의 정수를 받습니다.
		// - n1 ~ n2 까지의 합을 계산하여 결과를 보여줍니다.
		// - 예로, 2와 5를 입력받았다면 결과로 14를 반환합니다.
		// - 단, n1과 n2의 값이 반대로 입력되어도 결과는 똑같이 나와야합니다.
		
		// - 수1 : 2
		// - 수2 : 5
		// - 결과 : 14

		// 변수의 전환을 통한 작성
		Scanner sc = new Scanner(System.in);
		System.out.println("수1 : ");
		int num1 = sc.nextInt();

		System.out.println("수2 : ");
		int num2 = sc.nextInt();
		int num3 = 0;
		int total = 0;

		// 변수의 전환 (1을 3으로, 2를 1로, 3을 2로 이동)
		if (num1 > num2) {
			num3 = num1;
			num1 = num2;
			num2 = num3;
		}
		
		for (int i = num1; i <= num2; i++) {
			total += i;
		}
		
		System.out.println(total);
	}
}
