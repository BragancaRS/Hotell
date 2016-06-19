package br.com.hotell.conn;

// Classe para inserir um Author no banco de dados pousada.db
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexao {

    private static Conexao conexao = null;

    // Declara os objetos para conexao e manipulacao do banco de dados.
    private static Connection connection = null;
    private static PreparedStatement preparedStatement = null;

    public Conexao() {
        String server = "localhost";
        String database = "mydb";
        String user = "root";
        String password = "root";

        try {
           Class.forName("com.mysql.jdbc.Driver");
            Conexao.connection = DriverManager.getConnection("jdbc:mysql://localhost/hotell", "root", "root");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static PreparedStatement getPreparedStatement(String sql) throws SQLException {
        return connection.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

    }

    public static void fecharConexao() {

        if (conexao == null || preparedStatement == null) {
            return;
        }
        try {
            preparedStatement.close();
            connection.close();

            connection = null;
            preparedStatement = null;
            conexao = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Conexao getInstancia() {
        if (conexao == null) {
            conexao = new Conexao();

        }
        return (conexao);
    }
}
