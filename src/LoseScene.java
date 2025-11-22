import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class LoseScene {
    public static Scene getLoseScene(int wW, int wH){
        BgmPlayer.BgmLose();
        Pane root=new Pane();
        root.getChildren().addAll(LoseList.getLoseBg(),LoseList.getLoseButton());
        return new Scene(root,wW,wH);
    }

}
