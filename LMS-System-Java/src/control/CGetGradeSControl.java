package control;

import java.util.Vector;

import DAO.DBDAO;
import entity.CEnroll;


public class CGetGradeSControl extends CControl {
	public CGetGradeSControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public Vector<CEnroll> getGrade() throws Exception {
		String ID = this.getDao().getUser().getID();
		Vector<CEnroll> enrollList = null;
		this.getDao().connect("", "");
		enrollList = this.getDao().readGradeListS(ID);
		this.getDao().disconnect();
		return enrollList;
	}
}