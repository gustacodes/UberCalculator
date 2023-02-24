package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import banco.Conexao;
import model.Veiculo;

public class VeiculoDao {
    
    private Connection conexao = Conexao.getConnection();

    public void cadastrarVeiculo(Veiculo carro) {

        String sql = "INSERT INTO VEICULO VALUES(?, ?, ?, ?, ?)";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, carro.getPlaca().toUpperCase());
            stm.setString(2, carro.getMarca().toUpperCase());
            stm.setString(3, carro.getModelo().toUpperCase());
            stm.setDouble(4, carro.getKmRodados());
            stm.setString(5, carro.getCombustivel());

            stm.execute();
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    
    }
}