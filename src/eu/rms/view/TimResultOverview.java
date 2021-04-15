package eu.rms.view;

import java.lang.reflect.Array;

import eu.rms.model.IconLine;
import eu.rms.model.IconRoutelink;
import eu.rms.model.Subtitle;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class TimResultOverview extends GridPane{

	public TimResultOverview(int linId) {
		
		//TODO Get Array of Stations from DB
		String[] lineStations = {"Genève","Lausanne","Fribourg/Freiburg","Bern","Zürich HB"};
		
		String start = "Lausanne";
		String destination = "Bern";
		
		GridPane stationsView = new GridPane();
		GridPane informationView = new GridPane();
		
		informationView.getStyleClass().add("widget");
		
		Subtitle infLin = new Subtitle(" RE-"+linId);
		Label infDestination = new Label("Direction " + lastStation(lineStations));
		
		informationView.add(new ImgView(IconLine.getIc1()), 0, 0);
		informationView.add(infLin, 1, 0);
		
		informationView.add(infDestination, 0, 1, 2, 1);
		
		Boolean isRoute = false;
		for (int i = 0; i < lineStations.length; i++) {
			if(lineStations[i].intern() == start) {
				isRoute = true;  
			}
			if(lineStations[i].intern() == destination) {
				isRoute = false;
			}
			
			if (i == 0 && isRoute == false) {
				
				stationsView.add(new ImgView(IconRoutelink.getSN()), 1, i);
				stationsView.add(new Subtitle(lineStations[i]), 2, i);

			} else if (i == 0 && isRoute == true) {	
				
				stationsView.add(new ImgView(IconRoutelink.getSB()), 1, i);
				stationsView.add(new Subtitle(lineStations[i]), 2, i);

			} else if (i >= 1 && i < lineStations.length-1 && isRoute == false) {
				
				if(lineStations[i].intern() == destination) {
					stationsView.add(new ImgView(IconRoutelink.getMT()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				} else {
					stationsView.add(new ImgView(IconRoutelink.getMN()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				}
				
			} else if (i >= 1 && i < lineStations.length-1 && isRoute == true) {
				if(lineStations[i].intern() == start) {
					stationsView.add(new ImgView(IconRoutelink.getMB()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				} else {
					stationsView.add(new ImgView(IconRoutelink.getMM()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				}	
			} else if (i == lineStations.length-1 && isRoute == false) {

				if(lineStations[i].intern() == destination) {
					stationsView.add(new ImgView(IconRoutelink.getBT()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				} else {
					stationsView.add(new ImgView(IconRoutelink.getBN()), 1, i);
					stationsView.add(new Subtitle(lineStations[i]), 2, i);
				}
				
			}
		}
		
		this.add(stationsView, 0, 1);
		this.add(informationView, 0, 0);
	}

	private String lastStation(String[] stations) {

		return stations[stations.length-1];
	}

}
