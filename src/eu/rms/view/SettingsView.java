package eu.rms.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import eu.rms.controller.VisDepartActionListener;
import eu.rms.controller.VisGreetingActionListener;
import eu.rms.controller.VisTicketActionListener;
import eu.rms.controller.VisTimetableActionListener;
import eu.rms.controller.WidgetSetActionListener;
import eu.rms.controller.LangEventHandler;
import eu.rms.model.DepartObservableList;
import eu.rms.model.IconRoutelink;
import eu.rms.model.SettingsObservableList;
import eu.rms.model.Subtitle;
import eu.rms.model.Title;
import eu.rms.model.VisGridObservableList;
import eu.rms.model.WidgetSettings;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class SettingsView extends GridPane {
	
	@SuppressWarnings("unchecked")
	public SettingsView() {
		super();

		this.setPadding(new Insets(10,50,10,10));
		//this.setHgap(15);

		Title title = new Title("Settings");
		Subtitle setTheme = new Subtitle("Themes");
		ThemesRow themesRow = new ThemesRow();
		Subtitle setContent = new Subtitle("Content");
		Subtitle setWidget = new Subtitle("Widgets");
		Button btnSetAccount = new Button("Account-Settings");
		btnSetAccount.getStyleClass().add("btn-primary");
		btnSetAccount.setPrefSize(274, 60);
		Label setCurrency = new Label("Active Currency");
		Label filler = new Label();
		filler.setPrefSize(100, 20);
		
		Label smallFiller1 = new Label();
		smallFiller1.setPrefSize(10, 60);
		Label smallFiller2 = new Label();
		smallFiller1.setPrefSize(10, 60);
		Label smallFiller3 = new Label();
		smallFiller1.setPrefSize(10, 60);
		Label smallFiller4 = new Label();
		smallFiller1.setPrefSize(10, 60);
		
		Label greeting = new Label("Greeting");
		Label timetable = new Label("Timetable");
		Label departures = new Label("Departures");
		Label tickets = new Label("Tickets");
		
		int btn1width = 132;
		int btn1height = 60;
		
		Button btnEUR = new Button("CHF");
		btnEUR.getStyleClass().add("btn-currency-true");
		btnEUR.setPrefSize(137, 60);

		Button btnCHF = new Button("EUR");
		btnCHF.getStyleClass().add("btn-currency-false");
		btnCHF.setPrefSize(137, 60);

		
		btnEUR.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				//Set EUR
				btnEUR.getStyleClass().add("btn-currency-true");
				btnCHF.getStyleClass().clear();
				btnCHF.getStyleClass().addAll("button","btn-currency-false");
			}
			
		});
		
		btnCHF.setOnAction(new EventHandler() {

			@Override
			public void handle(Event arg0) {
				//Set CHF
				btnCHF.getStyleClass().add("btn-currency-true");
				btnEUR.getStyleClass().clear();
				btnEUR.getStyleClass().addAll("button","btn-currency-false");
			}
			
		});
		
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
		
		GridPane settings1 = new GridPane();
		settings1.setPrefSize(btn1width, btn1height);
		GridPane settings2 = new GridPane();
		settings2.setPrefSize(btn1width, btn1height);
		GridPane settings3 = new GridPane();
		settings3.setPrefSize(btn1width, btn1height);
		GridPane settings4 = new GridPane();
		settings4.setPrefSize(btn1width, btn1height);

		Button up1 = new Button();
		up1.setPrefSize(btn1width, btn1height);
		Button up2 = new Button();
		up2.setPrefSize(btn1width, btn1height);
		Button up3 = new Button();
		up3.setPrefSize(btn1width, btn1height);
		Button down1 = new Button();
		down1.setPrefSize(btn1width, btn1height);
		Button down2 = new Button();
		down2.setPrefSize(btn1width, btn1height);
		Button down3 = new Button();
		down3.setPrefSize(btn1width, btn1height);

		//TODO Add Customization of Widget Assortment
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

		//TODO FontSize Settings < Visibilty
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
		
		GridPane btnCurrency = new GridPane();
		btnCurrency.add(btnCHF, 0, 0);
		btnCurrency.add(btnEUR, 1, 0);
		
		Label fill = new Label("");
		fill.setPrefSize(100, 60);
		
		this.setHgap(0);
		this.setVgap(15);
	
		this.add(title, 0, 0);
		this.add(setTheme, 0, 1);
		this.add(themesRow, 0, 2, 5, 1);
		this.add(setContent, 0, 3);
		this.add(setCurrency, 0, 4);
		this.add(filler, 1, 4);
		this.add(btnCurrency, 2, 4, 3, 1);
		this.add(setWidget, 0, 5);
		this.add(greeting, 0, 6);
		this.add(timetable, 0, 7);
		//this.add(departures, 0, 6);
		this.add(tickets, 0, 8);
		this.add(visGreeting, 2, 6);
		this.add(visTimetable, 2, 7);
		//this.add(visDepartures, 2, 6);
		this.add(visTickets, 2, 8);
		this.add(settings1, 4, 6);
		this.add(settings2, 4, 7);
		//this.add(settings3, 4, 6);
		this.add(settings4, 4, 8);
		this.add(smallFiller1, 3, 6);
		SettingsObservableList.setTable(this);
		
	}
	
}
