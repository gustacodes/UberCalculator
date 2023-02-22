package controller;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Alertas;
import model.Consumos;
import  java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class ConsumosController {

    @FXML
    private TextField kmLitro;

    @FXML
    private TextField kmMedio;

    @FXML
    private TextField kmViagem;

    @FXML
    private TextField precoCombustivel;

    @FXML
    private TextField qtdLtMedio;

    @FXML
    private Text resultadoConsumoMedio;

    @FXML
    private Text resultadoConsumoViagem;

    @FXML
    void comofunciona(ActionEvent event) {
        Desktop desktop = Desktop.getDesktop();
        Alertas erro = new Alertas();

        try {
            desktop.browse(new URI("https://www.karvi.com.br/blog/como-calcular-o-consumo-de-combustivel/#:~:text=Divida%20a%20quantidade%20de%20quil%C3%B4metros,13%2C1%20km%2Fl."));
        } catch (IOException | URISyntaxException e) {
            erro.abrirLink();
        }
    }

    @FXML
    void calculoMedio(ActionEvent event) {

        Consumos medio = new Consumos();

            if(kmMedio.getText().isEmpty() || qtdLtMedio.getText().isEmpty()){

                Alertas alert = new Alertas();
                alert.alertaCampoVazio();
                
            } else {

                medio.consumoMedio(Double.parseDouble(kmMedio.getText()), Double.parseDouble(qtdLtMedio.getText()));

                DecimalFormat df = new DecimalFormat("##.#");                        
                resultadoConsumoMedio.setText("Seu consumo médio atual é de " + df.format(medio.getMedia()) + "KM/L");
            }
        
    }

    @FXML
    void consumoViagem(ActionEvent event) {
        Consumos consumoViagem = new Consumos();

        DecimalFormat d = new DecimalFormat("##.##");
        consumoViagem.consumoViagem(Double.parseDouble(kmViagem.getText()), Double.parseDouble(kmLitro.getText()), Double.parseDouble(precoCombustivel.getText()));
        resultadoConsumoViagem.setText("Você gastará uma média de " + d.format(consumoViagem.getTotal()) + " em uma viagem de " + 
                                        kmViagem.getText() + "KM");
    }

}
