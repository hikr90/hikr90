package ex1_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {
		
		// 문제
		// - 배열의 길이 값을 넣어주면 순차적으로 알파벳을 보여주세요.
		// - 배열의 길이 : 5
		// - ABCDE
		 Scanner sc = new Scanner(System.in);
		 System.out.print("배열의 길이 : ");
		 int n = sc.nextInt();
		 char c = 'A';
		 //
		 char[] ch = new char[n];
		 //
		 for(int i=0;i<n;i++) {
			 System.out.print(ch[i]=(char)(c+i));
		 }
	}
}
