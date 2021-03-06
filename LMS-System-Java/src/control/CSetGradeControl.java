package control;

import java.util.Vector;

import DAO.DBDAO;
import entity.CCourse;
import entity.CEnroll;

public class CSetGradeControl extends CControl {
	public CSetGradeControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Vector<CCourse> getCourse() throws Exception {
		Vector<CCourse> courseList = null;
		this.getDao().connect("", "");
		courseList = this.getDao().readCourseListP(
				this.getDao().getUser().getID());
		this.getDao().disconnect();
		return courseList;
	}

	public Vector<CEnroll> getEnroll(String ID) throws Exception {
		Vector<CEnroll> enrollList = null;
		this.getDao().connect("", "");
		enrollList = this.getDao().readGradeListP(ID);
		this.getDao().disconnect();
		return enrollList;
	}

	public void setGrade(Vector<CEnroll> enrollList) throws Exception {
		this.getDao().connect("", "");
		this.getDao().updateGradeList(enrollList);
		this.getDao().disconnect();
	}
}
