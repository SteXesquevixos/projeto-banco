import java.sql.*;

public class ConnectionDbUsuarios_03 {

    static final String DB_URL = "jdbc:mysql://localhost/banco";
    static final String USER = "root";
    static final String PASS = "88510-12PyJsxPMV**";

    public static void main(String[] args) {

        Pessoa pessoa = null;

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
             Statement stmt = conn.createStatement();
        ) {

        String sql_DB = "select * from usuario";
        ResultSet rs = stmt.executeQuery(sql_DB);

        while (rs.next()) {

            int id = rs.getInt("id");
            String nome = rs.getString("nome");
            Date dataNascimento = rs.getDate("data_nascimento");

            //Display values
//            System.out.println("ID: " + id);
//            System.out.println(", Nome: " + nome);
//            System.out.println(", Data Nascimento: " + dataNascimento);
            
            pessoa = new Pessoa(id, nome, dataNascimento);
            pessoa.registrarUsuario(id, nome, dataNascimento);
            
        }
        
        System.out.println("Connected to Students database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        pessoa.imprimirLista();
    }
}
