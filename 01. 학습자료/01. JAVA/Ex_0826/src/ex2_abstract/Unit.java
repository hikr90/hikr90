package ex2_abstract;
// ���� ������ ����, ���ֿ� ���� ��ü
public abstract class Unit {
	
	String name;
	int energy;
	boolean fly;
	
	// �ڽ� ���ֵ��� ������ ������ ��, ü�°��ҷ��� �����ϱ����� �޼��� 
	// �������� ü�� ���ҷ��� �ٸ� ���̹Ƿ� �߻�޼���� ����
	abstract public void decEnergy();
	
	public int getEnergy() {
		return energy;
	}

}
