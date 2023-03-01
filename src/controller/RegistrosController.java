package controller;

import java.io.IOException;

import dao.ManutencaoDao;
import dao.RegistrosDao;
import dao.StatusDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Alertas;
import model.Calculo;
import model.Despesas;

public class RegistrosController {

    @FXML
    private TextField despeCombus;

    @FXML
    private TextField despeLavagem;

    @FXML
    private TextField despeManut;

    @FXML
    private TextField despeRefeicoes;

    @FXML
    private TextField inGanhos;

    @FXML
    private TextField noveGanhos;

    @FXML
    private TextField outrosGanhos;

    @FXML
    private TextField uberGanhos;

    @FXML
    private TextField hrsTrabalhadas;

    @FXML
    private TextField kmRodados;
    
    @FXML
    private TextField viagensDia;

    Alertas alert = new Alertas();   

    @FXML
    void registrarDados(ActionEvent event) throws IOException {
        
            Calculo calculoDeGanhos = new Calculo();

            if(uberGanhos.getText().isEmpty() || noveGanhos.getText().isEmpty() || inGanhos.getText().isEmpty() || outrosGanhos.getText().isEmpty()){                
                alert.alertaCampoVazio();

            } else {               

                calculoDeGanhos.calculoTotal(Double.parseDouble(uberGanhos.getText()), Double.parseDouble(noveGanhos.getText()), Double.parseDouble(inGanhos.getText()), Double.parseDouble(outrosGanhos.getText()));              
                calculoDeGanhos.setKmDia(Double.parseDouble(kmRodados.getText()));
                calculoDeGanhos.setHorasTrabalhadas(Double.parseDouble(hrsTrabalhadas.getText()));
                calculoDeGanhos.setViagens(Integer.parseInt(viagensDia.getText()));
                
                Despesas despesas = new Despesas();

                despesas.DespesasTotais(Double.parseDouble(despeCombus.getText()), Double.parseDouble(despeRefeicoes.getText()), Double.parseDouble(despeLavagem.getText()), Double.parseDouble(despeManut.getText()));
                
                calculoDeGanhos.lucroTotal(calculoDeGanhos.getTotal(), despesas);

                RegistrosDao daoRegistros = new RegistrosDao();

                daoRegistros.salvar(calculoDeGanhos);

                ManutencaoDao daoManutencao = new ManutencaoDao();

                daoManutencao.salvarKmTroca(Double.parseDouble(kmRodados.getText()));

                StatusDao status = new StatusDao();

                    if(status.verificaTrocaOleo() >= 1) {
                        alert.oleoTroca();            
                    } else if(status.verificaTrocaOleo() >= 0.8) { 
                        alert.trocaOleoPerto(); 
                    }

                    if(status.verificaTrocaCorreia() >= 1) {
                        alert.CorreiaTroca();            
                    } else if(status.verificaTrocaCorreia() >= 0.8) { 
                        alert.trocaCorreiaPerto(); 
                    }

                    if(status.verificaTrocaCabos() >= 1) {
                        alert.CabosTroca();        
                    } else if(status.verificaTrocaCabos() >= 0.8) { 
                        alert.trocaCabosPerto(); 
                    }

            }
    }

}
