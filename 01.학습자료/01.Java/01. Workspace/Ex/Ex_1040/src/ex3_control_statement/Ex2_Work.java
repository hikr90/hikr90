package ex3_control_statement;

public class Ex2_Work {

	public static void main(String[] args) {
		
		// 문제1
		// - *
		// - * *
		// - * * *
		// - * * * *
		// - * * * * *
		// 콘솔에 보여주세요.
		for(int i=1;i<=5;i++) {
			for(int j=0;j<i;j++) {
				System.out.print("* ");
			}
			System.out.println();
		}

		System.out.println("---------------");

		// 문제2
		// - * 으로 산을 콘솔에 보여주세요.
		for(int i=0;i<5; i++) {
			for(int j=0; j<5+i;j++) {
				if(i+j>3) {
					System.out.print("* ");
				}else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}

		System.out.println("---------------");
		
		// 문제3
		// - 아래의 숫자 행열을 콘솔에 보여주세요.
		// - 1 2 3 4 5 6 7 8 9 10
		// - 2 3 4 5 6 7 8 9 10 11
		// - 3 4 5 6 7 8 9 10 11 12
		// - .....
		// - 10 1 2 3 4 5 6 7 8 9
		for(int i=1;i<=10;i++) {
			for(int j=0;j<10;j++) {
				//
				int num = i + j;
				
				// if문 밑에 한줄만 있다면 {}을 사용하지 않아도 인식한다.
				if(num>10) {
					num -= 10;
				}
				System.out.print(num+" ");
			}
			System.out.println();
		}
	}
}
