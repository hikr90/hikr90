package ex1_class_array;

public class ArrayMain {

	public static void main(String[] args) {
		
		ArrayTest at = new ArrayTest();
		at.setName("홍길동");
		at.setAge(30);
		
		
		System.out.println(at.getName());
		
		int res = at.getAge();
		System.out.println(res);
		
		System.out.println("------------");
		
		
		// 클래스로 배열을 생성 (원칙은 같다.)
		// String [] str = new String[2];
		// 배열의 클래스는 암시적 객체 생성이 안된다. (String 제외는 다 안된다.)
		// str[0] = "1";이 안된다.
		// 클래스명 [] 배열명 = new 클래스명[];
		ArrayTest [] arr = new ArrayTest[2];
		
		// 클래스로 배열을 생성하면, 우선 힙영역에 집터부터 생성된다. (데이터강 없는 null)
		// 그래서 아래와 같은 작업이 필요하다.		
		// 집터의 new 를 통해서 0번방을 만들 것이다라는 뜻이다.
		// (중요!)String을 제외한 모든 클래스는 배열로 만들 때, 각 index별로 new를 통해서 객체화 작업을 반드시 거쳐야한다.
		//arr[0] = new ArrayTest();
		//arr[1] = new ArrayTest();
		
		// for문을 통한 클래스 배열 생성
		for(int i=0;i<arr.length;i++) {
			arr[i] = new ArrayTest();
		}
		
		// 배열에 접근하여 값을 넣는 방법
		// arr.name으로는 접근할 수 없다. (private이므로)
		// 클래스를 배열로 만들게되면 다른 타입의 데이터를 한공간에 묶어서 객체 단위로 저장하는 것이 가능하다. 
		arr[0].setName("홍길동");
		arr[0].setAge(20);

		arr[1].setName("김길동");
		arr[1].setAge(30);
		
		// Get 메서드로 출력
		for(int i=0;i<arr.length;i++) {
			// println
			System.out.println(arr[i].getName()+" / "+arr[i].getAge());
			// printf
			System.out.printf("%s / %d\n",arr[i].getName(),arr[i].getAge());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
