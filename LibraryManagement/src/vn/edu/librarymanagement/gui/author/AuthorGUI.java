package vn.edu.librarymanagement.gui.author;

import vn.edu.librarymanagement.common.CommonClass;
import vn.edu.librarymanagement.dal.AuthorDAL;
import vn.edu.librarymanagement.dto.AuthorDTO;
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

public class AuthorGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    private JTextField tfName;
    private JButton btnSearch, btnAdd, btnEdit, btnDelete;
    private JTable table;
    private JLabel lbGetName, lbGetExpertise, lbGetEmail, lbGetDateOfBirth;

    private AuthorDTO author = new AuthorDTO();
    private AuthorDAL dao = new AuthorDAL();
    private DefaultTableModel model;
    private CommonClass common = new CommonClass();

    public AuthorGUI() {
        setUndecorated(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(225, 125, 916, 470);
        contentPane = new JPanel();
        contentPane.setBackground(Color.LIGHT_GRAY);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel pnTitle = new JPanel();
        pnTitle.setLayout(null);
        pnTitle.setBackground(new Color(186, 85, 211));
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

        JLabel lbAuthorList = new JLabel("Author List");
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
        scrollPane.setBounds(11, 150, 700, 300);
        contentPane.add(scrollPane);

        table = new JTable();
        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    int row = table.getSelectedRow();
                    String id = String.valueOf(table.getValueAt(row, 0));
                    AuthorDTO a = dao.findById(id);
                    if (a != null) {
                        lbGetName.setText(a.getLastName() + " " + a.getFirstName());
                        lbGetExpertise.setText(a.getExpertise());
                        lbGetEmail.setText(a.getEmail());
                        lbGetDateOfBirth.setText(a.getDateOfBirth());
                    }
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        scrollPane.setViewportView(table);

        JLabel lbFullName = new JLabel("Full Name:");
        lbFullName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbFullName.setBounds(730, 150, 175, 18);
        contentPane.add(lbFullName);

        JLabel lbExpertise = new JLabel("Expertise:");
        lbExpertise.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbExpertise.setBounds(730, 220, 175, 18);
        contentPane.add(lbExpertise);

        JLabel lbEmail = new JLabel("Email:");
        lbEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbEmail.setBounds(730, 290, 175, 18);
        contentPane.add(lbEmail);

        JLabel lbDateOfBirth = new JLabel("Date of birth:");
        lbDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbDateOfBirth.setBounds(730, 360, 175, 18);
        contentPane.add(lbDateOfBirth);

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
        lbGetName.setBounds(730, 180, 175, 18);
        contentPane.add(lbGetName);

        lbGetExpertise = new JLabel("");
        lbGetExpertise.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetExpertise.setBounds(730, 250, 175, 18);
        contentPane.add(lbGetExpertise);

        lbGetEmail = new JLabel("");
        lbGetEmail.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetEmail.setBounds(730, 320, 175, 18);
        contentPane.add(lbGetEmail);

        lbGetDateOfBirth = new JLabel("");
        lbGetDateOfBirth.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbGetDateOfBirth.setBounds(730, 390, 175, 18);
        contentPane.add(lbGetDateOfBirth);

        common.customizeTable(table);
        initTable();
        loadDataToTable("");
        customColumnWidth();
    }

    private void customColumnWidth() {
        table.getColumnModel().getColumn(0).setPreferredWidth(40);
        table.getColumnModel().getColumn(0).setMaxWidth(40);
        table.getColumnModel().getColumn(1).setPreferredWidth(70);
        table.getColumnModel().getColumn(1).setMaxWidth(70);
        table.getColumnModel().getColumn(2).setPreferredWidth(120);
        table.getColumnModel().getColumn(2).setMaxWidth(120);
        table.getColumnModel().getColumn(3).setPreferredWidth(70);
        table.getColumnModel().getColumn(3).setMaxWidth(70);
        table.getColumnModel().getColumn(4).setPreferredWidth(130);
        table.getColumnModel().getColumn(4).setMaxWidth(130);
        table.getColumnModel().getColumn(5).setPreferredWidth(100);
        table.getColumnModel().getColumn(5).setMaxWidth(100);
        table.getColumnModel().getColumn(6).setPreferredWidth(170);
        table.getColumnModel().getColumn(6).setMaxWidth(170);
    }

    private void loadDataToTable(String input) {
        try {
            List<AuthorDTO> list = dao.getTableData(input);

            model.setRowCount(0);
            for (AuthorDTO add : list) {
                model.addRow(new Object[]{add.getId(), add.getFirstName(), add.getLastName(), add.getExpertise(),
                        add.getAbout(), add.getEmail(), add.getDateOfBirth()});
            }
            model.fireTableDataChanged();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void initTable() {
        model = new DefaultTableModel();
        model.setColumnIdentifiers(
                new String[]{"Id", "First Name", "Last Name", "Expertise","About", "Email", "Date Of Birth" });
        table.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAdd) {
            dispose();
            new AddAuthorGUI().setVisible(true);
        }

        if (e.getSource() == btnEdit) {
            dispose();
            new EditAuthorGUI().setVisible(true);
        }

        if (e.getSource() == btnDelete) {
            dispose();
            new DeleteAuthorGUI().setVisible(true);
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

