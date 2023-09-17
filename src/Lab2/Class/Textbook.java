package Lab2.Class;
//        Учебник (Тип: код, наименование; уровень образования, форма
//        использования, дата поступления в библиотеку).

import java.text.SimpleDateFormat;
import java.util.Date;

public class Textbook extends Book {
    protected static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    private int number;
    private int educationLevel;
    private String useForm;
    private Date date;
    public Textbook(int number, String author, String publisher, String name, int circulation, int educationLevel, String useForm, Date date) {
        super(name, author, circulation, publisher);
        this.number = number;
        this.educationLevel = educationLevel;
        this.useForm = useForm;
        this.date = date;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(int educationLevel) {
        this.educationLevel = educationLevel;
    }

    public String getUseForm() {
        return useForm;
    }

    public void setUseForm(String useForm) {
        this.useForm = useForm;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Учебник: " +
                "код " + number +
                ", автор " + getAuthor() +
                ", название " + getName() +
                ", тираж " + getCirculation() +
                ", издательство " + getPublisher() +
                ", уровень образования " + educationLevel +
                ", форма использования " + useForm  +
                ", дата поступления в библиотеку " + dateFormat.format(date);
    }

}
