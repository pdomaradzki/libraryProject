import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by jaizm on 28/04/2017.
 */
public class Rent {

    private int book;
    private int user;

    public void addRent(Connection connection) throws SQLException {

        String sql = "INSERT INTO rent (book, user) VALUES(?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj id użytkownika: ");
        user = scanner.nextInt();
        System.out.print("Podaj id książki: ");
        book = scanner.nextInt();


        statement.setInt(1, book);
        statement.setInt(2, user);

        statement.execute();

        statement.close();

        System.out.println("Dodałem wypożyczenie!");
    }

    public void listRents (Connection connection) throws SQLException {

        String sql = "SELECT * FROM rent";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("-------------------------");
//            System.out.print("id: " + resultSet.getString("id") + ", ");
            System.out.print("Książka: " + resultSet.getInt("book") + ", ");
            System.out.print("Użytkownik: " + resultSet.getInt("user") + ", ");
            System.out.println("Data wypożyczenia: " + resultSet.getDate("rentTime"));
            System.out.println("-------------------------");
        }

        resultSet.close();
    }

}
