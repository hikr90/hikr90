package ex1_class_array;

public class Ex1_Class_Array {
	public static void main(String[] args) {
		/*	클래스 배열
		 * 		- 클래스 형태의 배열
		 * 		- 클래스 형태의 배열은 암시적 객체 생성이 안된다.
		 * 		- 클래스 형태로 생성하게되면 heap 영역에 데이터가 null인 집터부터 생성이 된다.
		 * 		- 그래서 인덱스별로 클래스를 따로 New 생성 해줘야한다.
		 */
		
		Ex1_1_Class_Array at = new Ex1_1_Class_Array();
		at.setName("홍길동");
		at.setAge(30);
		
		System.out.println(at.getName());
		
		int res = at.getAge();
		System.out.println(res);
		
		System.out.println("------------");
		
		// - 클래스 배열 생성
		Ex1_1_Class_Array [] arr = new Ex1_1_Class_Array[2];
		
		// - 반복문을 통한 클래스 배열 생성
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Ex1_1_Class_Array();
		}
		
		// - 배열에 접근하여 값 지정
		arr[0].setName("홍길동");
		arr[0].setAge(20);

		arr[1].setName("김길동");
		arr[1].setAge(30);
		
		// 반복문으로 확인
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].getName()+" / "+arr[i].getAge());
			System.out.printf("%s / %d\n",arr[i].getName(),arr[i].getAge());
		}
	}
}

//
class Ex1_1_Class_Array {
	// 클래스 안에서 Getter, Setter 생성
	private String name;
	private int age;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}