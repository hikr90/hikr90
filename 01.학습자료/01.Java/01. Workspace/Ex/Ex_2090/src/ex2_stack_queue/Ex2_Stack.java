package ex2_stack_queue;

import java.util.Stack;

public class Ex2_Stack {
	// ������ Ȱ��
	// - ���İ��, �������� �ڷ�/������
	public static Stack back = new Stack();
	public static Stack forward = new Stack();
	
	public static void main(String[] args) {
		// [����] �������� �ڷ�/������
		goURL("1.���̹�");
		goURL("2.����");
		goURL("3.���̹�");
		goURL("4.����");
		
		// ���
		printStatus();
		
		// �ڷ�
		goBack();
		System.out.println(" = �ڷ� ��ư�� ���� �� =");
		printStatus();

		// ������
		goForward();
		System.out.println(" = ������ ��ư�� ���� �� =");
		printStatus();

		// ���ο� ����Ʈ �̵�
		goURL("codechobo.com");
		System.out.println(" = ���ο� �ּ� �̵� �� = ");
		printStatus();
	}
	
	//  ���ο� ����Ʈ �̵�
	public static void goURL(String url) {
		back.push(url);
		if(!forward.empty()) forward.clear();
	}
	
	// ���
	public static void printStatus() {
		System.out.println("back : " + back);
		System.out.println("forward : " + forward);
		System.out.println("-------------------");
	}
	
	// �ڷ� �̵�
	public static void goBack() {
		if(!back.empty()) forward.push(back.pop());
	}
	
	// ������ �̵�
	public static void goForward() {
		if(!forward.empty()) back.push(forward.pop());
	}
}
