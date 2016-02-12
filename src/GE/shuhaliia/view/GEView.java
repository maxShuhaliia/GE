package GE.shuhaliia.view;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.model.Model;
import GE.shuhaliia.view.draw.DrawPanel;
import GE.shuhaliia.view.menus.MainMenu;
import GE.shuhaliia.view.toolBarButtons.ToolBarButtons;
import GE.shuhaliia.view.toolBarButtons.ToolBarColorAndWeight;




public class GEView extends JFrame {

	private static final long serialVersionUID = 1L;
	private Model model;
	private Controller controller;
	 
	private DrawPanel panel;
	 
	private MainMenu mainMenu = null;
	private ToolBarColorAndWeight tbcw = null;
	 
	public GEView(Model model, Controller controller){	
		this.model = model;
		this.controller = controller;
		panel = new DrawPanel(model, controller);
		model.registerObserver(this);
	}

	public void createView(){
		setFocusable(false);
		setSize(800, 650);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(true);
		setLayout(new BorderLayout());	
		//add draw panel on frame
		getContentPane().add(panel, BorderLayout.CENTER);
		model.setDrawPanel(panel);
		//create and add menu on frame
		mainMenu = new MainMenu(controller, model);
		setJMenuBar(mainMenu);
		mainMenu.changeVisuableComponents();
		//create a toolBar with buttons
		ToolBarButtons tbb = new ToolBarButtons(controller);
		add(tbb, BorderLayout.WEST);
		//create a toolBar with color chooser & waight of line
		tbcw = new ToolBarColorAndWeight(controller, model);
		add(tbcw, BorderLayout.SOUTH);	
		model.setGraphicString("line");
		controller.setCursorButton("line");
		setVisible(true);
	}
	
	public void updateView(){
		mainMenu.changeVisuableComponents();
		tbcw.updateColor();
	}

}
