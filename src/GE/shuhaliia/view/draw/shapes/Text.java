package GE.shuhaliia.view.draw.shapes;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;






import java.awt.RenderingHints;
import java.awt.font.FontRenderContext;
import java.awt.font.GlyphVector;

import GE.shuhaliia.model.Model;


public class Text extends Graphic implements Cloneable{

public String graphicType = "text";
	
	public Text(int x, int y, int x2, int y2, Model model) {
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		super.setColor(model.getColor());
		model.getDrawPanel().setX(x);
		model.getDrawPanel().setY(y);
		model.getDrawPanel().setAbilityCreateTextArea(true);
		setAddToComposite(false);
		setMessage("");
		this.model = model;
	}
	
	public String getGraphicType(){
		return graphicType;
	}
	
	@Override
	public void render(Graphics2D g2d) {
		
		if(isAddToComposite()){
			g2d.setColor(getColor());
			
			String[] s = getMessage().split("\n");
			int a = 13;
			g2d.setFont(model.getFont());
			//Initializing text
			g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_LCD_HRGB);
			
			for(String str: s){
				
				g2d.drawString(str, getX(), getY()+a);	
				a+=16;
								
			}
		}
		else{
			setMessage(model.getMessage());
			/*
		if(model.getFont()!=null)	{
			FontMetrics metrics = g2d.getFontMetrics(model.getFont());
			
		    int widthTextArea = metrics.stringWidth(model.getMessage());
		    model.setWidthTextArea(widthTextArea);
		    
		    String[] s = getMessage().split("\n");
		    int heightTextArea = s.length*16;
		    model.setHeightTextArea(heightTextArea);

		}
		*/
		}
	}

	@Override
	public Graphic clone() throws CloneNotSupportedException {
		return (Graphic)super.clone();
	}
}