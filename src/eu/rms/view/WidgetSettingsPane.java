package eu.rms.view;

import eu.rms.controller.VisDepartActionListener;
import eu.rms.controller.VisGreetingActionListener;
import eu.rms.controller.VisTicketActionListener;
import eu.rms.controller.VisTimetableActionListener;
import eu.rms.model.VisBtnGreetingObservableList;
import eu.rms.model.VisGreetingObservableList;
import eu.rms.model.VisGridObservableList;
import eu.rms.model.WidgetSettings;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class WidgetSettingsPane extends GridPane {
	
	public WidgetSettingsPane() {
		super();
		
		createPane();
	}
	
	@SuppressWarnings("unchecked")
	private void createPane(){				
		GridPane grid = new GridPane();
		grid.setVgap(5);
		grid.setHgap(20);
		
		this.add(grid, 0, 0);
		
		Label greeting = new Label("Greeting");
		Label timetable = new Label("Timetable");
		Label departures = new Label("Departures");
		Label tickets = new Label("Tickets");
		
		int btn1width = 150;
		int btn1height = 50;
		
		Button visGreeting = new Button("Visible");
		visGreeting.getStyleClass().remove("button");
		visGreeting.getStyleClass().add("btn-currency-false");
		visGreeting.setPrefSize(btn1width, btn1height);
		visGreeting.setAlignment(Pos.CENTER);
		visGreeting.setOnAction(new VisGreetingActionListener());
		visGreeting.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				if (WidgetSettings.getVisGreetng() == true) {
					visGreeting.getStyleClass().clear();
					visGreeting.getStyleClass().add("btn-currency-false");
				} else if (WidgetSettings.getVisGreetng() == false ) {
					visGreeting.getStyleClass().clear();
					visGreeting.getStyleClass().add("btn-currency-true");
				}
				if (WidgetSettings.getVisGreetng() == true) {
					WidgetSettings.setVisGreetng(false);
				} else if (WidgetSettings.getVisGreetng() == false) {
					WidgetSettings.setVisGreetng(true);
				}
			}
			
		});
		Button visTimetable = new Button("Visible");
		visTimetable.getStyleClass().remove("button");
		visTimetable.getStyleClass().add("btn-currency-false");
		visTimetable.setPrefSize(btn1width, btn1height);
		visTimetable.setAlignment(Pos.CENTER);
		visTimetable.setOnAction(new VisTimetableActionListener());
		visTimetable.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				if (WidgetSettings.getVisTimetable() == true) {
					visTimetable.getStyleClass().clear();
					visTimetable.getStyleClass().add("btn-currency-false");
				} else if (WidgetSettings.getVisTimetable() == false ) {
					visTimetable.getStyleClass().clear();
					visTimetable.getStyleClass().add("btn-currency-true");
				}
				if (WidgetSettings.getVisTimetable() == true) {
					WidgetSettings.setVisTimetable(false);
				} else if (WidgetSettings.getVisTimetable() == false) {
					WidgetSettings.setVisTimetable(true);
				}
			}
			
		});
		Button visDepartures = new Button("Visible");
		visDepartures.getStyleClass().remove("button");
		visDepartures.getStyleClass().add("btn-currency-false");
		visDepartures.setPrefSize(btn1width, btn1height);
		visDepartures.setAlignment(Pos.CENTER);
		visDepartures.setOnAction(new VisDepartActionListener());
		visDepartures.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				if (WidgetSettings.getVisDepartures() == true) {
					visDepartures.getStyleClass().clear();
					visDepartures.getStyleClass().add("btn-currency-false");
				} else if (WidgetSettings.getVisDepartures() == false ) {
					visDepartures.getStyleClass().clear();
					visDepartures.getStyleClass().add("btn-currency-true");
				}
				if (WidgetSettings.getVisDepartures() == true) {
					WidgetSettings.setVisDepartures(false);
				} else if (WidgetSettings.getVisDepartures() == false) {
					WidgetSettings.setVisDepartures(true);
				}
			}
			
		});
		Button visTickets = new Button("Visible");
		visTickets.getStyleClass().remove("button");
		visTickets.getStyleClass().add("btn-currency-false");
		visTickets.setPrefSize(btn1width, btn1height);
		visTickets.setAlignment(Pos.CENTER);
		visTickets.setOnAction(new VisTicketActionListener());
		visTickets.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				if (WidgetSettings.getVisTickets() == true) {
					visTickets.getStyleClass().clear();
					visTickets.getStyleClass().add("btn-currency-false");
				} else if (WidgetSettings.getVisTickets() == false ) {
					visTickets.getStyleClass().clear();
					visTickets.getStyleClass().add("btn-currency-true");
				}
				if (WidgetSettings.getVisTickets() == true) {
					WidgetSettings.setVisTickets(false);
				} else if (WidgetSettings.getVisTickets() == false) {
					WidgetSettings.setVisTickets(true);
				}
			}
			
		});
		
		Button settings1 = new Button("Settings");
		settings1.getStyleClass().clear();
		settings1.getStyleClass().add("btn-secondary");
		settings1.setPrefSize(btn1width, btn1height);
		Button settings2 = new Button("Settings");
		settings2.getStyleClass().clear();
		settings2.getStyleClass().add("btn-secondary");
		settings2.setPrefSize(btn1width, btn1height);
		Button settings3 = new Button("Settings");
		settings3.getStyleClass().clear();
		settings3.getStyleClass().add("btn-secondary");
		settings3.setPrefSize(btn1width, btn1height);
		Button settings4 = new Button("Settings");
		settings4.getStyleClass().clear();
		settings4.getStyleClass().add("btn-secondary");
		settings4.setPrefSize(btn1width, btn1height);

		/*
		DropShadow shadow = new DropShadow();
		//Adding the shadow when the mouse cursor is on
		visGreeting.addEventHandler(MouseEvent.MOUSE_ENTERED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		            visGreeting.setEffect(shadow);
		        }
		});
		//Removing the shadow when the mouse cursor is off
		visGreeting.addEventHandler(MouseEvent.MOUSE_EXITED, 
		    new EventHandler<MouseEvent>() {
		        @Override public void handle(MouseEvent e) {
		        	visGreeting.setEffect(null);
		        }
		});
		*/

		if(WidgetSettings.getVisGreetng() == true ) {
			visGreeting.getStyleClass().add("btn-currency-true");
		}
		if(WidgetSettings.getVisTimetable() == true ) {
			visTimetable.getStyleClass().add("btn-currency-true");
		}
		if (WidgetSettings.getVisDepartures() == true ) {
			visDepartures.getStyleClass().add("btn-currency-true");
		}
		if (WidgetSettings.getVisTickets() == true ) {
			visTickets.getStyleClass().add("btn-currency-true");
		}
		
		VisGridObservableList.setTable(grid);
		grid.add(greeting, 0, 1);
		grid.add(timetable, 0, 2);
		grid.add(departures, 0, 3);
		grid.add(tickets, 0, 4);
		grid.add(visGreeting, 1, 1);
		grid.add(visTimetable, 1, 2);
		grid.add(visDepartures, 1, 3);
		grid.add(visTickets, 1, 4);
		grid.add(settings1, 2, 1);
		grid.add(settings2, 2, 2);
		grid.add(settings3, 2, 3);
		grid.add(settings4, 2, 4);
		
		
	}
	
	
}
