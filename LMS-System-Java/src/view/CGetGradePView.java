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
		System.out.println("[������ȸ]");
		System.out.println("******************* ������ ���¸�� *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID()+" "+course.getName());
			map.put(course.getID(), true);
		}
		System.out.println("*************************************************");
		while(true)
		{
			error = false;
			System.out.print("������ȸ ���¹�ȣ: ");
			courseNumber = scanner.next();

			error = !map.containsKey(courseNumber);
			if(error)
			{
				System.out.println("�ڽ��� ������ ���¸� ������ �Է��� �� �ֽ��ϴ�.");
				continue;
			}
			else
			{
				break;
			}
		}
		
		System.out.println("******************* �����л� ������� *******************");
		Vector<CEnroll> enrollList = ((CGetGradePControl) this.getControl()).getEnroll(courseNumber);
		for (CEnroll enroll : enrollList) {
			System.out.println(enroll.getStudentID()+" "+enroll.getStudentName()+" "+enroll.getGrade());
		}
		System.out.println("**************************************************");		
		selection = EEvent.eProfessor;
		return selection;
	}
}
