package vn.edu.librarymanagement.gui.member;

import vn.edu.librarymanagement.common.UtilsClass;
import vn.edu.librarymanagement.dal.MemberDAL;
import vn.edu.librarymanagement.dto.MemberDTO;
import vn.edu.librarymanagement.gui.DashboardGUI;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class MemberGUI extends JFrame implements ActionListener {
    private JPanel contentPane;
    private JTextField tfName;
    private JButton btnSearch;
    private JButton btnAdd;
    private JButton btnEdit;
    private JButton btnDelete;
    private JTable table;
    private JLabel lbGetName;
    private JLabel lbGetDate;
    private JLabel lbGetEmail;
    private JLabel lbGender;
    private JLabel lbImg;

    private MemberDTO member = new MemberDTO();
    private MemberDAL dao = new MemberDAL();
    private DefaultTableModel model;
    private UtilsClass common = new UtilsClass();

    public MemberGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(225, 125, 916, 520);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(52, 191, 73));
        pnTitle.setBounds(0, 0, 916, 75);
        contentPane.add(pnTitle);

        JLabel lbBack = new JLabel("");
        lbBack.setIcon(new ImageIcon("assets/back-logo.png"));
        lbBack.setBounds(0, 0, 32, 32);
        pnTitle.add(lbBack);
        lbBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new DashboardGUI().setVisible(true);
            }
        });

        JLabel lbAuthorList = new JLabel("Member List");
        lbAuthorList.setIcon(new ImageIcon("assets/author-logo.png"));
        lbAuthorList.setHorizontalAlignment(SwingConstants.CENTER);
        lbAuthorList.setForeground(Color.WHITE);
        lbAuthorList.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbAuthorList.setBounds(333, 2, 250, 70);
        pnTitle.add(lbAuthorList);

        JLabel lbName = new JLabel("Enter the name");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lbName.setBounds(11, 90, 125, 20);
        contentPane.add(lbName);

        tfName = new JTextField();
        tfName.setFont(new Font("Tahoma", Font.PLAIN, 18));
        tfName.setColumns(10);
        tfName.setBounds(165, 90, 260, 26);
        contentPane.add(tfName);

        btnSearch = new JButton("Search");
        btnSearch.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnSearch.setBounds(445, 90, 100, 28);
        contentPane.add(btnSearch);
        btnSearch.addActionListener(this);
        btnSearch.setFocusable(false);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(11, 150, 700, 350);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int row = table.getSelectedRow();
                    String id = String.valueOf(table.getValueAt(row, 0));
                    MemberDTO a = dao.findById(id);
                    if (a != null) {
                        lbGetName.setText(a.getLastName() + " " + a.getFirstName());
                        lbGetEmail.setText(a.getEmail());
                        lbGetDate.setText(a.getJoinDate());
                        lbGender.setText("Gender: " + a.getGender());
                        String[] extensionImg = {"jpg", "png", "jpeg", "gif"};
                        for (String type : extensionImg) {
                            Image img = common.convertByteArrayToImage(a.getPicture(), type);
                            lbImg.setIcon(new ImageIcon(img));
                        }
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        scrollPane.setViewportView(table);

        JLabel lbFullName = new JLabel("Full Name:");
        lbFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbFullName.setBounds(730, 270, 175, 18);
        contentPane.add(lbFullName);

        JLabel lbDate = new JLabel("Join Date:");
        lbDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbDate.setBounds(730, 410, 175, 18);
        contentPane.add(lbDate);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbEmail.setBounds(730, 340, 175, 18);
        contentPane.add(lbEmail);

        lbGender = new JLabel("Gender:");
        lbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGender.setBounds(730, 480, 175, 18);
        contentPane.add(lbGender);

        btnAdd = new JButton("Add");
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnAdd.setFocusable(false);
        btnAdd.setBounds(565, 90, 100, 28);
        contentPane.add(btnAdd);
        btnAdd.addActionListener(this);

        btnEdit = new JButton("Edit");
        btnEdit.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnEdit.setFocusable(false);
        btnEdit.setBounds(685, 90, 100, 28);
        contentPane.add(btnEdit);
        btnEdit.addActionListener(this);

        btnDelete = new JButton("Delete");
        btnDelete.setFont(new Font("Tahoma", Font.BOLD, 18));
        btnDelete.setFocusable(false);
        btnDelete.setBounds(805, 90, 100, 28);
        contentPane.add(btnDelete);
        btnDelete.addActionListener(this);

        lbGetName = new JLabel("");
        lbGetName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetName.setBounds(730, 300, 175, 18);
        contentPane.add(lbGetName);

        lbGetDate = new JLabel("");
        lbGetDate.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetDate.setBounds(730, 440, 175, 18);
        contentPane.add(lbGetDate);

        lbGetEmail = new JLabel("");
        lbGetEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetEmail.setBounds(730, 370, 175, 18);
        contentPane.add(lbGetEmail);

        lbImg = new JLabel("");
        lbImg.setBounds(730, 151, 80, 80);
        contentPane.add(lbImg);
        lbImg.setOpaque(true);

        common.customizeTable(table);
        initTable();
        loadDataToTable("");
    }

    private void loadDataToTable(String input) {
        try {
            List<MemberDTO> list = dao.getTableData(input);

            model.setRowCount(0);
            for (MemberDTO add : list) {
                model.addRow(new Object[]{add.getId(), add.getFirstName(), add.getLastName(), add.getEmail(),
                        add.getJoinDate(), add.getGender()});
            }
            model.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new String[]{"Id", "First Name", "Last Name", "Email", "Join Date", "Gender"});
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

		if (e.getSource() == btnAdd) {
			dispose();
			new AddMemberGUI().setVisible(true);
		}

		if (e.getSource() == btnEdit) {
			dispose();
			new EditMemberGUI().setVisible(true);
		}

		if (e.getSource() == btnDelete) {
			dispose();
			new DeleteMemberGUI().setVisible(true);
		}

        if (e.getSource() == btnSearch) {
            try {
                String input = tfName.getText();
                loadDataToTable(input);
            } catch (Exception exception) {
                exception.printStackTrace();
            }
        }
    }
}

