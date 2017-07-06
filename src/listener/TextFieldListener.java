package listener;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import ui.MainFrame;

public class TextFieldListener extends KeyAdapter{
	
	private MainFrame mf;
	
	public TextFieldListener(MainFrame mf) {
		this.mf = mf;
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_ENTER){
			mf.addEntry();
		}
		if(e.getKeyCode() == KeyEvent.VK_DELETE){
			mf.deleteSelectedIndex();
		}
		if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
			mf.close();
		}
	}

}
