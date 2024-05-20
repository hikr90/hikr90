package ex2_work;

import java.util.Scanner;

public class Ex1_work {

	public static void main(String[] args) {
		
		// 문제
		// - 몇 월생입니까? : 7
		// - 7월은 31일까지 있습니다. 
		Scanner sc = new Scanner(System.in);
		System.out.print("몇 월생 입니까? : ");
		int month = sc.nextInt();
		
		switch (month) {
		case 1:	case 3: case 5: 
		case 7: case 8: case 10:
		case 12:
			System.out.println(month+"월은 31일까지 있습니다.");
			break;

		case 4:	case 6: case 9:
		case 11:
			System.out.println(month+"월은 30일까지 있습니다.");
			break;

		case 2:			
			System.out.println(month+"월은 28일까지 있습니다.");
			break;

		default :
			System.out.println(month+"월은 존재하지 않습니다.");
			break;
		}
	}
}
