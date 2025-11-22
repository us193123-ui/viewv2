import javafx.scene.media.AudioClip;
public class Wraith  extends Legend {
    static AudioClip wraithShot=new AudioClip(MyApp.class.getResource("/sounds/重機関銃を乱射1.mp3").toExternalForm());
    static AudioClip wraithRecovery=new AudioClip(MyApp.class.getResource("/sounds/レイス回復.mp3").toExternalForm());

    Wraith(){
        super("wraith",27,0,2,wraithShot,wraithRecovery);
    }
}