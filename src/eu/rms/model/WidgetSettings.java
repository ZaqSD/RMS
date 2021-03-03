package eu.rms.model;

public class WidgetSettings {

	private static Boolean visGreetng = true;
	private static Boolean visTimetable = true;
	private static Boolean visDepartures = true;
	private static Boolean visTickets = true;
	private static String departuresStation = "Zurich HB";

	public static String getDeparturesStation() {
		return departuresStation;
	}

	public static void setDeparturesStation(String departuresStation) {
		WidgetSettings.departuresStation = departuresStation;
	}

	public static Boolean getVisGreetng() {
		return visGreetng;
	}

	public static void setVisGreetng(Boolean visGreetng2) {
		WidgetSettings.visGreetng = visGreetng2;
	}

	public static Boolean getVisTimetable() {
		return visTimetable;
	}

	public static void setVisTimetable(Boolean visTimetable) {
		WidgetSettings.visTimetable = visTimetable;
	}

	public static Boolean getVisDepartures() {
		return visDepartures;
	}

	public static void setVisDepartures(Boolean visDepartures) {
		WidgetSettings.visDepartures = visDepartures;
	}

	public static Boolean getVisTickets() {
		return visTickets;
	}

	public static void setVisTickets(Boolean visTickets) {
		WidgetSettings.visTickets = visTickets;
	}

}
