package ex3_interface;

public class InterChild implements InterTest{
	
	// 추상 메소드의 재정의
	@Override
	public int getValue() {
		/* final 
		 * 	- 값을 상수로 지정하는 키워드
		 * 	- 변수와 마찬가지로 값을 저장하는 공간이지만 한번 값을 저장하면 다른 값으로 변경할 수 없다.
		 * 	- 상수는 전부 대문자로 작성하며, 여러 단어로 구성된 경우 _ 를 붙여서 구분한다.
		 * 	- 의미 그 자체인 값을 여러 곳에서 사용하지 않고 한 곳에서 수정하기 쉽게 사용하기 위해서 사용한다.
		 * 
		 * 	- 실무에서는 상수 대신 리터럴이라고 부른다.
		 * 			(상수 : 값을 한번만 저장할 수 있는 공간)
		 * 			(리터럴 : 그 자체로 값을 의미하는 것, 의미있는 값)
		 */
		return VALUE;
	}
}
