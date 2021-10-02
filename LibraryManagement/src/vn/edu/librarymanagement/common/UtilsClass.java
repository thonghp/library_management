package vn.edu.librarymanagement.common;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

public class UtilsClass {

    public static final String JPEG = "jpeg";
    public static final String JPG = "jpg";
    public static final String GIF = "gif";
    public static final String PNG = "png";

    public Image resizeImage(Image originalImage, int targetWidth, int targetHeight) {
        return originalImage.getScaledInstance(targetWidth, targetHeight, Image.SCALE_SMOOTH);
    }

    public byte[] convertImageToByteArray(Image img, String type) throws IOException {
        BufferedImage bi = new BufferedImage(img.getWidth(null),
                img.getHeight(null), BufferedImage.TYPE_INT_RGB);
        Graphics2D g = bi.createGraphics(); // convert img sang graphic
        g.drawImage(img, 0, 0, null);
        g.dispose();

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(bi, type, baos);

        return baos.toByteArray();
    }

    public Image convertByteArrayToImage(byte[] array, String type) throws IOException {
        ByteArrayInputStream bais = new ByteArrayInputStream(array);
        BufferedImage bi = ImageIO.read(bais);

        return bi.getScaledInstance(bi.getWidth(), bi.getHeight(), Image.SCALE_SMOOTH);
    }

    public String getImageExtension(File f) {
        String ext = null;
        String getFileName = f.getName();
        int i = getFileName.lastIndexOf('.');

        if (i > 0 && i < getFileName.length() - 1)
            ext = getFileName.substring(i + 1).toLowerCase();

        return ext;
    }

    public void customizeTable(JTable table) {
        table.setSelectionBackground(Color.lightGray);
        table.setRowHeight(30);
        table.setSelectionForeground(Color.BLACK);
        table.setFont(new Font("Tahoma", Font.BOLD, 14));

        table.getTableHeader().setBackground(new Color(13, 211, 255));
        table.getTableHeader().setForeground(Color.white);
        table.getTableHeader().setFont(new Font("Tahoma", Font.BOLD, 13));
    }

    //    public void setColumnWidth(JTable table, int columnIndex, int width) {
//        TableColumnModel columnModel = table.getColumnModel();
//        columnModel.getColumn(columnIndex).setPreferredWidth(width);
//    }
    public void getFilter() {
        FileFilter filter = new FileFilter() {
            @Override
            public boolean accept(File f) {
                if (f.isDirectory()) {
                    return true;
                }

                String extension = getImageExtension(f);
                if (extension != null) {
                    return extension.equals(GIF) || extension.equals(JPG) ||
                            extension.equals(JPEG) || extension.equals(PNG);
                }
                return false;
            }

            @Override
            public String getDescription() {
                return "Just Images";
            }
        };
    }
}
