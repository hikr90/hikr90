package ex6_constr_overload;

public class Ex1_Constr_Overload {
	public static void main(String[] args) {
		// �����ε� �����ڷ� Ŭ���� ����
		Ex2_Constr_Overload p1 = new Ex2_Constr_Overload("��ī��");
		Ex2_Constr_Overload p2 = new Ex2_Constr_Overload("������");

		System.out.println("�����ε� ������ : "+p1.getName());
		System.out.println("�����ε� ������ : "+p2.getName());
		
		// �⺻ ������ ȣ���� �Ұ���������.
		// �������̵� �� �⺻ �����ڸ� ���� ���̰� ������ ���ָ� �⺻ �����ڸ� ����� �� �ִ�.
		Ex2_Constr_Overload p3 = new Ex2_Constr_Overload();
		System.out.println("�⺻ ������ : "+p3.getName());
	}
}
