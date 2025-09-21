package ex4_set;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Ex3_HashSet {
	public static void main(String[] args) {
		/*	Set
		 *		- �÷��� �������̽��� ���
		 *		- ������ �������� �ʴ� �������� ����
		 *		- �������� �ߺ��� ������� ����
		 *		- HashSet, TreeSet
		 */
		Object [] arr = {"1", new Integer(1), "2", "2", "3", "3", "4", "4", "4"};
		Set s = new HashSet();
		
		for(int i=0; i<arr.length; i++) {
			s.add(arr[i]);
		}
		// ���� �ٸ� ��ü�� �ߺ����� �������� �ʴ´�.
		// Set�� ������ �������� �����Ƿ�, �ߺ� ���ſ� ������ ���������ϴ� ��쿡�� LinkedHashSet�� ����Ѵ�.
		System.out.println(s);
		System.out.println("---------------------");
		
		// [����] HashSet���� �ߺ� ��ü ���� ��� (���� �ν��Ͻ� ����)
		HashSet hs = new HashSet();
		
		hs.add(new String("abc"));
		hs.add(new String("abc"));
		hs.add(new Person("KIM", 35));
		hs.add(new Person("KIM", 35));
		
		System.out.println(hs);
	}
}

// Ŭ���� ����
class Person {
	String name;
	int age;
	
	// ������
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// [����] add �޼Ҵ� equals, hashCode �� ���ؼ� �ߺ� ���� üũ�Ѵ�.
	// �ߺ� üũ�� ���Ǵ� equals
	public boolean equals(Object obj) {
		if(obj instanceof Person) {
			Person p = (Person) obj;
			return name.equals(p.name) && age == p.age;
		}
		//
		return false;
	}
	
	// �ߺ� üũ�� ���Ǵ� hashCode
	// [�߿�] �������̵��� ���ؼ� �ۼ��� hashCode�� ������ ������ �����ؾ� �Ѵ�.
	// 	1. Ŭ������ ���� ��������� ���� ������� �ʴ� ��, �ϳ��� �ν��Ͻ������� hashCode ȣ�⸶�� �׻� ���� ���� ���� �Ѵ�.
	//				- String Ŭ������ ���ڿ��� ��������, Object�� ��ü�� �ּҷ� �ؽ��ڵ� ���� ������.
	//
	//		2. equals�� ���ؼ� true�� ���� �� ��ü�� ���ؼ� hashCode ȣ�� ����� �ݵ�� ���ƾ� �Ѵ�.
	//		3. equals�� ���ؼ� false�� ���� �� ��ü�� ������ ���ؼ� ���� �ٸ� int�� ��ȯ�ϴ� ���� ����.
	public int hashCode() {
		return Objects.hash(name, age);
	}
	
	// Syso�� ���Ǵ� toString
	public String toString() {
		return name + " : " + age;
	}
}