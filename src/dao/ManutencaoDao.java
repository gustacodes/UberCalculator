package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TrocaOleo;

public class ManutencaoDao {

    private Connection conexao = Conexao.getConnection();
    
    public void salvarKmTroca(double troca) {
        
        String sql = "INSERT INTO TROCAOLEO (kmDoDia) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, troca);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarKmProximaTroca(TrocaOleo troca) {
        
        String sql = "INSERT INTO TROCAOLEO (kmProxTroca) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, troca.getProxTroca());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
