package view;

import java.util.HashMap;
import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;
import main.Constant.EStudentView;

public class CStudentView extends CView {
	@Override
	public EEvent show(Scanner scanner, String title) {
		EEvent selection;
		int selectionNumber;
		HashMap<EEvent, Boolean> map = new HashMap<EEvent, Boolean>();
		
		newLine();
		System.out.println("["+title+"]");
		for (EStudentView eView: EStudentView.values()) {
			System.out.println(eView.getEventID().ordinal() 
					+ "." + eView.getTitle());
			map.put(eView.getEventID(), true);
		}
		
		selectionNumber = menuSelection(scanner, map, Constant.MENUSELECTION);
		selection = EEvent.values()[selectionNumber];
		return selection;
	}

}
