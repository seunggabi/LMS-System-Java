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
				System.out.println("�޴������� ���ڸ� �Է��� �����մϴ�. ���ڷ� �ٽ� �Է����ּ���.");
				continue;
			}
			if(EEvent.values().length < Integer.parseInt(selectionNumber))
				error = true;
			else
				error = !map.containsKey(EEvent.values()[Integer.parseInt(selectionNumber)]);
			if(error)
			{
				System.out.println("ȭ�鿡 �����ִ� �޴��� ������ �� �ֽ��ϴ�.");
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
