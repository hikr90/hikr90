package ex1_class_array;

public class Ex1_Class_Array {
	public static void main(String[] args) {
		/*	Ŭ���� �迭
		 * 		- Ŭ���� ������ �迭
		 * 		- Ŭ���� ������ �迭�� �Ͻ��� ��ü ������ �ȵȴ�.
		 * 		- Ŭ���� ���·� �����ϰԵǸ� heap ������ �����Ͱ� null�� ���ͺ��� ������ �ȴ�.
		 * 		- �׷��� �ε������� Ŭ������ ���� New ���� ������Ѵ�.
		 */
		
		Ex1_1_Class_Array at = new Ex1_1_Class_Array();
		at.setName("ȫ�浿");
		at.setAge(30);
		
		System.out.println(at.getName());
		
		int res = at.getAge();
		System.out.println(res);
		
		System.out.println("------------");
		
		// - Ŭ���� �迭 ����
		Ex1_1_Class_Array [] arr = new Ex1_1_Class_Array[2];
		
		// - �ݺ����� ���� Ŭ���� �迭 ����
		for(int i=0;i<arr.length;i++) {
			arr[i] = new Ex1_1_Class_Array();
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

//
class Ex1_1_Class_Array {
	// Ŭ���� �ȿ��� Getter, Setter ����
	private String name;
	private int age;

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
}