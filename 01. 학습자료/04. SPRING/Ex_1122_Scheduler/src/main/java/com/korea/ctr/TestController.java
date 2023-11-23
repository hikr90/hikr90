package com.korea.ctr;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;

@Controller
public class TestController {
	
	/*	# Scheduler
	 * 		- @Component (혹은 @Service) 같은 스프링 빈에 등록된 클래스에서 사용할 수 있다.
	 * 		- fixedDelay, fixedRate 옵션 혹은 Cron 표현식을 통해서 특정 시간대에 자동으로 실행시킨다.
	 * 		- 스케쥴러를 사용하는 메소드는 파라미터를 가질 수 없다.
	 * 		- 스케쥴러를 사용하는 메소드는 void 타입만을 사용할 수 있다.
	 * */
	@Scheduled(cron="0/10 * * * * ?")
	public void test1() throws Exception {
		/*	CRON 표현식
		 * 		- 스케쥴러 시간 세팅 방식 중 하나
		 * 		- [초 분 시 일 월 요일 년] 의 순서로 구성된다.
		 * 		
		 * 		- 초 : 0 ~ 59
		 * 		- 분 : 0 ~ 59
		 * 		- 시 : 0 ~ 23
		 * 		- 일 : 1 ~ 31
		 * 		- 월 : 1 ~ 12
		 * 		- 요일 : 0 ~ 6
		 * 		- 년 : 1970 ~ 2099
		 * 
		 *  CRON 표현식에서의 특수문자
		 *  	- * : 모든 값
		 *  	- ? : 사용하지 않음
		 * 		- / : 증가하는 값 지정 (초기값 / 증가값)
		 * 
		 * 	CRON 표현식 예시
		 * 		- "0/10 * * * * ?" : 10초마다 진행
		 * 		- "0 0/10 * * * ?" : 10분마다 진행
		 * 		- "0 10 * * * ?" : 매 시각 10분마다 진행
		 * 		- "0 30 11 * * ?" : 매일 오전 11시 30분마다 진행 
		 * */
		System.out.println("10초마다 동작하는 스케쥴러");
	}
	
	// FixedDelay
	@Scheduled(cron="0/10 * * * * ?")
	public void test2() throws Exception {
		/* FIXED DELAY
		 * 	- 
		 * 
		 * 
		 * 
		 */
	}	
	
	// FixedRate
	@Scheduled(cron="0/10 * * * * ?")
	public void test3() throws Exception {
		/* FIXED RATE 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * 
		 * */
	}
}
