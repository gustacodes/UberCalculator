package controller;

import java.text.DecimalFormat;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Consumos;

public class ConsumoViagemController {

    @FXML
    private TextField kmL;

    @FXML
    private TextField percurso;

    @FXML
    private TextField precoL;

    @FXML
    private Text totalConsumo;

    @FXML
    private Text txtPercurso;

    @FXML
    void consumoPercurso(ActionEvent event) {

        Consumos consumoViagem = new Consumos();

        DecimalFormat d = new DecimalFormat("##.##");

        consumoViagem.consumoViagem(Double.parseDouble(percurso.getText()), Double.parseDouble(kmL.getText()), Double.parseDouble(precoL.getText()));
        txtPercurso.setText("Você gastará uma média de R$ " + d.format(consumoViagem.getTotal()) + " em uma viagem de " + 
                                        percurso.getText() + "KM");
    }

}
