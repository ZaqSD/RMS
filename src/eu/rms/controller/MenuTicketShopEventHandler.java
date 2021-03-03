package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.DepartObservableList;
import eu.rms.model.TicketShopObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.DepartView;
import eu.rms.view.TicketShopView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MenuTicketShopEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane content = ContentObservableList.getTable();
		TicketShopView ticketShopView = TicketShopObservableList.getTable();
		content.Reload(ticketShopView);
		
	}

}
