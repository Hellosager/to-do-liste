package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import ui.MainFrame;

public class ControlListener implements ActionListener {
	private MainFrame mf;
	
	public ControlListener(MainFrame mf) {
		this.mf = mf;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		switch(e.getActionCommand()){
			case "add":
				mf.addEntry();
				break;
			case "done":
				mf.deleteSelectedIndex();
				break;
			case "deleteAll":
				mf.deleteList();
				break;
		}
	}

}
