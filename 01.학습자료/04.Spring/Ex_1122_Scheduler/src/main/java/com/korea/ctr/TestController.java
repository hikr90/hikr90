package com.korea.ctr;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	
	/*	스케쥴러
	 * 		- 특정한 시간대에 등록한 작업을 자동으로 진행시키는 기능
	 * 		- @Component에 속한 활성된 어노테이션이 있는 클래스에서 사용할 수 있다.
	 * 		- 스케쥴러를 사용하는 메소드는 파라미터를 가질 수 없다.
	 * 		- 스케쥴러를 사용하는 메소드는 void 타입만 사용할 수 있다.
	 * 
	 * 		[참고] 배치와 스케쥴러의 차이
	 * 			- 배치 : 여러 작업을 정해진 순서에따라 중단없이 일괄적으로 처리하는 기능
	 * 			- 스케쥴러 : 특정 배치 작업을 정해진 시간에 자동으로 동작	
	 * 	
	 * 		메소드
	 * 			(1) fixedDelay
	 * 				- 스케쥴러 작업이 전부 완료된 뒤 설정된 시간에따라 동작하는 기능
	 * 				- 파라미터의 단위는 밀리세컨드이다.
	 * 
	 * 			(2) fixedRate
	 * 				- 스케쥴러의 작업 완료 여부와 상관없이 스케쥴러가 시작한 순간부터 설정된 시간에따라 동작하는 기능
	 * 				- 파라미터의 단위는 밀리세컨드이다.
	 * 
	 * 		크론 표현식
	 * 			- 스케쥴러 시간 세팅 방식 중 하나
	 * 			- [초 분 시 일 월 요일 년] 의 순서로 구성된다.
	 * 		
	 * 			단위
	 *	 			(1) 초 : 0 ~ 59
	 * 				(2) 분 : 0 ~ 59
	 * 				(3) 시 : 0 ~ 23
	 * 				(4) 일 : 1 ~ 31
	 * 				(5) 월 : 1 ~ 12
	 * 				(6) 요일 : 0 ~ 6
	 * 				(7) 년 : 1970 ~ 2099
	 * 
	 *  	표현식의 특수문자
	 *  		(1) * : 모든 값
	 *  		(2) ? : 사용하지 않음
	 * 			(3) / : 증가하는 값 지정 (초기값 / 증가값)
	 * 
	 * 		표현식 예시
	 * 			(1) "0/10 * * * * ?" 	: 10초마다 진행
	 * 			(2) "0 0/10 * * * ?" 	: 10분마다 진행
	 * 			(3) "0 10 * * * ?" 		: 매 시각 10분마다 진행
	 * 			(4) "0 30 11 * * ?" 	: 매일 오전 11시 30분마다 진행 
	 */
	@Scheduled(cron="0/10 * * * * ?")
	public void test1() throws Exception {
		System.out.println("10초마다 동작하는 Cron방식 스케쥴러");
	}
	
	// FixedDelay
	@Scheduled(fixedDelay = 2000)
	public void test2() throws Exception {
		System.out.println("스케쥴러가 완료된 뒤 2초 후 FixedDelay방식 스케쥴러 동작");
	}	
	
	// FixedRate
	@Scheduled(fixedRate = 5000)
	public void test3() throws Exception {
		System.out.println("스케쥴러가 시작한 뒤 5초마다 동작하는 FixedRate방식 스케쥴러 동작");
	}
}
