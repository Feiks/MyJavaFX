package com.example.myfirstjavafx;

import javafx.animation.TranslateTransition;
import javafx.scene.Node;
import javafx.util.Duration;

public class Shake {


        private TranslateTransition tt;
        public Shake(Node node){
            tt = new TranslateTransition(Duration.millis(1000),node);
            tt.setFromX(0f);
            tt.setByX(100f);
            tt.setCycleCount(10);
            tt.setAutoReverse(true);
        }

        public void playAnim(){
            tt.playFromStart();
        }



}
