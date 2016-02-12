package GE.shuhaliia.view.draw.shapes;

import java.awt.Color;
import java.awt.Graphics2D;

import GE.shuhaliia.model.Model;

public abstract class Graphic implements Cloneable{ 
	private int x, y;
	private int x2, y2;

	boolean addToComposite;
	private Color color;
	
	private int weight;
	private String message;
	
	private boolean visible;
	
	private int xRect;
	private int yRect;
	private int widthRect;
	private int heightRect;
	protected Model model;
	
	public void setModel(Model model){
		this.model = model;
		this.xRect = model.getRectX();
		this.yRect = model.getRectY();
		this.widthRect = model.getRectWidth();
		this.heightRect = model.getRectHeight();
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX2() {
		return x2;
	}

	public void setX2(int x2) {
		this.x2 = x2;
	}

	public int getY2() {
		return y2;
	}

	public void setY2(int y2){
		this.y2 = y2;
	}
	
	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

		// method for each leaves
		public void render(Graphics2D g2d){
			throw new UnsupportedOperationException();
		}

		//methods for composite 
			
			public void add(Graphic graphic){
				throw new UnsupportedOperationException();
			}
			
			public void remove(Graphic graphic){
				throw new UnsupportedOperationException();
			}
			
			public Graphic removeLastChild(){
				throw new UnsupportedOperationException();
			}
			
			//for cloning objects
			
			@Override
			public Graphic clone() throws CloneNotSupportedException {
				// TODO Auto-generated method stub
				return (Graphic)super.clone();
			}
			

			public void setMessage(String message) {
				this.message = message;				
			}
			
			public String getMessage() {
				return message;				
			}
				

			public boolean isAddToComposite() {
				return addToComposite;
			}

			public void setAddToComposite(boolean addToComposite) {
				this.addToComposite = addToComposite;
			}


			public int getxRect() {
				return xRect;
			}


			public void setxRect(int xRect) {
				this.xRect = xRect;
			}


			public int getyRect() {
				return yRect;
			}


			public void setyRect(int yRect) {
				this.yRect = yRect;
			}


			public int getWidthRect() {
				return widthRect;
			}


			public void setWidthRect(int widthRect) {
				this.widthRect = widthRect;
			}


			public int getHeightRect() {
				return heightRect;
			}


			public void setHeightRect(int heightRect) {
				this.heightRect = heightRect;
			}

			public boolean isVisible() {
				return visible;
			}

			public void setVisible(boolean visible) {
				this.visible = visible;
			}
			
	}

