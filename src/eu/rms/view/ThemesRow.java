package eu.rms.view;

import eu.rms.model.IconTheme;
import javafx.scene.layout.GridPane;

public class ThemesRow extends GridPane {

	public ThemesRow() {
		
		this.setHgap(10);
		
		this.add(new ImgView(IconTheme.getLight()), 0, 0);
		this.add(new ImgView(IconTheme.getDark()), 1, 0);
		this.add(new ImgView(IconTheme.getAccessability()), 2, 0);
		this.add(new ImgView(IconTheme.getPurple()), 3, 0);

	}
	
}
