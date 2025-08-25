package ex1_generics;

public class Ex2_wild_card {
	public static void main(String[] args) {
		/*	���ϵ� ī��
		 * 	- ��� Ÿ�Ե� �����ϴٴ� ���� ����
		 * 	- Object�� ���������� extends, super �� ���Ѱ� ������ ������ �� �ִ�.
		 * 	- ���ϵ� ī��� & ����� ����� �� ����.
		 * 	
		 * 		(1) <? extends T>
		 * 			- ���ϵ� ī���� ���� ����
		 * 			- T�� �� �ڼյ鸸 ����
		 * 
		 * 		(2) <? super T>
		 * 			- ���ϵ� ī���� ���� ����
		 * 			- T�� �� ����鸸 ����
		 * 
		 * 		(3) <?>
		 * 			- ���� ����
		 * 
		 *			[����] ���׸� �޼ҵ��� Comparator �� ���������� ��� �����ϴ�.
		 */
		FruitBox<Fruit> fruitBox = new FruitBox<Fruit>();
		FruitBox<Apple> appleBox = new FruitBox<Apple>();
		
		fruitBox.add(new Apple());
		fruitBox.add(new Grape());

		appleBox.add(new Apple());

	}
}

class Juice {
	String name;
	Juice(String name) { this.name = name + "Juice"; }
	public String toString() { return name; }
}

class Juicer {
	static Juice makeJuice(FruitBox<? extends Fruit> box) {
		String tmp = "";
		
		for(Fruit f : box.getList())
			tmp += f + " ";
		return new Juice(tmp);
	}
}
