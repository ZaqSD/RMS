package eu.rms.view;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class RouteView extends GridPane {

	public RouteView(int linNr) {
		GridPane topGrid = new GridPane();
		GridPane infoBox = new GridPane();
		GridPane route = new GridPane();
		TilePane buttons = new TilePane();
		
		
		
		this.add(topGrid, 0, 0);
		this.add(infoBox, 1, 0, 2, 1);
		this.add(route, 0, 1);
		this.add(buttons, 0, 2);
	}
	
}
