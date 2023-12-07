package HomePage;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import BookingPage.Booking;
import LoginPage.LoginPage;

public class detail extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel nameLabel;
    private JLabel carImageLabel; // Thêm JLabel để hiển thị hình ảnh
    private JLabel descriptionLabel; // Thêm JLabel để hiển thị mô tả
    private JLabel priceLabel;
    private JButton backButton;
    private JButton rentButton;
    private static int userId;

    public detail(int selectedIndex, int userId) {
    	this.userId=userId;
        // Thiết lập JFrame
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        carImageLabel = new JLabel(); // Khởi tạo JLabel cho hình ảnh
        carImageLabel.setBounds(50, 57, 248, 262);
        contentPane.add(carImageLabel);

        // Khởi tạo các thành phần giao diện
        nameLabel = new JLabel("Name:");
        nameLabel.setBounds(341, 50, 300, 20);
        contentPane.add(nameLabel);

        descriptionLabel = new JLabel("Description:");
        descriptionLabel.setBounds(341, 80, 445, 200); // Tăng chiều rộng để hiển thị đầy đủ mô tả
        contentPane.add(descriptionLabel);

        priceLabel = new JLabel("Price:");
        priceLabel.setBounds(351, 299, 435, 20); // Tăng chiều rộng để hiển thị đầy đủ giá
        contentPane.add(priceLabel);

        rentButton = new JButton("Rent Now");
        rentButton.setBackground(Color.GREEN);
        rentButton.setBounds(363, 340, 120, 25);
        contentPane.add(rentButton);

        backButton = new JButton("Go Back");
        backButton.setBackground(Color.ORANGE);
        backButton.setBounds(196, 340, 102, 25);
        contentPane.add(backButton);

        // Xử lý sự kiện nút "Go Back"
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                HomePage homePage = new HomePage(userId);
                homePage.setVisible(true);
            }
        });

        // Xử lý sự kiện nút "Rent Now"
        rentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Booking bookingPage = new Booking(selectedIndex,userId);
                bookingPage.setVisible(true);
                dispose();
            }
        });

        // Hiển thị thông tin chi tiết của phương tiện
        showVehicleDetails(selectedIndex);
    }

    // Hiển thị thông tin chi tiết của phương tiện
    private void showVehicleDetails(int id) {
        try {
            // Kết nối đến cơ sở dữ liệu
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "mysql");
            String query = "SELECT url, name, description, price FROM product WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, id);

            // Thực hiện truy vấn
            ResultSet rs = stmt.executeQuery();

            // Thay đổi phần hiển thị hình ảnh trong showVehicleDetails
            if (rs.next()) {
                String name = rs.getString("name");
                String imageUrl = rs.getString("url");
                String description = rs.getString("description");
                float price = rs.getFloat("price");

                // In đường dẫn URL để kiểm tra
                System.out.println("Image URL: " + imageUrl);

                // Hiển thị thông tin chi tiết
                nameLabel.setText("Name: " + name);

                // hiển thị 
                try {
                    URL url = new URL(imageUrl);
                    Image image = ImageIO.read(url);
                    ImageIcon icon = new ImageIcon(image);
                    System.out.println(icon + "haha");
                    carImageLabel.setIcon(icon);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                descriptionLabel.setText("Description: " + description);
                priceLabel.setText("Price: $" + price);
            }

            // Đóng tài nguyên
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
