package ex7_work;

import java.io.Serializable;

public class Ex4_Work implements Serializable{
	// 유저의 아이디를 저장할 변수
	private String id;
	
	// 승무패를 저장할 변수
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
