package view;

import java.util.HashMap;
import java.util.Scanner;

import main.Constant;
import main.Constant.EEvent;
import control.CControl;

abstract public class CView {
	private CControl control;
	protected boolean error;
	protected static HashMap<Integer, EEvent> EEventType = new HashMap<Integer, EEvent>();
	
	public CControl getControl() {return control;}
	public void setControl(CControl control) {this.control = control;}
	public void newLine(){System.out.println();}
	
	public boolean isNumber(String str)
	{
		try{
			Integer.parseInt(str);
			return false;
		}
		catch(Exception e)
		{
			return true;
		}
	}
	
	public int menuSelection(Scanner scanner, HashMap<EEvent, Boolean> map, String constant)
	{
		String selectionNumber;
		while(true)
		{
			error = false;
			System.out.print(Constant.MENUSELECTION+": ");
			selectionNumber = scanner.next();
			
			error = isNumber(selectionNumber);
			if(error)
			{
				System.out.println("메뉴선택은 숫자만 입력이 가능합니다. 숫자로 다시 입력해주세요.");
				continue;
			}
			if(EEvent.values().length < Integer.parseInt(selectionNumber))
				error = true;
			else
				error = !map.containsKey(EEvent.values()[Integer.parseInt(selectionNumber)]);
			if(error)
			{
				System.out.println("화면에 나와있는 메뉴만 선택할 수 있습니다.");
				continue;
			}
			else
			{
				break;
			}
		}
		return Integer.parseInt(selectionNumber);
	}
	abstract public EEvent show(Scanner scanner, String title) throws Exception;
}
