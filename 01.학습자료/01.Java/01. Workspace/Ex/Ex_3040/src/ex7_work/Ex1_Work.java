package ex7_work;

import java.util.Random;
import java.util.Scanner;

public class Ex1_Work implements Runnable{
	// ����
	// - 1 ~ 100 ������ ������ �ι� ���ؼ� ���ϴ� ������ ����
	// - Ű���忡�� ������ ������ �Է��Ͽ�
	// - �� �ټ������� ����ó���Ǹ� ���α׷��� �����ϰ� �� �ʰ� �ɷȴ����� ȭ�鿡 �����ּ���.
	
	// - �Է� : 23 + 45 = 68
	// - ����!!
	// - �Է� : 35 + 100 = 1
	// - ����...
	// - 53 + 28 = 81
	// - ����!!
	// .....
	// ��� : 25��
	// ���α׷� ������ ����
	int i = 0; 
	Ex2_Work t2 = new Ex2_Work();
	
	
	@Override
	public void run() {
		//
		t2.start();
		//
		for(int i=0;i<5;) {
			// 
			int num1 = new Random().nextInt(10)+1;
			int num2 = new Random().nextInt(10)+1;
			//
			Scanner sc = new Scanner(System.in);
			System.out.print(num1+" + "+num2+" = ");
			int select = sc.nextInt();
			//
			if(num1+num2==select) {
				System.out.println("����!!");
				i++;
				
			} else {
				//
				System.out.println("����..");
				continue;
			}
		}
		//
		System.out.println("��� : "+t2.cnt);
	}
}
