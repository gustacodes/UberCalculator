package controller;

import java.net.URL;
import java.util.ResourceBundle;
import dao.ManutencaoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Alertas;
import model.TrocaOleo;

public class ManutencaoController implements Initializable {

    @FXML
    private ProgressBar progresso;

    @FXML
    private TextField proxTroca;

    Alertas alerta = new Alertas();
    TrocaOleo proximaTroca = new TrocaOleo();

    @FXML
    void trocaOleo(ActionEvent event) {

        ManutencaoDao daoManutencao = new ManutencaoDao();
        proximaTroca.setProxTroca(Double.parseDouble(proxTroca.getText()));

        daoManutencao.salvarKmProximaTroca(proximaTroca);

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        if(proximaTroca.verificaTroca() >= 1) {            
            progresso.setStyle("-fx-accent: red;");
            
         } else if(proximaTroca.verificaTroca() >= 0.8){ 
             progresso.setStyle("-fx-accent: yellow;");
 
         } else {
             progresso.setStyle("-fx-accent: #00FF00;");

         }
            progresso.setProgress(proximaTroca.verificaTroca());
        
        
    }

}
