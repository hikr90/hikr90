package vo;

public class PersonVo {
	/* CLASS는 무조건 JAVA RESOURCE의 SRC안에 들어가야한다. (밖에 만들어지면 프로젝트 찍고 F5 누르자)
	 * 
	 * VO
	 * 	- VALUE OBJECT의 줄임말로서, VO는 여러가지의 정보를 묶어서 저장하기위한 하나의 클래스이다.
	 * 	- 예를 들어 친구의 이름, 나이, 전화번호를 저장하고자한다면 이 세가지 정보를 묶어서 관리할 수 있도록 해주는 PERSON클래스가 VO가 된다.*/
	
	private String name;
	private int age;
	private String phone;

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
