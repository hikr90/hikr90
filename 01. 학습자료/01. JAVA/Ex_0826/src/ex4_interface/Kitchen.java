package ex4_interface;

// �������̽��� ��Ӱ� �޸� ������ ����. 
// �������̽��� ����� �Ǹ� �Ʒ� �Ŀ� AllMenu�� �� �ټ� �ִ�.
// ��ӹ��� �޼������ ���� �� �������־���Ѵ�. 
public class Kitchen implements AllMenu{
	
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
