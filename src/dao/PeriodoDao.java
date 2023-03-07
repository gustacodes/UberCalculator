package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.Conexao;
import model.Arredonda;
import model.Despesas;
import model.Registros;

public class PeriodoDao {
    
    private Connection conexao = Conexao.getConnection();
    Arredonda ar = new Arredonda();
    
    public Registros ganhosPeriod(String data1, String data2) {

        String sql = "SELECT * FROM REGISTROS WHERE data BETWEEN ? AND ?";
        Registros periodo = new Registros();

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            stm.setString(1, data1);
            stm.setString(2, data2);
            ResultSet rs = stm.executeQuery();

                while(rs.next()){

                    periodo.setTotal(periodo.getTotal() + rs.getDouble("total"));
                    periodo.setLucro(periodo.getLucro() + rs.getDouble("lucro"));
                    periodo.setViagens(periodo.getViagens() +  rs.getInt("viagens"));
                    periodo.setHorasTrabalhadas(periodo.getHorasTrabalhadas() + rs.getDouble("horasTrabalhadas"));
                    periodo.setKmDia(periodo.getKmDia() + rs.getDouble("kmDia"));                
                                        
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return periodo;
        
    }

    public Despesas despesa(String dt1, String dt2) {

        String sql = "SELECT * FROM DESPESAS WHERE data BETWEEN ? AND ?";
        Despesas despesa = new Despesas();

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);

            stm.setString(1, dt1);
            stm.setString(2, dt2);

            ResultSet rs = stm.executeQuery();

                while(rs.next()) {
                    despesa.setTotalDespesas(despesa.getTotalDespesas() + rs.getDouble("total"));
                }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return despesa;
    }

}
