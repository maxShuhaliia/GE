package GE.shuhaliia.view.draw.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;

import GE.shuhaliia.model.Model;

public class ColorPicker extends Graphic {

	private Model model;

	public ColorPicker(int x, int y, int x2, int y2,  Model model){
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		this.model = model;
	}

	@Override
	public void render(Graphics2D g2d) {
		
		int currentX = getX();
		int currentY = getY();
		setVisible(false);
		
		Shape line = new Line2D.Float(currentX, currentY, currentX, currentY);		
		Shape rect = new Rectangle(model.getRectX(), model.getRectY(), model.getRectWidth(), model.getRectHeight());

		boolean pointIsideOfWorkSpace = g2d.hit((Rectangle) rect, line, true);
		
		if(model.getAbilityCreateImage() && pointIsideOfWorkSpace){
			
			BufferedImage bImage = model.getScreenShot();			
			int packedInt = bImage.getRGB(currentX,currentY);
			Color color = new Color(packedInt, true);
			model.setColor(color);		
			model.setAbilityCreateImage(false);
			}
		
		else{
			model.setAbilityCreateImage(false);
			model.notifyObserver();
		}	
	}
	}
