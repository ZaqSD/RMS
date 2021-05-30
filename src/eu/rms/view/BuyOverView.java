package eu.rms.view;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import eu.rms.model.BuyVerificationViewObservableList;
import eu.rms.model.ContentObservableList;
import eu.rms.model.SearchResult;
import eu.rms.model.Subtitle;
import eu.rms.model.TimResultDetailViewObservableList;
import eu.rms.model.Title;
import eu.rms.view.timetable.TimResultDetailView;
import eu.rms.view.timetable.TimetableView;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.text.TextAlignment;

public class BuyOverView extends GridPane {

	public BuyOverView(SearchResult[] searchResults, String prename, String name, LocalDate birthday, String gender) {

		this.setVgap(10);
		this.setHgap(25);
		
		Title title = new Title("Confirm Ticket Purchase");
		
		SearchResult linStart = searchResults[0];
		SearchResult linDestination = searchResults[searchResults.length-1];
		String formattedBday = birthday.format(DateTimeFormatter.ofPattern("dd.MM.yy"));
	
		Label labRoute = new Label(linStart.getLinStart() + " ➔ " + linDestination.getLinEnd());
		Label labName = new Label(prename + " " + name);
		Label labGender = new Label(gender);
		Label labBirthday = new Label(formattedBday);
		Button btnConfirm = new Button("Confirm Purchase \n 4.90");
		btnConfirm.getStyleClass().add("btn-primary");
		btnConfirm.setPrefWidth(250);
	    btnConfirm.setTextAlignment(TextAlignment.CENTER);
	    btnConfirm.setOnAction( λ -> {
			ContentPane content = ContentObservableList.getTable();
			this.getChildren().clear();
			this.add(new Subtitle("Your purchase is currently getting processed..."), 0, 0);
			this.add(new Subtitle("Please wait"), 0, 1);
			content.Reload(new BuyVerificationView(searchResults, prename, name, birthday, gender));
		});
	    
		Button btnCancel = new Button("Cancel \nPurchase");
		btnCancel.getStyleClass().add("btn-danger");
		btnCancel.setPrefWidth(200);
	    btnCancel.setTextAlignment(TextAlignment.CENTER);
	    btnCancel.setOnAction( λ -> {
			TimResultDetailView view = TimResultDetailViewObservableList.getTable();
			ContentPane content = ContentObservableList.getTable();
			content.Reload(view);
		});
		
		this.add(title, 0, 0, 2, 1);
		this.add(labRoute, 0, 2, 2, 1);
		this.add(labName, 0, 4);
		this.add(labGender, 0, 5);
		this.add(labBirthday, 0, 6);
		this.add(btnConfirm, 0, 7);
		this.add(btnCancel, 1, 7);
	}

}
