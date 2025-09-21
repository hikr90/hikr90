package ex1_annotation;

import java.util.ArrayList;

public class Ex1_Annotation {
		/*	������̼�
		 * 		- ���α׷� ������ Ư�� ����� �����ϵ��� �ϴ� ���
		 * 		- ���ǵ� ������ �������� �ۼ��Ѵ�.
		 * 		
		 * 		ǥ�� ������̼�
		 * 			(1) @Override
		 * 				- �����Ϸ����� �������̵��ϴ� �޼ҵ����� ǥ��
		 * 				- �������̵� �� ��Ÿ�� ���ؼ� �޼ҵ���� �߸� �Է��ϴ� ��쿡, �ش� ������̼��� ���� �� ���� �ش� �޼ҵ尡 ���� ��� ���� ��ȯ
		 * 
		 * 			(2) @Deprecated
		 * 				- ������ ������� ���� ���� �����ϴ� ������� ǥ��
		 * 				- Date Ŭ������ Calendar Ŭ������ ��ü�Ǿ��� �� �ش� ������̼����� getDate���� �޼ҵ尡 ������ ������� ������ ǥ���ߴ�.
		 * 				- �ش� ������̼��� �ִ� �޼ҵ尡 ���۵Ǵ� ��� ������ �� ��� �޼����� ��Ÿ����. (�������� �����Ƿ� �����Ѵ�.)
		 * 
		 * 			(3) @SuppressWarnings
		 * 				- �����Ϸ��� Ư�� ��� �޼����� ��Ÿ���� �ʰ� ��
		 * 				- @SuppressWarnings("") �ȿ� ���� �߰��Ͽ� Ư�� ���� ��Ȳ�� ������ �� �ִ�.
		 * 				- value = {} �� ���·� ���� ���� ���� ó���� �����ϴ�.
		 * 		  
		 * 			(4) @SafeVarargs
		 * 				- ���׸��� Ÿ���� �������ڿ� ���
		 * 				- static, final�� ���� �޼ҵ忡���� ����� �� �ִ�.
		 * 
		 * 			(5) @FunctionallInterface
		 * 				- �Լ��� �������̽����� ǥ��
		 * 				- �Լ��� �������̽��� �߻� �޼ҵ尡 �ϳ��� �־���Ѵٴ� ������ �ִ�. (�ش� ������ �����Ϸ��� üũ�ϵ��� ����)
		 * 
		 * 			(6) @Native
		 * 				- native �޼ҵ忡�� �����Ǵ� ��� �տ� ��� 
		 */		
		
		// Deprecated ���� ����
		// - ���� ��� ������̼ǿ��� Deprecaated�� unchecked �� ��� ���� ó���� �����ϴ�.
		// - �ٸ� �׷��� �� ��� ���߿� �߰��� �ڵ忡�� �߻��� ����� ������ �� �����Ƿ� �ش� ��󿡸� ������̼��� ����Ͽ� ���� ���� �ּ�ȭ
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
	
	// ���� x
	@Deprecated
	int oldField;
	
	@Deprecated
	int getOldField() {
		return oldField;
	}
}