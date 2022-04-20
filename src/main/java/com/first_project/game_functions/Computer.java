package com.first_project.game_functions;

import javafx.scene.control.Button;

import java.util.List;
import java.util.Random;

public class Computer {

    Random random = new Random();

    public void computerMove(List<Button> buttons, String symbol) {
        while (true) {
            Button button = buttons.get(random.nextInt(buttons.size()));
            if ("".equals(button.getText())) {
                button.setText(symbol);
                button.setDisable(true);
                break;
            }
        }
    }
}
