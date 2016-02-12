package GE.shuhaliia.model;

import java.awt.Color;

import GE.shuhaliia.view.draw.shapes.Graphic;

public interface ModelInterface {

	public void setGraphic(Graphic graphic);
	
	public Graphic getGraphic();
	
	public void setWeight(int weight);
	
	public int getWeight();
	
	public void setColor(Color colorBtn);
	
	public Color getColor();
	
	
}
