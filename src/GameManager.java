import javafx.animation.PauseTransition;
import javafx.scene.media.AudioClip;
import javafx.util.Duration;

public class GameManager {
    static AudioClip nockDown=new AudioClip(MyApp.class.getResource("sounds/apex-legends-knockdown-sound-effect_0xqJePf.mp3").toExternalForm());
    static AudioClip recoverySound=new AudioClip(MyApp.class.getResource("sounds/ステータス治療1.mp3").toString());
    static{recoverySound.setVolume(0.2);}
    public static void attack(Legend meLegend,Legend compLegend,LegendUI cLUI,LegendUI mLUI)
    {
        meLegend.shotSound.play();
      int Amount = meLegend.attack(compLegend);
      cLUI.updateAnimation(Amount,()->{
                    setHp(compLegend,Amount);
                    cLUI.updateLabel();
                    System.out.println(Amount+"ダメージ"+ compLegend.getHp());
                    Boolean result=winCheck(meLegend,compLegend);
                    BattleScene.winLoseScene(result);
                    if(result!=null)nockDown.play();
                    meLegend.shotSound.stop();
                    if(result==null)enemyTurn(compLegend,meLegend,cLUI,mLUI);//勝利後相手のターンにいってしまうため
                }
        );
    }

    public static void recovery(Legend meLegend,Legend compLegend,LegendUI cLUI,LegendUI mLUI)
    {
        meLegend.recoverySound.play();
        recoverySound.play();
        int Amount=meLegend.recovery();
        mLUI.updateAnimation(Amount,()->{
            setHp(meLegend,Amount);
            mLUI.updateLabel();
            meLegend.getHp();
            System.out.println("回復"+meLegend.getHp());

            enemyTurn(compLegend,meLegend,cLUI,mLUI);
        }
        );
    }
    public static void enemyTurn(Legend compLegend,Legend meLegend,LegendUI cLUI,LegendUI mLUI)
    {
        PauseTransition pause=new PauseTransition(Duration.seconds(1));
        pause.play();
        pause.setOnFinished(e->{
        int choice = 1;
        if (compLegend.getRecoveryCount() > 1) choice = (int) (Math.random() * 2) + 1;
        if (choice == 1) {
            compLegend.shotSound.play();
            int Amount = compLegend.attack(meLegend);
            mLUI.updateAnimation(Amount, () -> {
                setHp(meLegend, Amount);
                mLUI.updateLabel();
                BattleScene.buttonOnOff(false,meLegend);
                System.out.println(Amount+"ダメージ"+ meLegend.getHp());
                Boolean result=winCheck(meLegend,compLegend);
                compLegend.shotSound.stop();
                if(result!=null)nockDown.play();
                BattleScene.winLoseScene(result);
            });
        } else if (choice == 2) {
            compLegend.recoverySound.play();
            recoverySound.play();
            int Amount = compLegend.recovery();
            cLUI.updateAnimation(Amount, () -> {
                setHp(compLegend, Amount);
                cLUI.updateLabel();
                System.out.println(Amount+"回復:"+ compLegend.getHp());
                BattleScene.buttonOnOff(false,meLegend);
            });
        }
        });

    }
    public static void setHp(Legend setLegend,int Amount){
        if(Amount<0)setLegend.setDamage(-Amount);
        else setLegend.setDamage(-Amount);
    }
    public static Boolean winCheck(Legend meLegend,Legend compLegend) {
        if (meLegend.getHp() <= 0) {
            return false;
        } else if (compLegend.getHp() <= 0) {
            return true;
        } else return null;
    }
}
