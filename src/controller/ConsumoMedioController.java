package controller;

import java.io.IOException;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import model.Alertas;
import model.Consumos;

public class ConsumoMedioController {

    @FXML
    private TextField km;

    @FXML
    private TextField litros;

    @FXML
    private Text totalConsumo;

    @FXML
    void consumoMedio(ActionEvent event) throws IOException {
        
        Consumos medio = new Consumos();

        if(km.getText().isEmpty() || litros.getText().isEmpty()){

            Alertas alert = new Alertas();
            alert.alertaCampoVazio();
            
        } else {

            medio.consumoMedio(Double.parseDouble(km.getText()), Double.parseDouble(litros.getText()));

            DecimalFormat df = new DecimalFormat("##.#");                        
            totalConsumo.setText("Seu consumo médio atual é de " + df.format(medio.getMedia()) + "KM/L");
            
        }
    }

}
