import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxml = new FXMLLoader(getClass().getResource("/resources/layout.fxml"));
        Parent root = fxml.load();
        Scene tela = new Scene(root);

        primaryStage.setTitle("Uber Calculator");
        primaryStage.setScene(tela);
        primaryStage.show();
        primaryStage.setResizable(false);
    }
}