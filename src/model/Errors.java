package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Errors {
    
    public void alertaNegativo() {
        Alert a = new Alert(AlertType.ERROR);

        a.setTitle("Valor inválido");
        a.setHeaderText("Informe apenas números positivos");
        a.setContentText("Números negativos não serão computados.");
        a.showAndWait();

    }

    public void alertaCampoVazio() {
        Alert a = new Alert(AlertType.ERROR);

        a.setTitle("Error");
        a.setHeaderText("Campo vazio");
        a.setContentText("Verifique se algum dos campos está vazio.");
        a.showAndWait();
    }
}
