package model;

public class Consumos {
    
    private double km;
    private double qtdLitro;
    private double preco;
    private double media = 0;

    public Consumos(){

    }

    public Consumos(double km, double qtdLitro, double preco) {
        this.km = km;
        this.qtdLitro = qtdLitro;
        this.preco = preco;
    }
    
    public double getKm() {
        return km;
    }

    public void setKm(double km) {
        this.km = km;
    }

    public double getQtdLitro() {
        return qtdLitro;
    }

    public void setQtdLitro(double qtdLitro) {
        this.qtdLitro = qtdLitro;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public double getMedia() {
        return media;
    }

    public void setMedia(double media) {
        this.media = media;
    }

    public double consumoMedio(double kmRodados, double litros) {

        if(kmRodados <= 0 || litros <= 0){

            Alertas alert = new Alertas();
            alert.alertaNegativo();

            return media;

        } else {
            
            return media = kmRodados / litros;
        }        
    }
}
