package GE.shuhaliia.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import GE.shuhaliia.controller.Controller;


public class MyMenuListener implements ActionListener {

	private Controller controller;

	public MyMenuListener(Controller controller) {
		this.controller = controller;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.setCommand(e.getActionCommand());
	}
}
