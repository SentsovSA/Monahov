package Lab2.Class;
//        Учебник (Тип: код, наименование; уровень образования, форма
//        использования, дата поступления в библиотеку).

import java.text.SimpleDateFormat;
import java.util.Date;

public class Textbook extends Book {
    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private TextBookType type;
    private int educationLevel;
    private String useForm;
    private Date date;
    public Textbook(String author, int circulation, String publisher, TextBookType type, int educationLevel, String useForm, Date date) {
        super(author, circulation, publisher);
        this.type = type;
        this.educationLevel = educationLevel;
        this.useForm = useForm;
        this.date = date;
    }

    public TextBookType getType() {
        return type;
    }

    public void setType(TextBookType type) {
        this.type = type;
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
                "код " + type.getId() +
                ", автор " + getAuthor() +
                ", название " + type.getName() +
                ", тираж " + getCirculation() +
                ", издательство " + getPublisher() +
                ", уровень образования " + educationLevel +
                ", форма использования " + useForm  +
                ", дата поступления в библиотеку " + dateFormat.format(date);
    }

}
