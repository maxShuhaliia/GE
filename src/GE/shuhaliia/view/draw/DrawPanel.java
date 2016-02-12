package GE.shuhaliia.view.draw;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.RenderingHints;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import GE.shuhaliia.command.CommandInvoker;
import GE.shuhaliia.command.CommandMgr;
import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.listeners.DrawPanelListeners;
import GE.shuhaliia.listeners.MyKeyListener;
import GE.shuhaliia.model.Model;
import GE.shuhaliia.view.draw.shapes.PictureComposite;
import GE.shuhaliia.view.draw.shapes.Text;

public class DrawPanel extends JPanel{
	private int xStartText;
	private int yStartText;
	private boolean abilityCreateTextArea;
	private JTextArea textArea;
	private Model model;
	private Controller controller;
	private CommandMgr commandmgr;
	private CommandInvoker commandInvoker;
	private boolean mouseWasPressed;
	//Drawing parameters
	private BufferedImage bi = null;
	private DrawPanelListeners dpl;
	private PictureComposite pictureComposite = new PictureComposite();
	
	
	
	public DrawPanel(Model model, Controller controller){
		JButton jb = new JButton();
		this.model = model;
		this.controller = controller;
		commandmgr = new CommandMgr(model);
		commandInvoker = new CommandInvoker(commandmgr);
		model.setCommandMgr(commandmgr);
		model.setCcommandInvoker(commandInvoker);
		
		setFocusable(true);
		setOpaque(true);
		setBackground(Color.WHITE);
		
		dpl = new DrawPanelListeners(this, model, controller);
		addMouseListener(dpl);
		addMouseMotionListener(dpl);
		
		MyKeyListener m = new MyKeyListener(model);
		addKeyListener(m);
		
		model.setPictureComposite(pictureComposite);
		model.setDrawPanel(this);
		this.setBackground(Color.LIGHT_GRAY);
		model.setRectX(10);
		model.setRectY(10);
		model.setRectWidth(600);
		model.setRectHeight(450);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;	

		g2d.setColor(Color.WHITE);
		g2d.clipRect(model.getRectX(), model.getRectY(), model.getRectWidth(), model.getRectHeight());
		g2d.fillRect(model.getRectX(), model.getRectY(), model.getRectWidth(), model.getRectHeight());
		
		//create image for draw on it
		if(model.getAbilityCreateImage()){
			
			 bi = new BufferedImage(model.getRectWidth()+10, model.getRectHeight()+10, BufferedImage.TYPE_INT_RGB);
			 g2d = bi.createGraphics();
			 
			 g2d.setColor(Color.WHITE);
			 g2d.fillRect(10, 10, model.getRectWidth(), model.getRectHeight());
			 
	//		model.setAbilityCreateImage(false);
			model.setScreenShot(bi);
			}	

		//drawing all graphics
		model.getPictureComposite().render(g2d);
		//drawing current graphic
	if(model.getGraphic()!=null)model.getGraphic().render(g2d);	

	
// this construction invokes only when text typing was choose
	if(abilityCreateTextArea){
		addTextArea();
		abilityCreateTextArea = false;
	}	

		//save as file onto hard disc
		if(model.getAbilitySaveImage()){
			try {
				ImageIO.write(bi, "PNG", new File("W:\\image.PNG"));
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			
			model.setAbilitySaveImage(false);		
		}	
		
	}
	
//// method for temporary setting TextArea
	public void addTextArea(){
		textArea = new JTextArea();
		
	
		setLayout(null);
		textArea.setForeground(model.getColor());
		Font f = new Font("TimesNewRoman", Font.ITALIC, 12);
		textArea.setFont(f);
		model.setFont(f);
		textArea.setBounds(xStartText, yStartText, getWidth(), getHeight());
		textArea.setOpaque(false);
		textArea.setBackground(new Color(0, 0 ,0 ,0));

		textArea.addKeyListener( new MyKeyListener(model));

		add(textArea);
		
	//	System.out.println(textArea.getFont().getSize());
		
		
	
		revalidate();
		validate();
		textArea.requestFocus();	
	}
	
 public void removeTextArea(){
	if(textArea!=null) remove(textArea);
	 revalidate();
	 validate(); 
 }
		//this method invoke when coordinates was updates
		// repainting picture 
		public void updateDrawPanel(){
			revalidate();
			validate();
			repaint();
		}

	public CommandInvoker getCommandInvoker() {
		return commandInvoker;
	}	
	
	public boolean ismouseWasPressed() {
		return mouseWasPressed;
	}
	
	public void setmouseWasPressed(boolean mouseWasPressed) {
		this.mouseWasPressed = mouseWasPressed;
	}
	public void setAbilityCreateTextArea(boolean b){
		abilityCreateTextArea = b;
		updateDrawPanel();
	}
	public boolean isAbilityCreateTextArea(){
		return abilityCreateTextArea;
	}
	
	public void setX(int xStartText){
		this.xStartText = xStartText;
	}
	public void setY(int yStartText){
		this.yStartText = yStartText;
	}

	public JTextArea getTextArea() {
		return textArea;
	}

	public void setTextArea(JTextArea textArea) {
		this.textArea = textArea;
	}
}
