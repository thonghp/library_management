package vn.edu.librarymanagement.gui;

import vn.edu.librarymanagement.gui.author.AuthorGUI;
import vn.edu.librarymanagement.gui.member.MemberGUI;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DashboardGUI extends JFrame implements ActionListener {

    private JPanel contentPane, pnMenu;
    private JLabel lbAmounBook, lbAmountBorrow, lbAmountAvailable, lbBookImg1, lbBookImg2, lbBookImg3, lbBookImg4,
            lbBookImg5, lbAmountMember, lbLogout, lbName;
    private JButton btnMember, btnReturn, btnBorrow, btnAuthor, btnBook, btnIssue, btnAccount;

    protected Border btn1 = BorderFactory.createMatteBorder(1, 1, 1, 1, Color.WHITE);
    protected Border btn2 = BorderFactory.createMatteBorder(1, 1, 1, 1,
            new Color(36, 37, 42));

    public DashboardGUI() {
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(75, 15, 1216, 700);
        setTitle("Home Page");
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        pnMenu = new JPanel();
        pnMenu.setBounds(0, 0, 250, 661);
        contentPane.add(pnMenu);
        pnMenu.setLayout(null);
        pnMenu.setBackground(new Color(36, 37, 42));

        JPanel pnLogo = new JPanel();
        pnLogo.setBorder(new MatteBorder(0, 0, 1, 0, Color.WHITE));
        pnLogo.setBounds(0, 0, 250, 101);
        pnMenu.add(pnLogo);
        pnLogo.setBackground(new Color(1, 50, 67));
        pnLogo.setLayout(null);

        JLabel lbTitle = new JLabel("Library");
        lbTitle.setFont(new Font("Tahoma", Font.BOLD, 36));
        lbTitle.setForeground(Color.WHITE);
        lbTitle.setBounds(110, 40, 130, 38);
        pnLogo.add(lbTitle);

        JLabel lbDashoboardLogo = new JLabel("");
        lbDashoboardLogo.setHorizontalAlignment(SwingConstants.CENTER);
        lbDashoboardLogo.setIcon(new ImageIcon("assets/dashboard-logo.png"));
        lbDashoboardLogo.setBounds(10, 11, 90, 80);
        pnLogo.add(lbDashoboardLogo);

        JLabel lbAuthor = new JLabel("Author");
        lbAuthor.setForeground(Color.WHITE);
        lbAuthor.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbAuthor.setBounds(40, 110, 90, 24);
        pnMenu.add(lbAuthor);

        btnAuthor = new JButton("Manage Author");
        btnAuthor.setForeground(Color.WHITE);
        btnAuthor.setBackground(new Color(36, 37, 42));
        btnAuthor.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAuthor.setBounds(50, 140, 170, 23);
        pnMenu.add(btnAuthor);
        btnAuthor.addActionListener(this);
        btnAuthor.setFocusable(false);

        btnBook = new JButton("Manage Book");
        btnBook.setBackground(new Color(36, 37, 42));
        btnBook.setForeground(Color.WHITE);
        btnBook.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBook.setBounds(50, 200, 170, 23);
        pnMenu.add(btnBook);
        btnBook.addActionListener(this);
        btnBook.setFocusable(false);

        JLabel lbBook = new JLabel("Book");
        lbBook.setForeground(Color.WHITE);
        lbBook.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbBook.setBounds(40, 170, 100, 24);
        pnMenu.add(lbBook);

        JLabel lbMember = new JLabel("Member");
        lbMember.setForeground(Color.WHITE);
        lbMember.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbMember.setBounds(40, 230, 110, 24);
        pnMenu.add(lbMember);

        JLabel lbBorrow = new JLabel("Borrow");
        lbBorrow.setForeground(Color.WHITE);
        lbBorrow.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbBorrow.setBounds(40, 290, 100, 24);
        pnMenu.add(lbBorrow);

        JLabel lbReturn = new JLabel("Return");
        lbReturn.setForeground(Color.WHITE);
        lbReturn.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbReturn.setBounds(40, 350, 134, 24);
        pnMenu.add(lbReturn);

        btnMember = new JButton("Manage Member");
        btnMember.setForeground(Color.WHITE);
        btnMember.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnMember.setBackground(new Color(36, 37, 42));
        btnMember.setBounds(50, 260, 170, 23);
        pnMenu.add(btnMember);
        btnMember.addActionListener(this);
        btnMember.setFocusable(false);

        btnBorrow = new JButton("Manage Borrow");
        btnBorrow.setForeground(Color.WHITE);
        btnBorrow.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnBorrow.setBackground(new Color(36, 37, 42));
        btnBorrow.setBounds(50, 320, 170, 23);
        pnMenu.add(btnBorrow);
        btnBorrow.addActionListener(this);
        btnBorrow.setFocusable(false);

        btnIssue = new JButton("Manage Issue");
        btnIssue.setForeground(Color.WHITE);
        btnIssue.setBackground(new Color(36, 37, 42));
        btnIssue.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnIssue.setBounds(50, 440, 170, 23);
        pnMenu.add(btnIssue);
        btnIssue.addActionListener(this);
        btnIssue.setFocusable(false);

        btnReturn = new JButton("Book Return Manager");
        btnReturn.setBackground(new Color(36, 37, 42));
        btnReturn.setForeground(Color.WHITE);
        btnReturn.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnReturn.setBounds(50, 380, 170, 23);
        pnMenu.add(btnReturn);
        btnReturn.addActionListener(this);
        btnReturn.setFocusable(false);

        JLabel lbAccount = new JLabel("Manage Account");
        lbAccount.setForeground(Color.WHITE);
        lbAccount.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbAccount.setBounds(40, 470, 190, 24);
        pnMenu.add(lbAccount);

        JLabel lbIssue = new JLabel("Issue");
        lbIssue.setForeground(Color.WHITE);
        lbIssue.setFont(new Font("Tahoma", Font.BOLD, 22));
        lbIssue.setBounds(40, 410, 134, 24);
        pnMenu.add(lbIssue);

        btnAccount = new JButton("Manage Account");
        btnAccount.setForeground(Color.WHITE);
        btnAccount.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnAccount.setBackground(new Color(36, 37, 42));
        btnAccount.setBounds(50, 500, 170, 23);
        pnMenu.add(btnAccount);
        btnAccount.setFocusable(false);
        btnAccount.addActionListener(this);

        JPanel pnBook = new JPanel();
        pnBook.setBackground(new Color(255, 194, 14));
        pnBook.setBounds(270, 50, 205, 150);
        contentPane.add(pnBook);
        pnBook.setLayout(null);

        JPanel pnHeadingBook = new JPanel();
        pnHeadingBook.setBackground(new Color(255, 150, 14));
        pnHeadingBook.setBounds(0, 0, 205, 60);
        pnBook.add(pnHeadingBook);
        pnHeadingBook.setLayout(null);

        JLabel lbHeadingBook = new JLabel("Books");
        lbHeadingBook.setForeground(Color.WHITE);
        lbHeadingBook.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbHeadingBook.setBounds(10, 11, 80, 38);
        pnHeadingBook.add(lbHeadingBook);

        lbAmounBook = new JLabel("05555");
        lbAmounBook.setHorizontalAlignment(SwingConstants.CENTER);
        lbAmounBook.setForeground(Color.WHITE);
        lbAmounBook.setFont(new Font("Tahoma", Font.BOLD, 36));
        lbAmounBook.setBounds(42, 80, 120, 38);
        pnBook.add(lbAmounBook);

        JPanel pnBorrow = new JPanel();
        pnBorrow.setBackground(new Color(246, 90, 91));
        pnBorrow.setBounds(500, 50, 205, 150);
        contentPane.add(pnBorrow);
        pnBorrow.setLayout(null);

        JPanel pnHeadingBorrow = new JPanel();
        pnHeadingBorrow.setBackground(new Color(246, 60, 91));
        pnHeadingBorrow.setBounds(0, 0, 205, 60);
        pnBorrow.add(pnHeadingBorrow);
        pnHeadingBorrow.setLayout(null);

        JLabel lbHeadingBorrow = new JLabel("Borrowed");
        lbHeadingBorrow.setForeground(Color.WHITE);
        lbHeadingBorrow.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbHeadingBorrow.setBounds(10, 11, 120, 38);
        pnHeadingBorrow.add(lbHeadingBorrow);

        lbAmountBorrow = new JLabel("05555");
        lbAmountBorrow.setHorizontalAlignment(SwingConstants.CENTER);
        lbAmountBorrow.setForeground(Color.WHITE);
        lbAmountBorrow.setFont(new Font("Tahoma", Font.BOLD, 36));
        lbAmountBorrow.setBounds(42, 80, 120, 38);
        pnBorrow.add(lbAmountBorrow);

        JPanel pnAvailable = new JPanel();
        pnAvailable.setBackground(new Color(186, 85, 211));
        pnAvailable.setBounds(730, 50, 205, 150);
        contentPane.add(pnAvailable);
        pnAvailable.setLayout(null);

        JPanel pnHeadingAvailable = new JPanel();
        pnHeadingAvailable.setBackground(new Color(148, 0, 211));
        pnHeadingAvailable.setBounds(0, 0, 205, 60);
        pnAvailable.add(pnHeadingAvailable);
        pnHeadingAvailable.setLayout(null);

        JLabel lbHeadingAvailable = new JLabel("Available");
        lbHeadingAvailable.setForeground(Color.WHITE);
        lbHeadingAvailable.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbHeadingAvailable.setBounds(10, 11, 115, 38);
        pnHeadingAvailable.add(lbHeadingAvailable);

        lbAmountAvailable = new JLabel("05555");
        lbAmountAvailable.setHorizontalAlignment(SwingConstants.CENTER);
        lbAmountAvailable.setForeground(Color.WHITE);
        lbAmountAvailable.setFont(new Font("Tahoma", Font.BOLD, 36));
        lbAmountAvailable.setBounds(42, 80, 120, 38);
        pnAvailable.add(lbAmountAvailable);

        JPanel pnMessageBoard = new JPanel();
        pnMessageBoard.setBackground(new Color(72, 169, 197));
        pnMessageBoard.setBounds(270, 250, 900, 400);
        contentPane.add(pnMessageBoard);
        pnMessageBoard.setLayout(null);

        JPanel pnHeadingMessageBoard = new JPanel();
        pnHeadingMessageBoard.setBackground(new Color(0, 142, 170));
        pnHeadingMessageBoard.setBounds(0, 0, 900, 60);
        pnMessageBoard.add(pnHeadingMessageBoard);
        pnHeadingMessageBoard.setLayout(null);

        JLabel lbHeadingMassageBoard = new JLabel("Latest Book Added");
        lbHeadingMassageBoard.setForeground(Color.WHITE);
        lbHeadingMassageBoard.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbHeadingMassageBoard.setBounds(10, 11, 230, 38);
        pnHeadingMessageBoard.add(lbHeadingMassageBoard);

        lbBookImg1 = new JLabel("");
        lbBookImg1.setHorizontalAlignment(SwingConstants.CENTER);
        lbBookImg1.setIcon(new ImageIcon("assets/"));
        lbBookImg1.setBounds(25, 120, 150, 200);
        pnMessageBoard.add(lbBookImg1);

        lbBookImg2 = new JLabel("");
        lbBookImg2.setIcon(new ImageIcon("assets/"));
        lbBookImg2.setHorizontalAlignment(SwingConstants.CENTER);
        lbBookImg2.setBounds(200, 120, 150, 200);
        pnMessageBoard.add(lbBookImg2);

        lbBookImg3 = new JLabel("");
        lbBookImg3.setIcon(new ImageIcon("assets/"));
        lbBookImg3.setHorizontalAlignment(SwingConstants.CENTER);
        lbBookImg3.setBounds(375, 120, 150, 200);
        pnMessageBoard.add(lbBookImg3);

        lbBookImg4 = new JLabel("");
        lbBookImg4.setHorizontalAlignment(SwingConstants.CENTER);
        lbBookImg4.setIcon(new ImageIcon("assets/"));
        lbBookImg4.setBounds(550, 120, 150, 200);
        pnMessageBoard.add(lbBookImg4);

        lbBookImg5 = new JLabel("");
        lbBookImg5.setIcon(new ImageIcon("assets/"));
        lbBookImg5.setHorizontalAlignment(SwingConstants.CENTER);
        lbBookImg5.setBounds(725, 120, 150, 200);
        pnMessageBoard.add(lbBookImg5);

        JPanel pnMember = new JPanel();
        pnMember.setLayout(null);
        pnMember.setBackground(new Color(52, 191, 73));
        pnMember.setBounds(960, 50, 205, 150);
        contentPane.add(pnMember);

        JPanel pnHeadingMember = new JPanel();
        pnHeadingMember.setLayout(null);
        pnHeadingMember.setBackground(new Color(39, 155, 55));
        pnHeadingMember.setBounds(0, 0, 205, 60);
        pnMember.add(pnHeadingMember);

        JLabel lbHeadingMember = new JLabel("Members");
        lbHeadingMember.setForeground(Color.WHITE);
        lbHeadingMember.setFont(new Font("Tahoma", Font.BOLD, 24));
        lbHeadingMember.setBounds(10, 11, 115, 38);
        pnHeadingMember.add(lbHeadingMember);

        lbAmountMember = new JLabel("05555");
        lbAmountMember.setHorizontalAlignment(SwingConstants.CENTER);
        lbAmountMember.setForeground(Color.WHITE);
        lbAmountMember.setFont(new Font("Tahoma", Font.BOLD, 36));
        lbAmountMember.setBounds(42, 80, 120, 38);
        pnMember.add(lbAmountMember);

        lbLogout = new JLabel("");
        lbLogout.setIcon(new ImageIcon("assets/logout.png"));
        lbLogout.setBounds(1144, 11, 32, 32);
        contentPane.add(lbLogout);
        lbLogout.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                dispose();
                new LoginGUI().setVisible(true);
            }
        });

        lbName = new JLabel("Xin chào, Thông");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lbName.setBounds(1000, 11, 120, 24);
        contentPane.add(lbName);

        // add border to the buttons
