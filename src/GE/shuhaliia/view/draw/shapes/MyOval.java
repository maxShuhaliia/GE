package GE.shuhaliia.view.draw.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;



import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;

import GE.shuhaliia.model.Model;

public class MyOval extends Graphic {
	
	public String graphicType = "oval";

	public MyOval(int x, int y, int x2, int y2, Model model) {
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		super.setColor(model.getColor());
		setModel(model);
	}
	
	public String getGraphicType(){
		return graphicType;	
	}

	@Override
	public void render(Graphics2D g2d) {
			g2d.setColor(getColor());
			
			BasicStroke w = new BasicStroke(getWeight());
			g2d.setStroke(w);

			Shape shape = null;
			
			if( getX() < getX2() && getY() < getY2() ){
				g2d.drawOval(getX(), getY(), getX2()-getX(), getY2()-getY());
				shape = new Ellipse2D.Float(getX(), getY(), getX2()-getX(), getY2()-getY());
			}
			else if( getX() < getX2() && getY() > getY2() ){
				g2d.drawOval(getX(), getY2(), getX2()-getX(), getY()-getY2());
				shape = new Ellipse2D.Float(getX(), getY2(), getX2()-getX(), getY()-getY2());
			}
			else if( getX() > getX2() && getY() > getY2() ){
				g2d.drawOval(getX2(), getY2(), getX()-getX2(), getY()-getY2());
				shape = new Ellipse2D.Float(getX2(), getY2(), getX()-getX2(), getY()-getY2());
			}
			else if( getX() > getX2() && getY() < getY2() ){
				g2d.drawOval(getX2(), getY(), getX()-getX2(), getY2()-getY());
				shape = new Ellipse2D.Float(getX2(), getY(), getX()-getX2(), getY2()-getY());
			}
			
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