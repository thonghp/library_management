package vn.edu.librarymanagement.dal;

import vn.edu.librarymanagement.dto.AuthorDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AuthorDAL implements Dao<AuthorDTO> {

    @Override
    public boolean insert(AuthorDTO authorDTO) throws Exception {
        String query = "INSERT INTO author (first_name,last_name,expertise,about,email,date_of_birth,author_status) " +
                "values(?,?,?,?,?,?,?)";

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            ppstm.setString(1, authorDTO.getFirstName());
            ppstm.setString(2, authorDTO.getLastName());
            ppstm.setString(3, authorDTO.getExpertise());
            ppstm.setString(4, authorDTO.getAbout());
            ppstm.setString(5, authorDTO.getEmail());
            ppstm.setString(6, authorDTO.getDateOfBirth());
            ppstm.setInt(7, 1);

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(AuthorDTO authorDTO) throws Exception {
        String query = "update author set first_name = ?, last_name = ?, expertise = ?, about = ?, email = ?, " +
                "date_of_birth = ?, author_status = 1 " + " where author_id = ?;";

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            ppstm.setString(1, authorDTO.getFirstName());
            ppstm.setString(2, authorDTO.getLastName());
            ppstm.setString(3, authorDTO.getExpertise());
            ppstm.setString(4, authorDTO.getAbout());
            ppstm.setString(5, authorDTO.getEmail());
            ppstm.setString(6, authorDTO.getDateOfBirth());
            ppstm.setInt(7, authorDTO.getId());

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "update author set author_status = 0 " + " where author_id = ?;";

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            ppstm.setInt(1, id);

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public List<AuthorDTO> getTableData(String input) throws Exception {
        String query = (input.equals("")) ? "select * from author where author_status = 1"
                : "select * from author where author_status = 1 and first_name like N'" + input + "%';";

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            try (ResultSet rs = ppstm.executeQuery()) {

                List<AuthorDTO> list = new ArrayList<>();
                while (rs.next()) {
                    AuthorDTO author = setValue(rs);
                    list.add(author);
                }

                return list;
            }
        }
    }

    @Override
    public boolean isUsed(String input) throws Exception {
        String query = "select * from author where email = '" + input + "';";
        boolean flag = false;

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            try (ResultSet rs = ppstm.executeQuery()) {
                if (rs.next())
                    flag = true;
            }
        }

        return flag;
    }

    @Override
    public AuthorDTO findById(String id) throws Exception {
        String query = "select * from author where author_id = ?;";

        try (Connection con = ConnectionDB.getConnectionInMySQL();
             PreparedStatement ppstm = con.prepareStatement(query)) {

            ppstm.setString(1, id);

            try (ResultSet rs = ppstm.executeQuery()) {

                if (rs.next()) {
                    AuthorDTO s = setValue(rs);
                    return s;
                }
            }

            return null;
        }
    }

    @Override
    public AuthorDTO setValue(ResultSet rs) throws SQLException {
        AuthorDTO author = new AuthorDTO();
        author.setId(rs.getInt("author_id"));
        author.setFirstName(rs.getString("first_name"));
        author.setLastName(rs.getString("last_name"));
        author.setExpertise(rs.getString("expertise"));
        author.setAbout(rs.getString("about"));
        author.setEmail(rs.getString("email"));
        author.setDateOfBirth(rs.getString("date_of_birth"));

        return author;
    }
}
