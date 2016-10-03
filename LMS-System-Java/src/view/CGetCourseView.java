package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CGetCourseControl;
import entity.CCourse;

public class CGetCourseView extends CView {
	public CGetCourseView() {
		this.setControl(new CGetCourseControl());
	}

	public EEvent show(Scanner scanner, String title)
			throws Exception {
		EEvent selection;
		Vector<CCourse> courseList = ((CGetCourseControl) this.getControl()).getCourse();
		
		newLine();
		System.out.println("[������ȸ]");
		System.out.println("******************* ������ ���¸�� *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID()+" "+course.getName());
		}
		System.out.println("*************************************************");

		selection = EEvent.eProfessor;
		return selection;
	}
}
