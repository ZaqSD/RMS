package eu.rms.view;

import java.util.Locale;
import java.util.ResourceBundle;

import eu.rms.controller.MenuDepartEventHandler;
import eu.rms.controller.MenuSettingsEventHandler;
import eu.rms.controller.MenuTicketShopEventHandler;
import eu.rms.controller.MenuTimetableEventHandler;
import eu.rms.controller.MenuWidgetEventHandler;
import eu.rms.controller.exitEventHandler;
import eu.rms.controller.langEventHandler;
import eu.rms.model.IconButton;
import eu.rms.model.Line;
import eu.rms.model.Logo;
import javafx.application.Platform;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.TilePane;

public class MenuView extends GridPane {

	ResourceBundle properties = ResourceBundle.getBundle("eu.rms.ressources.Application");

	Locale locale_de = new Locale("de");
	Locale locale_en = new Locale("en");
	Locale locale_fr = new Locale("fr");
	Locale locale_it = new Locale("it");
	
	private int tileWidth = 300;
	private int tileHeight = 150;
	private int langWidth = 75;
	private int langHeight = 75;

	private String language = "";
	
	public MenuView() {
		super();

		this.language = properties.getString("Language");
		Reload(language);	

	}

	@SuppressWarnings("unchecked")
	public void Reload(String language) {
		
		if (properties.getString("Language").contains("de")) {
			ResourceBundle.getBundle("eu.rms.lang.Lang_de", locale_de);
		} else if (properties.getString("Language").contains("fr")) {
			ResourceBundle.getBundle("eu.rms.lang.Lang_fr", locale_fr);
		} else if (properties.getString("Language").contains("it")) {
			ResourceBundle.getBundle("eu.rms.lang.Lang_it", locale_it);
		} else {
			ResourceBundle.getBundle("eu.rms.lang.Lang_en", locale_en);
		}
		
		// Create Buttons
		Button tile = new Button("Timetable");
		tile.getStyleClass().add("menutile");
		tile.setPrefSize(tileWidth, tileHeight);
		tile.setOnAction(new MenuTimetableEventHandler());
		tile.setGraphic(new ImgView(IconButton.getTimetable2x()));
		Button tile2 = new Button("Next Departs");
		tile2.getStyleClass().add("menutile");
		tile2.setPrefSize(tileWidth, tileHeight);
		tile2.setOnAction(new MenuDepartEventHandler());
		tile2.setGraphic(new ImgView(IconButton.getDisplay2x()));
		Button tile3 = new Button("Ticketshop");
		tile3.getStyleClass().add("menutile");
		tile3.setPrefSize(tileWidth, tileHeight);
		tile3.setGraphic(new ImgView(IconButton.getTicket2x()));
		tile3.setOnAction(new MenuTicketShopEventHandler());
		Button tile4 = new Button("Widgets");
		tile4.getStyleClass().add("menutile");
		tile4.setPrefSize(tileWidth, tileHeight);
		tile4.setOnAction(new MenuWidgetEventHandler());
		tile4.setGraphic(new ImgView(IconButton.getHouse2x()));
		Button tile5 = new Button("My Routes & Tickets");
		tile5.getStyleClass().add("menutile");
		tile5.setPrefSize(tileWidth, tileHeight);
		tile5.setGraphic(new ImgView(IconButton.getQrcode2x()));
		Button tile6 = new Button("Settings");
		tile6.getStyleClass().add("menutile");
		tile6.setPrefSize(tileWidth, tileHeight);
		tile6.setOnAction(new MenuSettingsEventHandler());
		tile6.setGraphic(new ImgView(IconButton.getGears2x()));
		Button tile7 = new Button("Info");
		tile7.getStyleClass().add("menutile");
		tile7.setPrefSize(tileWidth, tileHeight);
		tile7.setGraphic(new ImgView(IconButton.getInfo2x()));
		Button tile8 = new Button("Exit & Logout");
		tile8.setGraphic(new ImgView(IconButton.getExit2x()));
		tile8.getStyleClass().add("menutile-exit");
		tile8.setPrefSize(tileWidth, tileHeight);
		tile8.setOnAction(new EventHandler() {

			@Override
			public void handle(Event event) {
				System.out.println("kdhkdksgdkg");
				Platform.exit();
			}
		});

		// LanguageTile
		TilePane tile9 = new TilePane();
		tile9.getStyleClass().add("menutile-language");
		tile9.setPrefSize(tileWidth, tileHeight / 2);
		tile9.setOrientation(Orientation.HORIZONTAL);
		tile9.setPrefRows(1);

		// LanguageButtons and Logo

		BorderPane tile0 = new BorderPane();
		tile0.setCenter(new ImgView(Logo.getLogo()));
		tile0.getStyleClass().add("menutitle");
		tile0.setPrefSize(tileWidth, tileHeight / 2);

		Button btnLangDe = new Button("DE");
		btnLangDe.getStyleClass().add("btn-language-false");
		btnLangDe.setPrefSize(langWidth, langHeight);
		tile8.setOnAction(new langEventHandler());

		Button btnLangEn = new Button("EN");
		btnLangEn.getStyleClass().add("btn-language-false");
		btnLangEn.setPrefSize(langWidth, langHeight);

		Button btnLangFr = new Button("FR");
		btnLangFr.getStyleClass().add("btn-language-false");
		btnLangFr.setPrefSize(langWidth, langHeight);

		Button btnLangIt = new Button("IT");
		btnLangIt.getStyleClass().add("btn-language-false");
		btnLangIt.setPrefSize(langWidth, langHeight);

		if (properties.getString("Language").contains("de")) {
			btnLangDe.getStyleClass().add("btn-language-true");
		} else if (properties.getString("Language").contains("fr")) {
			btnLangFr.getStyleClass().add("btn-language-true");
		} else if (properties.getString("Language").contains("it")) {
			btnLangIt.getStyleClass().add("btn-language-true");
		} else {
			btnLangEn.getStyleClass().add("btn-language-true");
		}
		
		// Add Elements
		tile9.getChildren().addAll(btnLangDe, btnLangEn, btnLangFr, btnLangIt);

		this.add(tile0, 0, 0, 1, 1);
		this.add(tile9, 1, 0, 1, 1);
		this.add(tile, 1, 1, 1, 1);
		this.add(tile2, 0, 2, 1, 1);
		this.add(tile3, 1, 2, 1, 1);
		this.add(tile4, 0, 1, 1, 1);
		this.add(tile5, 0, 3, 1, 1);
		this.add(tile6, 1, 3, 1, 1);
		this.add(tile7, 0, 4, 1, 1);
		this.add(tile8, 1, 4, 1, 1);
		// this.add(tile9, 0, 5, 2, 2);

		this.setHgap(10);
		this.setVgap(10);	
		this.setPadding(new Insets(10,0,0,10));
	}

	public int getTileWidth() {
		return tileWidth;
	}

	public void setTileWidth(int tileWidth) {
		this.tileWidth = tileWidth;
	}

	public int getTileHeight() {
		return tileHeight;
	}

	public void setTileHeight(int tileHeight) {
		this.tileHeight = tileHeight;
	}

	public int getLangWidth() {
		return langWidth;
	}

	public void setLangWidth(int langWidth) {
		this.langWidth = langWidth;
	}

	public int getLangHeight() {
		return langHeight;
	}

	public void setLangHeight(int langHeight) {
		this.langHeight = langHeight;
	}

}
