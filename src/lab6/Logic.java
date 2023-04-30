package lab6;
import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;
import java.util.Scanner;

public class Logic {
    public void writeToFile(Path file, Book[] books) {
        try (BufferedWriter bfr = Files.newBufferedWriter(file)) {


            for (Book book : books) {

                bfr.write(book.toFile());
            }
        } catch (Throwable var8) {
            System.out.println("error inputOutput");
        }
    }

    public Book scannerBook(Scanner s) {
        System.out.println("Введіть id");
        int id = s.nextInt();
        s = new Scanner(System.in);
        System.out.println("Введіть назву");
        String name = s.nextLine();
        System.out.println("Введіть автора");
        String author = s.nextLine();
        System.out.println("Введіть видавництво");
        String edition = s.nextLine();
        System.out.println("Введіть дату видання");
        LocalDate date = LocalDate.parse(s.next());
        System.out.println("Введіть кількість сторінок");
        int pages = s.nextInt();
        System.out.println("Введіть ціну");
        double price = s.nextDouble();

        return new Book(id, name, author, edition, date, pages, price);
    }

    public void addToFile(Path path, Book[] temp) {
        try (BufferedWriter bfr = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {


            for (Book book : temp) {

                bfr.write(book.toFile());
            }
        } catch (Throwable var8) {
            System.out.println("error inputOutput");
        }

    }

    public Book[] readFromFile(String file) {
        Book[] books = new Book[100];
        int i = 0;
        String str = "";
        Path path = Paths.get(file);

        try {
            Scanner scanner = new Scanner(path);

            while (scanner.hasNext()) {
                str = scanner.nextLine();
                String[] strs = str.trim().split("\\|");
                int id = Integer.parseInt(strs[0]);
                String name = strs[1];
                String author = strs[2];
                String edition = strs[3];
                LocalDate date = LocalDate.parse(strs[4]);
                int pages = Integer.parseInt(strs[5]);
                double price = Double.parseDouble(strs[6]);
                books[i] = new Book(id, name, author, edition, date, pages, price);
                i++;
            }

        } catch (IOException var11) {
        }

        return Arrays.copyOf(books, i);
    }

    public Book[] filterNameSortYear(Book[] books, String author) { //список книг заданого автора в порядку зростання року видання;
        Book[] temp = new Book[books.length];
        int p = 0;

        for (Book book : books) {
            if (Objects.equals(book.getAuthor(), author)) {
                temp[p++] = book;
            }
        }
        temp = Arrays.copyOf(temp, p);
        Arrays.sort(temp, new Comparator<Book>() {
            @Override
            public int compare(Book o1, Book o2) {
                return Integer.compare(o1.getDate().getYear(), o2.getDate().getYear());
            }
        });

        return temp;
    }

    public Book[] filterEdition(Book[] books, String edition) { //список книг, що видані заданим видавництвом;
        Book[] temp = new Book[books.length];
        int p = 0;
        Book[] var6 = books;
        int var7 = books.length;

        for (int var8 = 0; var8 < var7; ++var8) {
            Book book = var6[var8];
            if (Objects.equals(book.getEdition(), edition)) {
                temp[p++] = book;
            }
        }

        return Arrays.copyOf(temp, p);
    }

    protected Book[] filterYear(Book[] books, int year) { //список книг, що випущені після заданого року;
        Book[] temp = new Book[books.length];
        int p = 0;
        for (int i = 0; i < books.length; i++) {
            if (books[i].getDate().isAfter(LocalDate.of(year, 12, 31)))
                temp[p++] = books[i];

        }
        return Arrays.copyOf(temp, p);
    }

    protected String[] sortAuthor(Book[] books) {//список авторів в алфавітному порядку
        String[] temp = new String[books.length];
        int p = 0;
        for (int i = 0; i < books.length; i++) {
            String author = books[i].getAuthor();

            if (contain(temp, p, author) == false) {
                temp[p++] = books[i].getAuthor();
            }

        }
        temp=Arrays.copyOf(temp, p);
        Arrays.sort(temp);
        return temp;
    }

    private static boolean contain(String[] temp, int p,String author) {
        for (int j = 0; j < p; j++) {
            if (Objects.equals(temp[j],author)) {
                 return true;

            }
        }
        return false;
    }
}






