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
		System.out.println("[회원가입]");
		System.out.print("아이디입력: ");
		user.setID(scanner.next());
		System.out.print("비밀번호입력: ");
		user.setPw(scanner.next());
		System.out.print("이름: ");
		user.setName(scanner.next());
		
		do {
			error = false;
			System.out.print("유형(학생0, 교수1): ");
			type = scanner.nextInt();
			if(type != 0 && type != 1)
			{
				error = true;
				System.out.println("가입유형은 학생(0), 교수(1)로 입력해야 합니다.");
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

		System.out.println("회원가입 되었습니다.");
		System.out.println("로그인 되었습니다.");
		if (vUser.geteUserType() == EUserType.EProfessor) {
			selection = EEvent.eProfessor;
		} else {
			selection = EEvent.eStudent;
			return selection;
		}
		return selection;
	}

}
