package ex3_interface;
// 인터페이스를 상속
// implements키워드를 통해서 인터페이스를 "구현"한다.
public class InterChild implements InterTest{
	
	
	@Override
	public int getValue() {
		
		// final키워드를 붙여서 만든 키워드는 상수이므로 값을 변경할 수 없다.
		// VALUE += 10; 
		
		return VALUE;
	}
	
	
}
