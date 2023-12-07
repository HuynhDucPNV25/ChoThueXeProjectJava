package user;

import javax.swing.*;

import HomePage.HomePage;
import LoginPage.LoginPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URL;
import java.sql.*;

public class UserProfile extends JFrame {

    private JLabel lblId, lblName, lblUsername, lblRole, lblPhone, lblAddress, lblGmail, lblIdPesonnal, lblImage;
   
    public UserProfile(int id) {
        // Thiết lập cấu hình JFrame
        setTitle("User Profile");
        setSize(532, 550); // Tăng chiều cao lên 550 để tạo không gian cho JPanel
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        getContentPane().setLayout(new BorderLayout()); // Sử dụng BorderLayout

        // Tạo JPanel để chứa JLabel và đặt kích thước cho nó
        JPanel topPanel = new JPanel();
        topPanel.setPreferredSize(new Dimension(getWidth(), 100)); // Đặt kích thước 50px chiều cao
        topPanel.setBackground(Color.lightGray); // Đặt màu nền

        JLabel lblTitle = new JLabel("User Profile");
        lblTitle.setHorizontalAlignment(SwingConstants.CENTER); // Căn giữa văn bản
        lblTitle.setFont(new Font("Arial", Font.BOLD, 20)); // Đặt kiểu font và kích thước

        topPanel.add(lblTitle); // Thêm JLabel vào JPanel

        getContentPane().add(topPanel, BorderLayout.NORTH); // Thêm JPanel vào phần đầu của JFrame

        // Thông tin kết nối database
        String url = "jdbc:mysql://localhost:3306/user";
        String username = "root";
        String password = "mysql";

        // Lấy thông tin profile từ cơ sở dữ liệu
        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Tạo câu truy vấn SELECT để lấy thông tin profile từ bảng useraccount
            String query = "SELECT * FROM useraccount WHERE idnew_table = ?";
            PreparedStatement statement = connection.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                // Lấy thông tin từ ResultSet
                String name = resultSet.getString("name");
                String username1 = resultSet.getString("useraccount");
                String role = resultSet.getString("role");
                String phone = resultSet.getString("phone");
                String address = resultSet.getString("address");
                String gmail = resultSet.getString("gmail");
                String idpesonnal = resultSet.getString("idpesonnal");
                String imgUrl = resultSet.getString("img");

                // Tạo các JLabel để hiển thị thông tin profile
                lblId = new JLabel("ID: " + id);
                lblName = new JLabel("Name: " + name);
                lblUsername = new JLabel("Username: " + username1);
                lblRole = new JLabel("Role: " + role);
                lblPhone = new JLabel("Phone: " + phone);
                lblAddress = new JLabel("Address: " + address);
                lblGmail = new JLabel("Gmail: " + gmail);
                lblIdPesonnal = new JLabel("ID Pesonnal: " + idpesonnal);

                // Tạo ImageIcon từ URL hình ảnh và điều chỉnh kích thước
                URL url1 = new URL(imgUrl);
                ImageIcon imageIcon = new ImageIcon(url1);
                Image image = imageIcon.getImage();
                int desiredWidth = 200; // Chiều rộng mong muốn
                int desiredHeight = 200; // Chiều cao mong muốn
                Image scaledImage = image.getScaledInstance(desiredWidth, desiredHeight, Image.SCALE_SMOOTH);
                ImageIcon scaledImageIcon = new ImageIcon(scaledImage);
                lblImage = new JLabel(scaledImageIcon);

                // Tạo JPanel để chứa các JLabel và đặt Layout cho nó
                JPanel contentPanel = new JPanel();
                contentPanel.add(lblImage); // Thêm JLabel chứa hình ảnh vào JPanel
                contentPanel.setLayout(new GridLayout(10, 2));
                contentPanel.add(lblId);
                contentPanel.add(lblName);
                contentPanel.add(lblUsername);
                contentPanel.add(lblRole);
                contentPanel.add(lblPhone);
                contentPanel.add(lblAddress);
                contentPanel.add(lblGmail);
                contentPanel.add(lblIdPesonnal);
                
                getContentPane().add(contentPanel, BorderLayout.CENTER); // Thêm JPanel vào phần trung tâm của JFrame
             // Tạo nút Back
                JButton btnBack = new JButton("Back");
                btnBack.addActionListener(new ActionListener() {
                	public void actionPerformed(ActionEvent e) {
                        // Đóng cửa sổ hiện tại
                		dispose();
                		HomePage homePage = new HomePage(id);
                        homePage.setVisible(true);  
                    }
                });
                contentPanel.add(btnBack);
            }
        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
        

        setVisible(true); // Hiển thị JFrame
    }
}