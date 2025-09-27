package ex5_serialization;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Ex1_Serialization {
	public static void main(String[] args) throws IOException {
		/*	Serialization (직렬화)
		 * 		- 객체를 데이터 스트림으로 변환하는 작업
		 * 		- 객체에 저장된 데이터를 스트림에 쓰기위해 연속적인 데이터로 변환하는 것을 말한다.
		 * 		- 객체를 컴퓨터에 저장했다가 나중에 다시 꺼내서 사용하거나, 네트워크를 통해서 컴퓨터 간에 객체를 주고 받는 것이 가능하다.
		 * 		- 반대로 스트림으로부터 데이터를 읽어서 객체를 만드는 것을 역직렬화라고 부른다.
		 * 
		 * 		[참고] 직렬화는 쉽게 표현하면 객체를 저장하거나 전송하는데 필요한 작업이다.
		 * 			- 객체는 클래스에 정의된 인스턴스 변수의 집합이다.
		 * 			- 객체를 저장한다는 것은 객체의 모든 인스턴스 변수의 값을 저장하는 것과 같다.
		 * 			- 저장한 객체를 다시 사용하려면 객체 생성 후에 저장했던 값을 읽어서 생성한 객체의 인스턴스 변수에 저장하면 된다.
		 * 			- 클래스에 정의된 인스턴스 변수가 기본형이 아닌 참조형인 경우에는 참조된 값들도 전부 저장되어야 한다.
		 * 			- 위와 같은 상황에서 ObjectInput/OutputStream을 통해서 직렬화를 진행한다. 
		 * 
		 * 
		 * 		(1) ObjectInputStream / ObjectOutputStream
		 * 			- ObjectInputStream : 역직렬화 (스트림으로부터 객체를 입력)
		 * 			- ObjectOutputStream : 직렬화 (스트림에 객체를 출력)
		 * 
		 * 			[참고] ObjectStream은 보조 스트림으로서, 객체 생성 시에 입출력 (직렬화/역직렬화)할 스트림(Input/OutputStream)을 지정해야한다.
		 * 				(1.1) 직렬화
		 * 					#1 출력 스트림 생성 
		 * 						- FileOutputStream fos = new FileOutputStream("objectfile.ser");
		 * 
		 * 					#2 출력 스트림을 기반으로 보조 스트림 생성
		 * 						- ObjectOutputStream out = new ObjectOutputStream(fos);
		 * 
		 * 					#3 객체를 파일에 직렬화하여 저장
		 * 						- out.writeObject(new UserInfo()); 
		 * 
		 * 				(1.2) 역직렬화
		 * 					#1 입력 스트림 생성
		 * 						- FileInputStream fis = new FileInputStream("objectfile.ser");
		 * 
		 * 					#2 입력 스트림을 기반으로 보조 스트림 생성
		 * 						- ObjectInputStream in = new ObjectInputStream(fis);
		 * 
		 * 					#3 파일에 저장된 객체 정보를 읽어온다.
		 * 						- UserInfo info = (UserInfo)in.readObject();
		 * 
		 * 		(2) 직렬화와 상속의 관계
		 * 			- 조상 클래스에서 Serializable을 구현했다면 자손 클래스에서 따로 구현할 필요 없이, 자손 클래스가 직렬화 할 때 조상 클래스의 인스턴스 변수도 같이 직렬화된다.
		 * 			- 조상 클래스에서 Serializable을 구현하지 않았다면, 자손 클래스가 직렬화할 때 조상 클래스의 인스턴스 변수는 직렬화 되지 않는다.
		 * 
		 * 		(3) java.io.NotSerializableException
		 * 			- 직렬화 할 수 없다는 의미의 오류
		 * 			- Object 객체는 직렬화 할 수 없으므로 Object 직렬화 시, 위와 같은 에러가 발생한다.
		 * 			- 단, Object obj = new String("123");와 같이 실제로 연결된 객체가 String같은 직렬화 가능한 인스턴스인 경우에는 직렬화 할 수 있다.
		 * 
		 * 			(3.1) transient
		 * 				- 직렬화 대상에서 제외하는 제어자
		 * 				- 패스워드와 같이 보안상 직렬화되면 안되는 값에 대해서 사용한다.
		 * 				- 해당 키워드가 붙은 인스턴스 변수의 값은 그 타입의 기본 값으로 직렬화된다.
		 * 
		 * 		(4) serialVersionUID
		 * 			- 객체를 직렬화 할 떄와 역직렬화 할 때의 클래스의 버전은 같아야 한다.
		 * 			- 만약 이 클래스의 버전이 다른 경우 예외가 발생하게되는데 이를 방지하기위해서 객체가 직렬화될 때 
		 * 			- 클래스에 정의된 멤버들의 정보를 이용해서 serialVersionUID 클래스의 버전을 자동생성하여 직렬화 내용에 포함한다. 
		 * 			- 이 버전을 기반으로 역질렬화 할 때 클래스의 버전을 비교함으로써 직렬화할 때의 클래스의 버전과 일치하는지 확인할 수 있다.
		 *
		 *			# 클래스의 버전을 수동으로 관리하는 방법
		 *				- 클래스 내에 따로 UID를 정의하는 경우 클래스의 내용이 변경되어도 클래스의 버전이 자동생성된 값으로 변하지 않는다.
		 *				- UID의 값은 정수 값이면 어떤 값으로도 지정할 수 있으나 서로 다른 클래스 간에 같은 값을 갖지 않도록 하는 것이 일반적이다.
		 * 
		 * 				class MyData implements java.io.Serializable {
		 * 					static final long serialVersionUID = 3518731767529258119L;
		 * 					int value1;
		 * 				}
		 * 
		 * 			[참고] static, transient가 있는 경우에는 직렬화에 영향을 미치지 않으므로 버전을 다르게 인식하도록 할 필요가 없다.
		 * 
		 * 
		 * 
		 */
		String fileName = "Ex3_UserInfo.ser";
		FileOutputStream fis = new FileOutputStream(fileName);
		BufferedOutputStream bis = new BufferedOutputStream(fis);
		ObjectOutputStream out = new ObjectOutputStream(bis);
		
		Ex3_UserInfo u1 = new Ex3_UserInfo("Kim", "1234", 30);
		Ex3_UserInfo u2 = new Ex3_UserInfo("Lee", "4321", 20);
		
		ArrayList<Ex3_UserInfo> list = new ArrayList<>();
		list.add(u1);
		list.add(u2);
		
		// 객체 직렬화
		out.writeObject(u1);
		out.writeObject(u2);
		out.writeObject(list);
		out.close();
		
		System.out.println("직렬화 완료");
	}
}

