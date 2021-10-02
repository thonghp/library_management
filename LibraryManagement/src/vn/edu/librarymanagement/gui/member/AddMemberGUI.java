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

public class AddMemberGUI extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JTextField tfEmail;
    private JComboBox cb;
    private JLabel lbNoteFirstName;
    private JLabel lbNoteLastName;
    private JLabel lbNoteEmail;
    private JLabel lbImg;
    private JButton btnSelect;
    private JButton btnAdd;
    private JDateChooser dateChooser;

    private MemberDAL dao = new MemberDAL();
    private MemberDTO member = new MemberDTO();
    private MemberBLL bll = new MemberBLL();
    private byte[] personalImg;
    private HelperClass helper = new HelperClass();
    private UtilsClass utils = new UtilsClass();

    public AddMemberGUI() {
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

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbEmail.setBounds(10, 250, 127, 20);
        contentPane.add(lbEmail);

        tfEmail = new JTextField();
        tfEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfEmail.setColumns(10);
        tfEmail.setBounds(11, 280, 363, 24);
        contentPane.add(tfEmail);

        JLabel lbGender = new JLabel("Gender");
        lbGender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbGender.setBounds(11, 410, 60, 20);
        contentPane.add(lbGender);

        JLabel lfFirst = new JLabel("First Name");
        lfFirst.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lfFirst.setBounds(11, 90, 95, 20);
        contentPane.add(lfFirst);

        JLabel lbPicture = new JLabel("Profile Picture");
        lbPicture.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbPicture.setBounds(11, 460, 105, 20);
        contentPane.add(lbPicture);

        cb = new JComboBox();
        cb.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cb.setModel(new DefaultComboBoxModel(new String[]{"male", "female"}));
        cb.setBounds(91, 410, 150, 24);
        contentPane.add(cb);

        btnSelect = new JButton("select profile");
        btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 13));
        btnSelect.setBounds(244, 459, 130, 25);
        contentPane.add(btnSelect);

        JLabel lbJoinDate = new JLabel("Join Date");
        lbJoinDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbJoinDate.setBounds(11, 330, 80, 20);
        contentPane.add(lbJoinDate);

        lbNoteFirstName = helper.setNotice("first name");
        lbNoteFirstName.setForeground(Color.RED);
        lbNoteFirstName.setBounds(11, 150, 126, 14);
        contentPane.add(lbNoteFirstName);

        lbNoteLastName = helper.setNotice("last name");
        lbNoteLastName.setForeground(Color.RED);
        lbNoteLastName.setBounds(11, 230, 126, 14);
        contentPane.add(lbNoteLastName);

        lbNoteEmail = helper.setNotice("email");
        lbNoteEmail.setForeground(Color.RED);
        lbNoteEmail.setBounds(11, 310, 126, 14);
        contentPane.add(lbNoteEmail);

        btnAdd = new JButton("Add New Member");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnAdd.setBounds(11, 550, 378, 30);
        contentPane.add(btnAdd);

        lbImg = new JLabel("");
        lbImg.setHorizontalAlignment(SwingConstants.CENTER);
        lbImg.setIcon(new ImageIcon("assets/user.png"));
        lbImg.setBounds(140, 460, 80, 80);
        contentPane.add(lbImg);
        lbImg.setBackground(Color.WHITE);
        lbImg.setOpaque(true);

        JPanel pnTitle = new JPanel();
        pnTitle.setBackground(new Color(52, 191, 73));
        pnTitle.setBounds(0, 0, 400, 75);
        contentPane.add(pnTitle);
        pnTitle.setLayout(null);

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

        JLabel lbTitle = new JLabel("Add Member");
        lbTitle.setIcon(new ImageIcon("assets/member-logo.png"));
        lbTitle.setHorizontalAlignment(SwingConstants.CENTER);
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbTitle.setBounds(75, 2, 250, 70);
        pnTitle.add(lbTitle);

        lbNoteFirstName.setVisible(false);
        lbNoteLastName.setVisible(false);
        lbNoteEmail.setVisible(false);

        btnSelect.addActionListener(this);
        btnAdd.addActionListener(this);
        btnAdd.setFocusable(false);
        btnSelect.setFocusable(false);

        dateChooser = new JDateChooser();
        dateChooser.setDate(new Date());
        dateChooser.setBounds(11, 360, 130, 24);
        contentPane.add(dateChooser);
    }

    private void resetText() {
        tfFirstName.setText("");
        tfLastName.setText("");
        tfEmail.setText("");
        dateChooser.setDate(new Date());
        lbImg.setIcon(new ImageIcon("assets/user.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnAdd) {

            if (helper.setDisplay(tfFirstName.getText(), lbNoteFirstName) ||
                    helper.setDisplay(tfLastName.getText(), lbNoteLastName) ||
                    helper.isEmail(tfEmail.getText(), lbNoteEmail) ||
                    helper.isSelectedImg(personalImg)) {
                return;
            }

            try {
                member.setFirstName(tfFirstName.getText());
                member.setLastName(tfLastName.getText());
                member.setEmail(tfEmail.getText());

                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                String dob = sdf.format(dateChooser.getDate());
                member.setJoinDate(dob);
                member.setGender((cb.getSelectedItem().toString()));
                member.setPicture(personalImg);

                if (dao.isUsed(tfEmail.getText())) {
                    JOptionPane.showMessageDialog(this, "Member already exists");
                    return;
                }

                if (bll.addMember(member)) {
                    resetText();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }

        if (e.getSource() == btnSelect) {
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.setDialogTitle("Select profile picture");

            // set folder default khi mở jfilechooser
//          fileChooser.setCurrentDirectory(new File("E:\\"));

            // lọc extension img (khi ta chọn vào mục image sẽ ko hiển thị các file có đuôi sau
//            FileNameExtensionFilter extensionFilter = new FileNameExtensionFilter("image",
//                    "png", "jpg", "jpeg", "gif");
//            fileChooser.addChoosableFileFilter(extensionFilter);

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
    }
}

