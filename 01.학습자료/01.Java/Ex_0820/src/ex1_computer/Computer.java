package ex1_computer;

public class Computer {
		
	// ��ǻ���� ������ ���ϴ� ���赵 (Ŭ����)
	// - ���� Ŭ������ ���赵 Ŭ������ ����ϱ� ���� �������� ���� Ŭ������ ���赵 ������ ���� �ʴ´�.

	// - ��ǻ���� ����ǰ
	int hdd = 500;
	int ram = 16;
	float cpu = 2.5f;
	String color = "white";
	
	/*	���������� 
	 * 	- �ش� �޼ҵ��� ���� ������ �����ϴ� Ű����
	 * 
	 * 		(1) public : ���� ������Ʈ ���� ��� ��ü�� ���� �㰡
	 * 		(2) private : ���� Ŭ���� �������� ���� �㰡 (������ �������� ���)
	 * 		(3) protected : ��� ���迡���� ��ü������ �㰡
	 * 		(4) default : ���������ڿ� �ƹ� ���뵵 ���� ���� ��� ���� ��Ű������ ��ü�� ���� �㰡 
	 * 
	 * 	����
	 * 		(����) public > protected > (default) > private (����)
	 * 
	 * 
	 * 	���������ڿ� ĸ��ȭ
	 * 		- ���������ڴ� Ŭ���� ���ο� ����� ������ ��ȣ�� ������ �д�.
	 * 		- ������ ���߱��� �ϸ�, ��ü���� ������ ĸ��ȭ��� �Ѵ�.
	 * 		- �������� ���� ��ȿ�ϵ��� (��й�ȣó�� �ܺο��� ������ �� ����) ������ �����ϰų�, �ܺο� ������ �ʿ䰡 ���� ������ private ���� �����ڷ� ���⼺�� ���̴� ���� ĸ��ȭ��� �Ѵ�.
	 */
	private String company = "LG";	// ������� ����Ǿ�� �ȵǴ� ������ private�� ���
	
	// ��ǻ���� ������ ��ȯ�ϴ� �޼ҵ� ����
	// - heap ������ �ִ� c1�� ��ü�� getInfo ��� ����� �߰��Ѵ�.
	
	/* ��ȯŸ��
	 *		- �޼ҵ� ���� �� ��ȯ�ϴ� ����
	 *		- ���� ���� String, int, char ���� �ڷ����� �ش�ȴ�.
	 *		- void�� System.out.println ó�� �����ִ� ������ ���� Ÿ���̴�. 
	 */
	public void getInfo() {
		System.out.println("������ : "+company);
		System.out.println("hdd : "+hdd+"GB");
		System.out.println("ram : "+ram+"GB");
		System.out.println("cpu : "+cpu+"GHz");
		System.out.println("color : "+color);
		System.out.println("------------------");
	}

	public static void main(String[] args) {
		
	}
}
