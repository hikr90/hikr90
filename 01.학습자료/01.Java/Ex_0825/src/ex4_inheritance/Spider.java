package ex4_inheritance;

public class Spider extends Animal{
	// Animal을 상속받는 Spider 클래스
	String web = "슉슉";
	
	// - 오버라이딩은 부모 메서드의 명칭 대소문자나 파라미터의 명칭까지 전부 같아야한다.
	@Override
	public int getLeg() {
		return 6;
	}
	
	@Override
	public int getEye() {
		return 8;
	}
}
