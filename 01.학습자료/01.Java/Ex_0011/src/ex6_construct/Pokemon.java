package ex6_construct;

public class Pokemon {
	//
	private String name;
	
	// - �Ʒ��� ���� �����ڸ� ���� ����ԵǸ� �⺻ �����ڸ� ����� �� �����Ƿ�
	// - ���� �⺻ �����ڸ� �������� �Ѵ�.
	public Pokemon(String name) {
		this.name = name;
	}

	// �⺻ �����ڸ� ����
	public Pokemon() {
		System.out.println("�⺻ �����ڷδ� ���α⸸ ����ϴ�.");
		name = "���α�";
	}
	
	public String getName() {
		return name;
	}
}