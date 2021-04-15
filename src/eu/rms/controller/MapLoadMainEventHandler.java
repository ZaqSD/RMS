package eu.rms.controller;

import eu.rms.model.ContentObservableList;
import eu.rms.model.IconMap;
import eu.rms.model.MainObservableList;
import eu.rms.view.ContentPane;
import eu.rms.view.ImgView;
import eu.rms.view.MainGrid;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

public class MapLoadMainEventHandler implements EventHandler<ActionEvent> {

	@Override
	public void handle(ActionEvent arg0) {

		MainGrid content = MainObservableList.getTable();
		ImgView imgView = new ImgView(IconMap.getFvL());

		content.MapLoad(imgView, "FV");
		
	}

}
