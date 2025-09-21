package ex3_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex1_Time {
	public static void main(String[] args) {
		/*	Time
		 * 		- �ð� ���� ��Ű��
		 * 		- Date, Calendar�� �ٸ��� ��ü �Һ��� Ư¡�� �ִ�. (String�� ����)
		 * 		- ��Ƽ ������ ȯ�濡�� ����
		 * 		- ��¥�� �ð��� ������ Ŭ������ �и��Ͽ� ��� (LocalDate, LocalTime, LocalDateTime, ZonedDateTime)
		 */
		
		// ���� �ð� ����
		LocalDate d1 = LocalDate.now();
		LocalTime t1 = LocalTime.now();
		
		System.out.println(d1);
		System.out.println(t1);
		System.out.println("------------------------");
		
		// �ð� ����
		LocalDate d2 = LocalDate.of(2025, 01, 01);
		LocalTime t2 = LocalTime.of(23, 59, 59);

		System.out.println(d2);
		System.out.println(t2);
		System.out.println("------------------------");
		
		// Ư�� �� ���
		// - Ķ������ �ٸ��� Ÿ�� ��Ű������ ���� 1~12�� ������ ������.
		System.out.println(d1.getMonthValue());
		System.out.println(t1.getMinute());
		System.out.println("------------------------");
		
		// ���ڿ� > �ð� ����
		LocalDate p = LocalDate.parse("2025-01-01");
		System.out.println(p);
		System.out.println("------------------------");
		
		// ��¥ ���� (�ð� ����)
		LocalDate p2 = p.withYear(2020);
		System.out.println(p2);
		System.out.println("------------------------");
		
		// �ʵ� �� �� ����, ����
		System.out.println(p2.plusDays(10));
		System.out.println(p2.minusMonths(6));
		System.out.println("------------------------");
		
		// ��¥, �ð� ��
		System.out.println(p.isAfter(p2));
		System.out.println(p.isBefore(p2));
		System.out.println(p.isEqual(p2));
		System.out.println("------------------------");
		
		// LocalDateTime > Date, Time ��ȯ
		LocalDateTime dt = LocalDateTime.now();
		LocalDate ld = dt.toLocalDate();
		LocalTime lt = dt.toLocalTime();
		
		System.out.println(dt);
		System.out.println(ld);
		System.out.println(lt);
	}
}
