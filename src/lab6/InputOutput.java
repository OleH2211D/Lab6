package lab6;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;

public class InputOutput {
    Logic logic;

    public InputOutput() {
        logic = new Logic();

    }
    public void printBook(Book[] books) {
        for (int i = 0; i < books.length; i++) {
            System.out.println(books[i]);
        }
    }

    public void printFilterNameSortYear(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть автора");
        String au = scanner.nextLine();
        printBook(logic.filterNameSortYear(books, au));
    }

    public void printFilterEdition(Book[] books) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть видавництво");
        String ed = scanner.nextLine();
        printBook(logic.filterEdition(books,ed));
    }
    public void printFilterYear(Book[] books){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введіть рік");
        int year= (scanner.nextInt());
        printBook(logic.filterYear(books, year));
    }

  public void printAuthorAlphabet(Book[] books) {
      System.out.println(Arrays.toString(logic.sortAuthor(books)));
  }
}