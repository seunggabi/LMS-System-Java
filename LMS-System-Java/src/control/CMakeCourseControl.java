package control;

import DAO.DBDAO;
import entity.CCourse;

public class CMakeCourseControl extends CControl {
	public CMakeCourseControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void make(CCourse course) throws Exception {
		this.getDao().connect("", "");
		this.getDao().write(course);
		this.getDao().disconnect();
	}
}
