package ex4_method;

public class MyParam {

	public void test(int [] arr) {
		
		// arr이라는 배열을 받은 뒤, 4에 있던 5를 10으로 변경
		// 기본 자료형에서만 복사값을 넘겨주고 new를 사용하는
		// heap영역을 사용하는 자료형(배열)은 주소값을 넘긴다.
		
		arr[4] = 10;
		System.out.println("test메서드의 arr");
		
		for(int i=0;i<arr.length;i++) {
			
			System.out.println(arr[i]);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
