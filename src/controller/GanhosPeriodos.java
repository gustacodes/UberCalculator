package controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import dao.PeriodoDao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.text.Text;
import model.Arredonda;

public class GanhosPeriodos {

    @FXML
    private DatePicker dataFinal;

    @FXML
    private DatePicker dataInicio;

    @FXML
    private Text txtDepesas;

    @FXML
    private Text txtFaturamento;

    @FXML
    private Text txtGanhosMedHora;

    @FXML
    private Text txtGanhosMedKm;

    @FXML
    private Text txtGanhosMedViagens;

    @FXML
    private Text txtHoras;

    @FXML
    private Text txtKmRodados;

    @FXML
    private Text txtSaldo;

    @FXML
    private Text txtViagens;

    @FXML
    void ganhosPeriodos(ActionEvent event) {
        
        LocalDate dataInicial = dataInicio.getValue();
        String formataData = dataInicial.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        LocalDate dataFim = dataFinal.getValue();
        String formataData2 = dataFim.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        PeriodoDao daoPeriodo = new PeriodoDao();        
        Arredonda arredonda = new Arredonda();

        
        
        txtFaturamento.setText(arredonda.arredondarValor(daoPeriodo.ganhosPeriod(formataData, formataData2).getTotal()).toString());
        txtSaldo.setText(arredonda.arredondarValor(daoPeriodo.ganhosPeriod(formataData, formataData2).getLucro()).toString());
        txtHoras.setText(String.valueOf(daoPeriodo.ganhosPeriod(formataData, formataData2).getHorasTrabalhadas()));
        txtKmRodados.setText(arredonda.arredondarValor(daoPeriodo.ganhosPeriod(formataData, formataData2).getKmDia()).toString());
        txtViagens.setText(String.valueOf(daoPeriodo.ganhosPeriod(formataData, formataData2).getViagens()));
        txtDepesas.setText(arredonda.arredondarValor(daoPeriodo.despesa(formataData, formataData2).getTotalDespesas()).toString());
        
    }

}
