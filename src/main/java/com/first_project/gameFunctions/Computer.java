package com.first_project.gameFunctions;

import javafx.scene.control.Button;
import javafx.scene.image.Image;

import java.util.List;

public class Computer {


    public void computerMove(List<Button> buttons, String symbol) {
        for (Button button : buttons){
            if ("".equals(button.getText())){
                button.setText(symbol);
                button.setDisable(true);
                break;
            }
        }
    }
}
