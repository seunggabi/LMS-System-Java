package control;

import java.util.Vector;

import DAO.DBDAO;
import entity.CCourse;
import entity.CEnroll;


public class CRegisterCourseControl extends CControl {
	public CRegisterCourseControl() {
		try {
			this.setDao(DBDAO.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public Vector<CCourse> getCourse() throws Exception {
		Vector<CCourse> courseList = null;
		this.getDao().connect("", "");
		courseList = this.getDao().readCourseListP("");
		this.getDao().disconnect();
		return courseList;
	}
	
	public void setEnroll(String courseNumber) throws Exception {
		String studentID = this.getDao().getUser().getID();
		CEnroll enroll = new CEnroll();
		enroll.setID(studentID);
		enroll.setCourseID(courseNumber);
		
		this.getDao().connect("", "");
		this.getDao().write(enroll);
		this.getDao().disconnect();
	}
}