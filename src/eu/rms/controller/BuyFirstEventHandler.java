package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.view.BuyFormView;
import eu.rms.view.ContentPane;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class BuyFirstEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		ContentPane contentPane = ContentObservableList.getTable();
		contentPane.Reload(new BuyFormView());
	}

}
