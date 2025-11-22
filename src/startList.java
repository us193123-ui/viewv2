import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class startList {
    //背景
    public static ImageView getStartBackGround(int wW,int wH){
        Image backGroundImage = new Image(MyApp.class.getResource("background/APEX.jfif").toExternalForm());
        ImageView backGroundImageView = new ImageView(backGroundImage);
        backGroundImageView.setPreserveRatio(true);
        backGroundImageView.setLayoutX(-(backGroundImage.getWidth() / 2 - wW / 2));
        backGroundImageView.setLayoutY(-(backGroundImage.getHeight() / 2 - wH / 2));
        return backGroundImageView;
    }
    //スタートボタン
    public static Button getStartButton(){
        Button startButton = new Button("Start");
        startButton.setPrefWidth(100);
        startButton.setPrefHeight(50);
        startButton.setLayoutX(350);
        startButton.setLayoutY(500);
        startButton.setOnAction(e->SceneManager.showSelect());
        return startButton;
    }

}
