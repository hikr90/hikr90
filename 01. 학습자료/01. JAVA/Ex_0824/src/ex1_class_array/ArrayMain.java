package ex1_class_array;

public class ArrayMain {

	public static void main(String[] args) {
		
		ArrayTest at = new ArrayTest();
		at.setName("ȫ�浿");
		at.setAge(30);
		
		
		System.out.println(at.getName());
		
		int res = at.getAge();
		System.out.println(res);
		
		System.out.println("------------");
		
		
		// Ŭ������ �迭�� ���� (��Ģ�� ����.)
		// String [] str = new String[2];
		// �迭�� Ŭ������ �Ͻ��� ��ü ������ �ȵȴ�. (String ���ܴ� �� �ȵȴ�.)
		// str[0] = "1";�� �ȵȴ�.
		// Ŭ������ [] �迭�� = new Ŭ������[];
		ArrayTest [] arr = new ArrayTest[2];
		
		// Ŭ������ �迭�� �����ϸ�, �켱 �������� ���ͺ��� �����ȴ�. (�����Ͱ� ���� null)
		// �׷��� �Ʒ��� ���� �۾��� �ʿ��ϴ�.		
		// ������ new �� ���ؼ� 0������ ���� ���̴ٶ�� ���̴�.
		// (�߿�!)String�� ������ ��� Ŭ������ �迭�� ���� ��, �� index���� new�� ���ؼ� ��üȭ �۾��� �ݵ�� ���ľ��Ѵ�.
		//arr[0] = new ArrayTest();
		//arr[1] = new ArrayTest();
		
		// for���� ���� Ŭ���� �迭 ����
		for(int i=0;i<arr.length;i++) {
			arr[i] = new ArrayTest();
		}
		
		// �迭�� �����Ͽ� ���� �ִ� ���
		// arr.name���δ� ������ �� ����. (private�̹Ƿ�)
		// Ŭ������ �迭�� ����ԵǸ� �ٸ� Ÿ���� �����͸� �Ѱ����� ��� ��ü ������ �����ϴ� ���� �����ϴ�. 
		arr[0].setName("ȫ�浿");
		arr[0].setAge(20);

		arr[1].setName("��浿");
		arr[1].setAge(30);
		
		// Get �޼���� ���
		for(int i=0;i<arr.length;i++) {
			// println
			System.out.println(arr[i].getName()+" / "+arr[i].getAge());
			// printf
			System.out.printf("%s / %d\n",arr[i].getName(),arr[i].getAge());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
