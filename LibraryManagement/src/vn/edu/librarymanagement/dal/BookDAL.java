package vn.edu.librarymanagement.dal;

import vn.edu.librarymanagement.dto.AuthorDTO;
import vn.edu.librarymanagement.dto.BookDTO;

import javax.sql.rowset.serial.SerialBlob;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BookDAL implements Dao<BookDTO> {
    AuthorDAL dao = new AuthorDAL();

    @Override
    public boolean insert(BookDTO bookDTO) throws Exception {
        String query = "insert into book(isbn,booktitle,authorid,genresid,quantity,publisher,price,datereceived,description,"
                + "picture,status) values(?,?,?,?,?,?,?,?,?,?,?)";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            ppstm.setString(1, bookDTO.getIsbn());
            ppstm.setString(2, bookDTO.getBookTitle());
            ppstm.setInt(3, bookDTO.getAuthorId());
            ppstm.setInt(4, bookDTO.getGenresId());
            ppstm.setInt(5, bookDTO.getQuantity());
            ppstm.setString(6, bookDTO.getPublisher());
            ppstm.setInt(7, bookDTO.getPrice());
            ppstm.setString(8, bookDTO.getDateReceived());
            ppstm.setString(9, bookDTO.getDescription());
            ppstm.setInt(11, 1);

            if (bookDTO.getPicture() != null) {
                Blob image = new SerialBlob(bookDTO.getPicture());
                ppstm.setBlob(10, image);
            } else {
                Blob image = null;
                ppstm.setBlob(10, image);
            }

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean update(BookDTO bookDTO) throws Exception {
        String query = "update book set isbn = ?, booktitle = ?, authorid = ?, genresid = ?, quantity = ?, "
                + "publisher = ?, price = ?, datereceived = ?, description = ?, picture = ?, status = '1' "
                + " where id = ?";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            ppstm.setString(1, bookDTO.getIsbn());
            ppstm.setString(2, bookDTO.getBookTitle());
            ppstm.setInt(3, bookDTO.getAuthorId());
            ppstm.setInt(4, bookDTO.getGenresId());
            ppstm.setInt(5, bookDTO.getQuantity());
            ppstm.setString(6, bookDTO.getPublisher());
            ppstm.setInt(7, bookDTO.getPrice());
            ppstm.setString(8, bookDTO.getDateReceived());
            ppstm.setString(9, bookDTO.getDescription());

            if (bookDTO.getPicture() != null) {
                Blob image = new SerialBlob(bookDTO.getPicture());
                ppstm.setBlob(10, image);
            } else {
                Blob image = null;
                ppstm.setBlob(10, image);
            }

            ppstm.setInt(11, bookDTO.getId());

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public boolean delete(int id) throws Exception {
        String query = "update book set status = '0' " + " where id = ?";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            ppstm.setInt(1, id);

            return ppstm.executeUpdate() > 0;
        }
    }

    @Override
    public List<BookDTO> getTableData(String input) throws Exception {
        String query = (input.equals("")) ? "select * from book where status = 1"
                : "select * from book where status = 1 and booktitle like N'" + input + "%'";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            try (ResultSet rs = ppstm.executeQuery()) {

                List<BookDTO> list = new ArrayList<>();
                while (rs.next()) {
                    BookDTO book = setValue(rs);
                    list.add(book);
                }

                return list;
            }
        }
    }

    @Override
    public boolean isUsed(String input) throws Exception {
        String query = "select * from book where isbn = '" + input + "'";
        boolean flag = false;

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            try (ResultSet rs = ppstm.executeQuery()) {

                if (rs.next()) {
                    flag = true;
                }
            }
        }

        return flag;
    }

    @Override
    public BookDTO findById(String id) throws Exception {
        String query = "select * from book where id = ?";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            ppstm.setString(1, id);

            try (ResultSet rs = ppstm.executeQuery()) {

                if (rs.next()) {
                    BookDTO s = setValue(rs);
                    return s;
                }
            }

            return null;
        }
    }

    @Override
    public BookDTO setValue(ResultSet rs) throws SQLException {
        BookDTO book = new BookDTO();
        book.setId(rs.getInt("id"));
        book.setIsbn(rs.getString("isbn"));
        book.setBookTitle(rs.getString("booktitle"));
        book.setAuthorId(rs.getInt("authorid"));
        book.setGenresId(rs.getInt("genresid"));
        book.setQuantity(rs.getInt("quantity"));
        book.setPublisher(rs.getString("publisher"));
        book.setPrice(rs.getInt("price"));
        book.setDateReceived(rs.getString("datereceived"));
        book.setDescription(rs.getString("description"));
        Blob blob = rs.getBlob("picture");
        if (blob != null)
            book.setPicture(blob.getBytes(1, (int) blob.length()));

        return book;
    }

    public String getKeyAuthorToDisplay(int value) throws Exception {
        String display = "";
        HashMap<String, Integer> author = getAuthorValue();
        for (Map.Entry<String, Integer> add : author.entrySet()) {
            if (add.getValue() == value) {
                display = add.getKey();
            }
        }
        return display;
    }

    public HashMap<String, Integer> getAuthorValue() throws Exception {
        HashMap<String, Integer> map = new HashMap<>();
        String query = "select * from author where status = 1";

        try (Connection con = ConnectionDB.getConnectionInSQLServer(); PreparedStatement ppstm = con.prepareStatement(query);) {

            try (ResultSet rs = ppstm.executeQuery()) {

                while (rs.next()) {
                    AuthorDTO author = dao.setValue(rs);
                    String fullName = author.getLastName() + " " + author.getFirstName();
                    map.put(fullName, author.getId());
                }

                return map;
            }
        }
    }
}
