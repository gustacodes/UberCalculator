package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Registros {

    Alertas error = new Alertas();

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");

    private String date = fd.format(data);
    private double uber;
    private double nove;
    private double inDriver;
    private double outros;
    private double total = 0.0;
    private double lucro = 0.0;
    protected double kmDia = 0.0;
    protected double horasTrabalhadas = 0.0;
    protected int viagens;

    public Registros() {

    }

    public Registros(String date, double uber, double nove, double inDriver, double total, double lucro, double kmDia, double horasTrabalhadas, int viagens) {
        this.date = date;
        this.uber = uber;
        this.nove = nove;
        this.inDriver = inDriver;
        this.total = total;
        this.lucro = lucro;
        this.kmDia = kmDia;
        this.horasTrabalhadas = horasTrabalhadas;
        this.viagens = viagens;
    }
    
    public double getKmDia() {
        return kmDia;
    }

    public void setKmDia(double kmDia) {
        this.kmDia = kmDia;
    }

    public double getUber() {
        return uber;
    }

    public void setUber(double uber) {
        this.uber = uber;
    }

    public double getNove() {
        return nove;
    }

    public void setNove(double nove) {
        this.nove = nove;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getLucro() {
        return lucro;
    }

    public void setLucro(double lucro) {
        this.lucro = lucro;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getInDriver() {
        return inDriver;
    }

    public void setInDriver(double inDriver) {
        this.inDriver = inDriver;
    }

    public double getOutros() {
        return outros;
    }

    public void setOutros(double outros) {
        this.outros = outros;
    }

    
    public double getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setHorasTrabalhadas(double horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public int getViagens() {
        return viagens;
    }

    public void setViagens(int viagens) {
        this.viagens = viagens;
    }

    Arredonda valorArredonda = new Arredonda();

    public String calculoTotal(double uberValor, double noveValor, double inDriverValor, double outrosValor) {

        if(uberValor >= 0 && noveValor >= 0 && inDriverValor >= 0 && outrosValor >= 0){
            this.uber = uberValor;
            this.nove = noveValor;
            this.inDriver = inDriverValor;
            this.outros = outrosValor;
            
            total = uberValor + noveValor + inDriverValor + outrosValor;

            return valorArredonda.arredondarValor(total);

        } else {
            error.alertaNegativo();
            date = null;
            return "0.00";
        }    

    }

    public String lucroTotal(double totalDoDia, Despesas despesa) {

        if(totalDoDia >= 0 && despesa.getTotalDespesas() >= 0) {

            lucro = totalDoDia - despesa.getTotalDespesas();
            
            return valorArredonda.arredondarValor(lucro);

        } else {
            error.alertaNegativo();
            date = null;
            return "0.00";
        }

    }
}
