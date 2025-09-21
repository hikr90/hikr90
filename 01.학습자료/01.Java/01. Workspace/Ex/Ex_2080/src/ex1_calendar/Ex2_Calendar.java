package ex1_calendar;

import java.util.Calendar;

public class Ex2_Calendar {
	public static void main(String[] args) {
		// [����] �� �ð��� ����
		final int [] TIME_UNIT = {3600, 60, 1};
		final String [] TIME_UNIT_NAME = {"�ð� ", "�� ", "�� "};
		//
		Calendar time1 = Calendar.getInstance();
		Calendar time2 = Calendar.getInstance();
		
		// time1 (10�� 20�� 30��) 
		time1.set(Calendar.HOUR_OF_DAY, 10);
		time1.set(Calendar.MINUTE, 20);
		time1.set(Calendar.SECOND, 30);

		// time2 (20�� 30�� 10��) 
		time2.set(Calendar.HOUR_OF_DAY, 20);
		time2.set(Calendar.MINUTE, 30);
		time2.set(Calendar.SECOND, 10);
		
		System.out.println("time1 : " + time1.get(Calendar.HOUR_OF_DAY) + "�� " + time1.get(Calendar.MINUTE) + "�� " + time1.get(Calendar.SECOND) + "��");
		System.out.println("time2 : " + time2.get(Calendar.HOUR_OF_DAY) + "�� " + time2.get(Calendar.MINUTE) + "�� " + time2.get(Calendar.SECOND) + "��");
		
		// �� �ð��� ����
		long diff = Math.abs((time2.getTimeInMillis() - time1.getTimeInMillis()) / 1000);
		System.out.println("time1�� time2�� ���̴� " + diff + "�� �Դϴ�.");
		
		// �ú��ʷ� ��ȯ
		String tmp = "";
		for(int i=0;i<TIME_UNIT.length;i++) {
			tmp += diff /TIME_UNIT[i] + TIME_UNIT_NAME[i];
			diff %= TIME_UNIT[i];
		}
		System.out.println("�ú��ʷ� ���� : " + tmp);
	}
}
