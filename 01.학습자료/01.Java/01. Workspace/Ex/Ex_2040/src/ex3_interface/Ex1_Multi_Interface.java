package ex3_interface;

public interface Ex1_Multi_Interface extends Ex3_Multi_Interface, Ex4_Multi_Interface, Ex5_Multi_Interface{
	/*	�������̽��� ���� ���
	 * 		- �ϳ��� �ڽ��� �ϳ��� �θ��� ���� �� �ִ� ��Ӱ� �ٸ��� �������̽��� ���ο� �߻� �޼ҵ常 �����ϹǷ� ���� ����� �����ϴ�.
	 * 		- ��� ����� �Ʒ��� ����.
	 * 
	 * 		[����] interface ����1 extends ����2, ����3... 
	 */
	String jabchae();
}


class Ex6_Multi_Interface {
	public static void main(String[] args) {
		// �ֹ� Ŭ���� ��üȭ
		Ex2_Multi_Interface kit = new Ex2_Multi_Interface();
		
		// �޴� Ȯ��
		System.out.println(kit.jjajang());
		System.out.println(kit.tangsuyuck());
		System.out.println(kit.boggembab());
	}
}

interface Ex5_Multi_Interface {
	String boggembab();
}

interface Ex4_Multi_Interface {
	// 
	String tangsuyuck();
}

interface Ex3_Multi_Interface {
	// �������̽� �������� abstract �� ������� �ʾƵ� �߻� �޼ҵ�� �����Ѵ�.
	abstract String jjajang();
	String jjambbong();
}

class Ex2_Multi_Interface implements Ex1_Multi_Interface{
	
	@Override
	public String jjajang() {
		return "�߸� + ���� + ����";
	}
	
	@Override
	public String jjambbong() {
		return "ȫ�� + Ű���� + �߸�";
	}

	@Override
	public String tangsuyuck() {
		return "������� + Ƣ�谡�� + �������";
	}

	@Override
	public String boggembab() {
		return "��õ�� + ¥��ҽ�";
	}

	@Override
	public String jabchae() {
		return "�� + ���";
	}
}
