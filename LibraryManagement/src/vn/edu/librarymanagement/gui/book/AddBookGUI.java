package vn.edu.librarymanagement.gui.book;

import com.toedter.calendar.JDateChooser;
import vn.edu.librarymanagement.bll.BookBLL;
import vn.edu.librarymanagement.common.UtilsClass;
import vn.edu.librarymanagement.common.Genres;
import vn.edu.librarymanagement.common.HelperClass;
import vn.edu.librarymanagement.dal.BookDAL;
import vn.edu.librarymanagement.dto.BookDTO;
import vn.edu.librarymanagement.gui.DashboardGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

public class AddBookGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfISBN, tfName, tfPublisher, tfPrice;
    private JComboBox cbGenres, cbAuthor;
    private JButton btnAdd, btnReturn, btnSelectImg;
    private JSpinner spQuantity;
    private JDateChooser dateChooser;
    private JLabel lbImg, lbNoteISBN, lbNoteName, lbNotePublisher, lbNotePrice, lbNoteDescription;
    private JTextArea taDescription;
    private DefaultComboBoxModel cbmGenres, cbmAuthor;

    private BookDAL dao = new BookDAL();
    private BookDTO book = new BookDTO();
    private byte[] personalImg;
    private HelperClass helper = new HelperClass();
    private UtilsClass imgProcess = new UtilsClass();
    private BookBLL bll = new BookBLL();

    public AddBookGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(265, 120, 836, 550);
        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lbISBN = new JLabel("ISBN");
        lbISBN.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbISBN.setBounds(83, 90, 40, 20);
        contentPane.add(lbISBN);

        tfISBN = new JTextField();
        tfISBN.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfISBN.setColumns(10);
        tfISBN.setBounds(135, 90, 180, 24);
        contentPane.add(tfISBN);

        JLabel lbName = new JLabel("Name");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbName.setBounds(77, 140, 45, 20);
        contentPane.add(lbName);

        JLabel lbAuthor = new JLabel("Author");
        lbAuthor.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbAuthor.setBounds(70, 190, 55, 20);
        contentPane.add(lbAuthor);

        JLabel lbGenres = new JLabel("Genres");
        lbGenres.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbGenres.setBounds(77, 240, 50, 20);
        contentPane.add(lbGenres);

        JLabel lbQuatity = new JLabel("Quantity");
        lbQuatity.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbQuatity.setBounds(57, 290, 65, 20);
        contentPane.add(lbQuatity);

        JLabel lbPublisher = new JLabel("Publisher");
        lbPublisher.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbPublisher.setBounds(53, 340, 70, 20);
        contentPane.add(lbPublisher);

        JLabel lbPrice = new JLabel("Price");
        lbPrice.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbPrice.setBounds(83, 390, 40, 20);
        contentPane.add(lbPrice);

        JLabel lbDateReceived = new JLabel("Date Received");
        lbDateReceived.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbDateReceived.setBounds(15, 440, 110, 20);
        contentPane.add(lbDateReceived);

        tfName = new JTextField();
        tfName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfName.setColumns(10);
        tfName.setBounds(135, 140, 360, 24);
        contentPane.add(tfName);

        tfPublisher = new JTextField();
        tfPublisher.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfPublisher.setColumns(10);
        tfPublisher.setBounds(135, 340, 360, 24);
        contentPane.add(tfPublisher);

        tfPrice = new JTextField();
        tfPrice.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfPrice.setColumns(10);
        tfPrice.setBounds(135, 390, 150, 24);
        contentPane.add(tfPrice);

        JLabel lbDescription = new JLabel("Book Description");
        lbDescription.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbDescription.setBounds(550, 100, 135, 20);
        contentPane.add(lbDescription);

        btnAdd = new JButton("Add Book");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBounds(243, 500, 150, 30);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(this);
        btnAdd.setFocusable(false);

        btnReturn = new JButton("Return Home");
        btnReturn.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnReturn.setBounds(443, 500, 150, 30);
        contentPane.add(btnReturn);
        btnReturn.addActionListener(this);
        btnReturn.setFocusable(false);

        JLabel lbBook = new JLabel("Book Cover");
        lbBook.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbBook.setBounds(550, 280, 95, 20);
        contentPane.add(lbBook);

        lbImg = new JLabel("");
        lbImg.setOpaque(true);
        lbImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbImg.setBackground(Color.WHITE);
        lbImg.setBounds(550, 310, 120, 120);
        contentPane.add(lbImg);

        btnSelectImg = new JButton("select profile");
        btnSelectImg.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSelectImg.setBounds(550, 440, 120, 26);
        contentPane.add(btnSelectImg);
        btnSelectImg.addActionListener(this);
        btnSelectImg.setFocusable(false);

        cbGenres = new JComboBox();
        cbGenres.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbGenres.setBounds(135, 240, 200, 24);
        contentPane.add(cbGenres);

        spQuantity = new JSpinner();
        spQuantity.setModel(new SpinnerNumberModel(0, 0, 100, 1));
        spQuantity.setFont(new Font("Tahoma", Font.PLAIN, 15));
        spQuantity.setBounds(135, 290, 50, 24);
        contentPane.add(spQuantity);

        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        dateChooser.setBounds(135, 440, 150, 24);
        contentPane.add(dateChooser);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(255, 194, 14));
        pnTitle.setBounds(0, 0, 836, 75);
        contentPane.add(pnTitle);

        JLabel lblAddBook = new JLabel("Add Book");
        lblAddBook.setIcon(new ImageIcon("assets/book-logo.png"));
        lblAddBook.setHorizontalAlignment(SwingConstants.CENTER);
        lblAddBook.setForeground(Color.WHITE);
        lblAddBook.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblAddBook.setBounds(293, 2, 250, 70);
        pnTitle.add(lblAddBook);

        taDescription = new JTextArea();
        taDescription.setBounds(550, 130, 260, 125);
        contentPane.add(taDescription);
        taDescription.setLineWrap(true);
        taDescription.setWrapStyleWord(true);

        lbNoteISBN = helper.setNotice("isbn");
        lbNoteISBN.setForeground(Color.RED);
        lbNoteISBN.setBounds(83, 120, 126, 14);
        contentPane.add(lbNoteISBN);
        lbNoteISBN.setVisible(false);

        lbNoteName = helper.setNotice("book title");
        lbNoteName.setForeground(Color.RED);
        lbNoteName.setBounds(83, 170, 126, 14);
        contentPane.add(lbNoteName);
        lbNoteName.setVisible(false);

        lbNotePublisher = helper.setNotice("publisher");
        lbNotePublisher.setForeground(Color.RED);
        lbNotePublisher.setBounds(83, 370, 126, 14);
        contentPane.add(lbNotePublisher);
        lbNotePublisher.setVisible(false);

        lbNotePrice = helper.setNotice("price");
        lbNotePrice.setForeground(Color.RED);
        lbNotePrice.setBounds(83, 420, 126, 14);
        contentPane.add(lbNotePrice);
        lbNotePrice.setVisible(false);

        lbNoteDescription = helper.setNotice("description");
        lbNoteDescription.setForeground(Color.RED);
        lbNoteDescription.setBounds(550, 260, 126, 14);
        contentPane.add(lbNoteDescription);
        lbNoteDescription.setVisible(false);

        cbAuthor = new JComboBox();
        cbAuthor.setFont(new Font("Tahoma", Font.PLAIN, 15));
        cbAuthor.setBounds(135, 190, 200, 24);
        contentPane.add(cbAuthor);

        initComboBoxGenres();
        initComboBoxAuthor();
    }

    private void initComboBoxAuthor() {
        cbmAuthor = new DefaultComboBoxModel();
        try {
            HashMap<String, Integer> author = dao.getAuthorValue();
            for (String add : author.keySet()) {
                cbmAuthor.addElement(add);
            }
            cbAuthor.setModel(cbmAuthor);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initComboBoxGenres() {
        cbmGenres = new DefaultComboBoxModel();
        List<Genres> list = new ArrayList<>();

        for (Genres s : Genres.values()) {
            list.add(s);
        }

        for (Genres genres : list) {
            cbmGenres.addElement(genres);
        }

        cbGenres.setModel(cbmGenres);
    }

    private void resetText() {
        tfISBN.setText("");
        tfName.setText("");
        cbGenres.setSelectedIndex(0);
        cbAuthor.setSelectedIndex(0);
        spQuantity.setValue(0);
        tfPublisher.setText("");
        tfPrice.setText("");
        dateChooser.setDate(new Date());
        taDescription.setText("");
        lbImg.setIcon(new ImageIcon("assets/user.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {

            if (helper.isNumber(tfISBN.getText(), lbNoteISBN) || helper.setDisplay(tfName.getText(), lbNoteName)
                    || helper.setDisplay(tfPublisher.getText(), lbNotePublisher)
                    || helper.isNumber(tfPrice.getText(), lbNotePrice)
                    || helper.setDisplay(taDescription.getText(), lbNoteDescription)
                    || helper.isSelectedImg(personalImg)) {
                return;
            }

            try {
//                HashMap<String, Integer> author = dao.getAuthorValue();
//                int authorId = author.get(cbAuthor.getSelectedItem());
//
//                book.setIsbn(tfISBN.getText());
//                book.setBookTitle(tfName.getText());
//                book.setAuthorId(authorId);
//                book.setGenresId(genresId);
//                book.setQuantity((Integer) spQuantity.getValue());
//                book.setPublisher(tfPublisher.getText());
//                book.setPrice(Integer.parseInt((tfPrice.getText())));
//
//                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//                String dob = sdf.format(dateChooser.getDate());
//                book.setDateReceived(dob);
//
//                book.setDescription(taDescription.getText());
//                book.setPicture(personalImg);
//
//                if (dao.isUsed(tfISBN.getText())) {
//                    JOptionPane.showMessageDialog(this, "Book already exists");
//                    return;
//                }
//
//                if (bll.addBook(book)) {
//                    resetText();
//                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (e.getSource() == btnSelectImg) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select profile picture");

            fileChooser.setFileFilter(new FileFilter() {
                @Override
                public boolean accept(File f) {
                    if (f.isDirectory()) {
                        return true;
                    }

                    String extension = imgProcess.getImageExtension(f);
                    if (extension != null) {
                        if (extension.equals(imgProcess.GIF) || extension.equals(imgProcess.JPG) ||
                                extension.equals(imgProcess.JPEG) || extension.equals(imgProcess.PNG)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    return false;
                }

                @Override
                public String getDescription() {
                    return "Just Images";
                }
            });

            if (fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                return;
            }

            String[] applyExtension = {"png", "jpg", "jpeg", "gif"};
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            try {
                ImageIcon icon = new ImageIcon(file.getPath());
                Image img = imgProcess.resizeImage(icon.getImage(), 120, 120);
                ImageIcon resize = new ImageIcon(img);
                lbImg.setIcon(resize);

                for (String type : applyExtension) {
                    personalImg = imgProcess.convertImageToByteArray(img, type);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == btnReturn) {
            dispose();
            new DashboardGUI().setVisible(true);
        }
    }
}

