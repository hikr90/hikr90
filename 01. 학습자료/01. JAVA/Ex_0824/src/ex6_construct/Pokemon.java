package ex6_construct;

public class Pokemon {
	
	private String name;
	
	// �����ε�
	// �Ʒ��� ���� ���� �����ڸ� ���� ����ԵǴ� (�����ε�) ����, �⺻ �����ڴ� �ƿ� ����� �� ���� �ȴ�. 
	public Pokemon(String name) {
		this.name = name;
	}

	// ������ ����� �ִ�. 
	// �������� 3��° Ư¡
	// �⺻ �����ڴ� �ڵ带 ���� ���̰� �����ص־� �����ε� �����ڿ� �Բ� ����� �� �ִ�.
	public Pokemon() {
		System.out.println("�⺻ �����ڷδ� ���α⸸ ����ϴ�.");
		name = "���α�";
	}
	
	public String getName() {
		return name;
	}
}