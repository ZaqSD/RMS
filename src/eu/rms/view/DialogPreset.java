package eu.rms.view;

import eu.rms.model.WidgetSettings;
import javafx.geometry.Insets;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.layout.GridPane;

public class DialogPreset<T> extends Dialog<WidgetSettings> {
	
	public DialogPreset() {
		super();
		
		this.setTitle("RMS - Personalize Widgets");
		createDialog();
	}
	
	private void createDialog(){		
		GridPane grid = new GridPane();
		
		this.getDialogPane().setContent(grid);
		
		ButtonType buttonTypeOk = new ButtonType("Save", ButtonData.OK_DONE);
		this.getDialogPane().getButtonTypes().add(buttonTypeOk);
		
		ButtonType buttonTypeCancel = new ButtonType("Cancel", ButtonData.CANCEL_CLOSE);
		this.getDialogPane().getButtonTypes().add(buttonTypeCancel);
		
	}
}
