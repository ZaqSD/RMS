package eu.rms.view.widgets;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class GreetingWidget extends GridPane {
	
		public GreetingWidget() {
			
			this.getStyleClass().add("widget");
			this.setPrefWidth(700);
			
			String scene = "";
			Calendar calendar = new GregorianCalendar();
			int hour  = calendar.get(Calendar.HOUR_OF_DAY);
			if (hour >= 21 || hour <= 5 ) {
				 scene = "Night";
			} else if (hour >= 11 && hour <= 6) {
				 scene = "Morning";
			} else if (hour == 12 ) {
				 scene = "Noon";
			} else if (hour >= 13 && hour <= 16) {
				 scene = "Afternoon";
			} else if (hour >= 17 && hour <= 20) {
				 scene = "Evening";
			} else {
				 scene = "Day";
			}

			Label sentence = new Label("Good " + scene);
			sentence.setStyle("-fx-font-family: 'arial black'; -fx-font-size: 40px;");
			
			Label sentence3 = new Label("It is " + calendar.get(Calendar.HOUR_OF_DAY) + ":" + calendar.get(Calendar.MINUTE) + ", " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH)+1 + "/" + calendar.get(Calendar.YEAR));
			Label sentence4 = new Label("It is " + calendar.get(Calendar.HOUR_OF_DAY) + ":0" + calendar.get(Calendar.MINUTE) + ", " + calendar.get(Calendar.DAY_OF_MONTH) + "/" + calendar.get(Calendar.MONTH)+1 + "/" + calendar.get(Calendar.YEAR));
			
			this.add(sentence, 1, 0);
			
			if(calendar.get(Calendar.MINUTE) < 10) {
				this.add(sentence4, 1, 1);
			} else {
				this.add(sentence3, 1, 1);
			}
			//this.add(date, 1, 0);
			//this.add(time, 0, 2);
		}
}
