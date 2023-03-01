package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import banco.Conexao;
import model.Manutencao;

public class ManutencaoDao {

    private Connection conexao = Conexao.getConnection();
    
    public void salvarKmTroca(double troca) {
        
        String sql = "INSERT INTO MANUTENCAO (kmDoDia) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, troca);

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarKmProximaTrocaOleo(Manutencao trocaOleo) {
        
        String sql = "INSERT INTO MANUTENCAO (kmProxTrocaOleo) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, trocaOleo.getProxTroca());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarKmProximaTrocaCorreia(Manutencao trocaCorreia) {

        String sql = "INSERT INTO MANUTENCAO (kmProxTrocaCorreia) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, trocaCorreia.getProxTroca());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void salvarKmProximaTrocaCabos(Manutencao trocaCabos) {

        String sql = "INSERT INTO MANUTENCAO (kmProxTrocaCabos) VALUES (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, trocaCabos.getProxTroca());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
