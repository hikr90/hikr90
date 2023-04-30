package ex8_work;

import java.util.Random;
import java.util.Scanner;

/* 1~100사이의 난수 두개를 더하는 문제를 출제
 * 키보드에서 출제된 문제의 정답을 입력받고
 * 총 다섯문제가 정답처리되면 프로그램을 종료하며
 * 몇초가 걸렸는지를 화면에 출력
 * 
 * 23 + 45 = 68(입력)
 * 정답!!
 * 35 + 100 = 1
 * 오답..
 * 53 + 28 = 81
 * 정답!!
 * 
 * 결과 : 25초
 * 
 * 프로그램 완전히 종료 
 * */
public class TestMain {
	public static void main(String[] args) {
		
		Test t = new Test();
		Thread th = new Thread(t);
		th.start();
		
	}
}
