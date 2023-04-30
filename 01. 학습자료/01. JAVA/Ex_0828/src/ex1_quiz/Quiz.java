package ex1_quiz;

import java.util.Random;
import java.util.Scanner;

/* 1~100������ ���� �ΰ��� ���ϴ� ������ ����
 * Ű���忡�� ������ ������ ������ �Է¹ް�
 * �� �ټ������� ����ó���Ǹ� ���α׷��� �����ϸ�
 * ���ʰ� �ɷȴ����� ȭ�鿡 ���
 * 
 * 23 + 45 = 68(�Է�)
 * ����!!
 * 35 + 100 = 1
 * ����..
 * 53 + 28 = 81
 * ����!!
 * 
 * ��� : 25��
 * 
 * ���α׷� ������ ���� 
 * */

public class Quiz extends Thread{

	int su1, su2;
	int timmer = 0;
	int playCount = 0;
	boolean isCheck = true;
	Random rnd = new Random();
	
	
	Scanner sc = new Scanner(System.in);
	
	
	public void startGame() {
		while(isCheck) {
			// ���� ���� �� ���� Ȯ��
			// 5������ ����ó���Ǹ� break�� ���ؼ� while�� ����������
			su1 = rnd.nextInt(100) + 1;
			su2 = rnd.nextInt(100) + 1;
			
			System.out.printf("%d + %d = ",su1,su2);
			
			int result = sc.nextInt();
			
			
			if(result==su1+su2) {
				System.out.println("����!!");
				playCount++;
			}else {
				System.out.println("����");
			}
			
			// ���� ���� �Ǵ�
			if(playCount==5) {				
				System.out.println("��� : "+timmer+"��");
				isCheck = false;
			}
		}

	}
	
	
	
	
	@Override
	// run������ �ð��� ���
	public void run() {
		
		while(isCheck) {
			try {
				Thread.sleep(1000);
				timmer++;
			} catch (Exception e) {
			}
		}
		
	}

		
	
	
}
