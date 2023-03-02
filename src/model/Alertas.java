package model;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Alertas {
    
    public void alertaNegativo() {
        Alert a = new Alert(AlertType.ERROR);

        a.setTitle("Valor inválido");
        a.setHeaderText("Informe apenas números positivos");
        a.setContentText("Números negativos não serão computados.");
        a.showAndWait();
    }

    public void alertaCampoVazio() {
        Alert a = new Alert(AlertType.ERROR);

        a.setTitle("Error");
        a.setHeaderText("Campo vazio");
        a.setContentText("Verifique se algum dos campos está vazio.");
        a.showAndWait();
    }

    public void abrirLink(){
        Alert a = new Alert(AlertType.ERROR);

        a.setTitle("Error");
        a.setHeaderText("Falha ao abrir");
        a.setContentText("Houve uma falha ao tentar abrir a página.");
        a.showAndWait();
    }

    public void numerosNegativos() {
        Alert alert = new Alert(AlertType.ERROR);
        
        alert.setHeaderText("Error");
        alert.setContentText("Digite valores maiores que 0.");
        alert.showAndWait();
    }

    public void trocaOleoPerto(){
        Alert alert = new Alert(AlertType.INFORMATION);
            
        alert.setHeaderText("Troca de óleo do motor");
        alert.setContentText("A próxima troca de óleo está perto. Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void oleoTroca(){
        Alert alert = new Alert(AlertType.WARNING);
            
        alert.setHeaderText("Troca de óleo do motor necessária");
        alert.setContentText("Está na hora da próxima troca de óleo.\n Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void trocaCorreiaPerto(){
        Alert alert = new Alert(AlertType.INFORMATION);
            
        alert.setHeaderText("Troca da correia do motor");
        alert.setContentText("A próxima troca da correia está perto. Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void CorreiaTroca(){
        Alert alert = new Alert(AlertType.WARNING);
            
        alert.setHeaderText("Troca da correia do motor necessária");
        alert.setContentText("Está na hora de trocar a correia de acordo com a kilometragem. Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void trocaCabosPerto(){
        Alert alert = new Alert(AlertType.INFORMATION);
            
        alert.setHeaderText("Troca dos cabos/velas do motor");
        alert.setContentText("A próxima troca dos cabos e velas está perto. Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void CabosTroca(){
        Alert alert = new Alert(AlertType.WARNING);
            
        alert.setHeaderText("Troca dos cabos/velas do motor necessária");
        alert.setContentText("Está na hora de trocar os cabos e velas de acordo com a kilometragem. Verifique no menu 'Veículo' e depois 'Manutenção' para conferir os status.");
        alert.showAndWait();
    }

    public void registroTrocas() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
            
        alert.setHeaderText("Kilometragem registrada");
        alert.setContentText("Você será notificado de acordo com a proximidade da troca.");
        alert.showAndWait();
    }

    public void metaDiariaBatida() {
        Alert alert = new Alert(AlertType.CONFIRMATION);
            
        alert.setHeaderText("META ATINGIDA!");
        alert.setContentText("PARABÉNS!\nVocê atingiu a meta diária de hoje.");
        alert.showAndWait();
    }

}
