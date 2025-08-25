package ex1_try_catch;

import java.util.Scanner;

public class Ex3_Try_Catch {
	
	// 문제
	// - 정수를 받아주고 결과를 보여주세요.
	// - 정수 : aa
	// - 결과 : aa은(는) 정수가 아닙니다.
	public static void main(String[] args) {
		//
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 : ");	
		String num = sc.next();
		//
		try {			
			//
			Integer.parseInt(num);
			System.out.println("결과 : "+num);
		
		} catch (Exception e) {
			System.out.println(num+"은(는) 정수가 아닙니다.");
		}
	}
}
