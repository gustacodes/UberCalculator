package controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.MetasDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ProgressBar;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class HomeController implements Initializable {

    @FXML
    private Text porcentagemInDriver;

    @FXML
    private Text porcentagemNove;

    @FXML
    private Text porcentagemOutros;

    @FXML
    private Text porcentagemUber;

    @FXML
    private ProgressBar progressInDriver;

    @FXML
    private ProgressBar progressNove;

    @FXML
    private ProgressBar progressOutros;

    @FXML
    private ProgressBar progressUber;

    @FXML
    private Text txtDepesas;

    @FXML
    public Text txtFaturamento;

    @FXML
    private Text txtGanhosMedHora;

    @FXML
    private Text txtGanhosMedKm;

    @FXML
    private Text txtGanhosMedViagens;

    @FXML
    private Text txtHoras;

    @FXML
    private Text txtKmRodados;

    @FXML
    private Text txtMetaDiaria;

    @FXML
    private Text txtSaldo;

    @FXML
    private Text txtViagens;

    @FXML
    void cabos(ActionEvent event) {

    }

    @FXML
    void clickInsta(ActionEvent event) {

    }

    @FXML
    void consumoMedio(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/consumomedio.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Consumo médio");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    void consumoViagens(ActionEvent event) throws IOException {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/consumoviagem.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Consumo percruso");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    void contato(ActionEvent event) {

    }

    @FXML
    void correia(ActionEvent event) {

    }

    @FXML
    void excluir(ActionEvent event) {

    }

    @FXML
    void metas(ActionEvent event) throws IOException {
        
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/metas.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Registros do dia");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }

    @FXML
    void oleo(ActionEvent event) {

    }

    @FXML
    void outros(ActionEvent event) {

    }

    @FXML
    void periodo(ActionEvent event) {

    }

    @FXML
    void registrar(ActionEvent event) throws IOException {

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/registrarGanhos.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        Stage primaryStage = new Stage();

        primaryStage.setTitle("Registros do dia");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);

    }

    @FXML
    void sobre(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        MetasDao daoMeta = new MetasDao();
        txtMetaDiaria.setText(String.valueOf(daoMeta.lerMetas()));
    }

}
