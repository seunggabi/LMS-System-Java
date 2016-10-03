package entity;

import java.util.Scanner;

public class VLogin {	
	private String ID;
	private String pw;
		
	public String getID() {return ID;}
	public void setID(String ID) {this.ID = ID;}
	public String getPw() {return pw;}
	public void setPw(String pw) {this.pw = pw;}
	public void read(Scanner scanner) {
		ID = scanner.next();
		pw = scanner.next();
	}
	public void write() {}
	
}
