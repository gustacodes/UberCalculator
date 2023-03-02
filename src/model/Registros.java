package model;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import dao.RegistrosDao;

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
    private double kmDia = 0.0;
    private double horasTrabalhadas = 0.0;
    private int viagens;

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

    DecimalFormat df = new DecimalFormat("###.00");

    public double calculoTotal(double uberValor, double noveValor, double inDriverValor, double outrosValor) {

        if(uberValor >= 0 && noveValor >= 0 && inDriverValor >= 0 && outrosValor >= 0){
            this.uber = uberValor;
            this.nove = noveValor;
            this.inDriver = inDriverValor;
            this.outros = outrosValor;

            df.format(total = uberValor + noveValor + inDriverValor + outrosValor);

            return total;

        } else {
            error.alertaNegativo();
            date = null;
            return total;
        }    

    }

    public double lucroTotal(double totalDoDia, Despesas despesa) {

        if(totalDoDia >= 0 && despesa.getTotalDespesas() >= 0) {

            df.format(lucro = totalDoDia - despesa.getTotalDespesas());
            
            return lucro;

        } else {
            error.alertaNegativo();
            date = null;
            return 0.0;
        }

    }

    private RegistrosDao daoRegistros = new RegistrosDao();

    public double mediaViagens(){
        viagens = (int) (daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getViagens());
        return viagens;
    }
    
    public double mediaHora(){
        horasTrabalhadas = daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getHorasTrabalhadas();
        return horasTrabalhadas;
    }

    public double mediaKm(){
        kmDia = daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getKmDia();
        return kmDia;
    }
}
