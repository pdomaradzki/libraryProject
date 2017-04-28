import java.sql.*;
import java.util.Scanner;

/**
 * Created by jaizm on 13/04/2017.
 */
public class Book {

    private String name;
    private String author;
    private int pages;

    public void addBook(Connection connection) throws SQLException {

        String sql = "INSERT INTO book (name, author, pages) VALUES(?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);

        Scanner scanner = new Scanner(System.in);

        System.out.print("Podaj tytuł: ");
        name = scanner.nextLine();
        System.out.print("Podaj autora: ");
        author = scanner.nextLine();
        System.out.print("Podaj liczbę stron: ");
        pages = scanner.nextInt();


        statement.setString(1, name);
        statement.setString(2, author);
        statement.setInt(3, pages);

        statement.execute();

        statement.close();

        System.out.println("Dodałem książkę!");
    }

    public void listBooks (Connection connection) throws SQLException {

        String sql = "SELECT * FROM book";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery(sql);

        while (resultSet.next()) {
            System.out.println("-------------------------");
            System.out.print("id: " + resultSet.getString("id") + ", ");
            System.out.print("Autor: " + resultSet.getString("author") + ", ");
            System.out.print("Tytuł: " + resultSet.getString("name") + ", ");
            System.out.println("Liczba stron: " + resultSet.getInt("pages"));
            System.out.println("-------------------------");
        }

        resultSet.close();
    }
}
