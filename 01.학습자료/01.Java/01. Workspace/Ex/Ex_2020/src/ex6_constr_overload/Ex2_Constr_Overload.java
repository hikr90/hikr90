package ex6_constr_overload;

public class Ex2_Constr_Overload {
	//
	private String name;
	
	// - �Ʒ��� ���� �����ڸ� ���� ����ԵǸ� �⺻ �����ڸ� ����� �� �����Ƿ�
	// - ���� �⺻ �����ڸ� �������� �Ѵ�.
	public Ex2_Constr_Overload(String name) {
		this.name = name;
	}

	// �⺻ �����ڸ� ����
	public Ex2_Constr_Overload() {
		System.out.println("�⺻ �����ڷδ� ���α⸸ ����ϴ�.");
		name = "���α�";
	}
	
	public String getName() {
		return name;
	}
}