package GE.shuhaliia.view.menus;


import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.listeners.MyMenuListener;
import GE.shuhaliia.model.Model;

public class MainMenu extends JMenuBar{

	private static final long serialVersionUID = -6903365737350005230L;
	
	private JMenu fileMenu;
	private JMenu editMenu;
	
	private JMenuItem newAction;
	private	JMenuItem openAction;
	private JMenuItem saveAction;
	private JMenuItem saveAsAction; 
	private	JMenuItem printAction;
	private JMenuItem exitAction;
	
	private JMenuItem undoAction;
	private	JMenuItem redoAction;
	private JMenuItem cutAction;
	private JMenuItem copyAction; 
	private	JMenuItem pasteAction;
	private Controller controller;
	private Model model;

	public MainMenu(Controller controller, Model model){
		this.controller  = controller;
		this.model = model;
		fileMenu = new JMenu("File");
		editMenu = new JMenu("Edit");
		
		add(fileMenu);
		add(editMenu);
		
		//menu File items
		
		newAction = new JMenuItem("new file");
		openAction = new JMenuItem("open File");
		saveAction = new JMenuItem("save file...");
		saveAsAction = new JMenuItem("save as...");
		printAction = new JMenuItem("print file");
		exitAction = new JMenuItem("exit");
		
		//menu edit items
		
		undoAction = new JMenuItem("undo");
		redoAction = new JMenuItem("redo");
		cutAction = new JMenuItem("cut");
		copyAction = new JMenuItem("copy");
		pasteAction = new JMenuItem("paste");
		
		fileMenu.add(newAction);
		fileMenu.add(openAction);
		fileMenu.add(saveAction);
		fileMenu.add(saveAsAction);
		fileMenu.add(printAction);
		fileMenu.add(exitAction);

		editMenu.add(undoAction);
		editMenu.add(redoAction);
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		newAction.setActionCommand("new");
		openAction.setActionCommand("open");
		saveAction.setActionCommand("save");
		saveAsAction.setActionCommand("saveAs");
		printAction.setActionCommand("print");
		exitAction.setActionCommand("exit");
		
		undoAction.setActionCommand("undo");
		redoAction.setActionCommand("redo");
		cutAction.setActionCommand("cut");
		copyAction.setActionCommand("copy");
		pasteAction.setActionCommand("paste");
		
		MyMenuListener myMenuListener = new MyMenuListener(controller);
		
		newAction.addActionListener(myMenuListener);
		openAction.addActionListener(myMenuListener);
		saveAction.addActionListener(myMenuListener);
		saveAsAction.addActionListener(myMenuListener);
		printAction.addActionListener(myMenuListener);
		exitAction.addActionListener(myMenuListener);
		
		undoAction.addActionListener(myMenuListener);
		redoAction.addActionListener(myMenuListener);
		cutAction.addActionListener(myMenuListener);
		copyAction.addActionListener(myMenuListener);
		pasteAction.addActionListener(myMenuListener);
			
		}
	public void changeVisuableComponents(){
		undoAction.setEnabled(model.getCommandMgr().undoable());
		redoAction.setEnabled(model.getCommandMgr().redoable());
	}
}
