package banco;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

    private static String url = "jdbc:mysql://127.0.0.1:3306/ubercalculator";
    private static String driver = "com.mysql.cj.jdbc.Driver";
    private static String usuario = "root";
    private static String senha = "wel3nsuh";

    public static Connection getConnection() {

        Connection conexao = null;

        try {
            Class.forName(driver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao conectar ao Banco de Dados");
        }

        try {
            conexao = DriverManager.getConnection(url, usuario, senha);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro no login ou senha");
        }

        return conexao;
    }


}