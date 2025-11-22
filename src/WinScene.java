import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class WinScene {
    public static Scene getWinScene(int wW,int wH){
       BgmPlayer.BgmWin();
        Pane root =new Pane();
        root.getChildren().addAll(WinList.getWinBg(),WinList.getWinButton());
        return new Scene(root,wW,wH);
    }
}
