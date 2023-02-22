package controller;

import java.net.URL;
import java.util.ResourceBundle;
import dao.VeiculoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Alertas;
import model.Veiculo;

public class CadastroVeiculoController implements Initializable {

    @FXML
    private TextField kmTotal;

    @FXML
    private TextField marcaVeiculo;

    @FXML
    private TextField modeloVeiculo;

    @FXML
    private TextField placaVeiculo;

    @FXML
    private ChoiceBox<String> tipoCombustivel;

    private String [] combustiveis = {"Gasolina", "Etanol", "Diesel", "GNV"};

    @FXML
    void cadastrarVeiculo(ActionEvent event) {

        if(marcaVeiculo.getText().isEmpty() || modeloVeiculo.getText().isEmpty() || placaVeiculo.getText().isEmpty()){

            Alertas erro = new Alertas();
            erro.alertaCampoVazio();

        } else {

            String combustivelEscolhido = tipoCombustivel.getValue();

            Veiculo carro = new Veiculo(placaVeiculo.getText(), marcaVeiculo.getText(), modeloVeiculo.getText(), Double.parseDouble(kmTotal.getText()), combustivelEscolhido);
            VeiculoDao daoVeiculo = new VeiculoDao();
            daoVeiculo.cadastrarVeiculo(carro);

            Alert cadastrado = new Alert(AlertType.CONFIRMATION);
            cadastrado.setHeaderText("Cadastro realizado!");
            cadastrado.setContentText("Veículo " + modeloVeiculo.getText().toUpperCase() + " de placa " + placaVeiculo.getText().toUpperCase() + " cadastrado.");
            cadastrado.showAndWait();
           
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {        
        tipoCombustivel.getItems().addAll(combustiveis);
    }

}
