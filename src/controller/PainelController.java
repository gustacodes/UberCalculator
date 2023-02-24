package controller;

import  java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.ManutencaoDao;
import dao.RegistrosDao;
import dao.StatusDao;
import javafx.collections.ObservableList;
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
import model.Calculo;
import model.Alertas;

public class PainelController implements Initializable {

    @FXML
    private TableView<Calculo> tableView;

    @FXML
    private TableColumn<Calculo, String> dataColumn;

    @FXML
    private TableColumn<Calculo, Double> despesaColumn;

    @FXML
    private TableColumn<Calculo, Double> lucroColumn;

    @FXML
    private TableColumn<Calculo, Double> noveColumn;

    @FXML
    private TableColumn<Calculo, Double> totalColumn;

    @FXML
    private TableColumn<Calculo, Double> uberColumn;

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

    Calculo calculoDeGanhos = new Calculo();
    ManutencaoDao daoManutencao = new ManutencaoDao();
    StatusDao status = new StatusDao();
    Alertas alert = new Alertas();

    @FXML
    void registrar(ActionEvent event) {
        
        RegistrosDao daoRegistros = new RegistrosDao();
        
            if(uber.getText().isEmpty() || nove.getText().isEmpty() || despesas.getText().isEmpty()){                
                erro.alertaCampoVazio();

            } else {

                calculoDeGanhos.calculoTotal(Double.parseDouble(uber.getText()), Double.parseDouble(nove.getText()));
                calculoDeGanhos.lucroTotal(calculoDeGanhos.getTotal(), Double.parseDouble(despesas.getText()));
                calculoDeGanhos.setKmDia(Double.parseDouble(kmDia.getText())); 

                ObservableList<Calculo> list = tableView.getItems();
                list.add(calculoDeGanhos);
                tableView.setItems(list); 
                
                daoRegistros.salvar(calculoDeGanhos);
                daoManutencao.salvarKmTroca(Double.parseDouble(kmDia.getText()));
                
                    if(status.verificaTrocaOleo() >= 1) {
                        alert.oleoTroca();            
                    } else if(status.verificaTrocaOleo() >= 0.8) { 
                        alert.trocaOleoPerto(); 
                    }

                    if(status.verificaTrocaCorreia() >= 1) {
                        alert.CorreiaTroca();            
                    } else if(status.verificaTrocaCorreia() >= 0.8) { 
                        alert.trocaCorreiaPerto(); 
                    }

                    if(status.verificaTrocaCabos() >= 1) {
                        alert.CabosTroca();        
                    } else if(status.verificaTrocaCabos() >= 0.8) { 
                        alert.trocaCabosPerto(); 
                    }
            }        
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
