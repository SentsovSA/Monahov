package Lab2.Class;
//        Базовый класс – Книга (Автор, Название, Тираж, Издательство).

public class Book {
    private String author;
    private String name;
    private int circulation;
    private String publisher;

    public Book(String author, String name, int circulation, String publisher) {
        this.author = author;
        this.name = name;
        this.circulation = circulation;
        this.publisher = publisher;
    }

    public Book(String name, int circulation) {
        this.name = name;
        this.circulation = circulation;
    }

    public String getAuthor() {
        return author;
    }

    public String getName() {
        return name;
    }

    public int getCirculation() {
        return circulation;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCirculation(int circulation) {
        this.circulation = circulation;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Книга: " +
                "автор " + author +
                ", название " + name +
                ", тираж " + circulation +
                ", издательство " + publisher;
    }
}
