package model;

public class Manutencao {

    private double kmDoDia;
    private double proxTroca;
    private double total;

    public Manutencao(){

    }

    public Manutencao(double kmDoDia, double proxTroca) {
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

    public double ProximaTroca(double atualKm, double trocaProx) {  
        this.kmDoDia = atualKm;      
        return total = (atualKm / trocaProx) / 100;
    }

}
