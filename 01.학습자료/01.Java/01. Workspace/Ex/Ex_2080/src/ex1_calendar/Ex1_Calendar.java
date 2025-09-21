package ex1_calendar;

import java.util.Calendar;

public class Ex1_Calendar {
	public static void main(String[] args) {
		/*	Calendar & Date
		 * 		- ��¥�� �ð� ���� Ŭ����
		 * 		- ������ Date Ŭ������ ����Ͽ�, Calendar Ŭ������ �߰��Ǿ����� ��� ������ �߰ߵ� ������ ����� time ��Ű���� ���ϵǾ���.
		 * 
		 * 		[����] Ķ������ �߻� Ŭ������ ���� ��ü ������ �Ұ��ϴ�.
		 * 			- Calendar c = Calendar.getInstance();
		 * 	
		 * 		[����] Ķ������ ����Ʈ Ŭ������ ��ȯ
		 * 			(1) Ķ���� > ����Ʈ
		 * 				- Calendar c = Calendar.getInstance();
		 * 				- Date d1 = new Date(c.getTimeInMillis());
		 * 
		 * 			(2) ����Ʈ > Ķ����
		 * 				- Date d = new Date();
		 * 				- Calendar c = Calendar.getInstance();
		 * 				- csetTime(d);
		 */
		// ���� ��¥, �ð� ���� 
		Calendar c = Calendar.getInstance();
		//
		System.out.println("�� ���� ���� : "+c.get(Calendar.YEAR));
		System.out.println("�� (0~11) : "+c.get(Calendar.MONTH));
		System.out.println("�� �� : "+c.get(Calendar.DATE));
		//
		System.out.println("���� ���� (1~7) : "+c.get(Calendar.DAY_OF_WEEK));		// 1:�Ͽ���, 2:������, ... 7:�Ͽ���
		System.out.println("�� ���� �� ��° ���� : "+c.get(Calendar.DAY_OF_MONTH));
		//
		System.out.println("����_���� : "+c.get(Calendar.AM_PM));
		System.out.println("�ð�(0~11) : "+c.get(Calendar.HOUR));
		System.out.println("�ð�(0~23) : "+c.get(Calendar.HOUR_OF_DAY));
		System.out.println("��(0~59) : "+c.get(Calendar.MINUTE));
		System.out.println("��(0~59) : "+c.get(Calendar.SECOND));
		//
		System.out.println("1000���� 1�� (0~999) : "+c.get(Calendar.MILLISECOND));	// 1�ð� = 60 * 60��
		//
		System.out.println("�� ���� ������ �� : "+c.getActualMaximum(Calendar.DATE));
	}
}
