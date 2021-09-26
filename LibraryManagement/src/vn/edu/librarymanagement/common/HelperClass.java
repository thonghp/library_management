package vn.edu.librarymanagement.common;

import javax.swing.*;

public class HelperClass {

    public JLabel setNotice(String notice) {
        JLabel lb = new JLabel("* enter the " + notice);
        return lb;
    }

    public boolean setDisplay(String input, JLabel lb) {
        boolean flag;

        if (input.isEmpty()) {
            lb.setVisible(true);
            flag = true;
        } else if (input.matches("-?\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Invalid input !");
            flag = true;
        } else {
            lb.setVisible(false);
            flag = false;
        }

        return flag;
    }

    public boolean isEmail(String input, JLabel lb) {
        boolean flag = false;

        if (input.isEmpty()) {
            lb.setVisible(true);
            flag = true;
        } else if (!input.matches("\\w+@\\w+\\.\\w+")) {
            JOptionPane.showMessageDialog(null, "Invalid email !");
            flag = true;
        } else {
            lb.setVisible(false);
            flag = false;
        }

        return flag;
    }

    public boolean isNumber(String input, JLabel lb) {
        boolean flag;

        if (input.isEmpty()) {
            lb.setVisible(true);
            flag = true;
        } else if (!input.matches("-?\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Invalid input !");
            flag = true;
        } else {
            lb.setVisible(false);
            flag = false;
        }

        return flag;
    }

    public boolean isSelectedImg(byte[] img) {
        boolean flag = false;
        if (img == null) {
            JOptionPane.showMessageDialog(null, "Request to choose an image");
            flag = true;
        }
        return flag;
    }
}
