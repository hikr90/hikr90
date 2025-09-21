package ex1_set_get;

public class Ex1_Set_Get {
	/*	setter & getter 
	 * 		- 접근제어자로 인해서, 접근할 수 없는 값을 가져오거나, 수정할 수 있게하는 메소드
	 * 		- 반드시 그렇게 하는 것은 아니지만 암묵적으로 set, get을 사용한다.
	 *			(setter 메소드에서는 값을 지정, getter 메소드에서 값을 가져온다.)
	 *
	 *		[참고] alt + shift + s > Generate Getter and Setter > Select All 클릭 후 Generate > getter, setter 생성
	 */
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

	/* [참고] this.name을 사용하는 이유
	 * 		- 메소드 내 name, 파라미터 name은 둘다 지역변수로 취급된다.
	 *			(메소드 내 두 파라미터는 동일하다.)
	 *
	 *		- this는 이 클래스를 뜻한다.
	 *		- this.name은 이 클래스의 name값이라는 표현이 된다.
	 *			(두 변수의 명칭을 혼동하지 않기위해서 사용)
	 */
	public void setProperty(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
