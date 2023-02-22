package controller;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javax.swing.JOptionPane;
import dao.Conexao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextField;
import model.TrocaOleo;

public class Manutencao implements Initializable {

    @FXML
    private ProgressBar progresso;

    @FXML
    private TextField proxTroca;

    private Connection conexao = Conexao.getConnection();

    @FXML
    void trocaOleo(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        TrocaOleo proximaTroca = new TrocaOleo();
        String sql = "SELECT * FROM TROCAOLEO";
        
       /*  try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

                while(rs.next()){
                    proximaTroca.setKmAtual(rs.getDouble("kmMarcado"));
                    proximaTroca.setProxTroca(rs.getDouble("kmProxTroca"));
                }

                proximaTroca.setTotal(proximaTroca.getKmAtual() + proximaTroca.getProxTroca());

        } catch (SQLException e) {
            e.printStackTrace();
        }*/

        proximaTroca.setTotal((proximaTroca.getKmAtual() / proximaTroca.getProxTroca()) / 100);
        progresso.setProgress(proximaTroca.getTotal());
        
        if(proximaTroca.getTotal() >= 1){            

           JOptionPane.showMessageDialog(null, "Atenção!\nPróxima troca necessária");
           progresso.setStyle("-fx-accent: red;");
           
        } else if(proximaTroca.getTotal() >= 0.8){

            JOptionPane.showMessageDialog(null, "Atenção!\nPróxima troca está perto");
            progresso.setStyle("-fx-accent: yellow;");

        } else {

            progresso.setStyle("-fx-accent: #00FF00;");
            System.out.println(proximaTroca.getTotal());
            
        }

    }

}
