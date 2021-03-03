package eu.rms.view.widgets;

import eu.rms.model.Subtitle;
import eu.rms.model.Title;
import eu.rms.model.WidgetSettings;
import javafx.scene.layout.GridPane;

public class DepartWidget extends GridPane{

	public DepartWidget() {
		
		this.getStyleClass().add("widget");
		this.setPrefWidth(700);
		
		String stationname = WidgetSettings.getDeparturesStation();

		Title title = new Title("Next Departs");
		Subtitle subtitle = new Subtitle(stationname);
		
		this.add(title, 0, 0);
		this.add(subtitle, 0, 1);
	}
}
