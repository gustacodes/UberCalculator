package model;

public class TrocaOleo {
    private double kmAtual = 1000;
    private double proxTroca = 10.000;
    private double total;

    public TrocaOleo(){

    }

    public TrocaOleo(double kmAtual, double proxTroca) {
        this.kmAtual = kmAtual;
        this.proxTroca = proxTroca;
    }

    public double getKmAtual() {
        return kmAtual;
    }

    public void setKmAtual(double kmAtual) {
        this.kmAtual = kmAtual;
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

    public double ProgressBar(double atualKm, double trocaProx) {
        total = trocaProx / atualKm;
        return 0;
    }

}
