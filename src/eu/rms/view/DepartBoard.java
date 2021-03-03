package eu.rms.view;

import eu.rms.model.LineObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DepartBoard extends TableView{

	public DepartBoard() {
		super();
		
		TableColumn<String, String> tagCol = new TableColumn<String, String>("");
		tagCol.setCellValueFactory(new PropertyValueFactory<String, String>("lineTag"));
		tagCol.setPrefWidth(83);

		TableColumn<String, String> departCol = new TableColumn<String, String>("Depart");
		departCol.setCellValueFactory(new PropertyValueFactory<String, String>("depart"));
		departCol.setPrefWidth(65);
		
		TableColumn<String, String> destinationCol = new TableColumn<String, String>("Destination");
		destinationCol.setCellValueFactory(new PropertyValueFactory<String, String>("destination"));
		destinationCol.setPrefWidth(170);
		
		TableColumn<String, String> stationCol = new TableColumn<String, String>("Stops");
		stationCol.setCellValueFactory(new PropertyValueFactory<String, String>("stops"));
		stationCol.setPrefWidth(300);
		
		TableColumn<String, String> gleisCol = new TableColumn<String, String>("Gleis");
		gleisCol.setCellValueFactory(new PropertyValueFactory<String, String>("gleis"));
		gleisCol.setPrefWidth(50);
		
		TableColumn<String, String> warningCol = new TableColumn<String, String>();
		warningCol.setCellValueFactory(new PropertyValueFactory<String, String>("warning"));
		warningCol.setPrefWidth(56);
		
		//Add Columns
		this.getColumns().add(tagCol);
		this.getColumns().add(departCol);
		this.getColumns().add(destinationCol);
		this.getColumns().add(stationCol);
		this.getColumns().add(gleisCol);
		this.getColumns().add(warningCol);
        
		//this.setItems(AddressObservableList.get());

		//link DataList
		this.setItems(LineObservableList.get());
		
		//add test data
		//LineObservableList.get().add(new Line("ir75"));
		//LineObservableList.get().add(new Line("Herr","Fritz","Muster"));
		//LineObservableList.get().add(new Line("Frau","Anna","Meier"));

	}
}
