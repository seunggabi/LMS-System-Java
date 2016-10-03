package view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CRegisterCourseControl;
import entity.CCourse;

public class CRegisterCourseView extends CView {
	public CRegisterCourseView() {
		this.setControl(new CRegisterCourseControl());
	}

	public EEvent show(Scanner scanner, String title) throws Exception {
		EEvent selection;
		String courseNumber;
		Vector<CCourse> courseList = ((CRegisterCourseControl) this.getControl())
				.getCourse();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		newLine();
		System.out.println("[수강신청]");
		System.out.println("******************* 개설된 강좌목록 *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID() + " " + course.getName()  + " " + course.getProfessorID() );
			map.put(course.getID(), true);
		}
		System.out.println("*************************************************");
		
		if(map.size() == this.getControl().getDao().enrollCount())
		{
			System.out.println("모든 과목을 수강신청하셨습니다.");
			selection = EEvent.eStudent;
			return selection;
		}
		
		while(true)
		{
			error = false;
			System.out.print("수강신청 강좌번호: ");
			courseNumber = scanner.next();
			
			error = !map.containsKey(courseNumber);
			if(error)
			{
				System.out.println("개설된 강좌만 수강신청할 수 있습니다.");
				continue;
			}
			
			error = this.getControl().getDao().redundancyRegistry(courseNumber);
			if(error)
			{
				System.out.println("수강신청한 강좌 입니다.");
				continue;
			}
			else
			{
				break;
			}
		}
		
		((CRegisterCourseControl) this.getControl()).setEnroll(courseNumber);
		
		System.out.println("수강신청 되었습니다.");
		selection = EEvent.eStudent;
		return selection;
	}
}
