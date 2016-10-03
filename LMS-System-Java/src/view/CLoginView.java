package view;

import java.util.Scanner;

import main.Constant.EEvent;
import control.CLoginControl;
import entity.VLogin;
import entity.VUser;
import entity.VUser.EUserType;

public class CLoginView extends CView {
	public CLoginView() {
		this.setControl(new CLoginControl());
	}

	public EEvent show(Scanner scanner, String title)
			throws Exception {
		newLine();
		System.out.println("[로그인]");
		VLogin vLogin = new VLogin();
		System.out.print("아이디입력: ");
		String userId = scanner.next();
		System.out.print("비밀번호입력: ");
		String password = scanner.next();
		vLogin.setID(userId);
		vLogin.setPw(password);

		VUser vUser = null;
		EEvent selection = null;
		vUser = ((CLoginControl) this.getControl()).login(vLogin);

		if(vUser == null)
		{
			return EEvent.eMain;
		}
		
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
