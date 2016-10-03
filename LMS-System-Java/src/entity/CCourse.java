package entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CCourse extends CEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String name;
	private String professorID;

	public CCourse() {
	}

	public CCourse(String id, String name, String professorID) {
		this.ID = id;
		this.name = name;
		this.professorID = professorID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getProfessorID() {
		return professorID;
	}

	public void setProfessorID(String professorID) {
		this.professorID = professorID;
	}

	@Override
	public void DBRead(ResultSet rs) throws SQLException {
		rs.getInt("no");
		ID = rs.getString("id");
		name = rs.getString("name");
		professorID = rs.getString("professor_id");
	}

	@Override
	public void DBWrite(Connection connection) throws SQLException {
		String sql = "INSERT INTO gangjwa (id, name, professor_id) VALUES ( ?, ?, ? );";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		statement.setString(2, name);
		statement.setString(3, professorID);
		statement.executeUpdate();
	}

	@Override
	public void DBCreate(Connection connection) throws SQLException {
		String sql = "CREATE TABLE gangjwa ( NO INT(11) AUTO_INCREMENT"
				+ ", ID VARCHAR(20)" + ", name VARCHAR(20)" + ", PROFESSOR_ID VARCHAR(20));";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	@Override
	public void DBDelete(Connection connection, String ID) throws SQLException {
		String sql = "DELETE FROM gangjwa";
		if (!ID.equals("*"))
			sql += " WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		if (!ID.equals("*"))
			statement.setString(1, ID);
		statement.executeUpdate();
	}

	@Override
	public void DBDrop(Connection connection) throws SQLException {
		String sql = "DROP TABLE gangjwa;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}

	@Override
	public CEntity newObject() {
		return new CUser();
	}
}
