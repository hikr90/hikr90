package com.korea.vo;
// 스프링에서는 사용하는 클래스에 기본 생성자가 있어야한다.
public class PersonVO {
	private String name;
	private int age;
	private String tel;

	// 셋터 주입 시 기본생성자가 있어야한다.
	public PersonVO() {
		System.out.println("PERSONVO 기본 생성자");
	}
	
	// 파라미터를 받는 생성자
	public PersonVO(String name, int age, String tel) {
		System.out.println("파라미터를 받는 생성자");
		this.name = name;
		this.age = age;
		this.tel = tel;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		System.out.println("SETNAME");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		System.out.println("SETAGE");
		this.age = age;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		System.out.println("SETTEL");
		this.tel = tel;
	}
}
