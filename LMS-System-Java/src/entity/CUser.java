package entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class CUser extends CEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	private String pw;
	private String name;
	private String type;

	public CUser(){}
	public CUser(String id, String pw, String name, String type) {
		this.ID = id;
		this.pw = pw;
		this.name = name;
		this.type = type;
	}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getType() {return type;}
	public void setType(String type) {this.type = type;}
	public void read(Scanner scanner) {
		ID = scanner.next();
		pw = scanner.next();
		name = scanner.next();
		type = scanner.next();
	}
	
	@Override
	public void DBRead(ResultSet rs) throws SQLException {
		ID = rs.getString("id");
		pw = rs.getString("pw");
		name = rs.getString("name");
		type = rs.getString("type");
	}
	@Override
	public void DBWrite(Connection connection) throws SQLException {
		String sql = "INSERT INTO member (id, pw, name, type) VALUES ( ?, ?, ?, ? );";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.setString(1, ID);
		statement.setString(2, pw);
		statement.setString(3, name);
		statement.setString(4, type);
		statement.executeUpdate();
	}
	@Override
	public void DBCreate(Connection connection) throws SQLException {
		String sql = "CREATE TABLE member ( id VARCHAR(20) PRIMARY KEY"
				+ ", pw VARCHAR(20)" + ", name VARCHAR(20)" + ", type VARCHAR(20) );";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}
	@Override
	public void DBDelete(Connection connection, String ID) throws SQLException {
		String sql = "DELETE FROM member";
		if(!ID.equals("*"))
			sql += " WHERE id = ?";
		PreparedStatement statement = connection.prepareStatement(sql);
		if(!ID.equals("*"))
			statement.setString(1, ID);
		statement.executeUpdate();
	}
	@Override
	public void DBDrop(Connection connection) throws SQLException {
		String sql = "DROP TABLE member;";
		PreparedStatement statement = connection.prepareStatement(sql);
		statement.executeUpdate();
	}
	@Override
	public CEntity newObject() {
		return new CUser();
	}
	
}
