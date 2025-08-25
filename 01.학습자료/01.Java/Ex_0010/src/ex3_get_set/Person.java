package ex3_get_set;

public class Person {

	// 회사의 직원과 이름 변수 선언
	private String name;
	private int age;
	
	/*	setter & getter 
	 * 	- 접근제어자로 인해서, 접근할 수 없는 값을 가져오거나, 수정할 수 있게하는 메소드
	 * 	- 반드시 그렇게 하는 것은 아니지만 암묵적으로 set, get을 사용한다.
	 *		- setter 메소드에서는 값을 지정, getter 메소드에서 값을 가져온다.
	 *
	 *		- alt + shift + s > Generate Getter and Setter > Select All 클릭 후 Generate > getter, setter 생성
	 */
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

	// [참고] 메소드 하나로 두가의 값을 반환하려는 경우
	// - 메소드 내의 name과 파라미터 name은 둘다 지역 변수로 취급한다.
	// - 즉 setProperty 안에 있는 name과 파라미터 name은 같다.
	// - 이 클래스에 선언되어있는 private name값에 넣기위해서는 이 클래스의 name 값이라고 표현이 되어야한다.
	// - 그래서 this라는 키워드를 사용한다.
	// - this는 현재 클래스를 의미한다.
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
