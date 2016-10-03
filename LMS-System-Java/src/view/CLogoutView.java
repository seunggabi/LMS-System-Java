package view;

import java.util.Scanner;

import main.Constant.EEvent;

public class CLogoutView extends CView {

	@Override
	public EEvent show(Scanner scanner, String title) throws Exception {
		System.out.println("로그아웃 되었습니다.");
		return EEvent.eLogout;
	}

}
