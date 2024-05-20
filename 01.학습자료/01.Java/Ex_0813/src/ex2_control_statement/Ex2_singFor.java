package ex2_control_statement;

import java.util.Scanner;

public class Ex2_singFor {

	public static void main(String[] args) {
		
		// 문제
		// - 키보드에서 2 ~ 9 사이의 숫자를 입력받고 입력받은 숫자의 구구단을 콘솔에 보여주세요.
		// - 단 숫자 값이 2 ~ 9 사이의 숫자가 아닌 경우 "2 ~ 9 사이의 숫자만 입력해주세요." 라는 문구를 보여주세요.
		 Scanner sc = new Scanner(System.in);
		 System.out.print("단 : ");
		 int dan = sc.nextInt();
		 
		 if(dan<=1 || dan>=10){
		 	System.out.println("2 ~ 9사이의 숫자만 입력하세요.");
		 }else{
		 	for(int i=1;i<=9;i++){
		 		System.out.printf("%d * %d = %d\n",dan,i,dan*i);
		 	}
		 }
	}
}
