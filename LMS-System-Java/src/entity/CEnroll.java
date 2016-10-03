package entity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CEnroll extends CEntity {
	private static final long serialVersionUID = 1L;
	private int no;
	private String courseID;
	private String grade;
	private String studentName;
	private String studentID;
	private String courseName;

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentID() {
		return studentID;
	}

	public void setStudentID(String studentID) {
		this.studentID = studentID;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getCourseID() {
		return courseID;
	}

	public void setCourseID(String course_id) {
		this.courseID = course_id;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public CEnroll() {
	}

	public CEnroll(String id, String courseID, String grade) {
		this.ID = id;
		this.courseID = courseID;
		this.grade = grade;
	}

	public void read(Scanner scanner) {
		ID = scanner.next();
		grade = scanner.next();
	}

	@Override
	public void DBRead(ResultSet rs) throws SQLException {
		no = rs.getInt("s.no");
		ID = rs.getString("s.member_id");
		courseID = rs.getString("s.gangjwa_id");
		grade = rs.getString("s.hakjeom");
		studentName = rs.getString("m.name");
		studentID= rs.getString("m.id");
		courseName = rs.getString("g.name");
	}

	@Override
	public void DBWrite(Connection connection) throws SQLException {
		String sql = "INSERT INTO sugang (member_id, gangjwa_id, hakjeom) VALUES ( ?, ?, ? );";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		statement.setString(2, courseID);
		statement.setString(3, grade);
		statement.executeUpdate();
	}

	@Override
	public void DBCreate(Connection connection) throws SQLException {
		String sql = "CREATE TABLE sugang ( NO INT(11) AUTO_INCREMENT"
				+ ", ID VARCHAR(20)" + ", courseID VARCHAR(20)"
				+ ", hakjeom VARCHAR(20));";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	@Override
	public void DBDelete(Connection connection, String ID) throws SQLException {
		String sql = "DELETE FROM sugang";
		if (!ID.equals("*"))
			sql += " WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		if (!ID.equals("*"))
			statement.setString(1, ID);
		statement.executeUpdate();
	}

	@Override
	public void DBDrop(Connection connection) throws SQLException {
		String sql = "DROP TABLE sugang;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	@Override
	public CEntity newObject() {
		return new CUser();
	}
}
