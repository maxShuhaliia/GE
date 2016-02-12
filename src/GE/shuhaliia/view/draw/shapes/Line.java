package GE.shuhaliia.view.draw.shapes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.Line2D;
import java.awt.geom.Rectangle2D;

import GE.shuhaliia.model.Model;



public class Line extends Graphic {
	
	private String graphicType = "line";
	private Model model;

	public Line(int x, int y, int x2, int y2, Model model) {
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		super.setColor(model.getColor());
		super.setModel(model);	
	}
	
	public String getGraphicType(){
		return graphicType;
	}


	@Override
	public void render(Graphics2D g2d) {
		g2d.setColor(getColor());
		BasicStroke bs = new BasicStroke(getWeight(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		g2d.setStroke(bs);		
		g2d.drawLine(getX(), getY(), getX2(), getY2());		
		//checking of intersection line with rectangle		
		Shape line = new Line2D.Float(getX(), getY(), getX2(), getY2());
		Rectangle workSpace = new Rectangle(getxRect(), getyRect(), getWidthRect(), getHeightRect());		
		boolean visible = g2d.hit(workSpace, line, true);
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
