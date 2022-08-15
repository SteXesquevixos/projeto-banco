import java.sql.*;

public class ConnectionDb_01 {

    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "88510-12PyJsxPMV**";

    public static void main(String[] args) {
        // Open a connection
        try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            Statement stmt = conn.createStatement();
        ) {


             // Criando um database:
              String sql_DB = "CREATE DATABASE BANCO";

              // Criando uma tabela:
              String sql_table = "CREATE TABLE BANCO.USUARIO (\n" +
                      "   id INT AUTO_INCREMENT PRIMARY KEY,\n"   +
                      "   nome VARCHAR(255) NOT NULL,\n"          +
                      "   data_nascimento DATE\n"                 +
                      ") ENGINE=INNODB;";

             // Executando:
              stmt.executeUpdate(sql_DB);
              stmt.executeUpdate(sql_table);

            System.out.println("Database criado com sucesso...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
