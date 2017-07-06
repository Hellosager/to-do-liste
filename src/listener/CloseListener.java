package listener;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import ui.MainFrame;

public class CloseListener extends WindowAdapter{

	private MainFrame mf;
	
	public CloseListener(MainFrame mf){
		this.mf = mf;
	}
	
	@Override
	public void windowClosing(WindowEvent e){
		mf.close();
	}
	
}
