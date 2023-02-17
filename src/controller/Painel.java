package controller;

import  java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Calculo;
import model.Errors;

public class Painel implements Initializable {

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
    private TextField despesas;

    @FXML
    private TextField uber;
    
    @FXML
    private TextField nove;

    @FXML
    void clickInsta(ActionEvent event) {

        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI("https://www.instagram.com/_gustalencar/"));
        } catch (IOException | URISyntaxException e) {
            
        }
        
    }


    @FXML
    void Fechamento(ActionEvent event) {

    }

    @FXML
    void Registrar(ActionEvent event) {

        Calculo c = new Calculo();
        Errors erro = new Errors();

            if(uber.getText().isEmpty() || nove.getText().isEmpty() || despesas.getText().isEmpty()){
                
                erro.alertaCampoVazio();

            } else {

                c.calculoTotal(Double.parseDouble(uber.getText()), Double.parseDouble(nove.getText()));
                c.lucroTotal(c.getTotal(), Double.parseDouble(despesas.getText())); 

                ObservableList<Calculo> list = tableView.getItems();
                list.add(c);
                tableView.setItems(list); 
            }
        
    }

    @FXML
    void gerarRelatorio(ActionEvent event) {

    }

    @FXML
    void atual(ActionEvent event) {

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
