import javafx.scene.image.ImageView;
import javafx.stage.Stage;
public class SceneManager{
    static int wW=800;
    static int wH=600;
    public static Stage stage;


    public static void showStart(){
        stage.setScene(StartScene.getStartScene(wW,wH));
    }

    public static void showSelect(){
        stage.setScene(SelectScene.getSelectScene(wW,wH));
    }

    public static void showBattle(Legend meLegend, Legend compLegend, ImageView meView, ImageView compView){
        stage.setScene(BattleScene.getBattleScene(meLegend,compLegend,meView,compView,wW,wH));
    }

    public static void showWin(){
        stage.setScene(WinScene.getWinScene(wW,wH));
    }
    public static void showLose(){
        stage.setScene(LoseScene.getLoseScene(wW,wH));
    }


    public static void setStage(Stage firstStage){
        stage=firstStage;
    }
}
