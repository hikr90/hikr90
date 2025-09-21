package ex4_set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex3_HashSet {
	public static void main(String[] args) {
		/*	Set
		 *		- 컬렉션 인터페이스에 상속
		 *		- 순서를 유지하지 않는 데이터의 집합
		 *		- 데이터의 중복을 허용하지 않음
		 *		- HashSet, TreeSet
		 */
		Object [] arr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set s = new HashSet();
		
		for(int i=0; i<arr.length; i++) {
			s.add(arr[i]);
		}
		// 서로 다른 객체는 중복으로 간주하지 않는다.
		// Set은 순서를 유지하지 않으므로, 중복 제거와 순서를 가지고자하는 경우에는 LinkedHashSet을 사용한다.
		System.out.println(s);
		System.out.println("---------------------");
		
		// [예시] HashSet에서 중복 객체 제거 방법 (동일 인스턴스 제거)
		HashSet hs = new HashSet();
		
		hs.add(new String("abc"));
		hs.add(new String("abc"));
		hs.add(new Person("KIM", 35));
		hs.add(new Person("KIM", 35));
		
		System.out.println(hs);
	}
}

// 클래스 구현
class Person {
	String name;
	int age;
	
	// 생성자
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// [참고] add 메소는 equals, hashCode 를 통해서 중복 값을 체크한다.
	// 중복 체크에 사용되는 equals
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			return name.equals(p.name) && age == p.age;
		}
		//
		return false;
	}
	
	// 중복 체크에 사용되는 hashCode
	// [중요] 오버라이딩을 통해서 작성된 hashCode는 세가지 조건을 충족해야 한다.
	// 	1. 클래스에 사용된 멤버변수의 값이 변경되지 않는 한, 하나의 인스턴스에대해 hashCode 호출마다 항상 같은 값을 얻어야 한다.
	//				- String 클래스는 문자열의 내용으로, Object는 객체의 주소로 해시코드 값을 만들어낸다.
	//
	//		2. equals를 통해서 true를 받은 두 객체에 대해서 hashCode 호출 결과는 반드시 같아야 한다.
	//		3. equals를 통해서 false를 받은 두 객체는 성능을 위해서 서로 다른 int를 반환하는 것이 좋다.
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	// Syso에 사용되는 toString
	public String toString() {
		return name + " : " + age;
	}
}