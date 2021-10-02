package vn.edu.librarymanagement.gui.member;

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

public class DeleteMemberGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfId;
    private JButton btnDelete;
    private JLabel lbNote;

    private MemberDAL dao = new MemberDAL();
    private MemberDTO member = new MemberDTO();
    private MemberBLL bll = new MemberBLL();
    private HelperClass helper = new HelperClass();
    private UtilsClass utils = new UtilsClass();

    public DeleteMemberGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(450, 260, 400, 200);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.lightGray);
        contentPane.setLayout(null);

        JLabel lbId = new JLabel("Enter Member ID");
        lbId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lbId.setBounds(11, 90, 127, 20);
        contentPane.add(lbId);

        tfId = new JTextField();
        tfId.setFont(new Font("Tahoma", Font.PLAIN, 15));
        tfId.setColumns(10);
        tfId.setBounds(150, 90, 219, 24);
        contentPane.add(tfId);

        btnDelete = new JButton("Delete Member");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnDelete.setBounds(11, 150, 378, 30);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(this);

        lbNote = helper.setNotice("id");
        lbNote.setForeground(Color.RED);
        lbNote.setBounds(11, 120, 126, 14);
        contentPane.add(lbNote);
        lbNote.setVisible(false);

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

        JLabel lblDeleteMember = new JLabel("Delete Member");
        lblDeleteMember.setIcon(new ImageIcon("assets/member-logo.png"));
        lblDeleteMember.setHorizontalAlignment(SwingConstants.CENTER);
        lblDeleteMember.setForeground(Color.WHITE);
        lblDeleteMember.setFont(new Font("Tahoma", Font.BOLD, 24));
        lblDeleteMember.setBounds(75, 2, 250, 70);
        pnTitle.add(lblDeleteMember);
    }

    private void resetText() {
        tfId.setText("");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnDelete) {

            if (helper.isNumber(tfId.getText(), lbNote)) {
                return;
            }

            try {
                if (JOptionPane.showConfirmDialog(this, "Do you want to delete the selected " +
                        "item?", "message", JOptionPane.YES_NO_OPTION) == JOptionPane.NO_OPTION) {
                    return;
                }

                if (bll.deleteMember(tfId.getText())) {
                    resetText();
                }
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}
