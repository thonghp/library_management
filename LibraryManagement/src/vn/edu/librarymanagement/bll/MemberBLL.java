package vn.edu.librarymanagement.bll;

import vn.edu.librarymanagement.dal.MemberDAL;
import vn.edu.librarymanagement.dto.MemberDTO;

import javax.swing.*;

public class MemberBLL {
    MemberDAL dao = new MemberDAL();

    public boolean addMember(MemberDTO dto) throws Exception {
        boolean flag;
        if (dao.insert(dto)) {
            JOptionPane.showMessageDialog(null, "Member added successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Add failed");
            flag = false;
        }
        return flag;
    }

    public boolean editMember(MemberDTO dto) throws Exception {
        boolean flag;
        if (dao.update(dto)) {
            JOptionPane.showMessageDialog(null, "Member updated successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid id");
            flag = false;
        }
        return flag;
    }

    public boolean deleteMember(String id) throws Exception {
        boolean flag;
        if (dao.delete(Integer.parseInt(id))) {
            JOptionPane.showMessageDialog(null, "Member deleted successfully");
            flag = true;
        } else {
            JOptionPane.showMessageDialog(null, "Invalid id");
            flag = false;
        }
        return flag;
    }
}

