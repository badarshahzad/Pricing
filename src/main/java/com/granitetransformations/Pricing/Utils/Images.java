package com.granitetransformations.Pricing.Utils;

import javafx.scene.image.ImageView;

public class Images {
	public static ImageView exit(){
		String imagePath = FxDialogs.class.getResource("exit.png").toExternalForm();
        ImageView image = new ImageView(imagePath);
        return image;
	}
	public static ImageView exitIcon(){
		String imagePath = FxDialogs.class.getResource("delete-cross.png").toExternalForm();
        ImageView image = new ImageView(imagePath);
        return image;
	}
	public static ImageView document(){
		String imagePath = FxDialogs.class.getResource("doc.png").toExternalForm();
        ImageView image = new ImageView(imagePath);
        return image;
	}
	public static ImageView add(){
		String imagePath = FxDialogs.class.getResource("arrow.png").toExternalForm();
        ImageView image = new ImageView(imagePath);
        
        return image;
	}
}
