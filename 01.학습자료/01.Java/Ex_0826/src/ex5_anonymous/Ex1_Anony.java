package ex5_anonymous;
// 익명클래스

import java.util.Random;
import java.util.Scanner;

public class Ex1_Anony {
	
	public static void main(String[] args) {
		
	
	// 재활용 가능 (sc를 담아서 다른 곳에 저장하고 다시 담는 것 가능)
	// 단점, 한번 사용하고 사용하지 않아도 메모리가 계속 사용됨
	Scanner sc = new Scanner(System.in);
	int num = sc.nextInt();
	
	// 스캐너의 익명클래스
	// int a = new Scanner(system.in).nextInt();
	
	
	// 재활용 불가능 
	// int rnd = new Random().nextInt(10)+1;
	// rnd = new Random().nextInt(10)+1;
	
	// 이름이 있는 객체와 이름이 없는 객체 
	// 스캐너는 sc라는 이름을 생성하여 거기에 저장이 가능하나
	// 랜덤은 이름이 없어서 필요할 때마다 계속해서 new에 만들어야한다. 

	// 클래스에 이름 생성
	Random random = new Random(); 
	int rnd = random.nextInt(10)+1; 
	
	// 익명클래스의 특징
	// 한번만쓰고 버려지는 값은 이름이 없는 익명클래스가 좋고
	// (프로그램의 x 종료 버튼)
	// 지속적으로 사용되는 편이라면 이름이 있는 클래스로 하는 것이 좋다.



	}
}
