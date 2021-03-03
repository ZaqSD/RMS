package eu.rms.view;

import javafx.scene.control.Dialog;
import javafx.scene.control.DialogPane;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import eu.rms.model.Login;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.util.Callback;

public class LoginDialog<T> extends Dialog<Login> {

	public LoginDialog() {
		super();
		
		this.setTitle("RMS - Login");
		createDialog(new Login("",""));
	}

	private void createDialog(Login login){		
		DialogPane dialogPane = this.getDialogPane();
		dialogPane.getStylesheets().add(getClass().getResource("css/application.css").toExternalForm());
		this.setHeaderText("Login");
		
		ButtonBar buttonBar = new ButtonBar();
		
		Label labelEmail = new Label("Email : ");
		Label labelPassword = new Label("Password : ");
		Label labelFill = new Label(" ");
		
		labelFill.setStyle("-fx-font-size: 2px");

		TextField textEmail = new TextField();
		TextField textPassword = new TextField();
				
		ButtonType btnLogin = new ButtonType("Login", ButtonData.OK_DONE);
		Button btnRegister = new Button("Register");
		//TODO set ButtonSize
		
		labelEmail.getStyleClass().add("dialog-label");
		labelPassword.getStyleClass().add("dialog-label");
		textEmail.getStyleClass().add("dialog-text");
		textPassword.getStyleClass().add("dialog-text");
		btnRegister.getStyleClass().add("dialog-btn-secondrary");

		GridPane grid = new GridPane();
		grid.setPadding(new Insets(15, 12, 15, 12));
		grid.add(labelEmail, 1, 2);
		grid.add(textEmail, 2, 2);
		grid.add(labelFill, 1, 3);
		grid.add(labelPassword, 1, 4);
		grid.add(textPassword, 2, 4);
		//grid.add(btnRegister, 1, 5);
		
		//Fix buttons that dont listen to your code
		
		this.getDialogPane().setContent(grid);

		grid.getStyleClass().add("dialog-grid");
		this.getDialogPane().getButtonTypes().add(btnLogin);

		if (textEmail.getText().isEmpty() || textPassword.getText().isEmpty()) {
			
		}
			
	}
}
		
