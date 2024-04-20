package ex1_work;

import java.util.Scanner;

public class Ex2_work {

	public static void main(String[] args) {
		
		/* 문제 
		결과 
		배열의 길이 : 5
		라고 입력하면 5개의 배열을 넣어서 순차적으로 알파벳을 넣어줘야한다. 
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이 : ");
		int num = sc.nextInt();
		char n = 'A';
		
		for(int i=0;i<num;i++) {
			int [] len = new int[num];
			len[i] = n++;
			System.out.print((char)len[i]);
		} */
		
		 /* 선생님  (아스키코드 없이 사용) */
		 Scanner sc = new Scanner(System.in);
		 System.out.print("배열의 길이 : ");
		 int n = sc.nextInt();
		 char c = 'A';
		 
		 char[] ch = new char[n];
		
		 for(int i=0;i<n;i++) {
			 System.out.print(ch[i]=(char)(c+i));
			
		 }
		
	}
}
