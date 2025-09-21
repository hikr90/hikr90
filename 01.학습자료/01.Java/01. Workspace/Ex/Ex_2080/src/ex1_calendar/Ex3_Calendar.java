package ex1_calendar;

import java.util.Calendar;

public class Ex3_Calendar {
	public static void main(String[] args) {
		/* add & roll
		 * 		- �� �޼ҵ�� Ķ������ ������ �ʵ� ���� ���ϴ� ��ŭ ���� Ȥ�� ���ҽ�Ų��.
		 * 	
		 * 	[����] add�� �ٸ� �ʵ忡 ������ �ְ�, roll�� �ٸ� �ʵ忡 ������ ���� �ʴ´�.
		 * 		- add �޼ҵ��� ���, DATE�� ���� 31��ŭ ������Ű��, ���� �޷� �Ѿ�Ƿ� MONTH�� 1 �����Ѵ�.
		 * 		- roll �޼ҵ��� ���, DATE�� ���� 31��ŭ �������ѵ�, MONTH�� ������ �ʴ´�.
		 */
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		// �� ���� ���� 2025.01.01�� ����
		c1.set(2025, 01, 01);
		c2.set(2025, 01, 01);
		
		c1.add(Calendar.DATE, 31);
		System.out.println("add �޼ҵ� : " + toString(c1));

		c2.roll(Calendar.DATE, 31);
		System.out.println("roll �޼ҵ� : " + toString(c2));
	}
	
	// toString �Լ� ������
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "�� " + (date.get(Calendar.MONTH) + 1) + "�� " + date.get(Calendar.DATE) + "��";
	}
}
