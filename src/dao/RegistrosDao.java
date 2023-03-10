package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.Conexao;
import model.Alertas;
import model.Registros;

public class RegistrosDao {

    private Connection conexao = Conexao.getConnection();
    Alertas alerta = new Alertas();

    public void salvar(Registros dados) {

        String sql = "INSERT INTO REGISTROS VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
            try {

                PreparedStatement statement = conexao.prepareStatement(sql);

                statement.setString(1, dados.getDate());
                statement.setDouble(2, dados.getUber());
                statement.setDouble(3, dados.getNove());
                statement.setDouble(4, dados.getInDriver());
                statement.setDouble(5, dados.getOutros());
                statement.setDouble(6, dados.getTotal());
                statement.setDouble(7, dados.getLucro());
                statement.setDouble(8, dados.getKmDia());
                statement.setDouble(9, dados.getHorasTrabalhadas());
                statement.setDouble(10, dados.getViagens());

                statement.execute();
                statement.close();
            } catch (SQLException e) {

                e.printStackTrace();
            }
        }

    public Registros lerRegistros() {
        
        Registros registros = new Registros();

        String sql = "SELECT * FROM REGISTROS";

        PreparedStatement stm;

            try {
                stm = conexao.prepareStatement(sql);
                ResultSet rs = stm.executeQuery();

                    while(rs.next()){
                        registros.setViagens(rs.getDouble("viagens"));
                        registros.setKmDia(rs.getDouble("kmDia"));
                        registros.setTotal(rs.getDouble("total"));
                        registros.setLucro(rs.getDouble("lucro"));
                        registros.setHorasTrabalhadas(rs.getDouble("horasTrabalhadas"));
                        
                    }

            } catch (SQLException e) {
                e.printStackTrace();
            }

            return registros;
        }

        public Registros lerRegistrosPeriodo() {
        
            Registros registros = new Registros();
    
            String sql = "SELECT * FROM REGISTROS";
    
            PreparedStatement stm;
    
                try {
                    stm = conexao.prepareStatement(sql);
                    ResultSet rs = stm.executeQuery();
    
                        while(rs.next()){
                            registros.setViagens(registros.getViagens() + rs.getDouble("viagens"));
                            registros.setHorasTrabalhadas(registros.getHorasTrabalhadas() + rs.getDouble("horasTrabalhadas"));
                            registros.setKmDia(registros.getKmDia() + rs.getDouble("kmDia"));
                            registros.setTotal(registros.getTotal() + rs.getDouble("total"));
                            registros.setLucro(registros.getLucro() + rs.getDouble("lucro"));
                            registros.setUber(registros.getUber() + rs.getDouble("uber"));
                            registros.setNove(registros.getNove() + rs.getDouble("nove"));
                            registros.setInDriver(registros.getInDriver() + rs.getDouble("inDriver"));
                            registros.setOutros(registros.getOutros() + rs.getDouble("outros"));
                            
                        }
    
                } catch (SQLException e) {
                    e.printStackTrace();
                }
    
                return registros;
            }
    
    }