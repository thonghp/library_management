package vn.edu.librarymanagement.gui.member;

import com.toedter.calendar.JDateChooser;
import vn.edu.librarymanagement.bll.MemberBLL;
import vn.edu.librarymanagement.common.HelperClass;
import vn.edu.librarymanagement.common.UtilsClass;
import vn.edu.librarymanagement.dal.MemberDAL;
import vn.edu.librarymanagement.dto.MemberDTO;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EditMemberGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfEmail;
    private JTextField tfId;
    private JComboBox cb;
    private JButton btnSelect;
    private JButton btnEdit;
    private JButton btnSearch;
    private JLabel lbNoteId;
    private JLabel lbNoteEmail;
    private JLabel lbNoteLastName;
    private JLabel lbNoteFirstName;
    private JLabel lbImg;
    private JDateChooser dateChooser;

    private MemberDAL dao = new MemberDAL();
    private MemberDTO member = new MemberDTO();
    private MemberBLL bll = new MemberBLL();
    private byte[] personalImg;
    private HelperClass helper = new HelperClass();
    private UtilsClass utils = new UtilsClass();

    public EditMemberGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 35, 400, 650);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setBackground(Color.lightGray);
        setContentPane(contentPane);
        contentPane.setLayout(null);

        tfFirstName = new JTextField();
        tfFirstName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfFirstName.setColumns(10);
        tfFirstName.setBounds(11, 170, 363, 24);
        contentPane.add(tfFirstName);

        JLabel lbLast = new JLabel("Last Name");
        lbLast.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbLast.setBounds(11, 220, 95, 20);
        contentPane.add(lbLast);

        tfLastName = new JTextField();
        tfLastName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfLastName.setColumns(10);
        tfLastName.setBounds(11, 250, 363, 24);
        contentPane.add(tfLastName);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbEmail.setBounds(10, 300, 127, 20);
        contentPane.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfEmail.setColumns(10);
        tfEmail.setBounds(11, 330, 363, 24);
        contentPane.add(tfEmail);

        JLabel lbGender = new JLabel("Gender");
        lbGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbGender.setBounds(11, 460, 70, 20);
        contentPane.add(lbGender);

        JLabel lfFirst = new JLabel("First Name");
        lfFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lfFirst.setBounds(11, 140, 95, 20);
        contentPane.add(lfFirst);

        JLabel lbPicture = new JLabel("Profile Picture");
        lbPicture.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbPicture.setBounds(11, 500, 110, 20);
        contentPane.add(lbPicture);

        cb = new JComboBox();
        cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cb.setModel(new DefaultComboBoxModel(new String[]{"male", "female"}));
        cb.setBounds(91, 460, 150, 24);
        contentPane.add(cb);

        btnSelect = new JButton("select profile");
        btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSelect.setBounds(244, 500, 130, 25);
        contentPane.add(btnSelect);
        btnSelect.addActionListener(this);

        JLabel lbJoinDate = new JLabel("Join Date");
        lbJoinDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbJoinDate.setBounds(11, 380, 80, 20);
        contentPane.add(lbJoinDate);

        lbNoteFirstName = helper.setNotice("first name");
        lbNoteFirstName.setForeground(Color.RED);
        lbNoteFirstName.setBounds(11, 200, 126, 14);
        contentPane.add(lbNoteFirstName);
        lbNoteFirstName.setVisible(false);

        lbNoteLastName = helper.setNotice("last name");
        lbNoteLastName.setForeground(Color.RED);
        lbNoteLastName.setBounds(11, 280, 126, 14);
        contentPane.add(lbNoteLastName);
        lbNoteLastName.setVisible(false);

        lbNoteEmail = helper.setNotice("email");
        lbNoteEmail.setForeground(Color.RED);
        lbNoteEmail.setBounds(11, 360, 126, 14);
        contentPane.add(lbNoteEmail);
        lbNoteEmail.setVisible(false);

        btnEdit = new JButton("Edit Member Info");
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnEdit.setBounds(11, 590, 378, 30);
        contentPane.add(btnEdit);
        btnEdit.addActionListener(this);

        JLabel lbId = new JLabel("Enter Member ID");
        lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbId.setBounds(11, 90, 127, 20);
        contentPane.add(lbId);

        tfId = new JTextField();
        tfId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        tfId.setColumns(10);
        tfId.setBounds(150, 90, 120, 24);
        contentPane.add(tfId);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnSearch.setBounds(280, 90, 89, 26);
        contentPane.add(btnSearch);
        btnSearch.addActionListener(this);

        lbImg = new JLabel("");
        lbImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbImg.setIcon(new ImageIcon("assets/user.png"));
        lbImg.setBounds(140, 500, 80, 80);
        contentPane.add(lbImg);
        lbImg.setBackground(Color.WHITE);
        lbImg.setOpaque(true);

        lbNoteId = helper.setNotice("id");
        lbNoteId.setForeground(Color.RED);
        lbNoteId.setBounds(11, 120, 126, 14);
        contentPane.add(lbNoteId);
        lbNoteId.setVisible(false);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(52, 191, 73));
        pnTitle.setBounds(0, 0, 400, 75);
        contentPane.add(pnTitle);

        JLabel lbHome = new JLabel("");
        lbHome.setIcon(new ImageIcon("assets/back-logo.png"));
        lbHome.setBounds(0, 0, 32, 32);
        pnTitle.add(lbHome);
        lbHome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new MemberGUI().setVisible(true);
            }
        });

        JLabel lbTitle = new JLabel("Edit Member");
        lbTitle.setIcon(new ImageIcon("assets/member-logo.png"));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(75, 2, 250, 70);
        pnTitle.add(lbTitle);
        setUndecorated(true);

        btnEdit.setFocusable(false);
        btnSelect.setFocusable(false);
        btnSearch.setFocusable(false);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(11, 410, 130, 20);
        contentPane.add(dateChooser);
        dateChooser.setDate(new Date());
    }

    private void resetText() {
        tfId.setText("");
        tfFirstName.setText("");
        tfLastName.setText("");
        tfEmail.setText("");
        dateChooser.setDate(new Date());
        lbImg.setIcon(new ImageIcon("assets/user.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnSearch) {

            if (helper.isNumber(tfId.getText(), lbNoteId)) {
                return;
            }

            try {
                MemberDTO m = dao.findById(tfId.getText());

                if (m != null) {
                    tfId.setText(String.valueOf(m.getId()));
                    tfFirstName.setText(m.getFirstName());
                    tfLastName.setText(m.getLastName());
                    tfEmail.setText(m.getEmail());

                    Date convertStringToDate = new SimpleDateFormat("yyyy-MM-dd").parse(m.getJoinDate());
                    dateChooser.setDate(convertStringToDate);

                    cb.setSelectedItem(m.getGender());
                    String[] extensionImg = {"jpg", "png", "jpeg", "gif"};
                    for (String type : extensionImg) {
                        Image img = utils.convertByteArrayToImage(m.getPicture(), type);
                        lbImg.setIcon(new ImageIcon(img));
                        personalImg = m.getPicture();
                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid id");
                    resetText();
                }

            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (e.getSource() == btnSelect) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select profile picture");

            utils.getFilter();

            if (fileChooser.showOpenDialog(null) == JFileChooser.CANCEL_OPTION) {
                return;
            }

            String[] applyExtension = {"png", "jpg", "jpeg", "gif"};
            File file = fileChooser.getSelectedFile().getAbsoluteFile();
            try {
                ImageIcon icon = new ImageIcon(file.getPath());
                Image img = utils.resizeImage(icon.getImage(), 80, 80);
                ImageIcon resize = new ImageIcon(img);
                lbImg.setIcon(resize);

                for (String type : applyExtension) {
                    personalImg = utils.convertImageToByteArray(img, type);
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        if (e.getSource() == btnEdit) {

            if (helper.isNumber(tfId.getText(), lbNoteId) ||
                    helper.setDisplay(tfFirstName.getText(), lbNoteFirstName) ||
                    helper.setDisplay(tfLastName.getText(), lbNoteLastName) ||
                    helper.isEmail(tfEmail.getText(), lbNoteEmail) ||
                    helper.isSelectedImg(personalImg)) {
                return;
            }

            try {
                member.setId(Integer.parseInt(tfId.getText()));
                member.setFirstName(tfFirstName.getText());
                member.setLastName(tfLastName.getText());
                member.setEmail(tfEmail.getText());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dob = sdf.format(dateChooser.getDate());
                member.setJoinDate(dob);

                member.setGender((cb.getSelectedItem().toString()));
                member.setPicture(personalImg);

                if (JOptionPane.showConfirmDialog(this, "Do you want to update the changes?",
                        "message", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    return;
                }

                if (bll.editMember(member)) {
                    resetText();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
