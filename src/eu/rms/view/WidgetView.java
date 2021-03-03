package eu.rms.view;

import eu.rms.model.TimetableObservableList;
import eu.rms.model.WidgetObservableList;
import eu.rms.model.WidgetSettings;
import eu.rms.view.widgets.DepartWidget;
import eu.rms.view.widgets.GreetingWidget;
import eu.rms.view.widgets.NoWidget;
import eu.rms.view.widgets.TicketWidget;
import eu.rms.view.widgets.TimetableWidget;
import eu.rms.view.widgets.Widget;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class WidgetView extends GridPane {

	public WidgetView() {
		Label filler = new Label("");
		Label filler2 = new Label("");
		Label filler3 = new Label("");
		Label filler4 = new Label("");
		Label filler5 = new Label("");

		GreetingWidget greeting = new GreetingWidget();
		TimetableWidget timetable = new TimetableWidget();
		//DepartWidget departs = new DepartWidget();
		TicketWidget tickets = new TicketWidget();
		NoWidget noWidget = new NoWidget();

		this.setHgap(20);
		if (WidgetSettings.getVisGreetng() == true) {
			this.add(greeting, 0, 1);
			this.add(filler2, 0, 2);
		}
		if (WidgetSettings.getVisTimetable() == true) {
			this.add(timetable, 0, 3);
			this.add(filler3, 0, 3);
		}
		
			//this.add(departs, 0, 4);
			this.add(filler4, 0, 4);
		
		 
		if (WidgetSettings.getVisTickets() == true) {
			this.add(tickets, 0, 5);
			this.add(filler5, 0, 5);
		}
		this.add(filler, 0, 0);

		if (WidgetSettings.getVisGreetng() == false && WidgetSettings.getVisTickets() == false
				&& WidgetSettings.getVisTimetable() == false) {
			this.add(noWidget, 0, 1);
		}

	}
}
