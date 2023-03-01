package model;

public class Despesas {
    
    private double combustivel;
    private double refeicoes;
    private double lavagem;
    private double manutencao;
    private double totalDespesas = 0.0;

    public Despesas() {

    }

    public Despesas(double combustivel, double refeicoes, double lavagem, double manutencao) {
        this.combustivel = combustivel;
        this.refeicoes = refeicoes;
        this.lavagem = lavagem;
        this.manutencao = manutencao;
    }

    public double getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(double combustivel) {
        this.combustivel = combustivel;
    }

    public double getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(double refeicoes) {
        this.refeicoes = refeicoes;
    }

    public double getLavagem() {
        return lavagem;
    }

    public void setLavagem(double lavagem) {
        this.lavagem = lavagem;
    }

    public double getManutencao() {
        return manutencao;
    }

    public void setManutencao(double manutencao) {
        this.manutencao = manutencao;
    }

    public double getTotalDespesas() {
        return totalDespesas;
    }

    public void setTotalDespesas(double totalDespesas) {
        this.totalDespesas = totalDespesas;
    }

    public double DespesasTotais(double combustivelDesp, double refeicoesDesp, double lavagemDesp, double manutencaoDesp) {

        Alertas alert = new Alertas();

        if(combustivelDesp >= 0 && refeicoesDesp >= 0 && lavagemDesp >= 0 && manutencaoDesp >= 0){

            totalDespesas = combustivelDesp + refeicoesDesp + lavagemDesp + manutencaoDesp;

             return totalDespesas;

        } else {

            alert.alertaNegativo();
            return totalDespesas;
        }
        
    }

}
