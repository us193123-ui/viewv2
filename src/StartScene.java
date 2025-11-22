import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;

public class StartScene {
    public static Scene getStartScene(int wW,int wH) {
        BgmPlayer.BgmStart();
        Pane root = new Pane();
        //背景、スタートボタン
        root.getChildren().addAll(startList.getStartBackGround(wW,wH), startList.getStartButton());
        return new Scene(root,wW,wH);
    }
}
