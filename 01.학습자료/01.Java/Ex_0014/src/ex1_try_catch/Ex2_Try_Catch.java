package ex1_try_catch;

import java.util.Scanner;

public class Ex2_Try_Catch {

	public static void main(String[] args) {
		
		// 문제
		// - 키보드에서 정수 값을 입력받습니다.
		// - 정수 값이면 결과를, 
		// - 정수가 아닌 값을 입력한다면 "정수만 입력할 수 있습니다." 라는 오류를 출력해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("정수 : ");
		int num = 0;
		//
		try {
			//
			num = sc.nextInt();
			System.out.println("결과 : "+num);
		
		} catch (Exception e) {
			System.out.println("정수만 입력할 수 있습니다.");
		}
	}
}
