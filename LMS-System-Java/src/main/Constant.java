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
		eLogout("로그아웃", new CLogoutView()),
		eSignIn("로그인", new CLoginView()),
		eSignUp("회원등록", new CJoinView()),
		eMain("메인", new CMainView()), 
		eProfessor("교수화면", new CProfessorView()), 
		eStudent("학생화면", new CStudentView()), 
		eMakeCourse("강좌개설", new CMakeCourseView()),
		eGetCourse("강좌조회", new CGetCourseView()),
		eSetGrade("성적입력", new CSetGradeView()),
		eGetGradeP("교수성적조회", new CGetGradePView()),
		eRegisterCourse("수강신청", new CRegisterCourseView()), 
		eGetGradeS("학생성적조회", new CGetGradeSView());
		
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
		eView1(EEvent.eRegisterCourse, "수강신청"),
		eView2(EEvent.eGetGradeS, "성적조회"),
		eView3(EEvent.eLogout,"로그아웃");
		
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
		eView1(EEvent.eMakeCourse, "강좌개설"),
		eView2(EEvent.eGetCourse, "강좌조회"),
		eView3(EEvent.eSetGrade, "성적입력"),
		eView4(EEvent.eGetGradeP, "성적조회"),
		eView5(EEvent.eLogout,"로그아웃");
		
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
		eView1(EEvent.eSignIn, "로그인"),
		eView2(EEvent.eSignUp,"회원가입"),
		eView3(EEvent.eLogout,"종료");
		
		private EEvent eventID;		
		public EEvent getEventID() {return this.eventID; }
		private String title;		
		public String getTitle() {return this.title; }
		
		private EMainView(EEvent eventID, String title) {
			this.eventID = eventID;
			this.title = title;
		}
	}
	public final static String MENUSELECTION = "메뉴선택";
}
