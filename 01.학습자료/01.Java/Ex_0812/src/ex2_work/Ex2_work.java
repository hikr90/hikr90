package ex2_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {

		// 문제
		// - switch를 통한 계산기 작성
		// - 수1 : 15
		// - 수2 : 5
		// - 연산자 : +
		Scanner sc = new Scanner(System.in);
		System.out.println("수1 : ");
		int num1 = sc.nextInt();

		System.out.println("수2 : ");
		int num2 = sc.nextInt();

		System.out.println("연산자 : ");
		String s = sc.next();

		switch (s) {
		case "+":
			System.out.println(num1+num2);
			break;

		case "-":
			System.out.println(num1-num2);
			break;

		case "/" :
			System.out.println(num1/num2);
			break;

		case "*" :
			System.out.println(num1*num2);
			break;
		
		default:
			System.out.println("정확한 연산자를 입력해주세요.");
			break;
		}
	}
}
