import java.sql.*;
import java.util.Scanner;

/**
 * Created by jaizm on 13/04/2017.
 */
public class User {

    private String name;
    private String lastName;
    private String number;
    private String password;
    private int id;

//    public User() {
//    }

    public void addUser(Connection connection) throws SQLException {

        String sql = "INSERT INTO user (name, password, lastName, number) VALUES(?, ?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj imię: ");
        name = scanner.nextLine();
        System.out.print("Podaj Nazwisko: ");
        lastName = scanner.nextLine();
        System.out.print("Podaj nr telefonu: ");
        number = scanner.nextLine();
        System.out.print("Podaj hasło: ");
        password = scanner.nextLine();


        statement.setString(1, name);
        statement.setString(2, password);
        statement.setString(3, lastName);
        statement.setString(4, number);

        statement.execute();

        statement.close();

        System.out.println("Dodałem użytkownika!");
    }

    public void listUsers (Connection connection) throws SQLException {

        String sql = "SELECT * FROM user";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("-------------------------");
            System.out.print("id: " + resultSet.getString("id") + ", ");
            System.out.print("Imię: " + resultSet.getString("name") + ", ");
            System.out.print("Nazwisko: " + resultSet.getString("lastName") + ", ");
            System.out.println("Nr telefonu: " + resultSet.getInt("number"));
            System.out.println("-------------------------");
        }

        resultSet.close();
    }

    public void deleteUser(Connection connection) throws SQLException {

        String sql = "DELETE FROM user WHERE id = ?";
        PreparedStatement statement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj id osoby do usunięcia: ");
        id = scanner.nextInt();


        statement.setInt(1, id);
        statement.executeUpdate();

        statement.close();

        System.out.println("Usunąłem użytkownika!");
    }

}

