package ex2_pokemon;

public class PokeMain {

	public static void main(String[] args) {
		
		// Ŭ���� ����
		PokeUnit p1 = new PokeUnit();	
		
		// - �ش� Ŭ���� ���� �̸�, Ÿ��, cp��  ���� ��������Ƿ� 
		// - ���� Ŭ�������� ���� ������ �ٸ� �Ӽ��� ������ �ִ� Ŭ������ �����ϴ� ���� �����ϴ�.
		// - �Ʒ��� ���ÿ��� p1�� ��ī��, p2�� ������, p3�� ���αⰡ �� �� �ִ�.
		// - �̷��� �Ӽ��� Ŭ������ �������̶�� �θ���.
		p1.name = "��ī��";
		p1.type = "����";
		p1.cp = 1500;
		//
		p1.myPokemon();
		//
		PokeUnit p2 = new PokeUnit();	
		p2.name = "������";
		p2.type = "����";
		p2.cp = 2000;
		//
		p2.myPokemon();
		//
		PokeUnit p3 = new PokeUnit();	
		p3.name = "���α�";
		p3.type = "��";
		p3.cp = 500;
		//
		p3.myPokemon();
	}
}
