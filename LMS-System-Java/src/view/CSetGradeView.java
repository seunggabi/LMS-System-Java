package view;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CSetGradeControl;
import entity.CCourse;
import entity.CEnroll;

public class CSetGradeView extends CView {
	public CSetGradeView() {
		this.setControl(new CSetGradeControl());
	}

	public EEvent show(Scanner scanner, String title) throws Exception {
		EEvent selection;
		String courseNumber;
		Vector<CCourse> courseList = ((CSetGradeControl) this.getControl())
				.getCourse();
		HashMap<String, Boolean> map = new HashMap<String, Boolean>();

		newLine();
		System.out.println("[성적입력]");
		System.out.println("******************* 개설한 강좌목록 *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID() + " " + course.getName());
			map.put(course.getID(), true);
		}
		System.out.println("*************************************************");

		while (true) {
			error = false;
			System.out.print("성적입력 강좌번호: ");
			courseNumber = scanner.next();

			error = !map.containsKey(courseNumber);
			if (error) {
				System.out.println("자신이 개설한 강좌만 성적을 입력할 수 있습니다.");
				continue;
			} else {
				break;
			}
		}

		System.out.println("******************* 수강학생 성적입력 *******************");
		Vector<CEnroll> enrollList = ((CSetGradeControl) this.getControl())
				.getEnroll(courseNumber);
		String grade = null;
		for (CEnroll enroll : enrollList) {
			boolean flag = false;
			System.out.println(enroll.getStudentID() + " "
					+ enroll.getStudentName());
			do {
				if(flag == true)
					System.out.println("올바르지 않은 성적입니다. 다시 입력해주세요");
				System.out.print("성적입력: ");
				grade = scanner.next();
				flag = true;
			} while (!grade.equals("A+") && !grade.equals("A0")  && !grade.equals("A-") && !grade.equals("A") 
					&& !grade.equals("B+") && !grade.equals("B0") && !grade.equals("B-") && !grade.equals("B")
					&& !grade.equals("C+") && !grade.equals("C0") && !grade.equals("C-") && !grade.equals("C")
					&& !grade.equals("D+") && !grade.equals("D0") && !grade.equals("D-") && !grade.equals("D")
					&& !grade.equals("F"));
			enroll.setGrade(grade);
		}
		System.out
				.println("**************************************************");

		System.out.println("성적입력 완료");
		((CSetGradeControl) this.getControl()).setGrade(enrollList);

		selection = EEvent.eProfessor;
		return selection;
	}
}
