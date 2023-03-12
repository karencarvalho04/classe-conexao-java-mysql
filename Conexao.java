import java.net.URL;
import java.sql.*;

public class Conexao {

    public static void main(String[] args) {

        final String URL = "jdbc:mysql://localhost:3306/cadaluno";
        final String USER = "root";
        final String PASSWORD = "root";
        final String CONSULTA = "select * from aluno";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conectado!");

            Statement st = con.createStatement();
            System.out.println("Statement criado!");

            String query = "insert into aluno (nome, matricula) values (?,?)";
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, "Felipe");
            stmt.setInt(2, 100);

            int linhasAfetadas = stmt.executeUpdate();

            System.out.println("Dados inseridos");

            ResultSet resultSet = stmt.executeQuery(CONSULTA);
           while (resultSet.next()) {
              System.out.println(resultSet.getString("nome"));
               System.out.println(resultSet.getString("matricula"));

            }
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }
    }
}
