package view;

import java.util.Scanner;

import main.Constant.EEvent;
import control.CMakeCourseControl;
import entity.CCourse;

public class CMakeCourseView extends CView {
	public CMakeCourseView() {
		this.setControl(new CMakeCourseControl());
	}

	public EEvent show(Scanner scanner, String title)
			throws Exception {
		EEvent selection;
		String professorID = this.getControl().getDao().getUser().getID();
		CCourse course = new CCourse();
		String courseID;
		
		newLine();
		System.out.println("[���°���]");
		while(true)
		{
			error = false;
			System.out.print("��ȣ: ");
			courseID = scanner.next();
			error = this.getControl().getDao().existCourseID(courseID);
			if(error)
			{
				System.out.println("�ش� ���¹�ȣ�� �ֽ��ϴ�. �ٸ� ���¹�ȣ�� �Է����ּ���.");
				continue;
			}
			else
			{
				break;
			}
		}
		course.setID(courseID);
		System.out.print("�̸�: ");
		course.setName(scanner.next());	
		course.setProfessorID(professorID);

		((CMakeCourseControl) this.getControl()).make(course);
		
		System.out.println("���°��� �Ǿ����ϴ�.");
		selection = EEvent.eProfessor;
		return selection;
	}
}
