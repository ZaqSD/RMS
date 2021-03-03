package eu.rms.view;

import eu.rms.model.DepartObservableList;
import eu.rms.model.TicketShopObservableList;
import javafx.scene.layout.GridPane;

public class TicketShopView extends GridPane {

	public TicketShopView() {
		TicketBox lineticket = new TicketBox("Daypass");
		TicketBox dayticket = new TicketBox("Daypass");
		TicketBox generalticket = new TicketBox("Generalticket");

		this.add(lineticket, 0, 0);
		this.add(dayticket, 0, 1);
		this.add(generalticket, 0, 2);
		TicketShopObservableList.setTable(this);

	}
}
