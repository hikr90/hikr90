package ex1_string;

import java.util.Scanner;

public class Ex4_StringWork {

	public static void main(String[] args) {
		
		/* 주민번호 판단 로직 구현하기 
		 주민번호를 입력하세요. (-포함) : 
		 991203-1022334
		 
		 결과 : 당신은 99년 12월 03일에 태어난 남자입니다.
		 
		 */
		
		Scanner sc = new Scanner(System.in);
		System.out.print("주민번호를 입력하세요. (-포함)\n");
		System.out.print(">>");
		String id = sc.next();
		
		String year = id.substring(0,2);
		String month = id.substring(2, 4);
		String day = id.substring(4, 6);
		
		String gender = id.substring(7,8);
	
		int i_gender = Integer.parseInt(gender);
		String s_gender = "여자";
		
		if(i_gender==1||i_gender==3) {
			s_gender = "남자";
		}
		
		System.out.printf("당신은 %s년 %s월 %s일에 태어난 %s입니다.",year,month,day,s_gender);
	}
}
