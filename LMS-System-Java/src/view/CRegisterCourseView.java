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
		System.out.println("[������û]");
		System.out.println("******************* ������ ���¸�� *******************");
		for (CCourse course : courseList) {
			System.out.println(course.getID() + " " + course.getName()  + " " + course.getProfessorID() );
			map.put(course.getID(), true);
		}
		System.out.println("*************************************************");
		
		if(map.size() == this.getControl().getDao().enrollCount())
		{
			System.out.println("��� ������ ������û�ϼ̽��ϴ�.");
			selection = EEvent.eStudent;
			return selection;
		}
		
		while(true)
		{
			error = false;
			System.out.print("������û ���¹�ȣ: ");
			courseNumber = scanner.next();
			
			error = !map.containsKey(courseNumber);
			if(error)
			{
				System.out.println("������ ���¸� ������û�� �� �ֽ��ϴ�.");
				continue;
			}
			
			error = this.getControl().getDao().redundancyRegistry(courseNumber);
			if(error)
			{
				System.out.println("������û�� ���� �Դϴ�.");
				continue;
			}
			else
			{
				break;
			}
		}
		
		((CRegisterCourseControl) this.getControl()).setEnroll(courseNumber);
		
		System.out.println("������û �Ǿ����ϴ�.");
		selection = EEvent.eStudent;
		return selection;
	}
}
