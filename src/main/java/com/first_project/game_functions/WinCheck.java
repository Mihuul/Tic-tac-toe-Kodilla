package com.first_project.game_functions;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import java.util.List;
import java.util.Objects;

public class WinCheck {

    public void gameOver(String symbol, List<Button> gameButtons,  Label infoScreen) {
        infoScreen.setText(symbol + " Wins");
        gameButtons.forEach(button -> button.setDisable(true));
    }

    public boolean winChecker(String symbol, List<Button> gameButtons, Label infoScreen) {
        if ((Objects.equals(gameButtons.get(0).getText(), symbol)) && (Objects.equals(gameButtons.get(1).getText(), symbol)) && (Objects.equals(gameButtons.get(2).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(3).getText(), symbol)) && (Objects.equals(gameButtons.get(4).getText(), symbol)) && (Objects.equals(gameButtons.get(5).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(6).getText(), symbol)) && (Objects.equals(gameButtons.get(7).getText(), symbol)) && (Objects.equals(gameButtons.get(8).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(0).getText(), symbol)) && (Objects.equals(gameButtons.get(3).getText(), symbol)) && (Objects.equals(gameButtons.get(6).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(1).getText(), symbol)) && (Objects.equals(gameButtons.get(4).getText(), symbol)) && (Objects.equals(gameButtons.get(7).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(2).getText(), symbol)) && (Objects.equals(gameButtons.get(5).getText(), symbol)) && (Objects.equals(gameButtons.get(8).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(0).getText(), symbol)) && (Objects.equals(gameButtons.get(4).getText(), symbol)) && (Objects.equals(gameButtons.get(8).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        if ((Objects.equals(gameButtons.get(2).getText(), symbol)) && (Objects.equals(gameButtons.get(4).getText(), symbol)) && (Objects.equals(gameButtons.get(6).getText(), symbol))
        ) {
            gameOver(symbol, gameButtons, infoScreen);
            return true;
        }
        return false;
    }
}
