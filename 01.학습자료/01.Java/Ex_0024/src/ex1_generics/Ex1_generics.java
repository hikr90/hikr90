package ex1_generics;

import java.util.ArrayList;

public class Ex1_generics {
	//
	public static void main(String[] args) {
		/*	Generics
		 * 		- �پ��� Ÿ���� ��ü�� �ٷ�� �޼ҵ峪 �÷��� Ŭ������ ������ ��, Ÿ�� üũ�� �ϴ� ���
		 * 		- ��ü�� Ÿ���� ������ �ÿ� üũ�ϹǷ� �������� ���̰� ����ȯ�� ���ŷο��� �پ���.
		 * 		
		 * 			class Box<T> {
		 * 				T item;
		 * 	
		 * 				void setItem(T item) { this.item = item; }
		 * 				T getItem() { return item; }
		 * 			}
		 * 
		 * 			- T�� Ÿ�� �����μ�, ������ ������ Ÿ���� ���Ѵ�.
		 * 			- ���׸� Ŭ������ ��ü ������ ���� Box<String> b = new Box<String>(); ó�� ���������� ������ Ÿ�Կ� ���� ���� Ÿ���� �����Ͽ� ����Ѵ�.
		 * 			- Box<T> �� ���׸� Ŭ����, T�� Ÿ�� ����, Box�� ���� Ÿ�� (raw type) �̶�� �θ���.
		 * 
		 * 			[����] ���׸��� ��� �Ұ��� ���
		 * 				(1) �ν��Ͻ� ���� ����
		 * 					- T�� �ν��Ͻ� ������ ���ֵǹǷ�, ��� ��ü�� ���� �����ϰ� �����ؾ��ϴ� static ����� Ÿ�� ���� T�� ����� �� ����.
		 * 					- static ����� �ν��Ͻ� ������ ������ �� ����. 
		 * 			
		 * 				(2) ��� ����
		 * 					- ��ü ���� �� ���������� �����ڿ� ���Ե� Ÿ���� ���� ��� ���迡 �־ ������ �߻��Ѵ�.
		 * 					- ��, �� ���׸� Ŭ������ Ÿ���� ��� ���迡 �ְ� ���ԵǴ� Ÿ���� ���� ���� ������.
		 */
		
		// ��ü ���� & ���
		Box<Fruit> fruitBox = new Box<Fruit>();
		Box<Apple> appleBox = new Box<Apple>();
		Box<Toy> toyBox = new Box<Toy>();
		
		//  [����] Ÿ�Ժ��� Ÿ�� <> ������ Ÿ��
		// Box<Grape> grapeBox = new Box<Apple>();
		
		//  [����] ��ü Ÿ�� == ������ Ÿ��
		appleBox.add(new Apple());
		
		// [����] ��ü Ÿ�� <> ��ü �߰� Ÿ��
		// appleBox.add(new Grape());
		
		// [����] ��, ����� ���迡���� �����ϴ�.
		fruitBox.add(new Fruit());
		fruitBox.add(new Apple());
		
		// [����] �ڼ� Ŭ������ ����
		FruitBox<Fruit> appleBox2 = new FruitBox<Fruit>();
		appleBox2.add(new Apple());
		appleBox2.add(new Grape());
		
		// [����] ��� ���谡 �ƴϹǷ� ����
		// appleBox2.add(new Toy());
		
	}	
}

// �ܺ� Ŭ����
class Fruit implements Eatable { public String toString() { return "Fruit";}}
class Apple extends Fruit { public String toString() { return "Apple";}}
class Grape extends Fruit { public String toString() { return "Grape";}}
class Toy { public String toString() { return "Toy";}}

class Box<T> {
	// 
	ArrayList<T> list = new ArrayList<>();	// ���������� Ÿ�����κ��� T Ÿ���� ������ ���� �� �����Ƿ� �����ڿ� Ÿ���� ���� ǥ������ �ʾƵ� ��� x
	void add(T item) { list.add(item); }
	T get(int i) { return list.get(i); }
	int size() { return list.size(); }
	public String toString() { return list.toString(); }
	ArrayList<T> getList() { return list; }
}

// �������̽�
// - extends�� & ���ڷ� ǥ��
interface Eatable {}

// ���ѵ� ���׸� Ŭ����
class FruitBox<T extends Fruit & Eatable> extends Box<T> {		// Ÿ�Ժ����� Fruit�� �ڽ��̸鼭 Eatable�� �����ؾ� �Ѵ�.
	// Ÿ�� ���� extends ��� ��, �ش� Ÿ���� �ڽĸ� ���� ����	
}

