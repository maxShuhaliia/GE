package GE.shuhaliia.view.toolBarButtons;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.listeners.DrawPanelListeners;


public class ToolBarButtons extends JToolBar implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4999668323012509213L;
	private Controller controller;	
	private IconButton btnPencil, btnEraser, btnOval, btnFillOval, btnRectangle,
						btnFillRectangle, btnLine, btnText, btnColorPicker, btnFill;
	
	private DrawPanelListeners dpl;
	private String choosedButton;	
	
	public ToolBarButtons(Controller controller){
		this.controller = controller;
				
		btnPencil = new IconButton("image/pencil.png");				
		btnEraser = new IconButton("image/eraser.png");				
		btnOval = new IconButton("image/empty_circle.png");		
		btnFillOval = new IconButton("image/fill_circle.png");	
		btnRectangle = new IconButton("image/empty_square.png");		
		btnFillRectangle = new IconButton("image/fill_square.png");	
		btnLine = new IconButton("image/line.png");					
		btnText = new IconButton("image/text.png");					
		btnColorPicker = new IconButton("image/color_picker.png");	
		btnFill = new IconButton("image/fill.png");		

		btnPencil.addActionListener(this);
		btnEraser.addActionListener(this);
		btnOval.addActionListener(this);
		btnFillOval.addActionListener(this);
		btnRectangle.addActionListener(this);
		btnFillRectangle.addActionListener(this);
		btnLine.addActionListener(this);
		btnText.addActionListener(this);
		btnColorPicker.addActionListener(this);
		btnFill.addActionListener(this);
		
		btnPencil.setActionCommand("curveLine");
		btnEraser.setActionCommand("eraser");
		btnOval.setActionCommand("oval");
		btnFillOval.setActionCommand("fillOval");
		btnRectangle.setActionCommand("rectangle");
		btnFillRectangle.setActionCommand("fillRectangle");
		btnLine.setActionCommand("line");
		btnText.setActionCommand("text");
		btnColorPicker.setActionCommand("colorPicker");
		btnFill.setActionCommand("fill");

		add(btnPencil);
		add(btnEraser);
		add(btnOval);
		add(btnFillOval);
		add(btnRectangle);
		add(btnFillRectangle);
		add(btnLine);
		add(btnText);
		add(btnColorPicker);
		add(btnFill);
		
		setOrientation(JToolBar.VERTICAL);
		setFloatable(false);
	}
	/*
	"pencil"
	"eraser"			
	"oval"		
	"fillOval"	
	"rectangle"
	"fillRectangle"
	"line"			
	"text"			
	"colorPicker"
	"fill"
*/
	@Override
	public void actionPerformed(ActionEvent e) {
		controller.setCursorButton(e.getActionCommand());
		
	}	
}
