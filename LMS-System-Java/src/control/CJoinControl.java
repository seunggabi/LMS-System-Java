package control;

import DAO.DBDAO;
import entity.CUser;

public class CJoinControl extends CControl {
	public CJoinControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void join(CUser user) throws Exception {
		this.setDao(DBDAO.getInstance());
		this.getDao().connect("", "");
		this.getDao().write(user);
		this.getDao().disconnect();
		this.getDao().setUser(user);
	}
}
