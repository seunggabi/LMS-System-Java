package view;

import java.util.Scanner;
import java.util.Vector;

import main.Constant.EEvent;
import control.CGetGradeSControl;
import entity.CEnroll;

public class CGetGradeSView extends CView {
	public CGetGradeSView() {
		this.setControl(new CGetGradeSControl());
	}

	public EEvent show(Scanner scanner, String title)
			throws Exception {
		EEvent selection;
		Vector<CEnroll> enrollList = ((CGetGradeSControl) this.getControl()).getGrade();
		
		newLine();
		System.out.println("[������ȸ]");
		System.out.println("******************* �������� ������� *******************");
		for (CEnroll enroll : enrollList) {
			System.out.println(enroll.getCourseID()+" "+enroll.getCourseName()+" "+enroll.getGrade());
		}
		System.out.println("**************************************************");
		
		selection = EEvent.eStudent;
		return selection;
	}
}