package controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;

public class Manutencao implements Initializable {

    @FXML
    private TextField kmLitro;

    @FXML
    private TextField kmViagem;

    @FXML
    private TextField precoCombustivel;

    @FXML
    private ProgressBar progresso;

    @FXML
    private TextField proxTroca;

    @FXML
    void comofunciona(ActionEvent event) {

    }

    @FXML
    void consumoViagem(ActionEvent event) {

    }

    @FXML
    void trocaOleo(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        progresso.setStyle("-fx-accent: #00FF00;");
    }

}
