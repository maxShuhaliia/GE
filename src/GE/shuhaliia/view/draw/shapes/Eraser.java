package GE.shuhaliia.view.draw.shapes;


import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.util.ArrayList;

import GE.shuhaliia.model.Model;

public class Eraser extends Graphic {

private ArrayList<Shape> pointsOfEraser;
private Shape rect = null;
	
	public Eraser(int x, int y, int x2, int y2, Model model) {
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		super.setColor(model.getColor());
		setModel(model);
		pointsOfEraser = new ArrayList<Shape>();
		rect = new Rectangle(model.getRectX(), model.getRectY(), model.getRectWidth(), model.getRectHeight());
	}

	@Override
	public void render(Graphics2D g2d) {
		g2d.setPaint(Color.WHITE);
		Shape line = new Line2D.Float(getX(), getY(), getX2(), getY2());
		
		if(g2d.hit( (Rectangle) rect, line, true)){
			pointsOfEraser.add(line);
			setVisible(true);
		}

		BasicStroke bs = new BasicStroke(getWeight(), BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND);
		for(int i=0; i<pointsOfEraser.size() ; i++){
			g2d.setStroke(bs);
			g2d.draw((Shape) pointsOfEraser.get(i));
		}
		
		setX(getX2());
		setY(getY2());
	}
}
