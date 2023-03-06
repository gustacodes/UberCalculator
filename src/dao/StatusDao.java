package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import banco.Conexao;

public class StatusDao {

    private double kmDoDiaDao = 0;
    private double proxTroca = 0;
    private double mediaOleo = 0;
    private double mediaCabos = 0;
    private double mediaCorreia = 0;
    private double aux = 0;
    private double aux2 = 0;

    private Connection conexao = Conexao.getConnection();

    public double verificaTrocaOleo(){

        String sql = "SELECT kmProxTrocaOleo, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaOleo");    
                    kmDoDiaDao = result.getDouble("kmDoDia"); 
                    
                    if(proxTroca > 0){
                        aux = proxTroca;
                    }

                        if(kmDoDiaDao > 0) {
                            aux2 += kmDoDiaDao;
                        }
                        
                            if(aux > 0){
                                mediaOleo = (aux2 / aux);                                
                            }
            }

            aux = 0;
            aux2 = 0;
            kmDoDiaDao = 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return mediaOleo;
    }

    public double verificaTrocaCorreia(){

        String sql = "SELECT kmProxTrocaCorreia, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaCorreia");    
                    kmDoDiaDao = result.getDouble("kmDoDia"); 
                    
                        if(proxTroca > 0){
                            aux = proxTroca;
                        }

                        if(kmDoDiaDao > 0) {
                            aux2 += kmDoDiaDao;
                        }
                        
                            if(aux > 0){
                                mediaCorreia = (aux2 / aux);                                
                            }
                }

                aux = 0;
                aux2 = 0;
                kmDoDiaDao = 0;
                

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mediaCorreia;
    }

    public double verificaTrocaCabos() {

        String sql = "SELECT kmProxTrocaCabos, kmDoDia FROM MANUTENCAO";

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) { 

                    proxTroca = result.getDouble("kmProxTrocaCabos");    
                    kmDoDiaDao = result.getDouble("kmDoDia"); 
                    
                    if(proxTroca > 0){
                        aux = proxTroca;
                    }

                    if(kmDoDiaDao > 0) {
                        aux2 += kmDoDiaDao;
                    }
                    
                        if(aux > 0){
                            mediaCabos = (aux2 / aux);                            
                        }
            }

            aux = 0;
            aux2 = 0;
            kmDoDiaDao = 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return mediaCabos;
    }

}
