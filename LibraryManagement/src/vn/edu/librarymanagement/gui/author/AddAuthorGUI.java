package vn.edu.librarymanagement.gui.author;

import com.toedter.calendar.JDateChooser;
import vn.edu.librarymanagement.bll.AuthorBLL;
import vn.edu.librarymanagement.dal.AuthorDAL;
import vn.edu.librarymanagement.dto.AuthorDTO;
import vn.edu.librarymanagement.common.HelperClass;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AddAuthorGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfFirstName, tfLastName, tfExpertise, tfEmail;
    private JLabel lbNoteFirstName, lbNoteLastName, lbNoteEmail, lbNoteExpertise;
    private JDateChooser dateChooser;
    private JTextArea taAbout;
    private JButton btnAdd;

    private AuthorDTO author = new AuthorDTO();
    private AuthorDAL dao = new AuthorDAL();
    private HelperClass helper = new HelperClass();
    private AuthorBLL bll = new AuthorBLL();

    public AddAuthorGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 60, 400, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tfFirstName = new JTextField();
        tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfFirstName.setColumns(10);
        tfFirstName.setBounds(11, 120, 363, 24);
        contentPane.add(tfFirstName);

        JLabel lbLast = new JLabel("Last Name");
        lbLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbLast.setBounds(11, 170, 95, 20);
        contentPane.add(lbLast);

        tfLastName = new JTextField();
        tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfLastName.setColumns(10);
        tfLastName.setBounds(11, 200, 363, 24);
        contentPane.add(tfLastName);

        JLabel lbExpertise = new JLabel("Expertise");
        lbExpertise.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbExpertise.setBounds(10, 250, 127, 20);
        contentPane.add(lbExpertise);

        tfExpertise = new JTextField();
        tfExpertise.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfExpertise.setColumns(10);
        tfExpertise.setBounds(11, 280, 363, 24);
        contentPane.add(tfExpertise);

        JLabel lbDateOfBirth = new JLabel("Date Of Birth");
        lbDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbDateOfBirth.setBounds(11, 410, 100, 20);
        contentPane.add(lbDateOfBirth);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfEmail.setColumns(10);
        tfEmail.setBounds(11, 360, 363, 24);
        contentPane.add(tfEmail);

        JLabel lfFirst = new JLabel("First Name");
        lfFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lfFirst.setBounds(11, 90, 95, 20);
        contentPane.add(lfFirst);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbEmail.setBounds(11, 330, 80, 20);
        contentPane.add(lbEmail);

        lbNoteFirstName = helper.setNotice("first name");
        lbNoteFirstName.setForeground(Color.RED);
        lbNoteFirstName.setBounds(11, 150, 126, 14);
        contentPane.add(lbNoteFirstName);
        lbNoteFirstName.setVisible(false);

        lbNoteLastName = helper.setNotice("last name");
        lbNoteLastName.setForeground(Color.RED);
        lbNoteLastName.setBounds(11, 230, 126, 14);
        contentPane.add(lbNoteLastName);
        lbNoteLastName.setVisible(false);

        lbNoteExpertise = helper.setNotice("expertise");
        lbNoteExpertise.setForeground(Color.RED);
        lbNoteExpertise.setBounds(11, 310, 126, 14);
        contentPane.add(lbNoteExpertise);
        lbNoteExpertise.setVisible(false);

        lbNoteEmail = helper.setNotice("email");
        lbNoteEmail.setForeground(Color.RED);
        lbNoteEmail.setBounds(11, 390, 126, 14);
        contentPane.add(lbNoteEmail);
        lbNoteEmail.setVisible(false);

        btnAdd = new JButton("Add New Author");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBounds(11, 550, 378, 30);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(this);
        btnAdd.setFocusable(false);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(186, 85, 211));
        pnTitle.setBounds(0, 0, 400, 75);
        contentPane.add(pnTitle);

        JLabel lbBack = new JLabel("");
        lbBack.setIcon(new ImageIcon("assets/back-logo.png"));
        lbBack.setBounds(0, 0, 32, 32);
        pnTitle.add(lbBack);
        lbBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new AuthorGUI().setVisible(true);
            }
        });

        JLabel lbAddAuthor = new JLabel("Add Author");
        lbAddAuthor.setIcon(new ImageIcon("assets/author-logo.png"));
        lbAddAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lbAddAuthor.setForeground(Color.WHITE);
        lbAddAuthor.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbAddAuthor.setBounds(75, 2, 250, 70);
        pnTitle.add(lbAddAuthor);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(150, 410, 224, 24);
        dateChooser.setDate(new Date());
        contentPane.add(dateChooser);

        JLabel lbAbout = new JLabel("About");
        lbAbout.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbAbout.setBounds(11, 460, 50, 20);
        contentPane.add(lbAbout);

        taAbout = new JTextArea();
        taAbout.setBounds(90, 460, 284, 80);
        contentPane.add(taAbout);
        taAbout.setLineWrap(true);
        taAbout.setWrapStyleWord(true);

        btnAdd.setFocusable(false);
    }

    private void resetText() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfExpertise.setText("");
        tfEmail.setText("");
        dateChooser.setDate(new Date());
        taAbout.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {
            if (helper.setDisplay(tfFirstName.getText(), lbNoteFirstName)
                    || helper.setDisplay(tfLastName.getText(), lbNoteLastName)
                    || helper.setDisplay(tfExpertise.getText(), lbNoteExpertise)
                    || helper.isEmail(tfEmail.getText(), lbNoteEmail)) {
                return;
            }

            try {
                author.setFirstName(tfFirstName.getText());
                author.setLastName(tfLastName.getText());
                author.setExpertise(tfExpertise.getText());
                author.setEmail(tfEmail.getText());
                author.setAbout(taAbout.getText());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dob = sdf.format(dateChooser.getDate());
                author.setDateOfBirth(dob);

                if (dao.isUsed(tfEmail.getText())) {
                    JOptionPane.showMessageDialog(this, "Author already exists");
                    return;
                }

                if (bll.addAuthor(author)) {
                    resetText();
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

