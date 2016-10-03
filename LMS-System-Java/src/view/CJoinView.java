package view;

import java.util.Scanner;

import main.Constant.EEvent;
import control.CJoinControl;
import entity.CUser;
import entity.VUser;
import entity.VUser.EUserType;

public class CJoinView extends CView {
	public CJoinView() {
		this.setControl(new CJoinControl());
	}

	public EEvent show(Scanner scanner, String title) throws Exception {
		int type = 0;
		String typeName = null;
		CUser user = new CUser();
		newLine();
		System.out.println("[ȸ������]");
		System.out.print("���̵��Է�: ");
		user.setID(scanner.next());
		System.out.print("��й�ȣ�Է�: ");
		user.setPw(scanner.next());
		System.out.print("�̸�: ");
		user.setName(scanner.next());
		
		do {
			error = false;
			System.out.print("����(�л�0, ����1): ");
			type = scanner.nextInt();
			if(type != 0 && type != 1)
			{
				error = true;
				System.out.println("���������� �л�(0), ����(1)�� �Է��ؾ� �մϴ�.");
			}
			else
			{
				if(type == 0)
					typeName = "stu";
				else
					typeName = "prof";
			}
		} while (error);

		user.setType(typeName);
		
		EEvent selection = null;
		((CJoinControl) this.getControl()).join(user);

		VUser vUser = new VUser();
		vUser.seteUserType(user.getType());

		System.out.println("ȸ������ �Ǿ����ϴ�.");
		System.out.println("�α��� �Ǿ����ϴ�.");
		if (vUser.geteUserType() == EUserType.EProfessor) {
			selection = EEvent.eProfessor;
		} else {
			selection = EEvent.eStudent;
			return selection;
		}
		return selection;
	}

}
