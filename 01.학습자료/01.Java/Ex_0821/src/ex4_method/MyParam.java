package ex4_method;

public class MyParam {

	public void test(int [] arr) {
		
		// - 배열의 4번 인덱스의 값을 10으로 지정
		// - 기본 자료형에서만 복사 값을 넘겨주고, New를 사용하는 자료형 (배열) 혹은 String은 주소 값을 넘기므로 값이 변경된다.
		arr[4] = 10;
		System.out.println("test메서드의 arr");
		//
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
