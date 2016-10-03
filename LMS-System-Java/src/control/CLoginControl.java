package control;

import DAO.DBDAO;
import entity.CUser;
import entity.VLogin;
import entity.VUser;

public class CLoginControl extends CControl {
	public CLoginControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public VUser login(VLogin vLogin) throws Exception {
		VUser vUser = new VUser();
		CUser user = new CUser();
		this.getDao().connect("", "");
		user = (CUser) this.getDao().read(user, vLogin.getID());
		this.getDao().disconnect();

		if (user == null) {
			System.out.println("ȸ���� �ƴմϴ�.");
			return null;
		}
		if (!user.getPw().equals(vLogin.getPw()))
		{
			System.out.println("�н����尡 Ʋ�Ƚ��ϴ�.");
			return null;
		}
		vUser.setName(user.getName());
		vUser.setID(user.getID());
		vUser.seteUserType(user.getType());

		this.getDao().setUser(user);

		return vUser;
	}
}
