package vn.edu.librarymanagement.dal;

import vn.edu.librarymanagement.dto.MemberDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MemberDAL implements Dao<MemberDTO> {

    @Override
    public boolean insert(MemberDTO memberDTO) throws Exception {
        String query = "insert into library_member(first_name,last_name,email,join_date,gender,picture,member_status) "
                + "values(?,?,?,?,?,?,?)";

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query)
        ) {

            ppstm.setString(1, memberDTO.getFirstName());
            ppstm.setString(2, memberDTO.getLastName());
            ppstm.setString(3, memberDTO.getEmail());
            ppstm.setString(4, memberDTO.getJoinDate());
            ppstm.setInt(5, (memberDTO.getGender().equals("male") ? 0 : 1));
            ppstm.setBytes(6, memberDTO.getPicture());
            ppstm.setInt(7, 1);

            // sử dụng nếu chèn ảnh vào trong sql server
//            if (member.getPicture() != null) {
//                Blob image = new SerialBlob(member.getPicture());
//                ppstm.setBlob(6, image);
//            } else {
//                Blob image = null;
//                ppstm.setBlob(6, image);
//            }

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(MemberDTO memberDTO) throws Exception {
        String query = "update library_member set first_name = ?, last_name = ?, email = ?, join_date = ?, gender = ?, "
                + "picture = ?, member_status = 1 " + " where member_id = ?";

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query);
        ) {

            ppstm.setString(1, memberDTO.getFirstName());
            ppstm.setString(2, memberDTO.getLastName());
            ppstm.setString(3, memberDTO.getEmail());
            ppstm.setString(4, memberDTO.getJoinDate());
            ppstm.setInt(5, (memberDTO.getGender().equals("male") ? 0 : 1));
            ppstm.setBytes(6, memberDTO.getPicture());

//            if (member.getPicture() != null) {
//                Blob image = new SerialBlob(member.getPicture());
//                ppstm.setBlob(6, image);
//            } else {
//                Blob image = null;
//                ppstm.setBlob(6, image);
//            }

            ppstm.setInt(7, memberDTO.getId());

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "update library_member set member_status = 0 " + " where member_id = ?";

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query);
        ) {

            ppstm.setInt(1, id);

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public List<MemberDTO> getTableData(String input) throws Exception {
        String query = (input.equals("")) ? "select * from library_member where member_status = 1" :
                "select * from library_member where member_status = 1 and first_name like N'" + input + "%'";

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query);
        ) {

            try (ResultSet rs = ppstm.executeQuery()) {

                List<MemberDTO> list = new ArrayList<>();
                while (rs.next()) {
                    MemberDTO member = setValue(rs);
                    list.add(member);
                }

                return list;
            }
        }
    }

    @Override
    public boolean isUsed(String input) throws Exception {
        String query = "select * from library_member where email = '" + input + "'";
        boolean flag = false;

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query);
        ) {

            try (ResultSet rs = ppstm.executeQuery()) {
                if (rs.next())
                    flag = true;
            }
        }

        return flag;
    }

    @Override
    public MemberDTO findById(String id) throws Exception {
        String query = "select * from library_member where member_id = ?";

        try (
                Connection con = ConnectionDB.getConnectionInMySQL();
                PreparedStatement ppstm = con.prepareStatement(query);
        ) {

            ppstm.setString(1, id);

            try (ResultSet rs = ppstm.executeQuery()) {

                if (rs.next()) {
                    return setValue(rs);
                }
            }

            return null;
        }
    }

    @Override
    public MemberDTO setValue(ResultSet rs) throws SQLException {
        MemberDTO member = new MemberDTO();
        member.setId(rs.getInt("member_id"));
        member.setFirstName(rs.getString("first_name"));
        member.setLastName(rs.getString("last_name"));
        member.setEmail(rs.getString("email"));
        member.setJoinDate(rs.getString("join_date"));
        member.setGender((rs.getInt("gender") == 0) ? "male" : "female");
//        Blob blob = rs.getBlob("picture");
//        if (blob != null)
//            member.setPicture(blob.getBytes(1, (int) blob.length()));
        member.setPicture(rs.getBytes("picture"));

        return member;
    }
}
