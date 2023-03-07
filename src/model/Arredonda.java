package model;

import java.math.RoundingMode;
import java.text.DecimalFormat;

public class Arredonda {
    
    public String arredondarValor(double valor) {

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.HALF_UP);

        return df.format(valor);
     }

}
