package ex8_work;

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
public class TestMain {
	public static void main(String[] args) {
		
		Test t = new Test();
		Thread th = new Thread(t);
		th.start();
		
	}
}
