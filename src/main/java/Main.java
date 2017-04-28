import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Created by jaizm on 13/04/2017.
 */
public class Main {

    public static int menu() {
        System.out.println();
        System.out.println("     ****************************************");
        System.out.println("     *                 MENU                 *");
        System.out.println("     ****************************************");
        System.out.println("     1. Dodaj książkę");
        System.out.println("     2. Dodaj osobę");
        System.out.println("     3. Dodaj wypożyczenie");
        System.out.println("     4. Wyświetlanie wszystkich książek");
        System.out.println("     5. Wyświetlanie wszystkich wypożyczeń");
        System.out.println("     6. Wyświetlanie wszystkich osób");
        System.out.println("     7. Usunięcie osoby");
        System.out.println("     0. Koniec");

        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();

        return option;
    }

    public static void main(String[] args) throws SQLException, IOException {

        int choice = menu();

        Mysql mysql = new Mysql();
        User user = new User();
        Book book = new Book();
        Rent rent = new Rent();

        while(choice!=0){
            switch(choice){
                case 1:
                    book.addBook(mysql.serverConnection());
                    break;

                case 2:
                    user.addUser(mysql.serverConnection());
                    break;

                case 3:
                    rent.addRent(mysql.serverConnection());
                    break;

                case 4:
                    book.listBooks(mysql.serverConnection());
                    break;

                case 5:
                    rent.listRents(mysql.serverConnection());
                    break;

                case 6:
                    user.listUsers(mysql.serverConnection());
                    break;

                case 7:
                    user.deleteUser(mysql.serverConnection());
                    break;

            }

            System.out.println("\nWciśnij Enter, aby kontynuować...");

            System.in.read();

            choice = menu();
        }


        System.out.println("     ****************************************");
        System.out.println("\n     Koniec programu\n\n");
    }
}
