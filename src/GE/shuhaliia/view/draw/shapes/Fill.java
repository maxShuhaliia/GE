package GE.shuhaliia.view.draw.shapes;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import GE.shuhaliia.model.Model;

public class Fill extends Graphic {
	private Model model;

	public Fill(int x, int y, int x2, int y2, Color color, Model model) {
		super.setX(x);
		super.setY(y);
		super.setX2(x2);
		super.setY2(y2);
		super.setColor(color);	
		this.model = model;
	}

	@Override
	public void render(Graphics2D g2d) {
				
	}
	

	
}
