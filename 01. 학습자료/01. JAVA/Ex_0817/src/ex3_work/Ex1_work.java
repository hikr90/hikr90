package ex3_work;

import java.util.Scanner;

public class Ex1_work {

	public static void main(String[] args) {
		
		/* 문제 키보드에서 정수를 입력받고 그 수가 소수(약수가 1과 자기자신만 존재하는 수)인지 판단하는 코드를 작성
		 정수 : 3
		 3은(는) 소수입니다.
		 
		 정수 : 4
		 4은(는) 소수가 아닙니다. */
		
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 : ");
		int n = sc.nextInt();
		int i = 0;
		
		
		for(i=2;i<=n;i++) {
			
			if(n%i==0) {
				break;
			}
			
		}
		
		if(i==n) {
			System.out.println(n+"은 소수이다.");
		}else {
			System.out.println(n+"은 소수가 아니다.");
		}
		
		
		
		
	}
}
