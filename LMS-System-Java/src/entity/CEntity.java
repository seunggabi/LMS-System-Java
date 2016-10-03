package entity;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

abstract public class CEntity implements Serializable {

	protected static final long serialVersionUID = 1L;
	protected String ID;
	
	public String getID() {return ID;}
	public void setID(String ID) {this.ID = ID;}
	
	abstract public void DBRead(ResultSet rs) throws SQLException;
	abstract public void DBWrite(Connection connection) throws SQLException;
	abstract public void DBCreate(Connection connection) throws SQLException;
	abstract public void DBDelete(Connection connection, String ID) throws SQLException;
	abstract public void DBDrop(Connection connection) throws SQLException;
	abstract public CEntity newObject();
}
