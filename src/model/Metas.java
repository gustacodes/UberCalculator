package model;

public class Metas {
    
    private double metaDiaria;
    private double metaMensal;

    public Metas() {

    }

    public Metas(double metaDiaria, double metaMensal) {
        this.metaDiaria = metaDiaria;
        this.metaMensal = metaMensal;
    }

    Alertas alertas = new Alertas();

    public double getMetaDiaria() {
        return metaDiaria;
    }

    public void setMetaDiaria(double metaDiaria) {
        this.metaDiaria = metaDiaria;           
    }

    public double getMetaMensal() {
        return metaMensal;
    }

    public void setMetaMensal(double metaMensal) {
        this.metaMensal = metaMensal;
    }

    public double registraMetaDiaria(double diaMeta) {

        if(diaMeta > 0){
            metaDiaria = diaMeta;
            return metaDiaria;
        } else {
            alertas.alertaNegativo();
            return 0;
        }

    }

    public double registraMetaMensal(double mesMeta) {

        if(mesMeta > 0){
            metaMensal = mesMeta;
            return metaMensal;
        } else {
            alertas.alertaNegativo();
            return 0;
        }

    }

}
