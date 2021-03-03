package eu.rms.model;

import eu.rms.view.ContentPane;
import eu.rms.view.TicketShopView;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.TableView;

public class TicketShopObservableList {

	private final static ObservableList<TicketShopView> data = FXCollections.observableArrayList();

	private static TicketShopView content = null;

	public static TicketShopView getTable() {
		return content;
	}

	public static void setTable(TicketShopView content) {
		TicketShopObservableList.content = content;
	}

	public static ObservableList<TicketShopView> getData() {
		return data;
	}

	public static ObservableList<TicketShopView> get() {
		return data;
	}

}
