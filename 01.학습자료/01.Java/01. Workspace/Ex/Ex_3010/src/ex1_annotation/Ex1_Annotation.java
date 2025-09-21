package ex1_annotation;

import java.util.ArrayList;

public class Ex1_Annotation {
		/*	어노테이션
		 * 		- 프로그램 내에서 특정 기능을 수행하도록 하는 기술
		 * 		- 정의된 종류와 형식으로 작성한다.
		 * 		
		 * 		표준 어노테이션
		 * 			(1) @Override
		 * 				- 컴파일러에게 오버라이딩하는 메소드임을 표시
		 * 				- 오버라이딩 시 오타로 인해서 메소드명을 잘못 입력하는 경우에, 해당 어노테이션이 있을 때 조상에 해당 메소드가 없는 경우 오류 반환
		 * 
		 * 			(2) @Deprecated
		 * 				- 앞으로 사용하지 않을 것을 권장하는 대상임을 표시
		 * 				- Date 클래스가 Calendar 클래스로 대체되었을 때 해당 어노테이션으로 getDate등의 메소드가 앞으로 권장되지 않음을 표시했다.
		 * 				- 해당 어노테이션이 있는 메소드가 동작되는 경우 컴파일 시 경고 메세지가 나타난다. (강제성은 없으므로 동작한다.)
		 * 
		 * 			(3) @SuppressWarnings
		 * 				- 컴파일러의 특정 경고 메세지가 나타나지 않게 함
		 * 				- @SuppressWarnings("") 안에 변수 추가하여 특정 에러 상황을 무시할 수 있다.
		 * 				- value = {} 의 형태로 여러 개의 에러 처리가 가능하다.
		 * 		  
		 * 			(4) @SafeVarargs
		 * 				- 제네릭스 타입의 가변인자에 사용
		 * 				- static, final이 붙은 메소드에서만 사용할 수 있다.
		 * 
		 * 			(5) @FunctionallInterface
		 * 				- 함수형 인터페이스임을 표시
		 * 				- 함수형 인터페이스는 추상 메소드가 하나만 있어야한다는 제약이 있다. (해당 제약을 컴파일러가 체크하도록 수행)
		 * 
		 * 			(6) @Native
		 * 				- native 메소드에서 참조되는 상수 앞에 사용 
		 */		
		
		// Deprecated 에러 억제
		// - 위의 경고 어노테이션에서 Deprecaated와 unchecked 두 경고 동시 처리가 가능하다.
		// - 다만 그렇게 할 경우 나중에 추가된 코드에서 발생할 경고마저 억제될 수 있으므로 해당 대상에만 어노테이션을 사용하여 억제 범위 최소화
		@SuppressWarnings("Deprecated")
		public static void main(String args) {
			//
			NewClass nc = new NewClass();
			
			nc.oldField = 10;
			System.out.println(nc.getOldField());
			
			@SuppressWarnings("unchecked")
			ArrayList<NewClass> list = new ArrayList<>();
			list.add(nc);
	}
}

class NewClass {
	int newField;
	
	int getField() {
		return newField;
	}
	
	// 권장 x
	@Deprecated
	int oldField;
	
	@Deprecated
	int getOldField() {
		return oldField;
	}
}