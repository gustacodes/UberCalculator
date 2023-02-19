package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Calculo {

    Alertas error = new Alertas();

    Date data = new Date();
    SimpleDateFormat fd = new SimpleDateFormat("dd/MM/yyyy");

    private String date = fd.format(data);

    private double uber;
    private double nove;
    private double despesas;
    private double total = 0.0;
    private double lucro = 0.0;

    public Calculo() {

    }

    public Calculo(String date, double uber, double nove, double despesas, double total, double lucro) {
        this.date = date;
        this.uber = uber;
        this.nove = nove;
        this.despesas = despesas;
        this.total = total;
        this.lucro = lucro;
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

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(double despesas) {
        this.despesas = despesas;
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

    DecimalFormat df = new DecimalFormat("###.00");

    public Double calculoTotal(double uberValor, double noveValor) {

        if(uberValor >= 0 && noveValor >= 0){
            this.uber = uberValor;
            this.nove = noveValor;

            df.format(total = uberValor + noveValor);

            return total;

        } else {
            error.alertaNegativo();
            date = null;
            return total;
        }    

    }

    public Double lucroTotal(double totalDoDia, double despesa) {

        if(totalDoDia >= 0 && despesa >= 0) {
            this.despesas = despesa;

            df.format(lucro = totalDoDia - despesa);
            
            return lucro;

        } else {
            error.alertaNegativo();
            date = null;
            return 0.0;
        }

    }
}
