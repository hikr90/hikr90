package ex2_control_statement;

import java.util.Scanner;

public class Ex2_singFor {

	public static void main(String[] args) {

		// 문제 : 키보드에서 2 ~ 9중 한가지를 입력받고 입력받은 숫자의 해당되는 구구단을 출력하세요.
		// 단 2~9에서 숫자가 입력되지 않았을 경우 "2~9사이의 숫자만 입력해주세요."

		Scanner sc = new Scanner(System.in);
		System.out.print("단 : ");
		int i = sc.nextInt();

		if(i>=2&&i<=9) {

			for(int j=1;j<=9;j++) {
				System.out.printf("%d * %d = %d\n",i,j,i*j);
			}
		}else {
			System.out.println("2 ~ 9 사이의 숫자만 입력하세요.");
		}

	/* 선생님
	 Scanner sc = new Scanner(System.in);
	 System.out.print("단 : ");
	 int dan = sc.nextInt();
	 
	 if(dan<=1||dan>=10){
	 	System.out.println("2 ~ 9사이의 숫자만 입력하세요.");
	 }else{
	 	for(int i=1;i<=9;i++){
	 		System.out.printf("%d * %d = %d\n",dan,i,dan*i);
	 	}
	 }
	 */
	
	
	}
}
