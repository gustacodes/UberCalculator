package controller;

import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Alertas;
import model.Consumos;

public class ConsumosController {

    @FXML
    private TextField kmMedio;

    @FXML
    private TextField qtdLtMedio;

    @FXML
    private Text resultadoConsumoMedio;

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

}
