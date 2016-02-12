package GE.shuhaliia.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import GE.shuhaliia.model.Model;

public class MyKeyListener implements KeyListener {

	private Model model;
	private boolean canTyped;
	private boolean backSpasePressed;

	public MyKeyListener(Model model){
		this.model = model;
			
	}

		@Override
		public void keyPressed(KeyEvent e) {

				if(e.getKeyCode()==10){
					model.setMessage('\n');
				}
				else {
					model.setMessage(e.getKeyChar());
				}
		}

		@Override
		public void keyReleased(KeyEvent e) {
		}

		@Override
		public void keyTyped(KeyEvent e) {
		}
}
