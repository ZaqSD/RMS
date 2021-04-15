package eu.rms.model;

import javafx.scene.image.Image;

public class IconRoutelink {

	private final static Image s_n = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_0_0.png"));
	private final static Image s_b = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_0_1.png"));
	private final static Image m_n = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_1_0.png"));
	private final static Image m_t = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_1_1.png"));
	private final static Image m_b = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_1_2.png"));
	private final static Image m_m = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_1_3.png"));
	private final static Image b_n = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_2_0.png"));
	private final static Image b_t = new Image(Logo.class.getResourceAsStream("../ressources/img/routelink/RMS_Station_2_1.png"));


	public static Image getSN() {
		return s_n;
	}

	public static Image getSB() {
		return s_b;
	}


	public static Image getMN() {
		return m_n;
	}


	public static Image getMT() {
		return m_t;
	}


	public static Image getMB() {
		return m_b;
	}


	public static Image getMM() {
		return m_m;
	}


	public static Image getBN() {
		return b_n;
	}


	public static Image getBT() {
		return b_t;
	}

	
}
