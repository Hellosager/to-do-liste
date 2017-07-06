package ui;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import listener.ControlListener;

public class ControlPanel extends JPanel {
	private JButton add, done, deleteAll;
	
	public ControlPanel(MainFrame mf) {
		setLayout(new GridLayout(1, 3, 20, 0));
		
		add = new JButton("Hinzu");
		add.setActionCommand("add");
		done = new JButton("Erledigt");
		done.setActionCommand("done");
		deleteAll = new JButton("Liste löschen");
		deleteAll.setActionCommand("deleteAll");
		
		JButton[] buttons ={add, done, deleteAll};
		for(JButton b : buttons){
			b.addActionListener(new ControlListener(mf));
			b.setFocusable(false);
			this.add(b);
		}
	}
	
}
