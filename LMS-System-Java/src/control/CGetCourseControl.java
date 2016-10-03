package control;

import java.util.Vector;

import DAO.DBDAO;
import entity.CCourse;


public class CGetCourseControl extends CControl {
	public CGetCourseControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Vector<CCourse> getCourse() throws Exception {
		Vector<CCourse> courseList = null;
		this.getDao().connect("", "");
		courseList = this.getDao().readCourseListP(this.getDao().getUser().getID());
		this.getDao().disconnect();
		return courseList;
	}
}