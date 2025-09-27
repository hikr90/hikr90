package ex5_serialization;

public class Ex3_UserInfo implements java.io.Serializable {
	String name;
	String password;
	int age;
	
	public Ex3_UserInfo() {
		this("Unknown", "1111", 0);
	}

	public Ex3_UserInfo(String name, String password, int age) {
		this.name = name;
		this.password = password;
		this.age = age;
	}
	
	public String toString() {
		return "(" + name + "," + password + "," + age + ")";
	}
}