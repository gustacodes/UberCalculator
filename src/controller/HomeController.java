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
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import model.Alertas;
import model.Arredonda;
import model.Medias;
import view.Janelas;

public class HomeController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private Text txtDepesas;

    @FXML
    private Text txtFaturamento;

    @FXML
    private Text txtGanhosMedHora;

    @FXML
    private Text txtGanhosMedKm;

    @FXML
    private Text txtGanhosMedViagens;

    @FXML
    private Text txtHoras;

    @FXML
    private Text txtInDriver;

    @FXML
    private Text txtKmRodados;

    @FXML
    private Text txtMeta;

    @FXML
    private Text txtNove;

    @FXML
    private Text txtOutros;

    @FXML
    private Text txtSaldo;

    @FXML
    private Text txtUber;

    @FXML
    private Text txtViagens;


    private Janelas tela = new Janelas();
    Alertas alerta = new Alertas();

    @FXML
    void clickInsta(ActionEvent event) {        
        
        Desktop desktop = Desktop.getDesktop();

        try {
            desktop.browse(new URI("https://www.instagram.com/_gustalencar/"));
        } catch (IOException | URISyntaxException e) {
            alerta.abrirLink();
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
    void manutencao(ActionEvent event) throws IOException {
        tela.telas("manutencao", "Manutenção");
    }
    

    @FXML
    void periodo(ActionEvent event) throws IOException {
        tela.telas("ganhosperiodo", "Registros por período");
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

    @FXML
    void metas(ActionEvent event) throws IOException {
        tela.telas("metas", "Metas");
        fecharStage();
    }


    static boolean controlador = false;

    @Override
    public void initialize(URL location, ResourceBundle resources) {    
        
        MetasDao daoMeta = new MetasDao();
        RegistrosDao daoRegistros = new RegistrosDao();
        Arredonda arredonda = new Arredonda(); 

        txtMeta.setText(String.valueOf(daoMeta.lerMetas().getMetaDiaria()));
        txtUber.setText(arredonda.arredondarValor(daoRegistros.lerRegistrosPeriodo().getUber()));
        txtNove.setText(arredonda.arredondarValor(daoRegistros.lerRegistrosPeriodo().getNove()));
        txtInDriver.setText(arredonda.arredondarValor(daoRegistros.lerRegistrosPeriodo().getInDriver()));
        txtOutros.setText(arredonda.arredondarValor(daoRegistros.lerRegistrosPeriodo().getOutros()));

        if(controlador == true) {            

                if(daoRegistros.lerRegistros().getTotal() >= daoMeta.lerMetas().getMetaDiaria()){
                    alerta.metaDiariaBatida();
                }           

            txtFaturamento.setText(arredonda.arredondarValor(daoRegistros.lerRegistros().getTotal()));
            txtSaldo.setText(arredonda.arredondarValor(daoRegistros.lerRegistros().getLucro()));
            txtViagens.setText(String.valueOf(daoRegistros.lerRegistros().getViagens()));
            txtHoras.setText(String.valueOf(daoRegistros.lerRegistros().getHorasTrabalhadas()));
            txtKmRodados.setText(arredonda.arredondarValor(daoRegistros.lerRegistros().getKmDia()));

            DespesasDao daoDespesas = new DespesasDao();

            txtDepesas.setText(String.valueOf(daoDespesas.lerDespesas().getTotalDespesas()));

            Medias medias = new Medias();

            txtGanhosMedViagens.setText(String.valueOf(medias.mediaViagens()));
            txtGanhosMedHora.setText(String.valueOf(medias.mediaHora()));
            txtGanhosMedKm.setText(String.valueOf(medias.mediaKm()));

        }        

    }

}
