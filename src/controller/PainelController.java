package controller;

import  java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Registros;
import model.Alertas;

public class PainelController implements Initializable {

    @FXML
    private TableView<Registros> tableView;

    @FXML
    private TableColumn<Registros, String> dataColumn;

    @FXML
    private TableColumn<Registros, Double> despesaColumn;

    @FXML
    private TableColumn<Registros, Double> lucroColumn;

    @FXML
    private TableColumn<Registros, Double> noveColumn;

    @FXML
    private TableColumn<Registros, Double> totalColumn;

    @FXML
    private TableColumn<Registros, Double> uberColumn;

    @FXML
    private TextField kmDia;

    @FXML
    private TextField despesas;

    @FXML
    private TextField uber;
    
    @FXML
    private TextField nove;

    Alertas erro = new Alertas();

    @FXML
    void clickInsta(ActionEvent event) {

        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI("https://www.instagram.com/_gustalencar/"));
        } catch (IOException | URISyntaxException e) {
            erro.abrirLink();
        }
        
    }

    @FXML
    void cadastrarVeiculo(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/cadastroveiculo.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();
        primaryStage.setTitle("Cadastro veículo");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    @FXML
    void consultarGanhos(ActionEvent event) {

    }
    
    @FXML
    void consumoVeiculo(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/consumos.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Consumos");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    @FXML
    void fecharMes(ActionEvent event) {

    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void manutencaoVeiculo(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/manutencao.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Manutenção");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    void registrar(ActionEvent event) {
        
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        dataColumn.setCellValueFactory(new PropertyValueFactory<>("date"));
        noveColumn.setCellValueFactory(new PropertyValueFactory<>("uber"));
        uberColumn.setCellValueFactory(new PropertyValueFactory<>("nove"));
        despesaColumn.setCellValueFactory(new PropertyValueFactory<>("despesas"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
        lucroColumn.setCellValueFactory(new PropertyValueFactory<>("lucro"));

   }                    

}
