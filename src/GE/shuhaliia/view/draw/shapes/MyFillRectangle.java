package GE.shuhaliia.view.draw.shapes;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;

import GE.shuhaliia.model.Model;

public class MyFillRectangle extends Graphic {
	
	public String graphicType = "fillSquare";

	public MyFillRectangle(int x, int y, int x2, int y2, Model model) {
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
		
		int arrayX[] = { getX(), getX2(), getX2(), getX()};
		int yarrayY[] = { getY(), getY(), getY2(), getY2()};
		g2d.fillPolygon(arrayX, yarrayY, 4);

		Shape line1 = new Line2D.Float(getX(), getY(), getX(), getY2());		
		Shape line2 = new Line2D.Float(getX(), getY(), getX2(), getY());		
		Shape line3 = new Line2D.Float( getX2(), getY(), getX2(), getY2());		
		Shape line4 = new Line2D.Float( getX(),  getY2(), getX2(), getY2());
		
		Rectangle workSpace = new Rectangle(getxRect(), getyRect(), getWidthRect(), getHeightRect());
		
		boolean visibleLine1 = g2d.hit( workSpace, line1, true);
		boolean visibleLine2 = g2d.hit( workSpace, line2, true);
		boolean visibleLine3 = g2d.hit( workSpace, line3, true);
		boolean visibleLine4 = g2d.hit( workSpace, line4, true);
		
		if(visibleLine1 || visibleLine2 || visibleLine3 || visibleLine4){
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
