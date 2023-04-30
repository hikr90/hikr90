package ex4_work;

import java.util.Scanner;

public class GuguMain {

	public static void main(String[] args) {
		
		// 키보드에서 출력할 단을 입력받아, 해당 단을 showTable()을 거쳐 화면에 출력하시오.
		// 구구단은 2단에서 9단만 나오도록하고 만약 해당하는 단이 나오지 않으면 "정확한 숫자를 입력해주세요."라고 나오게해주세요.
		Scanner sc = new Scanner(System.in);
		System.out.println("단 : ");
		int dan = sc.nextInt();
		
		Gugudan gu = new Gugudan();
		
		gu.showTable(dan);
		
	}
}
