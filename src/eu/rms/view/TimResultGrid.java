package eu.rms.view;

import eu.rms.model.IconLine;
import javafx.scene.layout.GridPane;

public class TimResultGrid extends GridPane{
	
	public TimResultGrid() {
		super();
		this.setHgap(10);
		this.add(new TimResult(), 0, 0);
		
	}
}
