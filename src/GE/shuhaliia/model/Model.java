package GE.shuhaliia.model;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

import GE.shuhaliia.command.CommandInvoker;
import GE.shuhaliia.command.CommandMgr;
import GE.shuhaliia.view.GEView;
import GE.shuhaliia.view.draw.DrawPanel;
import GE.shuhaliia.view.draw.shapes.CurveLine;
import GE.shuhaliia.view.draw.shapes.Graphic;
import GE.shuhaliia.view.draw.shapes.Line;
import GE.shuhaliia.view.draw.shapes.PictureComposite;


public class Model implements ModelInterface {

	private int rectX;
	private int rectY;
	private int rectWidth;
	private int rectHeight;

	private GEView view;
	private boolean abilityCreateImage;
	private Cursor cursor;
	private Graphic graphicBtn;
	private Color colorBtn;
	private int weight;

	private PictureComposite pictureComposite;
	private DrawPanel panel;
	private String message;
	private Graphics2D g2d;
	private boolean abilitySaveImage;
	private CommandMgr commandmgr;
	private CommandInvoker commandInvoker;
	private BufferedImage screenShot;
	private String pushedButton;
	private Font font;
	private int widthTextArea;
	private int heightTextArea;

	public void registerObserver(GEView view){
		this.view = view;
	}
	
	public void notifyObserver(){
		view.updateView();
		panel.updateDrawPanel();
	}

	public Cursor getCursor() {
		return cursor;
	}

	public void setCursor(Cursor cursor) {
		this.cursor = cursor;
	}

	public Model(){
		colorBtn = Color.BLACK;
		weight = 1;
		graphicBtn = null;
		message = "";
		abilityCreateImage = false;
		abilitySaveImage = false;
	}
	
	@Override
	public void setGraphic(Graphic graphicBtn) {
		this.graphicBtn = graphicBtn;
		}
		
	@Override
	
	public Graphic getGraphic() {
		return graphicBtn;
	}

	@Override
	public void setWeight(int weight) {
		this.weight = weight;	
	}
	@Override
	public int getWeight() {
		return weight;
	}
	@Override
	public void setColor(Color colorBtn) {
		this.colorBtn = colorBtn;
		notifyObserver();	
	}
	@Override
	public Color getColor() {
		return colorBtn;
	}

	//getter and setter coordinates methods
	
	public int getX() {
		return graphicBtn.getX();
	}
	public void setX(int x) {
		graphicBtn.setX(x);
		setColorAndWeight();
		getDrawPanel().updateDrawPanel();
	}
	public int getY() {
		return graphicBtn.getY();
	}
	public void setY(int y) {
		graphicBtn.setY(y);
		setColorAndWeight();
		getDrawPanel().updateDrawPanel();
	}
	public int getX2() {
		return graphicBtn.getX2();
	}
	public void setX2(int x2) {
		graphicBtn.setX2(x2);
		setColorAndWeight();
		getDrawPanel().updateDrawPanel();
	}
	public int getY2() {
		return graphicBtn.getY2();
	}
	public void setY2(int y2) {
		graphicBtn.setY2(y2);
		setColorAndWeight();
		getDrawPanel().updateDrawPanel();
	}
	public void setPictureComposite(PictureComposite pictureComposite) {
		this.pictureComposite = pictureComposite;
		if(getGraphic()!=null)setColorAndWeight();
	}
	public PictureComposite getPictureComposite() {
		return pictureComposite;
	}
	public void setDrawPanel(DrawPanel panel) {
		this.panel = panel;
	}
	public DrawPanel getDrawPanel() {
		return panel;	
	}

	public void setColorAndWeight(){	
		graphicBtn.setColor(getColor());
		graphicBtn.setWeight(getWeight());		
	}
	
	public void setMessage(char keyChar) {
		message+=Character.toString(keyChar);
		getGraphic().setMessage(message);
		notifyObserver();
	}
	
	public String getMessage() {
	    return message;
	}
	public void clearMessage(){
		message="";
	}

	public void setMessageRemoveLastChar() {
		if(message.length()!=0){
		String m = message.substring(0, message.length()-1);
		message = m;
		graphicBtn.setMessage(m);
		}
	}
	
	public void setAbilityCreateImage(boolean abilityCreateImage) {
		this.abilityCreateImage = abilityCreateImage;
	}

	public boolean getAbilityCreateImage() {
		return abilityCreateImage;
	}

	public void setG2D(Graphics2D g2d) {
		this.g2d = g2d;	
	}
	
	public Graphics getG2D() {
		return g2d;	
	}

	public boolean getAbilitySaveImage() {
		return abilitySaveImage;
	}
	
	public void setAbilitySaveImage(boolean abilitySaveImage) {
		this.abilitySaveImage = abilitySaveImage;
	}

	public void setCommandMgr(CommandMgr commandmgr) {
		this.commandmgr = commandmgr;	
	}
	public CommandMgr getCommandMgr() {
		return commandmgr;	
	}

	public void setCcommandInvoker(CommandInvoker commandInvoker) {
		this.commandInvoker = commandInvoker;	
	}
	public CommandInvoker getCcommandInvoker() {
		 return commandInvoker;	
	}

	public void setScreenShot(BufferedImage bi) {
		this.screenShot = bi;	
	}
	
	public BufferedImage getScreenShot() {
		return screenShot;	
	}

	public void setGraphicString(String pushedButton) {
		this.pushedButton = pushedButton;	
	}
	
	public String getGraphicString() {
		return pushedButton;	
	}

	public int getRectX() {
		return rectX;
	}

	public int getRectY() {
		return rectY;
	}

	public int getRectWidth() {
		return rectWidth;
	}

	public int getRectHeight() {
		return rectHeight;
	}

	public void setRectX(int rectX) {
		this.rectX = rectX;
	}

	public void setRectY(int rectY) {
		this.rectY = rectY;
	}

	public void setRectWidth(int rectWidth) {
		this.rectWidth = rectWidth;
	}

	public void setRectHeight(int rectHeight) {
		this.rectHeight = rectHeight;
	}

	public void setFont(Font font) {
		this.font = font;
	}
	
	public Font getFont() {
		return font;
	}
/*
	public void setWidthTextArea(int widthTextArea) {
		this.widthTextArea = widthTextArea;
		getDrawPanel().updateDrawPanel();
	}
	public int getWidthTextArea() {
		return widthTextArea;
	}

	public void setHeightTextArea(int heightTextArea) {
		this.heightTextArea = heightTextArea;
		getDrawPanel().updateDrawPanel();
	}
	public int getHeightTextArea() {
		return heightTextArea;
	}
*/	
	
}
