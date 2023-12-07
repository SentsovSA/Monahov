package Lab6;

import Lab2.Class.TextBookType;
import Lab2.Class.Textbook;

import javax.swing.*;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static Lab2.Class.Textbook.dateFormat;

public class MainTable implements TableModelListener {
    private static Color defaultColor;
    JTable tbl;
    BookTableModel tblModel;
    DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
    private TableRowSorter<BookTableModel> sorter;
    private RowFilter<Object, Object> filter;
    private boolean flag = false;
    ArrayList<Textbook> bookArrayList = new ArrayList<>();
    JTextField number = new JTextField(10);
    JTextField author = new JTextField(20);
    JTextField publisher = new JTextField(10);
    JTextField name = new JTextField(10);
    JTextField circulation = new JTextField(7);
    JTextField educationLevel = new JTextField(5);
    JTextField useForm = new JTextField(10);
    JTextField arrivingDate = new JTextField(10);
    JButton bAdd = new JButton("Добавить");
    JButton bClear = new JButton("Очистить");
    JButton filterButton = new JButton("Фильтр");
    JButton sortButton = new JButton("Сортировка по номеру");
    JTextField filterText = new JTextField(20);

    public MainTable() throws ParseException {
        tblModel = creatingModel();//создание модели

        creatingGui(tblModel);//создание ui и загрузка готовых данных
        //Ведь отрисовкой данных всегда занимается view, вне зависимости от архитектуры приложения, будь то MVVM,
        //MVC, MVP и тп. А мы используем паттерн проектирования, основанный на SOLID или всё-таки на архитектурах?
        //Между ними бывают расхождения, например MVVM в редакции Google для Android нарушает solid :)

        addingListeners(bookArrayList);//добавление слушателей
    }

    private BookTableModel creatingModel() throws ParseException {
        Textbook[] booksArray = new Textbook[10];
        booksArray[0] = new Textbook( "Kolotushkin", 15000, "Pub1",
                new TextBookType(1, "Matematika"), 6, "Chitat'", dateFormat.parse("2020-02-20"));
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
        booksArray[6] = new Textbook( "Kolotushkin", 15000, "Pub1",
                new TextBookType(1, "Matematika"), 6, "Chitat'", dateFormat.parse("2020-02-20"));
        booksArray[7] = new Textbook("Dostoevskiy",10000,  "Pub2", new TextBookType(2, "Istoriya"),
                11, "Pisat'", dateFormat.parse("2019-02-20"));
        booksArray[8] = new Textbook( "Netstoevskiy", 12000,"Pub3", new TextBookType(3, "Himiya"),
                9, "Smotret'", dateFormat.parse("2023-02-20"));
        booksArray[9] = new Textbook( "Pochtistoevskiy", 13000,"Pub5", new TextBookType(4, "Fizika"),
                11, "Vse vmeste", dateFormat.parse("2022-02-20"));
        List<Textbook> bookList = Arrays.asList(booksArray);
        bookArrayList = new ArrayList<>(bookList);
        tblModel = new BookTableModel(bookArrayList);
        tblModel.addTableModelListener(this);
        return tblModel;
    }

    private void addingListeners(ArrayList<Textbook> bookArrayList) {
        bAdd.addActionListener(e -> {
            try {
                if(flag) {
                    bookArrayList.get(tbl.getSelectedRow()).setAuthor(author.getText());
                    bookArrayList.get(tbl.getSelectedRow()).setCirculation(Integer.parseInt(circulation.getText()));
                    bookArrayList.get(tbl.getSelectedRow()).setPublisher(publisher.getText());
                    bookArrayList.get(tbl.getSelectedRow()).getType().setId(Integer.parseInt(number.getText()));
                    bookArrayList.get(tbl.getSelectedRow()).getType().setName(name.getText());
                    bookArrayList.get(tbl.getSelectedRow()).setEducationLevel(Integer.parseInt(educationLevel.getText()));
                    bookArrayList.get(tbl.getSelectedRow()).setUseForm(useForm.getText());
                    bookArrayList.get(tbl.getSelectedRow()).setDate(dateFormat.parse(arrivingDate.getText()));
                } else {
                    bookArrayList.add(new Textbook(
                            author.getText(),
                            Integer.parseInt(circulation.getText()),
                            publisher.getText(),
                            new TextBookType(Integer.parseInt(number.getText()), name.getText()),
                            Integer.parseInt(educationLevel.getText()),
                            useForm.getText(),
                            dateFormat.parse(arrivingDate.getText())));
                }
            } catch (NumberFormatException | ParseException exception) {
                exception.printStackTrace();
            }
            tblModel.fireTableDataChanged();
            tbl.updateUI();
        });
        bClear.addActionListener(e -> clearFields());

        filterButton.addActionListener(e -> {
            String text = filterText.getText();
            applyFilter(text);
        });

        sortButton.addActionListener(e -> {
            applySorting();
        });

        tbl.getSelectionModel().addListSelectionListener(e -> {
            int selectedRow = tbl.getSelectedRow();
            setFieldsFromSelectedRow(selectedRow, bookArrayList);
        });
    }

