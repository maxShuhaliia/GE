package GE.shuhaliia.view.draw.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;


public class MyCircle extends Graphic {

	private String graphicType = "oval";
	private int x0;
	private int y0;
	private int d;

	public MyCircle(int x0, int y0, int d, Color color) {
	this.x0 = x0;
	this.y0 = y0;
	this.d = d;
	setColor(color);
	}
	
	public String getGraphicType(){
		return graphicType;
	}

	@Override
	public void render(Graphics2D g2d) {
			g2d.setColor(getColor());

		//	g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
			
			g2d.fillOval(x0-d/2, y0-d/2, d, d);
			Shape shape = new Ellipse2D.Float(x0-d/2, y0-d/2, d, d);
			Rectangle rect  = new Rectangle(getxRect(), getyRect(), getWidthRect(), getHeightRect());
			boolean visible = false ;
			
			if(shape!=null)visible = g2d.hit(rect, shape, true);
			if(visible){
				setVisible(true);
			}
			else{
				setVisible(false);
			}		
	
	}

	@Override
	public Graphic clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return (Graphic)super.clone();
	}
}
