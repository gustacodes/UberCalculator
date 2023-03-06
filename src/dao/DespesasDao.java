package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.Conexao;
import model.Despesas;

public class DespesasDao {
    
    private Connection conexao = Conexao.getConnection();

    public void salvarDespesas(Despesas despesa){
        
        String sql = "INSERT INTO DESPESAS VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement stm = conexao.prepareStatement(sql);
            
            stm.setString(1, despesa.getDate());
            stm.setDouble(2, despesa.getCombustivel());
            stm.setDouble(3, despesa.getRefeicoes());
            stm.setDouble(4, despesa.getLavagem());
            stm.setDouble(5, despesa.getManutencao());
            stm.setDouble(6, despesa.getTotalDespesas());

            stm.execute();
            stm.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public Despesas lerDespesas() {
        
        Despesas despesa = new Despesas();
        String sql = "SELECT * FROM DESPESAS";

        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

                while(rs.next()){
                    despesa.setCombustivel(rs.getDouble("combustivel"));
                    despesa.setRefeicoes(rs.getDouble("refeicoes"));
                    despesa.setLavagem(rs.getDouble("lavagem"));
                    despesa.setManutencao(rs.getDouble("manutencao"));
                    despesa.setTotalDespesas(rs.getDouble("total"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }   
        
        return despesa;        
    }
}