    private void creatingGui(BookTableModel tblModel) {
        JFrame frm = new JFrame("Книги");
        JPanel pnlTbl = new JPanel();
        JPanel pnlEdt = new JPanel();

        pnlTbl.setLayout(new BorderLayout());
        pnlEdt.setLayout(new FlowLayout());

        frm.setLayout(new BorderLayout());
        frm.setSize(600, 200);
        frm.setLocation(300, 300);
        frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        tbl = new JTable(tblModel);
        tbl.setDefaultRenderer (Number.class, new CirculationRenderer());
        tbl.setDefaultRenderer (Object.class, new StrRenderer());

        RowSorter<BookTableModel> sorter =
                new TableRowSorter<>(tblModel);
        tbl.setRowSorter(sorter);
        JScrollPane scroll = new JScrollPane(tbl);
        tbl.setPreferredScrollableViewportSize(new Dimension(600, 100));
        pnlTbl.add(scroll);
        pnlEdt.add(number);
        pnlEdt.add(author);
        pnlEdt.add(publisher);
        pnlEdt.add(name);
        pnlEdt.add(circulation);
        pnlEdt.add(educationLevel);
        pnlEdt.add(useForm);
        pnlEdt.add(arrivingDate);
        pnlEdt.add(bAdd);
        pnlEdt.add(bClear);
        defaultColor = number.getBackground();
        number.setForeground(Color.BLACK);

        pnlEdt.add(filterText);
        pnlEdt.add(filterButton);

        pnlEdt.add(sortButton);

        frm.getContentPane().add(pnlTbl, BorderLayout.CENTER);
        frm.getContentPane().add(pnlEdt, BorderLayout.SOUTH);
        frm.setVisible(true);
        frm.pack();
    }

    public static Color getDefaultColor() {
        return defaultColor;
    }

    @Override
    public void tableChanged(TableModelEvent e) {
        int row = e.getFirstRow();
        int column = e.getColumn();
        TableModel model = (TableModel) e.getSource();
        String columnName = model.getColumnName(column);
        Object data = model.getValueAt(row, column);
    }

    public static void main(String[] args) {
        try {
            new MainTable();
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    private void applyFilter(String text) {
        RowFilter<BookTableModel, Object> rf = null;
        sorter = new TableRowSorter<>(tblModel);
        tbl.setRowSorter(sorter);
        try {
            rf = RowFilter.regexFilter(text);
        } catch (java.util.regex.PatternSyntaxException e) {
            return;
        }
        sorter.setRowFilter(rf);
    }

    private void applySorting() {
        sorter = new TableRowSorter<>(tblModel);
        tbl.setRowSorter(sorter);
        List<RowSorter.SortKey> sortKeys = new ArrayList<>();
        sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
        sorter.setSortKeys(sortKeys);
    }

    private void setFieldsFromSelectedRow(int rowIndex, ArrayList<Textbook> bookArrayList) {
        flag = true;
        if (rowIndex >= 0 && rowIndex < tblModel.getRowCount()) {
            Textbook selectedBook = bookArrayList.get(rowIndex);
            number.setText(String.valueOf(selectedBook.getType().getId()));
            author.setText(selectedBook.getAuthor());
            publisher.setText(selectedBook.getPublisher());
            name.setText(selectedBook.getType().getName());
            circulation.setText(String.valueOf(selectedBook.getCirculation()));
            educationLevel.setText(String.valueOf(selectedBook.getEducationLevel()));
            useForm.setText(selectedBook.getUseForm());
            arrivingDate.setText(formatter.format(selectedBook.getDate()));
        } else {
            clearFields();
        }
    }

    private void clearFields() {
        number.setText("");
        author.setText("");
        publisher.setText("");
        name.setText("");
        circulation.setText("");
        educationLevel.setText("");
        useForm.setText("");
        arrivingDate.setText("");
    }
}

