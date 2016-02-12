package GE.shuhaliia.main;

import GE.shuhaliia.controller.Controller;
import GE.shuhaliia.model.Model;
import GE.shuhaliia.view.GEView;

public class Main {

	public static void main(String[] args) {
		
		Model model = new Model();
		
		Controller controller = new Controller(model);
		
		GEView view = new GEView(model, controller);
		view.createView();

	}
}
