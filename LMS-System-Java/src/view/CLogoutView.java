package view;

import java.util.Scanner;

import main.Constant.EEvent;

public class CLogoutView extends CView {

	@Override
	public EEvent show(Scanner scanner, String title) throws Exception {
		System.out.println("�α׾ƿ� �Ǿ����ϴ�.");
		return EEvent.eLogout;
	}

}
