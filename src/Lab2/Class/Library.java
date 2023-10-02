package Lab2.Class;
//        Вывести список книг заданного издательства.
//        Определить суммарный тираж книг для заданного уровня образования.

import java.text.ParseException;
import java.util.Scanner;

import static Lab2.Class.Textbook.dateFormat;


public class Library {
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        Book[] booksArray = new Book[10];
        booksArray[0] = new Book("Pushkin", "Kapitanskaya dochka", 10000, "Pub1");
        booksArray[1] = new Textbook( "Kolotushkin", 15000, "Pub1",
                new TextBookType(1, "Matematika"), 6, "Chitat'", dateFormat.parse("2020-02-20"));
        booksArray[2] = new Textbook("Dostoevskiy",10000,  "Pub2", new TextBookType(2, "Istoriya"),
                 11, "Pisat'", dateFormat.parse("2019-02-20"));
        booksArray[3] = new Textbook( "Netstoevskiy", 12000,"Pub3", new TextBookType(3, "Himiya"),
                 9, "Smotret'", dateFormat.parse("2023-02-20"));
        booksArray[4] = new Textbook( "Pochtistoevskiy", 13000,"Pub5", new TextBookType(4, "Fizika"),
                 11, "Vse vmeste", dateFormat.parse("2022-02-20"));
        booksArray[5] = new Textbook( "Bulgakov", 11000,"Pub3", new TextBookType(5,"Astronomiya"),
                 10, "Ne ispol'zuetsa", dateFormat.parse("2021-02-20"));
        booksArray[6] = new Book("Tolstoy", "Prestuplenie i nakazanie", 10000, "Pub2");
        booksArray[7] = new Book("Hudoi", "Prestuplenie i beznakazannost'", 10000, "Pub2");
        booksArray[8] = new Book("Griboedov", "Zakonoposlushnost' i nakazanie", 10000, "Pub4");
        booksArray[9] = new Book("Griboneedov", "Pol'za gribov", 10000, "Pub5");
        displayingBooks(booksArray);
        circulationDetermination(booksArray);
    }

    public static void displayingBooks(Book[] booksArray) {
        boolean flag = false;
        System.out.print("Напишите название издателя: ");
        String pub = scan.nextLine();
        for (Book book : booksArray) {
            if (book.getPublisher().equals(pub)) {
                System.out.println(book);
                flag = true;
            }
        }
        if(!flag) System.out.println("От этого издателя книг нет");
    }

    public static void circulationDetermination(Book[] booksArray) {
        System.out.print("Напишите необходимый уровень образования: ");
        int sum = 0;
        int edLev = scan.nextInt();
        for (int i = 0; i < booksArray.length; i++) {
            if(booksArray[i] instanceof Textbook) {
                if (((Textbook)booksArray[i]).getEducationLevel() == edLev) {
                    sum += booksArray[i].getCirculation();
                }
            }
        }
        System.out.println("Тираж учебников с уровнем образования " + edLev + " равен " + sum);
    }
}
