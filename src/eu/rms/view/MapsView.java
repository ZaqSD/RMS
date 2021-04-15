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
import eu.rms.model.IconButton;
import eu.rms.model.MapsObservableList;
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

public class MapsView extends GridPane {
	
	@SuppressWarnings("unchecked")
	public MapsView() {
		super();

		this.setPadding(new Insets(10,50,10,10));
		this.setHgap(10);
		this.setVgap(10);

		Title title = new Title("Maps");
		
		this.add(title, 0, 0);

		MapsObservableList.setTable(this);
		
		MainMapGrid mainMapGrid = new MainMapGrid();
		
		ZhMapGrid zhSBahn = new ZhMapGrid();
		TlMapGrid tlMetro = new TlMapGrid();
		LexMapGrid lex = new LexMapGrid();

		this.add(mainMapGrid, 0, 1, 2, 1);

		this.add(zhSBahn, 0, 2, 1, 1);
		this.add(tlMetro, 1, 2, 1, 1);
		this.add(lex, 0, 3, 1, 1);
	}
	
}
