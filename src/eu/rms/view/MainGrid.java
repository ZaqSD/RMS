package eu.rms.view;

import eu.rms.model.ContentObservableList;
import eu.rms.model.MainObservableList;
import javafx.scene.layout.GridPane;

public class MainGrid extends GridPane {

	MainGrid(){
		super();

		MainObservableList.setTable(this);

		CreateGrid();
	}
	
	private void CreateGrid() {
		ContentPane content = new ContentPane();
		MenuView menu = new MenuView();
		menu.setPrefWidth(700);
		
		this.setStyle("-fx-background-color: white;");

		this.add(menu, 0, 0);
		this.add(content, 1, 0);
	}
	
	public void MapLoad(ImgView imgView, String string) {
		this.getChildren().clear();
		this.add(new MapPopoutView(imgView, string), 0, 0);
	}
	
	public void MapClose() {
		this.getChildren().clear();
		this.getChildren().add(new MenuView());
	}
}
