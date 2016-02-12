package GE.shuhaliia.controller;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;

import GE.shuhaliia.model.Model;
import GE.shuhaliia.view.draw.shapes.Graphic;


public class Controller {
	
	private Model model;	
	private Graphic graphic;

	private int weight;

	public void setGraphic(Graphic graphic) {
		model.setGraphic(graphic);
	}
	
	public Graphic getGraphic() {
		return model.getGraphic();
	}

	 public Controller(Model model) {
		this.model = model;
	}

	
	public void setCursorButton(String pushedButton) {
		model.setGraphicString(pushedButton);

		//need for setting a cursor
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		Image image = null;
		Point hotSpot = null;
		Cursor cursor = null;
		
		if(pushedButton=="curveLine"){
			image = toolkit.getImage("image/cursors/pencil_cursor.png");
			hotSpot = new Point(0, 30);
			cursor = toolkit.createCustomCursor(image, hotSpot , "curveLine"); 
		}
		else if(pushedButton=="eraser"){
			image = toolkit.getImage("image/cursors/erasers/cursor_eraser.png");
			hotSpot = new Point(0, 30);
			cursor = toolkit.createCustomCursor(image, hotSpot , "Eraser");   
		}
		
		else if(pushedButton=="oval"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
			
		}
		else if(pushedButton=="fillOval"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(pushedButton=="rectangle"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(pushedButton=="fillRectangle"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(pushedButton=="line"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);
		}
		else if(pushedButton=="text"){
//			model.clearMessage();
			cursor = new Cursor(Cursor.TEXT_CURSOR);
				
		}
		else if(pushedButton=="colorPicker"){
			image = toolkit.getImage("image/cursors/cursor_color_picker.png");
			hotSpot = new Point(0, 30);
			cursor = toolkit.createCustomCursor(image, hotSpot, "color_picker");
		}
		else if(pushedButton=="fill"){
			cursor = new Cursor(Cursor.CROSSHAIR_CURSOR);   //mknijnijioj
		}
		
		model.getDrawPanel().setCursor(cursor); 	
	}

	public void setXY(int x, int y){
	
	}
	
	public void setX2Y2(int x2, int y2){
			model.setX2(x2);
			model.setY2(y2);
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public void setColor(Color color) {
		model.setColor(color);
		
	}

	public void setCommand(String command) {
		model.getCcommandInvoker().invoke(command);
	}
	
}
