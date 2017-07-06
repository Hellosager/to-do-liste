package ui;
import java.awt.GridLayout;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import io.ListIO;
import listener.CloseListener;
import listener.TextFieldListener;

public class MainFrame {
	private ArrayList<String> entries;
	private JFrame frame;
	private JTextField textField = new JTextField();
	private JComboBox entryList = new JComboBox<>();

	public MainFrame() {
		frame = new JFrame();
		frame.setSize(400, 100);
		frame.setResizable(false);
		frame.setLayout(new GridLayout(3, 1));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		
		entryList.setFocusable(false);
		entryList.addItem("---keine Auswahl---");
		try{
			entries = new ListIO().loadList();
			for(String s : entries)
				entryList.addItem(s);
		}catch(FileNotFoundException fnfe){
			entries = new ArrayList<String>();
		}
		textField.addKeyListener(new TextFieldListener(this));
		
		
		frame.add(entryList);
		frame.add(textField);
		frame.add(new ControlPanel(this));
		frame.addWindowListener(new CloseListener(this));
		frame.setVisible(true);
	}

	public void addEntry() {
		String input = textField.getText();
		if(!input.trim().equals("")){
			int selectedIndex = entryList.getSelectedIndex();
			if(selectedIndex == 0){ // Keine Auswahl
				entries.add(input);
				entryList.addItem(input);
			}else{
				entries.add(selectedIndex-1, input);
				entryList.insertItemAt(input, selectedIndex);
			}
		}
		textField.setText("");
	}

	public void deleteSelectedIndex() {
		int selectedIndex = entryList.getSelectedIndex();
		if(selectedIndex != 0){
			if(JOptionPane.showConfirmDialog(frame, "Eintrag löschen?", "Eintrag löschen", JOptionPane.YES_NO_OPTION) == 0)
				entries.remove(selectedIndex-1);
				entryList.removeItemAt(selectedIndex);
		}
	}

	public void deleteList() {
		if(JOptionPane.showConfirmDialog(frame, "Eintrag löschen?", "Eintrag löschen", JOptionPane.YES_NO_OPTION) == 0){
			if(!entries.isEmpty()){
				entries.clear();
				entryList.removeAllItems();
				entryList.addItem("---keine Auswahl");
			}
		}
	}

	public void close() {
		if(!entries.isEmpty())
			if(JOptionPane.showConfirmDialog(frame, "Liste Speichern?", "Schließen", JOptionPane.YES_NO_OPTION) == 0)
				new ListIO().saveList(entries);
		System.exit(0);		
	}
}
