import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class LegendUI {
    public Legend legend;
    public ImageView legendView;
    public ProgressBar hpBar;
    public Label hpLabel;
    LegendUI(Legend legend, ImageView imageView, ProgressBar hpBar, Label hpLabel) {
        this.legend = legend;
        this.legendView = imageView;
        this.hpBar = hpBar;
        this.hpLabel=hpLabel;
    }

    public void updateAnimation(int Amount,Runnable afterAnimation) {
        Timeline timeline = new Timeline();
        int startHp=this.legend.getHp();
        int endHp=startHp+Amount;
        int frames;
        frames=Math.abs(Amount); //回復ならそのまま Amount=damageはLegend.attack(マイナス)　ダメージ数によってフレーム数変える
        if (endHp < 0) endHp = 0;
        if (endHp > 100) endHp = 100;

        for (int i = 1; i <= frames; i++) {
            double t=(double)i/frames;//フレームの進み具合
            double nextHp=startHp+Amount*t;

            if (Amount < 0) {
                nextHp = Math.max(endHp, nextHp);
            }

            final double hplamda=nextHp;
            //1フレームあたりの時間。ここでアニメーションの長さ設定　or　フレームダメージ下げてフレームを増やしてフレーム時間を短く(anime時間=frames*時間)
            KeyFrame kf = new KeyFrame(Duration.millis(65 * i), e -> {
                this.hpBar.setProgress(hplamda/ 100.0);
            });// HPUIをフレーム毎に更新更新
            timeline.getKeyFrames().add(kf);
        }
        timeline.setOnFinished(e-> {
            afterAnimation.run();
        });
        timeline.play();
    }
    public void updateLabel(){
        this.hpLabel.setText("HP: " + this.legend.getHp()+"回復:"+this.legend.getRecoveryCount());
    }

}
