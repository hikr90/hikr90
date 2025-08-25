package ex1_object_stream;

import java.io.Serializable;

public class RspInfo implements Serializable{
	
	/*	직렬화 (Serializable)
	 * 	- 객체 또는 데이터를 외부에서도 사용할 수 있도록 바이트 형태로 변환하는 작업
	 * 	- 인터페이스이므로, 클래스 implements Serializable 방식으로 구현한다.

	 * 	- 반대로 바이트로 변환된 데이터를 다시 객체로 변환하는 작업을 역직렬화라고 부른다.
	 */
	
	
	// - 이 클래스는 유저의 아이디와 전적을 관리한다.
	// - Object Stream 을 사용하여 객체를 통으로 읽고 쓰므로 객체의 직렬화가 필수이다.
	
	/*	java.io.NotSerializableException
	 * 	- 직렬화할 수 없다. 라는 오류
	 * 	- heap 영역 안에 RspInfo 클래스 내에 있는 각각의 변수 주소 값이 다 흩어져있어서 생긴 오류이다.
	 * 	- Object Stream에서는 클래스의 id, win, lose, draw 변수를 기억하고자하지만 각 주소 값이 다르다보니 어떤 값을 참조해야하는지 알 수 없다.
	 * 
	 * 	- 그래서, 하나의 배열 형태를 만들어서 그 곳에 승무패의 정보를 저장한 뒤
	 * 	- 그 배열의 주소 값을 Object Stream 에 전달해야한다.
	 * 
	 * 	- 위의 작업이 직렬화이다. 이 작업이 없으면 객체를 직렬화 할 수 없다.
	 */
	
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
