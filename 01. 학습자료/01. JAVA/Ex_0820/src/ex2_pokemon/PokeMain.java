package ex2_pokemon;

public class PokeMain {

	public static void main(String[] args) {
		
		// stack�� p1 �������� �ּҰ��� �ΰ�, heap�� p1��ü�� �ش��ϴ� ����(�������)�� �ҷ��´�.
		PokeUnit p1 = new PokeUnit();	
		// ����ִ� ������ �����͸� ���� ���� �� �ִ�.
		// ���������̶�� Ŭ������ �߻����ε�, ���ϸ��̶�� ū ���־ȿ��� �Ӽ���(����)������ 
		//p1 Ŭ���������� ��ī�� �ǰ�, p2��� Ŭ���������� �����򰡵ǰ� p3��� Ŭ���������� ���αⰡ �� �� �ִ�.
		
		//Ŭ������ ������ (���۸��غ���)
		//�ϳ��� ���� �ȿ��� Ŭ������ �Ӽ��������� ���� ������ �ٸ� �Ӽ��� �������ִ� Ŭ����(�޼���)�� �����ϴ� ��
		p1.name = "��ī��";
		p1.type = "����";
		p1.cp = 1500;
		
		p1.myPokemon();

		PokeUnit p2 = new PokeUnit();	
		p2.name = "������";
		p2.type = "����";
		p2.cp = 2000;

		p2.myPokemon();
	
		PokeUnit p3 = new PokeUnit();	
		p3.name = "���α�";
		p3.type = "��";
		p3.cp = 500;

		p3.myPokemon();
	}
}
