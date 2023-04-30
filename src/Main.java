
import lab6.Book;
import lab6.InputOutput;
import lab6.Logic;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Scanner;



public class Main {
    Book[] books;
    String file;
    Logic logic = new Logic();
    InputOutput printAll=new InputOutput();

    public static void main(String[] args) {
        Main prog = new Main();
        prog.run();
    }

    private void run() {

        Scanner sc = new Scanner(System.in);
        int q;

            while (true) {
                System.out.println("1: Додати запис до файлу");
                System.out.println("2: Вивести зміст файлу на екран");
                System.out.println("3: Вивести список книг заданого автора в порядку зростання року видання");
                System.out.println("4: Вивести список книг, що видані заданим видавництвом");
                System.out.println("5: Вивести список книг, що випущені після заданого року");
                System.out.println("6: Вивести список авторів в алфавітному порядку");
                System.out.println("0: Вийти з програми");
                int k = sc.nextInt();
                switch (k) {
                    case 0:
                        System.out.println("Роботу завершенно");
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Введіть кількість книг");
                        q = sc.nextInt();
                        Book[] temp = new Book[q];

                        for (int i = 0; i < temp.length; i++) {
                              temp[i] = logic.scannerBook(sc);
                        }
                        System.out.println("Введіть назву файлу");
                        String fileName = sc.next();
                        Path path = Paths.get(fileName);
                        if (!Files.exists(path)) {
                            logic.writeToFile(path, temp);
                        }
                        else {
                            logic.addToFile(path, temp);
                        }
                        break;
                case 2:
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    System.out.println("Зміст файлу");
                    this.books = logic.readFromFile(file);
                    printAll.printBook(this.books);
                    break;
                  case 3:
                     System.out.println("Введіть назву файлу");
                     file = sc.next();
                     this.books = logic.readFromFile(file);
                     printAll.printFilterNameSortYear(books);
                     break;
                case 4:
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    books = logic.readFromFile(file);
                    printAll.printFilterEdition(this.books);
                case  5:
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    books = logic.readFromFile(file);
                    printAll.printFilterYear(books);
                case 6:
                    System.out.println("Введіть назву файлу");
                    file = sc.next();
                    books = logic.readFromFile(file);
                    printAll.printAuthorAlphabet(books);
                }
            }
        }
    }
