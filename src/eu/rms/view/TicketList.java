package eu.rms.view;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TicketList extends GridPane {

	public TicketList() {
		this.setPadding(new Insets(20,0,10,0));
		Boolean tic = true;

		Label noTicket = new Label(" No Tickets purchased");
		
		if (tic == true) {
			this.add(noTicket, 0, 0);
		}
	}
}