//		addBorders();

        buttonHoverEffect();
    }

    private void buttonHoverEffect() {
        // get all component in panel menu
        Component[] components = pnMenu.getComponents();
        for (Component check : components) {
            if (check instanceof JButton) {
                JButton button = (JButton) check;
                button.addMouseListener(new MouseAdapter() {

                    // chuột đưa qua ô nào thì ô đó sẽ sáng lên
                    @Override
                    public void mouseEntered(MouseEvent e) {
                        button.setBorder(btn1);
                    }

                    // qua ô nào thì ô đó sáng ko qua thì ko sáng
                    @Override
                    public void mouseExited(MouseEvent e) {
                        button.setBorder(btn2);
                    }
                });
            }
        }
    }

//	private void addBorders() {
//		Component[] components = pnMenu.getComponents();
//		for (Component check : components) {
//			if (check instanceof JButton) {
//				JButton button = (JButton) check;
//				button.setBorder(btn1);
//			}
//		}
//	}

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == btnAuthor) {
            dispose();
            new AuthorGUI().setVisible(true);
        }

//        if (e.getSource() == btnBook) {
//            dispose();
//            new BookGUI().setVisible(true);
//        }

        if (e.getSource() == btnMember) {
            dispose();
            new MemberGUI().setVisible(true);
        }

//        if (e.getSource() == btnAuthorList) {
//            dispose();
//            new AuthorListGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnAddMember) {
//            dispose();
//            new AddMemberGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnEditMember) {
//            dispose();
//            new EditMemberGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnDeleteMember) {
//            dispose();
//            new DeleteMemberGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnMemberList) {
//            dispose();
//            new MemberList().setVisible(true);
//        }
//
//        if (e.getSource() == btnAddBook) {
//            dispose();
//            new AddBookGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnEditBook) {
//            dispose();
//            new EditBookGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnDeleteBook) {
//            dispose();
//            new DeleteBookGUI().setVisible(true);
//        }
//
//        if (e.getSource() == btnBookList) {
//            dispose();
//            new BookListGUI().setVisible(true);
//        }
    }
}
