package com.first_project;

import com.first_project.gameFunctions.Computer;
import com.first_project.gameFunctions.WinCheck;
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
    private Parent root;
    private Stage stage;
    private Scene scene;
    String playerSymbol;
    String computerSymbol;
    boolean playerTurn;
    WinCheck winCheck = new WinCheck();
    Computer computer = new Computer();
    Random random = new Random();

    //Reset button and information screen
    @FXML
    Label infoScreen;
    @FXML
    Button reset;
    //Symbol buttons
    @FXML
    Button chooseX;
    @FXML
    Button chooseO;

    //Game buttons
    @FXML
    Button one;
    @FXML
    Button two;
    @FXML
    Button three;
    @FXML
    Button four;
    @FXML
    Button five;
    @FXML
    Button six;
    @FXML
    Button seven;
    @FXML
    Button eight;
    @FXML
    Button nine;



    //Mechaniki gry
    //Mechanika resetu
    @FXML
    public void resetGame(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("gameScreen.fxml"));
        stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    //Mechanika wyboru 2 metody
    public void playerPlaysX() {
        List<Button> gameButtons = new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
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
        List<Button> gameButtons = new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
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
        List<Button> gameButtons = new ArrayList<>(Arrays.asList(one, two, three, four, five, six, seven, eight, nine));
        gameButtons.forEach(button -> {
            if (playerTurn) {
                if ("".equals(button.getText())) {
                    button.setOnMouseClicked(mouseEvent -> {
                        button.setText(playerSymbol);
                        button.setDisable(true);
                        playerTurn = false;
                        infoScreen.setText("Tic tac toe");
                        computer.computerMove(gameButtons,computerSymbol);
                        winCheck.winChecker(playerSymbol, gameButtons, infoScreen);
                        winCheck.winChecker(computerSymbol, gameButtons, infoScreen);
                        playerTurn = true;
                    });
                }
            } else {
                computer.computerMove(gameButtons,computerSymbol);
                playerTurn = true;
                infoScreen.setText("Tic tac toe");
                winCheck.winChecker(playerSymbol, gameButtons, infoScreen);
                winCheck.winChecker(computerSymbol, gameButtons, infoScreen);
            }
        });
    }
}

