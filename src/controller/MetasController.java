package controller;

import dao.MetasDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Metas;

public class MetasController {

    @FXML
    private TextField metaDiaria;

    @FXML
    private TextField metaMensal;

    @FXML
    void metas(ActionEvent event) {
        Metas meta = new Metas();

        meta.registraMetaDiaria(Double.parseDouble(metaDiaria.getText()));
        meta.registraMetaMensal(Double.parseDouble(metaMensal.getText()));

        MetasDao daoMetas = new MetasDao();
        daoMetas.salvaMetas(meta);
    }

}
