package com.first_project;

import com.first_project.game_functions.Computer;
import com.first_project.game_functions.WinCheck;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.*;

public class GameController {
    private String playerSymbol;
    private String computerSymbol;
    private boolean playerTurn;
    private WinCheck winCheck = new WinCheck();
    private Computer computer = new Computer();
    private Random random = new Random();


    @FXML
    private Label infoScreen;
    @FXML
    private Button reset;
    @FXML
    private Button chooseX;
    @FXML
    private Button chooseO;
    @FXML
    private Button one;
    @FXML
    private Button two;
    @FXML
    private Button three;
    @FXML
    private Button four;
    @FXML
    private Button five;
    @FXML
    private Button six;
    @FXML
    private Button seven;
    @FXML
    private Button eight;
    @FXML
    private Button nine;

    private List<Button> getButtons() {
        return new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
    }
    @FXML
    public void resetGame(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("gameScreen.fxml")));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    public void playerPlaysX() {
        List<Button> gameButtons = getButtons();
        chooseX.setOnMouseClicked(mouseEvent -> {
            playerSymbol = "X";
            computerSymbol = "O";
            chooseO.setDisable(true);
            chooseO.setVisible(false);
            chooseX.setDisable(true);
            chooseX.setVisible(false);
            gameButtons.forEach(button -> button.setDisable(false));
            startSymbol();
        });
    }

    public void playerPlaysO() {
        List<Button> gameButtons = getButtons();
        chooseO.setOnMouseClicked(mouseEvent -> {
            playerSymbol = "O";
            computerSymbol = "X";
            chooseO.setDisable(true);
            chooseO.setVisible(false);
            chooseX.setDisable(true);
            chooseX.setVisible(false);
            gameButtons.forEach(button -> button.setDisable(false));
            startSymbol();
        });
    }

    public void startSymbol() {
        if (random.nextInt(2) == 1) {
            playerTurn = true;
            infoScreen.setText("Player starts");
        } else {
            playerTurn = false;
            infoScreen.setText("Pc starts");
            game();
        }
    }

    public void game() {
        List<Button> gameButtons = getButtons();
        gameButtons.forEach(button -> {
            if (playerTurn) {
                if ("".equals(button.getText())) {
                    button.setOnMouseClicked(mouseEvent -> {
                        button.setText(playerSymbol);
                        button.setDisable(true);
                        playerTurn = false;
                        infoScreen.setText("Tic tac toe");
                        if(winCheck.winChecker(playerSymbol, gameButtons, infoScreen)){
                            return;
                        }
                        computer.computerMove(gameButtons,computerSymbol);
                        if(winCheck.winChecker(computerSymbol, gameButtons, infoScreen)){
                            return;
                        }
                        playerTurn = true;
                    });
                }
            } else {
                computer.computerMove(gameButtons,computerSymbol);
                playerTurn = true;
                infoScreen.setText("Tic tac toe");
                if(winCheck.winChecker(playerSymbol, gameButtons, infoScreen)){
                    return;
                }
                if(winCheck.winChecker(computerSymbol, gameButtons, infoScreen)){
                    return;
                }
            }
        });
    }
}

