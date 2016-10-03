package entity;

import exception.EUserTypeNotFoundException;

public class VUser {
	public enum EUserType {EProfessor, EStudent};
	private String ID;
	private String name;
	private EUserType eUserType;
	
	public String getID() {return ID;}
	public void setID(String ID) {this.ID = ID;}
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public EUserType geteUserType() {return eUserType;}
	public void seteUserType(EUserType eUserType) {this.eUserType = eUserType;}
	
	public void seteUserType(String type) throws EUserTypeNotFoundException
	{
		if(type.equals("stu"))
			this.seteUserType(EUserType.EStudent);
		else if(type.equals("prof"))
			this.seteUserType(EUserType.EProfessor);
		else
			throw new EUserTypeNotFoundException();
	}
	
}
