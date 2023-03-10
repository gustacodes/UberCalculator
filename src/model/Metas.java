package model;

public class Metas {
    
    private double metaDiaria = 0;

    public Metas() {

    }

    public Metas(double metaDiaria) {
        this.metaDiaria = metaDiaria;
    }

    Alertas alertas = new Alertas();

    public double getMetaDiaria() {
        return metaDiaria;
    }

    public void setMetaDiaria(double metaDiaria) {
        this.metaDiaria = metaDiaria;           
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

}
