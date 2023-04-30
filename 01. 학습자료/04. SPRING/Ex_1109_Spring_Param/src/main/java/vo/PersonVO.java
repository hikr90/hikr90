package vo;

public class PersonVO {
	
	public PersonVO(String name, int age, String tel) {
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	
	public PersonVO() {

	}
	
	// 파라미터에 있는 정보를 담아줄 수 있는 VO객체
	private String name;
	private int age;
	private String tel;

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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	
	
}
