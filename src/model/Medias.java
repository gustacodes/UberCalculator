package model;

import dao.RegistrosDao;

public class Medias extends Registros {    

    private RegistrosDao daoRegistros = new RegistrosDao();
    
    //MÉTODOS PARA CALCULAR MÉDIA POR DIA
    public String mediaViagens(){
        
        viagens = (int) (daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getViagens());

        return valorArredonda.arredondarValor(viagens);
    }
    
    public String mediaHora(){

        horasTrabalhadas = daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getHorasTrabalhadas();  

        return valorArredonda.arredondarValor(horasTrabalhadas);
    }

    public String mediaKm(){

        kmDia = daoRegistros.lerRegistros().getTotal() / daoRegistros.lerRegistros().getKmDia();
        
        return valorArredonda.arredondarValor(kmDia);
    }

    //MÉTODOS PARA CALCULAR MÉDIA POR PERÍODO

    public String mediaViagensPeriodo(){
        
        viagens = (int) (daoRegistros.lerRegistrosPeriodo().getTotal() / daoRegistros.lerRegistrosPeriodo().getViagens());

        return valorArredonda.arredondarValor(viagens);
    }
    
    public String mediaHoraPeriodo(){

        horasTrabalhadas = daoRegistros.lerRegistrosPeriodo().getTotal() / daoRegistros.lerRegistrosPeriodo().getHorasTrabalhadas();  

        return valorArredonda.arredondarValor(horasTrabalhadas);
    }

    public String mediaKmPeriodo(){

        kmDia = daoRegistros.lerRegistrosPeriodo().getTotal() / daoRegistros.lerRegistrosPeriodo().getKmDia();
        
        return valorArredonda.arredondarValor(kmDia);
    }
    
}
