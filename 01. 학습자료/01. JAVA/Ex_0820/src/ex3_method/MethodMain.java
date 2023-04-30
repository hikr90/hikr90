package ex3_method;

public class MethodMain {
	
	public static void main(String[] args) {
		
		// stack에는 v1이라는 주소값이, heap에는 v1이라는 객체의 데이터(greet매서드)가 생긴다. 
		// 매서드를 사용하는 이유 : 만들어둔 코드를 재사용하기위해서이다.
		ValueTest v1 = new ValueTest();
		v1.greet();
		
		System.out.println("---------------");
		
		
		// 파라미터 매서드 
		// 예로, 메서드를 커피머신이라고 가정하면
		// 1번 캡슐 -> 1번 커피
		// 2번 캡슐 -> 2번 커피
		
		// 들어가는 데이터에따라서 결과가 다를 수 있다.
		// charAt(x)와 같이, x값에 따라서 결과값이 달라질 수 있다. 
		int su = 100; 
		int su2 = 0;
		v1.test1(su);
		
		// 결과는 100이 나온다.
		// 메서드는 값을 전달하는 용도로 쓰인다, 즉 su값의 복사본이 ValueTest의 test1의 n으로 넘어간다.
		// test1에서 복사본이 메서드내용에따라서 변화하고 그 리턴값을 돌려준다.
		// 원본값은 변하지 않았으므로 su의 값은 그대로이다.
		System.out.println("su : "+su);
		
		System.out.println("---------------");
		
		// 복사본의 값을 가지고오는 방법
		// CTRL+SPACE시 반환하는 값이 int가 되어있는 것을 확인할 수 있다.
		// 메서드의 리턴값이 n으로 되어있으므로 메서드 안에서 변한 200의 값으로 su2가 된 것을 확인할 수 있다.
		su2 = v1.test0(su);
		System.out.println("su2 : "+su2);
		
		System.out.println("---------------");
		
		String name = "홍길동";
		int age = 19;
		String res = v1.test2(age);
		
		System.out.printf("%s님은 %s입니다.\n",name,res);

		System.out.println("---------------");
		
		// 받는 값은 boolean으로 받자
		System.out.println("---남자 목욕탕 관리사 조건---");
		boolean result = v1.test3("남", 21);
		
		if(result==true) {
			System.out.println("합격");
		}else {
			System.out.println("불합격");
		}
		
		
	} //main
}
