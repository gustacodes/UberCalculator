package controller;

import dao.VeiculoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import model.Alertas;
import model.Veiculo;

public class CadastroVeiculoController {

    @FXML
    private TextField marcaVeiculo;

    @FXML
    private TextField modeloVeiculo;

    @FXML
    private TextField placaVeiculo;

    @FXML
    void cadastrarVeiculo(ActionEvent event) {

        if(marcaVeiculo.getText().isEmpty() || modeloVeiculo.getText().isEmpty() || placaVeiculo.getText().isEmpty()){

            Alertas erro = new Alertas();
            erro.alertaCampoVazio();

        } else {

            Veiculo carro = new Veiculo(placaVeiculo.getText(), marcaVeiculo.getText(), modeloVeiculo.getText());
            VeiculoDao daoVeiculo = new VeiculoDao();
            daoVeiculo.cadastrarVeiculo(carro);

            Alert cadastrado = new Alert(AlertType.CONFIRMATION);
            cadastrado.setHeaderText("Cadastro realizado!");
            cadastrado.setContentText("Veículo " + modeloVeiculo.getText().toUpperCase() + " de placa " + placaVeiculo.getText().toUpperCase() + " cadastrado.");
            cadastrado.showAndWait();

        }
        
    }

}
