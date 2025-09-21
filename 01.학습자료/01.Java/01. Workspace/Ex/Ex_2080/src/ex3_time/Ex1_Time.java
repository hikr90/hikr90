package ex3_time;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class Ex1_Time {
	public static void main(String[] args) {
		/*	Time
		 * 		- 시간 관련 패키지
		 * 		- Date, Calendar와 다르게 객체 불변의 특징이 있다. (String과 동일)
		 * 		- 멀티 쓰레드 환경에서 안전
		 * 		- 날짜와 시간을 별도의 클래스로 분리하여 사용 (LocalDate, LocalTime, LocalDateTime, ZonedDateTime)
		 */
		
		// 현재 시간 생성
		LocalDate d1 = LocalDate.now();
		LocalTime t1 = LocalTime.now();
		
		System.out.println(d1);
		System.out.println(t1);
		System.out.println("------------------------");
		
		// 시간 지정
		LocalDate d2 = LocalDate.of(2025, 01, 01);
		LocalTime t2 = LocalTime.of(23, 59, 59);

		System.out.println(d2);
		System.out.println(t2);
		System.out.println("------------------------");
		
		// 특정 값 출력
		// - 캘린더와 다르게 타임 패키지에서 월은 1~12의 범위를 가진다.
		System.out.println(d1.getMonthValue());
		System.out.println(t1.getMinute());
		System.out.println("------------------------");
		
		// 문자열 > 시간 변경
		LocalDate p = LocalDate.parse("2025-01-01");
		System.out.println(p);
		System.out.println("------------------------");
		
		// 날짜 변경 (시간 동일)
		LocalDate p2 = p.withYear(2020);
		System.out.println(p2);
		System.out.println("------------------------");
		
		// 필드 내 값 증가, 감소
		System.out.println(p2.plusDays(10));
		System.out.println(p2.minusMonths(6));
		System.out.println("------------------------");
		
		// 날짜, 시간 비교
		System.out.println(p.isAfter(p2));
		System.out.println(p.isBefore(p2));
		System.out.println(p.isEqual(p2));
		System.out.println("------------------------");
		
		// LocalDateTime > Date, Time 변환
		LocalDateTime dt = LocalDateTime.now();
		LocalDate ld = dt.toLocalDate();
		LocalTime lt = dt.toLocalTime();
		
		System.out.println(dt);
		System.out.println(ld);
		System.out.println(lt);
	}
}
