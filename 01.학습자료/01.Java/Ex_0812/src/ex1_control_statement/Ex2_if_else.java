package ex1_control_statement;

import java.util.Scanner;

public class Ex2_if_else {
	public static void main(String[] args) {
		
		/*
		 if-else 문 : 하나의 조건을 가지고 두가지의 결과를 얻을 수 있다.
		 
		 if(조건식){
		 조건식이 참인 경우 실행되는 영역
		 }else{
		 조건식이 거짓인 경우 실행되는 영역
		 }
		 */

	int n = 45;
	String str = "";
	
	if(++n >= 50) {
		str = "50이상의 수";
	}else {
		str = "50미만의 수";
	}
	
	System.out.println(str);
	
	System.out.println("------------------");
	
	// 문제 :: 변수 age에 나이를 대입하고, 30세 이상이면 "드실만큼 드셨군요."를, 그렇지 않으면 "조금 기다리셔야겠네요."를 출력하는 if문을 작성
	int age = 0;
	String word = "";
	
	if(age>=30) {
		word = "드실만큼 드셨군요.";
	}else {
		word = "조금 기다리셔야겠네요.";
	}
	System.out.println(word);
	
	System.out.println("------------------");

	// 문제 :: 바로 위의 나이 코드를 삼항 연산자로 바꾸시오.
	// 문자열(String) "" / 문자(char) ''
	String res = age >= 30 ? "드실만큼 드셨군요." : "조금 기다리셔야겠네요.";
	System.out.println(res);
	
	
	// Scanner를 통해서 나이를 직접 받는 방식
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
