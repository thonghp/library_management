package vn.edu.librarymanagement.bll;

import vn.edu.librarymanagement.dal.AuthorDAL;
import vn.edu.librarymanagement.dto.AuthorDTO;

import javax.swing.*;

public class AuthorBLL {
    AuthorDAL dao = new AuthorDAL();

    public boolean addAuthor(AuthorDTO dto) throws Exception {
        boolean flag;
        if (dao.insert(dto)) {
            JOptionPane.showMessageDialog(null, "Author added successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Add failed");
            flag = false;
        }
        return flag;
    }

    public boolean editAuthor(AuthorDTO dto) throws Exception {
        boolean flag;
        if (dao.update(dto)) {
            JOptionPane.showMessageDialog(null, "Author updated successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid id");
            flag = false;
        }
        return flag;
    }

    public boolean deleteAuthor(String id) throws Exception {
        boolean flag;
        if (dao.delete(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(null, "Author deleted successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid id");
            flag = false;
        }
        return flag;
    }
}
