package ex2_stack_queue;

import java.util.Stack;

public class Ex2_Stack {
	// 스택의 활용
	// - 수식계산, 웹브라우저 뒤로/앞으로
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		// [예시] 브라우저의 뒤로/앞으로
		goURL("1.네이버");
		goURL("2.야후");
		goURL("3.네이버");
		goURL("4.다음");
		
		// 출력
		printStatus();
		
		// 뒤로
		goBack();
		System.out.println(" = 뒤로 버튼을 누른 뒤 =");
		printStatus();

		// 앞으로
		goForward();
		System.out.println(" = 앞으로 버튼을 누른 뒤 =");
		printStatus();

		// 새로운 사이트 이동
		goURL("codechobo.com");
		System.out.println(" = 새로운 주소 이동 후 = ");
		printStatus();
	}
	
	//  새로운 사이트 이동
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) forward.clear();
	}
	
	// 출력
	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("-------------------");
	}
	
	// 뒤로 이동
	public static void goBack() {
		if(!back.empty()) forward.push(back.pop());
	}
	
	// 앞으로 이동
	public static void goForward() {
		if(!forward.empty()) back.push(forward.pop());
	}
}
