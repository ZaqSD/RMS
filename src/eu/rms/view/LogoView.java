package eu.rms.view;

import eu.rms.model.Logo;
import javafx.scene.image.ImageView;

public class LogoView extends ImageView{

	public LogoView() {
		super();
		Logo logo = new Logo();
		
		this.setImage(logo);
	}
}
