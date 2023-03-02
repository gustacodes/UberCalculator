package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.Conexao;
import model.Metas;

public class MetasDao {

    private Connection conexao = Conexao.getConnection();
    
    public void salvaMetas(Metas metas){
        
        String sql = "INSERT INTO METAS VALUES (?, ?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, metas.getMetaDiaria());
            statement.setDouble(2, metas.getMetaMensal());

            statement.execute();
            statement.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Metas lerMetas() {
        
        Metas metas = new Metas();
        String sql = "SELECT * FROM METAS";

        PreparedStatement stm;
        try {
            stm = conexao.prepareStatement(sql);
            ResultSet rs = stm.executeQuery();

                while(rs.next()){
                    metas.setMetaDiaria(rs.getDouble("metaDiaria"));
                    metas.setMetaMensal(rs.getDouble("metaMensal"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }   
        
        return metas;        
    }

}
