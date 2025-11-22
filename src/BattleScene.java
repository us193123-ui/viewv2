import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class BattleScene {
    static Button attackButton=BattleList.getAttackButton();
    static Button recoveryButton=BattleList.getRecoveryButton();
    public static Scene getBattleScene(Legend meLegend,Legend compLegend,ImageView meView,ImageView compView,int wW,int wH){
        BgmPlayer.BgmBattle();
        AudioClip Ng=new AudioClip(MyApp.class.getResource("sounds/ビープ音4.mp3").toExternalForm());
        AudioClip choice=new AudioClip(MyApp.class.getResource("sounds/決定ボタンを押す17.mp3").toExternalForm());
        AudioClip nockDown=new AudioClip(MyApp.class.getResource("sounds/apex-legends-knockdown-sound-effect_0xqJePf.mp3").toExternalForm());
        //meLegendView compLegendView
        LegendUI mLUI=new LegendUI(meLegend,meView,BattleList.getHpBarMe(),BattleList.getPlayerHpLabel(meLegend));
        LegendUI cLUI =new LegendUI(compLegend,compView,BattleList.getHpBarComp(),BattleList.getCompHpLabel(compLegend));
        if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
            recoveryButton.setOpacity(0.2);
        }
        //アクション
        attackButton.setOnAction(e->{
            choice.play();
            buttonOnOff(true,meLegend);
            GameManager.attack(meLegend,compLegend,cLUI,mLUI);

        });
        recoveryButton.setOnAction(e->{
            if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
                Ng.play();
                return;
            }
            else {
                choice.play();
                buttonOnOff(true, meLegend);
                GameManager.recovery(meLegend, compLegend, cLUI, mLUI);
            }
        });



        Pane root = new Pane(BattleList.getBg(wW,wH),mLUI.legendView,mLUI.hpBar,mLUI.hpLabel, cLUI.legendView, cLUI.hpBar, cLUI.hpLabel,attackButton,recoveryButton);
        return new Scene(root,wW,wH);
    }
    public static void buttonOnOff(boolean offTrue,Legend meLegend){
        if(offTrue){//消える
            attackButton.setDisable(true);
            recoveryButton.setDisable(true);
            attackButton.setOpacity(0);
            recoveryButton.setOpacity(0);

        }
        else{// 戻す
            attackButton.setDisable(false);
            recoveryButton.setDisable(false);
            attackButton.setOpacity(0.5);
            recoveryButton.setOpacity(0.5);
            if(meLegend.getRecoveryCount()<=0||meLegend.getHp()>=100){
                recoveryButton.setOpacity(0.2);
            }
        }
    };
    public static void winLoseScene(Boolean result) {
        if(result==null) return;
        else if(result==false){SceneManager.showLose();}
        else SceneManager.showWin();

    }

}
