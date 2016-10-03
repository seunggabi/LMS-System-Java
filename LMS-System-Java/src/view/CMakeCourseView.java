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
		System.out.println("[강좌개설]");
		while(true)
		{
			error = false;
			System.out.print("번호: ");
			courseID = scanner.next();
			error = this.getControl().getDao().existCourseID(courseID);
			if(error)
			{
				System.out.println("해당 강좌번호가 있습니다. 다른 강좌번호를 입력해주세요.");
				continue;
			}
			else
			{
				break;
			}
		}
		course.setID(courseID);
		System.out.print("이름: ");
		course.setName(scanner.next());	
		course.setProfessorID(professorID);

		((CMakeCourseControl) this.getControl()).make(course);
		
		System.out.println("강좌개설 되었습니다.");
		selection = EEvent.eProfessor;
		return selection;
	}
}
