package ex1_class_array;

public class ArrayMain {

	public static void main(String[] args) {
		// Ŭ���� ����
		ArrayTest at = new ArrayTest();
		at.setName("ȫ�浿");
		at.setAge(30);
		
		System.out.println(at.getName());
		
		int res = at.getAge();
		System.out.println(res);
		
		System.out.println("------------");
		
		/*	Ŭ���� �迭
		 * 	- Ŭ���� ������ �迭
		 * 	- Ŭ���� ������ �迭�� �Ͻ��� ��ü ������ �ȵȴ�.
		 * 	- Ŭ���� ���·� �����ϰԵǸ� heap ������ �����Ͱ� null�� ���ͺ��� ������ �ȴ�.
		 * 	- �׷��� �ε������� Ŭ������ ���� New ���� ������Ѵ�.
		 */
		
		// - Ŭ���� �迭 ����
		ArrayTest [] arr = new ArrayTest[2];
		
		// - �ݺ����� ���� Ŭ���� �迭 ����
		for(int i=0;i<arr.length;i++) {
			arr[i] = new ArrayTest();
		}
		
		// - �迭�� �����Ͽ� �� ����
		arr[0].setName("ȫ�浿");
		arr[0].setAge(20);

		arr[1].setName("��浿");
		arr[1].setAge(30);
		
		// �ݺ������� Ȯ��
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i].getName()+" / "+arr[i].getAge());
			System.out.printf("%s / %d\n",arr[i].getName(),arr[i].getAge());
		}
	}
}
