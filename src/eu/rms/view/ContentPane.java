package eu.rms.view;

import java.sql.SQLException;

import eu.rms.model.ContentObservableList;
import eu.rms.model.TimetableObservableList;
import eu.rms.view.timetable.TimResultDetailOverView;
import eu.rms.view.timetable.TimResultDetailView;
import eu.rms.view.timetable.TimResultOverview;
import eu.rms.view.timetable.TimetableView;
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
		this.add(new TimetableView(), 0, 0);
	}
	
	public void Reload(int yNot) {
		this.getChildren().clear();
		this.add(TimetableObservableList.getTable(), 0, 0);
	}
	
	public void Reload() throws SQLException {
		this.getChildren().clear();
		this.add(new DepartView(), 0, 0);
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
		this.getChildren().add(new MapsView());			
	}
	
	public void Reload(TimResultOverview overview) {
		this.getChildren().clear();
		this.add(overview, 0, 0);
	}

	public void Reload(TimResultDetailView detailView) {
		this.getChildren().clear();
		this.add(detailView, 0, 0);
	}

	public void Reload(BuyFormView buyFormView) {
		this.getChildren().clear();
		this.add(buyFormView, 0, 0);
	}

	public void Reload(TimResultDetailOverView view) {
		this.getChildren().clear();
		this.add(view, 0, 0);		
	}

	public void Reload(BuyOverView buyOverView) {
		this.getChildren().clear();
		this.add(buyOverView, 0, 0);			
	}

	public void Reload(BuyVerificationView view) {
		this.getChildren().clear();
		this.add(view, 0, 0);			
	}
	
}
