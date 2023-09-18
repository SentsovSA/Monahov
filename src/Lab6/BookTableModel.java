package Lab6;

import Lab2.Class.Book;
import Lab2.Class.Textbook;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

public class BookTableModel extends AbstractTableModel {
    ArrayList<Textbook> books;

    public BookTableModel(ArrayList<Textbook> books) {
        super();
        this.books = books;
    }

    @Override
    public int getRowCount() {
        return books.size();
    }

    @Override
    public int getColumnCount() {
        return 8;
    }

    //int number, String author, String publisher, String name, int circulation, int educationLevel, String useForm, Date date
    @Override
    public String getColumnName(int c) {
        return switch (c) {
            case 0 -> "Number";
            case 1 -> "Author";
            case 2 -> "Publisher";
            case 3 -> "Name";
            case 4 -> "Circulation";
            case 5 -> "Education level";
            case 6 -> "Use form";
            case 7 -> "Arriving date";
            default -> "";
        };
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(0, columnIndex).getClass();
    }

    @Override
    public Object getValueAt(int r, int c) {
        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        return switch (c) {
            case 0 -> books.get(r).getNumber();
            case 1 -> books.get(r).getAuthor();
            case 2 -> books.get(r).getPublisher();
            case 3 -> books.get(r).getName();
            case 4 -> books.get(r).getCirculation();
            case 5 -> books.get(r).getEducationLevel();
            case 6 -> books.get(r).getUseForm();
            case 7 -> books.get(r).getDate();
            default -> "";
        };
    }
}
