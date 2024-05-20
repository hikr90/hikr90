package ex1_control_statement;

import java.util.Scanner;

public class Ex2_if_else {
	public static void main(String[] args) {
		
		
		// if else 문
		// - 하나의 조건으로 조건이 참인 경우와 그 외에 해당하는 경우 두가지의 결과를 얻을 수 있는 문장
		int n = 45;
		String str = "";
	
		if(++n >= 50) {
			str = "50이상의 수";
		} else {
			str = "50미만의 수";
		}
	
		System.out.println(str);
		
		System.out.println("------------------");
		
		// 문제 1
		// - 변수 age에 나이를 대입하여 30 이상인 경우, "드실만큼 드셨군요"
		// - 그렇지 않은 경우 "조금 기다리셔야겠네요." 를 출력하는 if else 문 작성
		int age = 0;
		String word = "";
		
		if(age>=30) {
			word = "드실만큼 드셨군요.";
		}else {
			word = "조금 기다리셔야겠네요.";
		}
		System.out.println(word);
		
		System.out.println("------------------");

		// 문제2
		// - 위의 if else문을 삼항연산자로 변경
		String res = age >= 30 ? "드실만큼 드셨군요." : "조금 기다리셔야겠네요.";
		System.out.println(res);
		
		// 문제3
		// - 위의 문제를 스캐너 방식으로 값을 직접 받는다.
		Scanner sc = new Scanner(System.in);
		int age_s = 0;
		System.out.println("나이를 입력하세요. : ");
		
		age_s = sc.nextInt();
		
		if(age_s==30){
			System.out.println("드실만큼 드셨군요.");
		}else {
			System.out.println("조금 더 기다리셔야겠네요.");
		}
	}
}
