package vo;

public class PersonVo {
	/* Value Object 
	 *	- 여러가지의 정보를 묶어서 저장하기위한 하나의 클래스
	 */
	private String name;
	private int age;
	private String phone;
	//
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
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
}
