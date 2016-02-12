package GE.shuhaliia.view.draw.shapes;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;


public class PictureComposite extends Graphic {

	ArrayList<Graphic> graphicList = new ArrayList<Graphic>();
	

	@Override
	public void add(Graphic graphic) {
		graphicList.add(graphic);
		
	}

	@Override
	public void remove(Graphic graphic) {
			graphicList.remove(graphic);
			graphicList.trimToSize();
	}

	@Override
	public Graphic removeLastChild() {
		return graphicList.remove(graphicList.size()-1);	
	}

	@Override
	public void render(Graphics2D g2d) {
		
		Iterator<Graphic> iterator = graphicList.iterator();
		while(iterator.hasNext()){
			Graphic graphic = (Graphic)iterator.next();
			graphic.render(g2d);
		}
	}
	public ArrayList<Graphic> getGraphicList() {
		return graphicList;
	}
}
