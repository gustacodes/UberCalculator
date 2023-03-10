package controller;

import java.io.IOException;

import dao.MetasDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Alertas;
import model.Metas;
import view.Janelas;

public class MetasController {

    @FXML
    private TextField metaDiaria;

    @FXML
    private AnchorPane root;
    
    private Janelas tela = new Janelas();

    @FXML
    void metas(ActionEvent event) throws IOException {

        Metas meta = new Metas();
        MetasDao daoMetas = new MetasDao();
        Alertas alerta = new Alertas();

            if(!metaDiaria.getText().isEmpty()) {

                meta.registraMetaDiaria(Double.parseDouble(metaDiaria.getText()));

                daoMetas.salvaMetas(meta);

                tela.telas("inicial", "NUBER");
                fecharStage();

            } else {                
                
                alerta.metaAlerta();

            }

    }

    @FXML
    void fecharStage(){
        Stage stage = (Stage) root.getScene().getWindow();
		stage.close();
    }

}
