package ex1_object_stream;
/* 가위바위보 게임의 정보를 유저별로 저장할 수 있는 클래스 */

import java.io.Serializable;

	// Serializable는 추상메서드가 없는 인터페이스라서 그냥 아래처럼 적으면 된다.
public class RspInfo implements Serializable{
	// 이 클래스는 유저의 id와 승무패를 관리한다.
	// Object스트림을 통해서 객체를 통째로 읽고 쓰기 위해서는 객체의 직렬화가 필수적이므로 
	// Serializable을 구현하여 "내가 RspInfo의 정보를 일렬로 만들어뒀습니다."라고 명시해줘야한다.
	
	// 유저의 id를 저장할 변수
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

	
	//rspinfo에서 java.io.NotSerializableException 오류가 떳다고 뜬다.
	// 힙영역의 클래스안에 각각의 변수가 한집에 있는 것이 아닌, 각각 다 흩어져서 주소값이 힙영역 info클래스 영역에서 참조하고있는 것이다.
	// 오브젝트 스트림은 클래스의 4가지 정보를 기억하고자하는데 각각의 정보의 주소가 다달라서, 어느 주소값을 참조해야하는지 알지 못한다.
	// 오브젝트스트림이 기록하기위해선 하나의 배열처럼 만들어서 그 곳에 아이디와 승무패의 정보를 넣은 다음에 그 배열의 주소를 oos에게 전달해줘야한다. 
	// 흩어져있는 정보들이 하나의 배열이 되면 주소값이 순차적으로 되는데
	// 이 배열에는 값을 복사만해주는 것이다.
	// 이렇게 한줄로 만드는 작업을 직렬화(seializable)이라고 한다. 이 작업이 되어있지 않으면 값을 저장하지 못한다.
	
	






















}
