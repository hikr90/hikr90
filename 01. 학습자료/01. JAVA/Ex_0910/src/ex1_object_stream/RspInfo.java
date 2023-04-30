package ex1_object_stream;
/* ���������� ������ ������ �������� ������ �� �ִ� Ŭ���� */

import java.io.Serializable;

	// Serializable�� �߻�޼��尡 ���� �������̽��� �׳� �Ʒ�ó�� ������ �ȴ�.
public class RspInfo implements Serializable{
	// �� Ŭ������ ������ id�� �¹��и� �����Ѵ�.
	// Object��Ʈ���� ���ؼ� ��ü�� ��°�� �а� ���� ���ؼ��� ��ü�� ����ȭ�� �ʼ����̹Ƿ� 
	// Serializable�� �����Ͽ� "���� RspInfo�� ������ �Ϸķ� �����׽��ϴ�."��� ���������Ѵ�.
	
	// ������ id�� ������ ����
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

	
	//rspinfo���� java.io.NotSerializableException ������ ���ٰ� ���.
	// �������� Ŭ�����ȿ� ������ ������ ������ �ִ� ���� �ƴ�, ���� �� ������� �ּҰ��� ������ infoŬ���� �������� �����ϰ��ִ� ���̴�.
	// ������Ʈ ��Ʈ���� Ŭ������ 4���� ������ ����ϰ����ϴµ� ������ ������ �ּҰ� �ٴ޶�, ��� �ּҰ��� �����ؾ��ϴ��� ���� ���Ѵ�.
	// ������Ʈ��Ʈ���� ����ϱ����ؼ� �ϳ��� �迭ó�� ���� �� ���� ���̵�� �¹����� ������ ���� ������ �� �迭�� �ּҸ� oos���� ����������Ѵ�. 
	// ������ִ� �������� �ϳ��� �迭�� �Ǹ� �ּҰ��� ���������� �Ǵµ�
	// �� �迭���� ���� ���縸���ִ� ���̴�.
	// �̷��� ���ٷ� ����� �۾��� ����ȭ(seializable)�̶�� �Ѵ�. �� �۾��� �Ǿ����� ������ ���� �������� ���Ѵ�.
	
	






















}
