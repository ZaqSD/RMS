package eu.rms.view;

import eu.rms.model.ContentObservableList;
import eu.rms.model.SearchResultObservableList;
import eu.rms.model.Subtitle;
import eu.rms.model.TimResultDetailViewObservableList;
import eu.rms.model.Title;
import eu.rms.view.timetable.TimResultDetailOverView;
import eu.rms.view.timetable.TimResultDetailView;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;


public class BuyFormView extends GridPane {

	public BuyFormView() {
		this.setVgap(10);
		this.setHgap(20);
		
		Title title = new Title("Buy a Ticket");
		Subtitle subPersonal = new Subtitle("Personal Information");
		
		Label labPrename = new Label("Prename");
		TextField textPrename = new TextField();
		Label labName = new Label("Name");
		TextField textName = new TextField();
		Label labBirthday = new Label("Birthday");
		DatePicker birthday = new DatePicker();
		birthday.getStyleClass().add("date-picker");
		Label labGender = new Label("Gender");
		final ToggleGroup gender = new ToggleGroup();
		RadioButton radMale = new RadioButton();
		radMale.setText("Male");
		radMale.isSelected();
		radMale.setToggleGroup(gender);
		radMale.setUserData("M");
		RadioButton radFemale = new RadioButton();
		radFemale.setText("Female");
		radFemale.setToggleGroup(gender);
		radFemale.setUserData("F");
		GridPane genderToggles = new GridPane();
		genderToggles.setHgap(25);
		genderToggles.add(radMale, 0, 0);
		genderToggles.add(radFemale, 1, 0);
		
		Button btnBuy = new Button("Continue");
		btnBuy.getStyleClass().add("btn-primary");
		btnBuy.setPrefWidth(350);
		btnBuy.setOnAction( λ -> {
			RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
			String genderString = selectedRadioButton.getText();
			
			ContentPane content = ContentObservableList.getTable();
			content.Reload(new BuyOverView(SearchResultObservableList.getTable(), textPrename.getText(), textName.getText(), birthday.getValue(), genderString));
		});
		Button btnCancel = new Button("Cancel");
		btnCancel.getStyleClass().add("btn-secondary");
		btnCancel.setPrefWidth(350);
		btnCancel.setOnAction( λ -> {
			TimResultDetailView view = TimResultDetailViewObservableList.getTable();
			ContentPane content = ContentObservableList.getTable();
			content.Reload(view);
		});
		
		this.add(title, 0, 0);
		this.add(subPersonal, 0, 1);
		this.add(labGender, 0, 2);
		this.add(labBirthday, 1, 2);
		this.add(genderToggles, 0, 3);
		this.add(birthday, 1, 3);
		this.add(labPrename, 0, 4);
		this.add(labName, 1, 4);
		this.add(textPrename, 0, 5);
		this.add(textName, 1, 5);
		this.add(btnBuy, 0, 6);
		this.add(btnCancel, 1, 6);
	}
	
}
