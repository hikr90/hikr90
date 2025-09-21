package ex2_work;

public class Ex1_Work {
	
	public static void main(String[] args) {
		//
		Ex2_Work b1 = new Ex2_Work("강남점", "02-111-1111");
		Ex2_Work b2 = new Ex2_Work("신촌점", "02-111-2222");
		Ex2_Work b3 = new Ex2_Work("홍대점", "02-111-3333");
		//
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
		
		// static 변수나 static 메소드는 클래스.static변수(메소드) 방식으로 직접 호출해서 사용한다.
		Ex2_Work.interest = 0.1f;
		// 값 확인
		b1.getInfo();
		b2.getInfo();
		b3.getInfo();
	}
}
