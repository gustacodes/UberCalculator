package controller;

import java.io.IOException;

import dao.MetasDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Metas;
import view.Janelas;

public class MetasController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField metaDiaria;

    @FXML
    private TextField metaMensal;
    
    private Janelas tela = new Janelas();

    @FXML
    void metas(ActionEvent event) throws IOException {
        Metas meta = new Metas();

        meta.registraMetaDiaria(Double.parseDouble(metaDiaria.getText()));
        meta.registraMetaMensal(Double.parseDouble(metaMensal.getText()));

        MetasDao daoMetas = new MetasDao();
        daoMetas.salvaMetas(meta);

        tela.telas("inicial", "NUBER");
        fecharStage();
    }

    @FXML
    void fecharStage(){
        Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
    }

}
