package ex2_work;

public abstract class Ex2_Work {
	// �߻� Ŭ����
	String name;
	int energy;
	boolean fly;
	
	// ������ ������ ������ ������ ������ ��� ü���� ���ҵǴ� �޼ҵ�
	// 	- �� ��ü�� ������ ü�� ���ҷ��� �ٸ� ���̹Ƿ� ���� �ڽ� Ŭ�������� ������ �� �ֵ��� ���� Ŭ���������� �߻� �޼ҵ�� ����
	abstract public void decEnergy();
	//
	public int getEnergy() {
		return energy;
	}
}
