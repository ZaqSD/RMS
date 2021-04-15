package eu.rms.view;

import eu.rms.model.ContentObservableList;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class ContentPane extends GridPane{

	public ContentPane() {
		
		//TODO Widgets
		
		ContentObservableList.setTable(this);
		WidgetView widgets = new WidgetView();

		this.add(widgets, 0, 0);
	}
	
	public void Reload(TimetableView timetableView) {
		this.getChildren().clear();
		this.add(timetableView, 0, 0);
	}
	
	public void Reload(DepartView departView) {
		this.getChildren().clear();
		this.add(departView, 0, 0);
	}
	
	public void Reload(SettingsView settingsView) {
		this.getChildren().clear();
		this.add(settingsView, 0, 0);
	}
	
	public void Reload(WidgetView widgetView) {
		this.getChildren().clear();
		this.add(widgetView, 0, 0);
	}

	public void Reload(TicketShopView ticketshopView) {
		this.getChildren().clear();
		this.add(ticketshopView, 0, 0);
	}

	public void Reload(MapsView mapsView) {
		this.getChildren().clear();
		this.getChildren().add(mapsView);			
	}
	
	public void Reload(TimResultOverview overview) {
		this.getChildren().clear();
		this.add(overview, 0, 0);
	}
	
}
