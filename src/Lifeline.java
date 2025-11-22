import javafx.scene.media.AudioClip;
public class Lifeline  extends Legend {
    static AudioClip lifelineShot=new AudioClip(MyApp.class.getResource("/sounds/shotgun.mp3").toExternalForm());
    static AudioClip lifelineRecovery=new AudioClip(MyApp.class.getResource("/sounds/ライフラ回復.mp3").toExternalForm());

    Lifeline(){
        super("lifeline",12,25,4,lifelineShot,lifelineRecovery);
    }
}