package ex3_interface;

public class InterChild implements InterTest{
	
	// 추상 메소드의 재정의
	@Override
	public int getValue() {
		// - final 키워드를 붙여서 만든 키워드는 상수이므로 값을 변경할 수 없다.
		return VALUE;
	}
}
