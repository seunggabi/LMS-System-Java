package DAO;

import java.util.Vector;

import entity.CCourse;
import entity.CEnroll;
import entity.CEntity;
import entity.CUser;

public interface IDAO {
	// Connect & Disconnect
	public void connect(String string, String mode) throws Exception;
	public void disconnect() throws Exception;

	// File & DB
	public void create(CEntity entity) throws Exception;
	public void update(CEntity entity) throws Exception;
	public void drop(CEntity entity) throws Exception;
	public void delete(CEntity entity, String ID) throws Exception;
	public CEntity read(CEntity entity, String ID) throws Exception;
	public void write(CEntity entity) throws Exception;

	// DB
	public void createAccount() throws Exception;
	public void createDB() throws Exception;
	public void dropDB() throws Exception;
	public void dropMember() throws Exception;
	public void setUser(CUser user);
	public CUser getUser();
	public Vector<CCourse> readCourseListP(String ID) throws Exception;
	public Vector<CEnroll> readGradeListP(String ID) throws Exception;
	public void updateGradeList(Vector<CEnroll> enrollList) throws Exception;
	public Vector<CEnroll> readGradeListS(String ID) throws Exception;
	public boolean existCourseID(String courseNumber) throws Exception;
	public boolean redundancyRegistry(String courseNumber) throws Exception;
	public int enrollCount() throws Exception;
}
