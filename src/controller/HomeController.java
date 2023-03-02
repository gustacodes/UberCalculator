package controller;

import java.io.IOException;
import  java.awt.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import dao.DespesasDao;
import dao.MetasDao;
import dao.RegistrosDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Alertas;
import model.Registros;
import view.Janelas;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane root;
    
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

    private Janelas tela = new Janelas();
    Alertas erro = new Alertas();

    @FXML
    void cabos(ActionEvent event) {

    }

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
    void consumoMedio(ActionEvent event) throws IOException {        
        tela.telas("consumomedio", "Consumo médio");        
    }

    @FXML
    void consumoViagens(ActionEvent event) throws IOException {
        tela.telas("consumoviagem", "Consumo percurso");
    }

    @FXML
    void contato(ActionEvent event) throws IOException {
        tela.telas("contato", "Contato");
    }

    @FXML
    void correia(ActionEvent event) throws IOException {
        tela.telas("correia", "Correia");
    }

    @FXML
    void excluir(ActionEvent event) throws IOException {
        tela.telas("excluir", "Excluir");
    }

    @FXML
    void metas(ActionEvent event) throws IOException {        
        tela.telas("metas", "Metas");
        fecharStage();
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
        tela.telas("registrarGanhos", "Registros do dia");
        fecharStage();
    }

    @FXML
    void sobre(ActionEvent event) throws IOException {
        tela.telas("sobre", "Sobre");
    }

    @FXML
    void fecharStage() {
        Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        MetasDao daoMeta = new MetasDao();

        txtMetaDiaria.setText(String.valueOf(daoMeta.lerMetas().getMetaDiaria()));

        RegistrosDao daoRegistros = new RegistrosDao();

            if(daoRegistros.lerRegistros().getTotal() >= daoMeta.lerMetas().getMetaDiaria()){
                erro.metaDiariaBatida();
            }

        txtFaturamento.setText(String.valueOf(daoRegistros.lerRegistros().getTotal()));
        txtSaldo.setText(String.valueOf(daoRegistros.lerRegistros().getLucro()));
        txtViagens.setText(String.valueOf(daoRegistros.lerRegistros().getViagens()));
        txtHoras.setText(String.valueOf(daoRegistros.lerRegistros().getHorasTrabalhadas()));
        txtKmRodados.setText(String.valueOf(daoRegistros.lerRegistros().getKmDia()));

        DespesasDao daoDespesas = new DespesasDao();

        txtDepesas.setText(String.valueOf(daoDespesas.lerDespesas().getTotalDespesas()));

        Registros medias = new Registros();

        txtGanhosMedViagens.setText(String.valueOf(medias.mediaViagens()));
        txtGanhosMedHora.setText(String.valueOf(medias.mediaHora()));
        txtGanhosMedKm.setText(String.valueOf(medias.mediaKm()));

    }

}
