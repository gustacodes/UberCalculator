package model;

public class Veiculo {

    private String placa;
    private String marca;
    private String modelo;
    private double kmRodados;
    private String combustivel;

    public Veiculo(){

    }

    public Veiculo(String placa, String marca, String modelo, double kmRodados, String combustivel) {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.kmRodados = kmRodados;
        this.combustivel = combustivel;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getKmRodados() {
        return kmRodados;
    }

    public void setKmRodados(double kmRodados) {
        this.kmRodados = kmRodados;
    }

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

}
