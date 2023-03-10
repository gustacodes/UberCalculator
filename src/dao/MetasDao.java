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
        
        String sql = "UPDATE METAS SET metaDiaria = (?)";

        try {

            PreparedStatement statement = conexao.prepareStatement(sql);

            statement.setDouble(1, metas.getMetaDiaria());          

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
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }   
        
        return metas;        
    }

}
