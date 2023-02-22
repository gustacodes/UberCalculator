package model;

public class Consumos {
    
    private double km;
    private double kmViagem;
    private double qtdLitro;
    private double preco;
    private double media = 0;
    private double total = 0;

    public Consumos(){

    }

    public Consumos(double km, double qtdLitro, double preco, double kmViagem) {
        this.km = km;
        this.qtdLitro = qtdLitro;
        this.preco = preco;
        this.kmViagem = kmViagem;
    }
    
    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    
    public double getKmViagem() {
        return kmViagem;
    }

    public void setKmViagem(double kmViagem) {
        this.kmViagem = kmViagem;
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

    Alertas alert = new Alertas();

    public double consumoMedio(double kmRodados, double litros) {

        if(kmRodados <= 0 || litros <= 0){

            alert.alertaNegativo();

            return media;

        } else {
            
            return media = kmRodados / litros;
        }        
    }

    public double consumoViagem(double kmV, double kmL, double precoL) {
        
        if(kmV <= 0 || kmL <= 0 || precoL <= 0) {

            alert.alertaNegativo();
            return total;

        } else {

            media = kmV / kmL;
            total = media * precoL;

            return total;
        }
    }

}
