package ex1_calendar;

import java.util.Calendar;

public class Ex3_Calendar {
	public static void main(String[] args) {
		/* add & roll
		 * 		- 두 메소드는 캘린더의 지정한 필드 값을 원하는 만큼 증가 혹은 감소시킨다.
		 * 	
		 * 	[참고] add는 다른 필드에 영향을 주고, roll은 다른 필드에 영향을 주지 않는다.
		 * 		- add 메소드의 경우, DATE의 값을 31만큼 증가시키면, 다음 달로 넘어가므로 MONTH도 1 증가한다.
		 * 		- roll 메소드의 경우, DATE의 값을 31만큼 증가시켜도, MONTH는 변하지 않는다.
		 */
		Calendar c1 = Calendar.getInstance();
		Calendar c2 = Calendar.getInstance();
		// 두 일자 값을 2025.01.01로 지정
		c1.set(2025, 01, 01);
		c2.set(2025, 01, 01);
		
		c1.add(Calendar.DATE, 31);
		System.out.println("add 메소드 : " + toString(c1));

		c2.roll(Calendar.DATE, 31);
		System.out.println("roll 메소드 : " + toString(c2));
	}
	
	// toString 함수 재정의
	public static String toString(Calendar date) {
		return date.get(Calendar.YEAR) + "년 " + (date.get(Calendar.MONTH) + 1) + "월 " + date.get(Calendar.DATE) + "일";
	}
}
