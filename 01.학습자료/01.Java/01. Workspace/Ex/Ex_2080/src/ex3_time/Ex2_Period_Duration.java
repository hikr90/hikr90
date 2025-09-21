package ex3_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Ex2_Period_Duration {
	public static void main(String[] args) {
		// Period : ��¥ - ��¥
		// Duration : �ð� - �ð�
		
		// between
		LocalDate date1 = LocalDate.of(2024, 1, 1);
		LocalDate date2 = LocalDate.of(2025, 12, 31);
		
		Period pe = Period.between(date1, date2);
		System.out.println(pe);
		
		LocalTime time1 = LocalTime.of(00,  00);
		LocalTime time2 = LocalTime.of(23, 59);
		
		Duration du = Duration.between(time1, time2);
		System.out.println(du);
		System.out.println("-----------------------");
		
		// �ʵ� �� ���
		long year = pe.getYears();
		System.out.println(year);
		
		LocalTime t = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		System.out.println(t.getHour());
		System.out.println(t.getMinute());
		System.out.println(t.getSecond());
		System.out.println("-----------------------");
		
		// �ʵ� �� ����
		System.out.println(pe.withDays(1));
		System.out.println(du.withSeconds(60));
		
		// ��Ģ����
		System.out.println(pe.minusYears(1).multipliedBy(2));		// 1�� ���� �� 2�� ��
		System.out.println(du.plusHours(1).dividedBy(60));			// 1�ð� ���� �� 60���� ������
		System.out.println("-----------------------");
		
		// �ð�, ��¥ ��
		boolean isSame = Period.between(date1, date2).isZero();
		boolean isBefore = Duration.between(time1, time2).isNegative();
		
		System.out.println(isSame);
		System.out.println(isBefore);
		System.out.println("-----------------------");
		
		// �ʵ� ���� ����
		System.out.println(pe.toTotalMonths());	// ������� �������� ��ȯ�ؼ� ��ȯ (�� ���� ����)
		
		System.out.println(du.toDays());	// �� ���� ��ȯ
		System.out.println(du.toHours());	//�ð� ���� ��ȯ
		System.out.println(du.toMinutes());	// �� ���� ��ȯ
	}
}
