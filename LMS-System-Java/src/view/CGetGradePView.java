package view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CGetGradePControl;
import entity.CCourse;
import entity.CEnroll;

public class CGetGradePView extends CView {
	public CGetGradePView() {
		this.setControl(new CGetGradePControl());
	}

	public EEvent show(Scanner scanner, String title)
			throws Exception {
		EEvent selection;
		String courseNumber;
		Vector<CCourse> courseList = ((CGetGradePControl) this.getControl()).getCourse();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();
		
		newLine();
		System.out.println("[성적조회]");
		System.out.println("******************* 개설한 강좌목록 *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID()+" "+course.getName());
			map.put(course.getID(), true);
		}
		System.out.println("*************************************************");
		while(true)
		{
			error = false;
			System.out.print("성적조회 강좌번호: ");
			courseNumber = scanner.next();

			error = !map.containsKey(courseNumber);
			if(error)
			{
				System.out.println("자신이 개설한 강좌만 성적을 입력할 수 있습니다.");
				continue;
			}
			else
			{
				break;
			}
		}
		
		System.out.println("******************* 수강학생 성적목록 *******************");
		Vector<CEnroll> enrollList = ((CGetGradePControl) this.getControl()).getEnroll(courseNumber);
		for (CEnroll enroll : enrollList) {
			System.out.println(enroll.getStudentID()+" "+enroll.getStudentName()+" "+enroll.getGrade());
		}
		System.out.println("**************************************************");		
		selection = EEvent.eProfessor;
		return selection;
	}
}
