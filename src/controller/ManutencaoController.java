package controller;

import java.net.URL;
import java.util.ResourceBundle;
import dao.ManutencaoDao;
import dao.StatusDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.Alertas;
import model.Manutencao;

public class ManutencaoController implements Initializable {

    @FXML
    private ProgressBar statusOleo;

    @FXML
    private TextField proxTroca;

    @FXML
    private TextField proxTrocaCabos;

    @FXML
    private TextField proxTrocaCorreia;

    @FXML
    private ProgressBar statusCabos;

    @FXML
    private ProgressBar statusCorreia;    

    Alertas alerta = new Alertas();
    Manutencao proximaTroca = new Manutencao();
    ManutencaoDao daoManutencao = new ManutencaoDao();

    @FXML
    void trocaCabos(ActionEvent event) {
        proximaTroca.setProxTroca(Double.parseDouble(proxTrocaCabos.getText()));
        daoManutencao.salvarKmProximaTrocaCabos(proximaTroca);
        alerta.registroTrocas();
    }

    @FXML
    void trocaCorreia(ActionEvent event) {
        proximaTroca.setProxTroca(Double.parseDouble(proxTrocaCorreia.getText()));
        daoManutencao.salvarKmProximaTrocaCorreia(proximaTroca);
        alerta.registroTrocas();
    }

    @FXML
    void trocaOleo(ActionEvent event) {                
        proximaTroca.setProxTroca(Double.parseDouble(proxTroca.getText()));
        daoManutencao.salvarKmProximaTrocaOleo(proximaTroca);
        alerta.registroTrocas();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        StatusDao status = new StatusDao();

        if(status.verificaTrocaOleo() >= 1) {            
            statusOleo.setStyle("-fx-accent: red;");
            
         } else if(status.verificaTrocaOleo() >= 0.8){ 
            statusOleo.setStyle("-fx-accent: yellow;");
 
         } else {
            statusOleo.setStyle("-fx-accent: #00FF00;");

         }
            statusOleo.setProgress(status.verificaTrocaOleo());

        if(status.verificaTrocaCorreia() >= 1) {            
            statusCorreia.setStyle("-fx-accent: red;");
            
        } else if(status.verificaTrocaCorreia() >= 0.8){ 
            statusCorreia.setStyle("-fx-accent: yellow;");
 
        } else {
            statusCorreia.setStyle("-fx-accent: #00FF00;");    
         }

            statusCorreia.setProgress(status.verificaTrocaCorreia());            

        if(status.verificaTrocaCabos() >= 1) {            
            statusCabos.setStyle("-fx-accent: red;");
            
        } else if(status.verificaTrocaCabos() >= 0.8){ 
            statusCabos.setStyle("-fx-accent: yellow;");
     
        } else {
            statusCabos.setStyle("-fx-accent: #00FF00;");    
        }    
        
            statusCabos.setProgress(status.verificaTrocaCabos());
                   
        
    }

}
