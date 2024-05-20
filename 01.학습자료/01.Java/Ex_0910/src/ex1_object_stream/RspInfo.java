package ex1_object_stream;

import java.io.Serializable;

public class RspInfo implements Serializable{
	
	/*	����ȭ (Serializable)
	 * 	- ��ü �Ǵ� �����͸� �ܺο����� ����� �� �ֵ��� ����Ʈ ���·� ��ȯ�ϴ� �۾�
	 * 	- �������̽��̹Ƿ�, Ŭ���� implements Serializable ������� �����Ѵ�.

	 * 	- �ݴ�� ����Ʈ�� ��ȯ�� �����͸� �ٽ� ��ü�� ��ȯ�ϴ� �۾��� ������ȭ��� �θ���.
	 */
	
	
	// - �� Ŭ������ ������ ���̵�� ������ �����Ѵ�.
	// - Object Stream �� ����Ͽ� ��ü�� ������ �а� ���Ƿ� ��ü�� ����ȭ�� �ʼ��̴�.
	
	/*	java.io.NotSerializableException
	 * 	- ����ȭ�� �� ����. ��� ����
	 * 	- heap ���� �ȿ� RspInfo Ŭ���� ���� �ִ� ������ ���� �ּ� ���� �� ������־ ���� �����̴�.
	 * 	- Object Stream������ Ŭ������ id, win, lose, draw ������ ����ϰ��������� �� �ּ� ���� �ٸ��ٺ��� � ���� �����ؾ��ϴ��� �� �� ����.
	 * 
	 * 	- �׷���, �ϳ��� �迭 ���¸� ���� �� ���� �¹����� ������ ������ ��
	 * 	- �� �迭�� �ּ� ���� Object Stream �� �����ؾ��Ѵ�.
	 * 
	 * 	- ���� �۾��� ����ȭ�̴�. �� �۾��� ������ ��ü�� ����ȭ �� �� ����.
	 */
	
	// ������ ���̵� ������ ����
	private String id;
	
	// �¹��и� ������ ����
	private int win, lose, draw;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getWin() {
		return win;
	}

	public void setWin(int win) {
		this.win = win;
	}

	public int getLose() {
		return lose;
	}

	public void setLose(int lose) {
		this.lose = lose;
	}

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}
}
