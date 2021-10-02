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

public class EditAuthorGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfId;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfExpertise;
    private JTextField tfEmail;
    private JButton btnSearch;
    private JButton btnEdit;
    private JLabel lbNoteId;
    private JDateChooser dateChooser;
    private JTextArea taAbout;

    private AuthorDTO author = new AuthorDTO();
    private AuthorDAL dao = new AuthorDAL();
    private HelperClass helper = new HelperClass();
    private AuthorBLL bll = new AuthorBLL();

    public EditAuthorGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 35, 400, 650);
        contentPane = new JPanel();
        contentPane.setBackground(Color.lightGray);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

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

        JLabel lbEditAuthor = new JLabel("Edit Author");
        lbEditAuthor.setIcon(new ImageIcon("assets/author-logo.png"));
        lbEditAuthor.setHorizontalAlignment(SwingConstants.CENTER);
        lbEditAuthor.setForeground(Color.WHITE);
        lbEditAuthor.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbEditAuthor.setBounds(75, 2, 250, 70);
        pnTitle.add(lbEditAuthor);

        lbNoteId = helper.setNotice("id");
        lbNoteId.setForeground(Color.RED);
        lbNoteId.setBounds(10, 115, 126, 14);
        contentPane.add(lbNoteId);
        lbNoteId.setVisible(false);

        JLabel lbId = new JLabel("Enter Author ID");
        lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbId.setBounds(10, 90, 127, 20);
        contentPane.add(lbId);

        tfId = new JTextField();
        tfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfId.setColumns(10);
        tfId.setBounds(149, 90, 120, 24);
        contentPane.add(tfId);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSearch.setBounds(279, 90, 89, 26);
        contentPane.add(btnSearch);
        btnSearch.addActionListener(this);
        btnSearch.setFocusable(false);

        JLabel lfFirst = new JLabel("First Name");
        lfFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lfFirst.setBounds(11, 140, 95, 20);
        contentPane.add(lfFirst);

        tfFirstName = new JTextField();
        tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfFirstName.setColumns(10);
        tfFirstName.setBounds(11, 170, 363, 24);
        contentPane.add(tfFirstName);

        JLabel lbLast = new JLabel("Last Name");
        lbLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbLast.setBounds(11, 220, 95, 20);
        contentPane.add(lbLast);

        tfLastName = new JTextField();
        tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfLastName.setColumns(10);
        tfLastName.setBounds(11, 250, 363, 24);
        contentPane.add(tfLastName);

        JLabel lbExpertise = new JLabel("Expertise");
        lbExpertise.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbExpertise.setBounds(10, 300, 127, 20);
        contentPane.add(lbExpertise);

        tfExpertise = new JTextField();
        tfExpertise.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfExpertise.setColumns(10);
        tfExpertise.setBounds(11, 330, 363, 24);
        contentPane.add(tfExpertise);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbEmail.setBounds(11, 380, 80, 20);
        contentPane.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfEmail.setColumns(10);
        tfEmail.setBounds(11, 410, 363, 24);
        contentPane.add(tfEmail);

        JLabel lbDateOfBirth = new JLabel("Date Of Birth");
        lbDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbDateOfBirth.setBounds(11, 460, 100, 20);
        contentPane.add(lbDateOfBirth);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(150, 460, 224, 24);
        dateChooser.setDate(new Date());
        contentPane.add(dateChooser);

        JLabel lbAbout = new JLabel("About");
        lbAbout.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbAbout.setBounds(11, 510, 50, 20);
        contentPane.add(lbAbout);

        taAbout = new JTextArea();
        taAbout.setWrapStyleWord(true);
        taAbout.setLineWrap(true);
        taAbout.setBounds(90, 510, 284, 80);
        contentPane.add(taAbout);

        btnEdit = new JButton("Edit Author Info");
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnEdit.setBounds(11, 600, 378, 30);
        contentPane.add(btnEdit);
        btnEdit.addActionListener(this);
        btnEdit.setFocusable(false);
    }

    private void resetText() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfExpertise.setText("");
        tfEmail.setText("");
        dateChooser.setDate(new Date());
        taAbout.setText("");
        tfId.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {

            if (helper.isNumber(tfId.getText(), lbNoteId)) {
                return;
            }

            try {
                AuthorDTO a = dao.findById(tfId.getText());

                if (a != null) {
                    tfId.setText(String.valueOf(a.getId()));
                    tfFirstName.setText(a.getFirstName());
                    tfLastName.setText(a.getLastName());
                    tfExpertise.setText(a.getExpertise());
                    tfEmail.setText(a.getEmail());

                    Date convertStringToDate = new SimpleDateFormat("yyyy-MM-dd").parse(a.getDateOfBirth());
                    dateChooser.setDate(convertStringToDate);

                    taAbout.setText(a.getAbout());
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid id");
                    resetText();
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (e.getSource() == btnEdit) {

            if (helper.isNumber(tfId.getText(), lbNoteId)) {
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
                author.setId(Integer.parseInt(tfId.getText()));

                if (JOptionPane.showConfirmDialog(this, "Do you want to update the changes?",
                        "message", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    return;
                }

                if (bll.editAuthor(author)) {
                    resetText();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

