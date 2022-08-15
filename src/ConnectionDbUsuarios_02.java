import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDbUsuarios_02 {

    static final String DB_URL = "jdbc:mysql://localhost/";
    static final String USER = "root";
    static final String PASS = "88510-12PyJsxPMV**";

    public static void main(String[] args) {

        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
        ) {
            System.out.println("Connected to Students database successfully...");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        }

}
