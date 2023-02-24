package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import banco.Conexao;

public class StatusDao {

    private double kmDoDiaDao = 0;
    private double proxTroca = 0;
    private double media = 0;
    private double aux = 0;

    private Connection conexao = Conexao.getConnection();

    public double verificaTrocaOleo(){

        String sql = "SELECT kmProxTrocaOleo, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaOleo");    
                    kmDoDiaDao += result.getDouble("kmDoDia"); 
                    
                        if(proxTroca > 0){
                            aux = proxTroca;
                        }  
                                                                             
                }
                
                    if(aux > 0){
                        media = (kmDoDiaDao / aux) / 100;
                        kmDoDiaDao = 0;
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return media;
    }

    public double verificaTrocaCorreia(){

        String sql = "SELECT kmProxTrocaCorreia, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaCorreia");    
                    kmDoDiaDao += result.getDouble("kmDoDia"); 
                    
                        if(proxTroca > 0){
                            aux = proxTroca;
                        }  
                                                                             
                }
                
                    if(aux > 0){
                        media = (kmDoDiaDao / aux) / 100;
                        kmDoDiaDao = 0;
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return media;
    }

    public double verificaTrocaCabos(){

        String sql = "SELECT kmProxTrocaCabos, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaCabos");    
                    kmDoDiaDao += result.getDouble("kmDoDia"); 
                    
                        if(proxTroca > 0){
                            aux = proxTroca;
                        }  
                                                                             
                }
                
                    if(aux > 0){
                        media = (kmDoDiaDao / aux) / 100;
                        kmDoDiaDao = 0;
                    }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return media;
    }

}
