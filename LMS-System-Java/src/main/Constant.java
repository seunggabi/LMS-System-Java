package main;

import view.CGetCourseView;
import view.CGetGradePView;
import view.CGetGradeSView;
import view.CJoinView;
import view.CLoginView;
import view.CLogoutView;
import view.CMainView;
import view.CMakeCourseView;
import view.CProfessorView;
import view.CRegisterCourseView;
import view.CSetGradeView;
import view.CStudentView;
import view.CView;

public class Constant {
	public enum EEvent {
		eLogout("�α׾ƿ�", new CLogoutView()),
		eSignIn("�α���", new CLoginView()),
		eSignUp("ȸ�����", new CJoinView()),
		eMain("����", new CMainView()), 
		eProfessor("����ȭ��", new CProfessorView()), 
		eStudent("�л�ȭ��", new CStudentView()), 
		eMakeCourse("���°���", new CMakeCourseView()),
		eGetCourse("������ȸ", new CGetCourseView()),
		eSetGrade("�����Է�", new CSetGradeView()),
		eGetGradeP("����������ȸ", new CGetGradePView()),
		eRegisterCourse("������û", new CRegisterCourseView()), 
		eGetGradeS("�л�������ȸ", new CGetGradeSView());
		
		private String title;
		private CView view;
		public String getTitle() { return this.title; }
		public CView getView() { return this.view; }
		
		private EEvent(String title, CView view) {
			this.title = title;
			this.view = view;
		}
	}
	public enum EStudentView {
		eView1(EEvent.eRegisterCourse, "������û"),
		eView2(EEvent.eGetGradeS, "������ȸ"),
		eView3(EEvent.eLogout,"�α׾ƿ�");
		
		private EEvent eventID;		
		public EEvent getEventID() {return this.eventID; }
		private String title;		
		public String getTitle() {return this.title; }
		
		private EStudentView(EEvent eventID, String title) {
			this.eventID = eventID;
			this.title = title;
		}
	}
	public enum EProfessorView {
		eView1(EEvent.eMakeCourse, "���°���"),
		eView2(EEvent.eGetCourse, "������ȸ"),
		eView3(EEvent.eSetGrade, "�����Է�"),
		eView4(EEvent.eGetGradeP, "������ȸ"),
		eView5(EEvent.eLogout,"�α׾ƿ�");
		
		private EEvent eventID;		
		public EEvent getEventID() {return this.eventID; }
		private String title;		
		public String getTitle() {return this.title; }
		
		private EProfessorView(EEvent eventID, String title) {
			this.eventID = eventID;
			this.title = title;
		}
	}
	public enum EMainView {
		eView1(EEvent.eSignIn, "�α���"),
		eView2(EEvent.eSignUp,"ȸ������"),
		eView3(EEvent.eLogout,"����");
		
		private EEvent eventID;		
		public EEvent getEventID() {return this.eventID; }
		private String title;		
		public String getTitle() {return this.title; }
		
		private EMainView(EEvent eventID, String title) {
			this.eventID = eventID;
			this.title = title;
		}
	}
	public final static String MENUSELECTION = "�޴�����";
}
