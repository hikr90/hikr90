package ex1_generics;

import java.util.ArrayList;

public class Ex3_Generic_Method {
	public static void main(String[] args) {
		/*	���׸� �޼ҵ�
		 * 		- �޼ҵ��� ����ο� ���׸� Ÿ���� ����� �޼ҵ�
		 * 		- ���׸� Ŭ������ �ƴ� Ŭ�������� ���ǵ� �� �ִ�.
		 * 		- �Ʒ��� ���׸� �޼ҵ��� Ÿ�� T�� ���� ���� Ÿ���̶�� �ǹ̰� �ƴ϶� ������ ��� ���̴�.
		 * 
		 * 			static <T> void sort(List<T> list, Comparator<? super T> c) 	
		 * 		
		 * 			[����] static ������� ���׸� Ÿ���� �� �� ������, �޼ҵ忡 ���׸� Ÿ���� �����ϰ� ����ϴ� ���� �����ϴ�.
		 * 				- �޼ҵ忡 ����� ���׸� Ÿ���� ���� ������ ������ �Ͱ� ����.
		 * 				- �޼ҵ� �������� ���� ���̹Ƿ� �޼ҵ尡 static�̰� ����� ����.
		 * 			
		 * 			[����] ���� Ÿ�� ����
		 * 				- ��κ��� ��� �����Ϸ��� Ÿ���� ���� �����ϹǷ� Ÿ�� ������ ������ �� ������
		 * 				- ���Ե� Ÿ���� ������ �� ���� ���Ե� Ÿ���� ���� ���� �ݵ�� ��� �Ѵ�. 
		 * 
		 * 					Juicer.makeJuice(fruitBox);
		 * 					Juicer.<Fruit>makeJuice(fruitBox);
		 */
	}
	
	// ���ʸ� �޼ҵ�
	public static <T extends Fruit> void Juice(FruitBox<T> box) {
		//
	}

}
