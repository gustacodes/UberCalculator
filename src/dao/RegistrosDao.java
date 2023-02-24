package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import banco.Conexao;
import model.Alertas;
import model.Calculo;

public class RegistrosDao {

    private Connection conexao = Conexao.getConnection();
    Alertas alerta = new Alertas();

    public void salvar(Calculo dados) {

        String sql = "INSERT INTO REGISTROS VALUES (?, ?, ?, ?, ?, ?, ?)";
        
            try {

                PreparedStatement statement = conexao.prepareStatement(sql);

                statement.setString(1, dados.getDate());
                statement.setDouble(2, dados.getUber());
                statement.setDouble(3, dados.getNove());
                statement.setDouble(4, dados.getDespesas());
                statement.setDouble(5, dados.getTotal());
                statement.setDouble(6, dados.getLucro());
                statement.setDouble(7, dados.getKmDia());

                statement.execute();
                statement.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }
    
    }