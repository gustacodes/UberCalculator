package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import dao.Conexao;

public class TrocaOleo {

    private double kmDoDia;
    private double proxTroca;
    private double total;
    private double proxTrocaDao = 0;
    private double kmDoDiaDao = 0;
    private double media = 0;

    public TrocaOleo(){

    }

    public TrocaOleo(double kmDoDia, double proxTroca) {
        this.kmDoDia = kmDoDia;
        this.proxTroca = proxTroca;
    }

    public double getkmDoDia() {
        return kmDoDia;
    }

    public void setkmDoDia(double kmDoDia) {
        this.kmDoDia = kmDoDia;
    }

    public double getProxTroca() {
        return proxTroca;
    }

    public void setProxTroca(double proxTroca) {
        this.proxTroca = proxTroca;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getKmDoDia() {
        return kmDoDia;
    }
    public void setKmDoDia(double kmDoDia) {
        this.kmDoDia = kmDoDia;
    }

    public double getProxTrocaDao() {
        return proxTrocaDao;
    }

    public void setProxTrocaDao(double proxTrocaDao) {
        this.proxTrocaDao = proxTrocaDao;
    }

    public double getKmDoDiaDao() {
        return kmDoDiaDao;
    }

    public void setKmDoDiaDao(double kmDoDiaDao) {
        this.kmDoDiaDao = kmDoDiaDao;
    }    

    public double ProximaTroca(double atualKm, double trocaProx) {  
        this.kmDoDia = atualKm;      
        return total = (atualKm / trocaProx) / 100;
    }

    private Connection conexao = Conexao.getConnection();

    public double verificaTroca(){

        String sql = "SELECT * FROM TROCAOLEO";
        double aux = 0;

        try {

            PreparedStatement stm = conexao.prepareStatement(sql);
            ResultSet result = stm.executeQuery();

                while(result.next()) {     
                    proxTrocaDao = result.getDouble("kmProxTroca");               
                    kmDoDiaDao += result.getDouble("kmDoDia"); 
                    
                        if(proxTrocaDao > 0){
                            aux = proxTrocaDao;
                        }                                                       
                }               
                
                media = (kmDoDiaDao / aux) / 100;
                kmDoDiaDao = 0;

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return media;
    }
}
