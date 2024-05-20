package ex1_string;

import java.util.Scanner;

public class Ex3_StringWork {

	public static void main(String[] args) {
		
		// 문제
		// - 키보드에서 문장을 입력받고 문장에서 소문자 a가 몇개 있는지 표시해주세요.
		// - 입력 : sdfkleisdalsldkaa
		// - 결과 : a의 개수 : 2
		Scanner sc = new Scanner(System.in);
		int cnt = 0; 
		
		System.out.print("입력 : ");
		String str = sc.next();
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)=='a') {
				cnt++;
			}
		}
		System.out.println("a의 갯수 : "+cnt);
	}
}
