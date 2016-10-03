package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import entity.CCourse;
import entity.CEnroll;
import entity.CEntity;
import entity.CUser;

public class DBDAO implements IDAO {
	private final static String DRIVER = "com.mysql.jdbc.Driver";
	private static String URL = "jdbc:mysql://localhost:3306/javalms";
	private static String ID = "root";
	private static String pw = "autoset";
	private static DBDAO instance = null;

	private CUser user = null;
	private Connection connection;
	private PreparedStatement statement;
	private ResultSet resultSet;

	public CUser getUser() {
		return user;
	}

	public void setUser(CUser user) {
		this.user = user;
	}

	private DBDAO() throws ClassNotFoundException {
		Class.forName(DRIVER);
	}

	public static DBDAO getInstance() throws ClassNotFoundException {
		if (instance == null)
			instance = new DBDAO();
		return instance;
	}

	@Override
	public void connect(String string, String mode) throws Exception {
		if (string == null)
			connection = DriverManager.getConnection(URL + string, ID, pw);
		else
			connection = DriverManager.getConnection(URL, ID, pw);
	}

	@Override
	public void disconnect() throws Exception {
		if (connection != null)
			connection.close();
		if (statement != null)
			statement.close();
		if (resultSet != null)
			resultSet.close();
	}

	@Override
	public CEntity read(CEntity entity, String ID) throws Exception {
		connect("", "");
		String sql = "SELECT * FROM member";
		statement = connection.prepareStatement(sql);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			entity.DBRead(resultSet);
			if (entity.getID().equals(ID)) {
				return entity;
			}
		}
		return null;
	}
	
	@Override
	public void createAccount() throws Exception {
		connect("", "");
		String sql = "GRANT ALL PRIVILEGES ON *.* TO java@localhost IDENTIFIED BY 'mju12345' WITH GRANT OPTION;";
		statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		ID = "java";
		disconnect();
		System.out.println("[java Account Create & ID java Change]");
	}

	@Override
	public void createDB() throws Exception {
		connect("", "");
		String sql = "CREATE DATABASE javaDB;";
		statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		URL = "jdbc:mysql://localhost:3306/javaDB";
		disconnect();
		System.out.println("[javaDB DataBase Create]");
	}

	public void create(CEntity entity) throws Exception {
		connect("", "");
		entity.DBCreate(connection);
		disconnect();
		System.out.println("[member Table Create]");
	}

	public void write(CEntity entity) throws Exception {
		connect("", "");
		entity.DBWrite(connection);
		disconnect();
	}

	public void updateData() throws Exception {
		connect("", "");
		String sql = "UPDATE member SET id=?, pw=?, name=? WHERE id=?;";
		statement = connection.prepareStatement(sql);
		statement.setString(1, "id5");
		statement.setString(2, "pw5");
		statement.setString(3, "name5");
		statement.setString(4, "id0");
		statement.executeUpdate();
		disconnect();
		System.out.println("[Data Update (0->5)]");
	}

	public void delete(CEntity entity, String ID) throws Exception {
		connect("", "");
		entity.DBDelete(connection, ID);
		disconnect();
	}

	public void drop(CEntity entity) throws Exception {
		connect("", "");
		entity.DBDrop(connection);
		disconnect();
		System.out.println("[Table Drop]");
	}

	public void dropDB() throws Exception {
		URL = "jdbc:mysql://localhost:3306/";
		connect("", "");
		String sql = "DROP DataBase javaDB;";
		statement = connection.prepareStatement(sql);
		statement.executeUpdate(sql);
		disconnect();
		System.out.println("[DataBase Drop]");
	}

	public void dropMember() throws Exception {
		ID = "root";
		connect("", "");
		String sql = "DROP member 'java'@localhost;";
		statement = connection.prepareStatement(sql);
		statement.executeUpdate();
		disconnect();
		System.out.println("[member Drop]");
	}

	@Override
	public void update(CEntity entity) throws Exception {
		updateData();
	}

	public Vector<CCourse> readCourseListP(String ID) throws Exception {
		Vector<CCourse> courseList = new Vector<CCourse>();
		connect("", "");
		String sql;
		if(!ID.equals(""))
			sql = "SELECT * FROM gangjwa " + "WHERE professor_id = ?";
		else
			sql = "SELECT * FROM gangjwa";
		
		statement = connection.prepareStatement(sql);
		
		if(!ID.equals(""))
			statement.setString(1, ID);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			CCourse entity = new CCourse();
			entity.DBRead(resultSet);
			courseList.add(entity);
		}
		return courseList;
	}

	@Override
	public Vector<CEnroll> readGradeListP(String ID) throws Exception {
		Vector<CEnroll> enrollList = new Vector<CEnroll>();
		connect("", "");
		String sql = "SELECT * FROM ( sugang s JOIN member m ON s.member_id = m.id ) JOIN gangjwa g ON s.member_id = m.id AND s.gangjwa_id = g.id "
				+ " WHERE gangjwa_id = ?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			CEnroll entity = new CEnroll();
			entity.DBRead(resultSet);
			enrollList.add(entity);
		}
		return enrollList;
	}

	@Override
	public void updateGradeList(Vector<CEnroll> enrollList) throws Exception {
		String studentID;
		String courseID;
		String grade;

		String sql = "UPDATE sugang SET hakjeom = ? WHERE member_id = ? AND gangjwa_id = ?";
		statement = connection.prepareStatement(sql);

		for (CEnroll enroll : enrollList) {
			studentID = enroll.getStudentID();
			courseID = enroll.getCourseID();
			grade = enroll.getGrade();

			statement.setString(1, grade);
			statement.setString(2, studentID);
			statement.setString(3, courseID);
			statement.executeUpdate();
		}
	}

	@Override
	public Vector<CEnroll> readGradeListS(String ID) throws Exception {
		Vector<CEnroll> courseList = new Vector<CEnroll>();
		connect("", "");
		String sql = "SELECT * FROM ( sugang s JOIN gangjwa g ON g.id = s.gangjwa_id ) JOIN member m ON s.member_id = m.id "
				+ "WHERE m.id = ?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		resultSet = statement.executeQuery();
		while (resultSet.next()) {
			CEnroll entity = new CEnroll();
			entity.DBRead(resultSet);
			courseList.add(entity);
		}
		return courseList;
	}
	
	public boolean existCourseID(String courseNumber) throws Exception
	{
		int count=0;
		connect("", "");
		String sql = "SELECT * FROM gangjwa WHERE id=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, courseNumber);
		resultSet = statement.executeQuery();
		
		while(resultSet.next())
		{
			count++;
		}
		
		if(count != 0)
			return true;
		else
			return false;
	}
	
	public boolean redundancyRegistry(String courseNumber) throws Exception
	{
		int count=0;
		connect("", "");
		String sql = "SELECT * FROM sugang WHERE member_id=? AND gangjwa_id=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, user.getID());
		statement.setString(2, courseNumber);
		resultSet = statement.executeQuery();
		
		while(resultSet.next())
		{
			count++;
		}
		
		if(count != 0)
			return true;
		else
			return false;
	}
	public int enrollCount() throws Exception
	{
		int count=0;
		connect("", "");
		String sql = "SELECT count(*) as cnt FROM sugang WHERE member_id=?";
		statement = connection.prepareStatement(sql);
		statement.setString(1, user.getID());
		resultSet = statement.executeQuery();
		
		while(resultSet.next())
			count = resultSet.getInt("cnt");
		return count;
	}
}