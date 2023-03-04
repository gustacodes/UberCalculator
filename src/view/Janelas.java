package view;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Janelas {

    Stage primaryStage = new Stage();
    private static Stage stg;
    
    public void telas(String telas, String titulo) throws IOException {

        Janelas.stg = primaryStage;
        Janelas.stg.getIcons().add(new Image("/resources/icone/uber.png"));

        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/fxml/" + telas + ".fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle(titulo);
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}
