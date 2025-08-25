package ex3_time;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;

public class Ex2_Period_Duration {
	public static void main(String[] args) {
		// Period : 날짜 - 날짜
		// Duration : 시간 - 시간
		
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
		
		// 필드 값 출력
		long year = pe.getYears();
		System.out.println(year);
		
		LocalTime t = LocalTime.of(0, 0).plusSeconds(du.getSeconds());
		System.out.println(t.getHour());
		System.out.println(t.getMinute());
		System.out.println(t.getSecond());
		System.out.println("-----------------------");
		
		// 필드 값 변경
		System.out.println(pe.withDays(1));
		System.out.println(du.withSeconds(60));
		
		// 사칙연산
		System.out.println(pe.minusYears(1).multipliedBy(2));		// 1년 감소 후 2배 곱
		System.out.println(du.plusHours(1).dividedBy(60));			// 1시간 증가 후 60으로 나누기
		System.out.println("-----------------------");
		
		// 시간, 날짜 비교
		boolean isSame = Period.between(date1, date2).isZero();
		boolean isBefore = Duration.between(time1, time2).isNegative();
		
		System.out.println(isSame);
		System.out.println(isBefore);
		System.out.println("-----------------------");
		
		// 필드 단위 변경
		System.out.println(pe.toTotalMonths());	// 년월일을 월단위로 변환해서 반환 (일 단위 무시)
		
		System.out.println(du.toDays());	// 일 단위 변환
		System.out.println(du.toHours());	//시간 단위 변환
		System.out.println(du.toMinutes());	// 분 단위 변환
	}
}
