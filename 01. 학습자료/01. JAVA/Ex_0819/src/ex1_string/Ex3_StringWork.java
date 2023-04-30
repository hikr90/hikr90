package ex1_string;

import java.util.Scanner;

public class Ex3_StringWork {

	public static void main(String[] args) {
		
		
		/* 문제 
		 키보드에서 next를 통해서 문장을 입력받고 입력받은 문장에서 소문자 a가 몇개 있는지를 출력하자
		 
		 결과
		 입력 : sdfkleisdalsldkaa
		 
		 a의 갯수 : 2 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		String s = sc.next();
		int count = 0;
		
		for(int i=0;i<s.length();i++) {
			
			if(s.charAt(i)=='a') {
				count++;
			}
		}
		
		System.out.println("a의 갯수 : "+count); 
		
		/* 선생님 
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
		
		*/
		
		
		
	}
}
