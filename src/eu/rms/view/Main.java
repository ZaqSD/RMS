package eu.rms.view;

import java.sql.Connection;
import java.util.Locale;
import java.util.Optional;
import java.util.ResourceBundle;

import eu.rms.model.Currency;
import eu.rms.model.ExitAlert;
import eu.rms.model.Line;
import eu.rms.model.Login;
import eu.rms.model.User;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.shape.*;
import javafx.scene.text.Font;

public class Main extends Application {
	@Override
	public void start(Stage stage) {
		try {
			//System.out.print(javafx.scene.text.Font.getFamilies());
			Initial();
			
			BorderPane root = new BorderPane();

			MainGrid mainGrid = new MainGrid();
			
			Scene login = new Scene(root, 2000, 1000);
			login.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
			stage.setScene(login);
			stage.getIcons().add(new Image("file:Icon.png"));
			stage.setTitle("RMS");
			stage.setFullScreenExitHint(STYLESHEET_CASPIAN);
			stage.show();

			root.setCenter(mainGrid);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}


	private void Initial() {
		new Currency().getCurrency();
		new TimetableView();
		new DepartView();
		new SettingsView();
		new WidgetView();
		new MapsView();
	}


	public static void main(String[] args) {
		launch(args);
	}
}
