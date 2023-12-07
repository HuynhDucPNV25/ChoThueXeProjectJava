package BookingPage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.PanelUI;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;

import HomePage.HomePage;
import LoginPage.LoginPage;
import LoginPage.RegisterPage;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import javax.swing.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

public class Booking extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField rentDateTextField;
    private JTextField returnDateTextField;
    private JTextField licenseNumberTextField;
    private JTextField priceTextField;
    private JTextField emailTextField;

    
    private int userId;
    public Booking() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Booking Page");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.setBackground(Color.PINK);
        setContentPane(contentPane);

        // JLabel chào mừng
        JLabel lblHello = new JLabel("Welcome to Our Booking Page!");
        lblHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblHello.setBounds(200, 20, 400, 30);
        lblHello.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblHello);
        
        // form 
        // JLabel name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setBounds(60, 100, 100, 30);
        contentPane.add(nameLabel);
        
        // ô input name
        nameTextField = new JTextField();
        nameTextField.setBounds(220, 100, 200, 20);
        contentPane.add(nameTextField);

        // JLabel rent date
        JLabel rentDateLabel = new JLabel("Rent Date:");
        rentDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rentDateLabel.setBounds(60, 150, 100, 30);
contentPane.add(rentDateLabel);
        
        // ô input rent date
        rentDateTextField = new JTextField();
        rentDateTextField.setBounds(220, 150, 200, 20);
        contentPane.add(rentDateTextField);
       // add ảnh vào button
        try {
            // URL của hình ảnh trực tuyến
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Google_Calendar_icon_%282020%29.svg/768px-Google_Calendar_icon_%282020%29.svg.png");

            // Tải hình ảnh từ URL
            Image image = javax.imageio.ImageIO.read(imageUrl);

            // Kích thước mới cho hình ảnh
            int newWidth = 30;
            int newHeight = 30;

            // Thay đổi kích thước của hình ảnh
            Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            
            // Tạo một ImageIcon từ hình ảnh đã tải về
            ImageIcon imageIcon = new ImageIcon(resizedImage);
                      
            // Tạo JButton với hình ảnh
            JButton calendarButton = new JButton(imageIcon);
            calendarButton.setBounds(440, 150, 30, 30);
            contentPane.add(calendarButton);
            
            calendarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog calendarDialog = new JDialog();
                    calendarDialog.setTitle("Calendar");
                    calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    calendarDialog.setSize(300, 300);
                    calendarDialog.setLocationRelativeTo(null);

                    JCalendar calendar = new JCalendar();
                    calendarDialog.getContentPane().add(calendar);

                    calendarDialog.setVisible(true);

                    calendarDialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            Date selectedDate = calendar.getDate();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(selectedDate);

                            rentDateTextField.setText(formattedDate); // Gán giá trị cho rentDateTextField
                        }
                    });
                }
            });
            
//            // JLabel return date
            JLabel returnDateLabel = new JLabel("Return Date:");
            returnDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            returnDateLabel.setBounds(60, 200, 100, 30);
            contentPane.add(returnDateLabel);
            
            // ô input return date
            returnDateTextField = new JTextField();
            returnDateTextField.setBounds(220, 200, 200, 20);
            contentPane.add(returnDateTextField);
            
            JButton calendarButton2 = new JButton(imageIcon);
            calendarButton2.setBounds(440, 200, 30, 30);
contentPane.add(calendarButton2);
            
            calendarButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog calendarDialog = new JDialog();
                    calendarDialog.setTitle("Calendar");
                    calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    calendarDialog.setSize(300, 300);
                    calendarDialog.setLocationRelativeTo(null);

                    JCalendar calendar = new JCalendar();
                    calendarDialog.getContentPane().add(calendar);

                    calendarDialog.setVisible(true);

                    calendarDialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            Date selectedDate = calendar.getDate();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(selectedDate);

                            returnDateTextField.setText(formattedDate); // Gán giá trị cho rentDateTextField
                        }
                    });
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JLabel license number
        JLabel licenseNumberLabel = new JLabel("License Number:");
        licenseNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        licenseNumberLabel.setBounds(60, 250, 120, 30);
        contentPane.add(licenseNumberLabel);
        
        // ô input license number
        licenseNumberTextField = new JTextField();
        licenseNumberTextField.setBounds(220, 250, 200, 20);
        contentPane.add(licenseNumberTextField);

        // JLabel email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emailLabel.setBounds(60, 300, 100, 30);
        contentPane.add(emailLabel);
        
        // ô input email
        emailTextField = new JTextField();
        emailTextField.setBounds(220, 300, 200, 20);
        contentPane.add(emailTextField);
        
      //String sql = "SELECT price FROM booking WHERE id = 1";
        
      // JLabel price
      JLabel priceLabel = new JLabel("Price:");
      priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
      priceLabel.setBounds(60, 350, 100, 30);
      contentPane.add(priceLabel);
      
      // ô input price
      priceTextField = new JTextField();
      priceTextField.setBounds(220, 350, 200, 20);
      contentPane.add(priceTextField);
        
     // Tạo một JButton mới
        JButton button = new JButton("Booking");
        // Thêm JButton vào JFrame
        contentPane.add(button);
        // thuộc tính
        button.setBackground(Color.RED); // Đặt màu nền là màu đỏ
button.setForeground(Color.WHITE); // Đặt màu chữ là màu trắng
        button.setSize(100, 30); // Đặt kích thước
        button.setLocation(220, 400);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // Lấy thông tin từ các ô input
                String name = nameTextField.getText();
                String rentDate = rentDateTextField.getText();
                String returnDate = returnDateTextField.getText();
                String licenseNumber = licenseNumberTextField.getText();
//              String price = priceTextField.getText();
                String email = emailTextField.getText();
                String CCCD = emailTextField.getText();
                
                
                
                // kết nối đến cơ sở dữ liệu
                String url = "jdbc:mysql://localhost:3306/user";
                String username = "root";
                String password = "mysql";

                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
//                    System.out.println(connection);
                    String sql = "INSERT INTO booking ( nameuser, rent_date, return_date, license_number, price, email, CCCD) VALUES (?, ?, ?, ?, ?, ?, ?)";
//                    
                    
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setString(2, rentDate);
                    statement.setString(3, returnDate);
                    statement.setString(4, licenseNumber);
                    statement.setString(5, "null");
                    statement.setString(6, email);
                    statement.setString(7, CCCD);
                    
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println(statement);
                    }
                    
                    payment payment = new payment(userId);
                    payment.setVisible(true);
                    dispose(); // Đóng trang đăng nhập sau khi chuyển đến trang đăng ký
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
    
            }
            
        });
        
        
    }
    // tạo class mới.
    public Booking(int selectcar, int userId) {
    	this.userId=userId;
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
        setTitle("Booking Page");

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        setContentPane(contentPane);

        // JLabel chào mừng
        JLabel lblHello = new JLabel("Welcome to Our Booking Page!");
        lblHello.setFont(new Font("Tahoma", Font.PLAIN, 20));
lblHello.setBounds(200, 20, 400, 30);
        lblHello.setHorizontalAlignment(SwingConstants.CENTER);
        contentPane.add(lblHello);
        
        // form 
        // JLabel name
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        nameLabel.setBounds(60, 100, 100, 30);
        contentPane.add(nameLabel);
        
        // ô input name
        nameTextField = new JTextField();
        nameTextField.setBounds(220, 100, 200, 20);
        contentPane.add(nameTextField);

        // JLabel rent date
        JLabel rentDateLabel = new JLabel("Rent Date:");
        rentDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        rentDateLabel.setBounds(60, 150, 100, 30);
        contentPane.add(rentDateLabel);
        
        // ô input rent date
        rentDateTextField = new JTextField();
        rentDateTextField.setBounds(220, 150, 200, 20);
        contentPane.add(rentDateTextField);
       // add ảnh vào button
        try {
            // URL của hình ảnh trực tuyến
            URL imageUrl = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/a/a5/Google_Calendar_icon_%282020%29.svg/768px-Google_Calendar_icon_%282020%29.svg.png");

            // Tải hình ảnh từ URL
            Image image = javax.imageio.ImageIO.read(imageUrl);

            // Kích thước mới cho hình ảnh
            int newWidth = 30;
            int newHeight = 30;

            // Thay đổi kích thước của hình ảnh
            Image resizedImage = image.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            
            // Tạo một ImageIcon từ hình ảnh đã tải về
            ImageIcon imageIcon = new ImageIcon(resizedImage);
                      
            // Tạo JButton với hình ảnh
            JButton calendarButton = new JButton(imageIcon);
            calendarButton.setBounds(440, 150, 30, 30);
            contentPane.add(calendarButton);
            
            calendarButton.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog calendarDialog = new JDialog();
                    calendarDialog.setTitle("Calendar");
                    calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    calendarDialog.setSize(300, 300);
                    calendarDialog.setLocationRelativeTo(null);

                    JCalendar calendar = new JCalendar();
                    calendarDialog.getContentPane().add(calendar);

                    calendarDialog.setVisible(true);
                    calendarDialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            Date selectedDate = calendar.getDate();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(selectedDate);
rentDateTextField.setText(formattedDate); // Gán giá trị cho rentDateTextField
                        }
                    });
                }
            });
            
//            // JLabel return date
            JLabel returnDateLabel = new JLabel("Return Date:");
            returnDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
            returnDateLabel.setBounds(60, 200, 100, 30);
            contentPane.add(returnDateLabel);
            
            // ô input return date
            returnDateTextField = new JTextField();
            returnDateTextField.setBounds(220, 200, 200, 20);
            contentPane.add(returnDateTextField);
            
            JButton calendarButton2 = new JButton(imageIcon);
            calendarButton2.setBounds(440, 200, 30, 30);
            contentPane.add(calendarButton2);
            
            calendarButton2.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JDialog calendarDialog = new JDialog();
                    calendarDialog.setTitle("Calendar");
                    calendarDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                    calendarDialog.setSize(300, 300);
                    calendarDialog.setLocationRelativeTo(null);

                    JCalendar calendar = new JCalendar();
                    calendarDialog.getContentPane().add(calendar);

                    calendarDialog.setVisible(true);

                    calendarDialog.addWindowListener(new WindowAdapter() {
                        @Override
                        public void windowClosed(WindowEvent e) {
                            Date selectedDate = calendar.getDate();

                            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            String formattedDate = dateFormat.format(selectedDate);

                            returnDateTextField.setText(formattedDate); // Gán giá trị cho rentDateTextField
                        }
                    });
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        // JLabel license number
        JLabel licenseNumberLabel = new JLabel("License Number:");
        licenseNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        licenseNumberLabel.setBounds(60, 250, 120, 30);
        contentPane.add(licenseNumberLabel);
        
        // ô input license number
        licenseNumberTextField = new JTextField();
        licenseNumberTextField.setBounds(220, 250, 200, 20);
        contentPane.add(licenseNumberTextField);

        // JLabel email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emailLabel.setBounds(60, 300, 100, 30);
        contentPane.add(emailLabel);
        
        // ô input email
        emailTextField = new JTextField();
emailTextField.setBounds(220, 300, 200, 20);
        contentPane.add(emailTextField);
  
      // JLabel price
      JLabel priceLabel = new JLabel("Price:");
      priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
      priceLabel.setBounds(60, 350, 100, 30);
      contentPane.add(priceLabel);
      
      // ô input price
      priceTextField = new JTextField();
      priceTextField.setBounds(220, 350, 200, 20);
      contentPane.add(priceTextField);
        
     // Tạo một JButton mới
        JButton button = new JButton("Booking");
        // Thêm JButton vào JFrame
        contentPane.add(button);
        // thuộc tính
        button.setBackground(Color.RED); // Đặt màu nền là màu đỏ
        button.setForeground(Color.WHITE); // Đặt màu chữ là màu trắng
        button.setSize(100, 30); // Đặt kích thước
        button.setLocation(220, 400);

        contentPane.setBackground(Color.PINK);
        
        JButton backButton = new JButton("Go Back");
        backButton.setBounds(450, 400, 100, 25);
        contentPane.add(backButton);

        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            	HomePage homePage = new HomePage(userId);
                homePage.setVisible(true);  
            }
        });
        
     // Assuming selectcar is the id you want to use in your WHERE clause
        int selectedCarId = selectcar;

        // JDBC connection parameters
        String url = "jdbc:mysql://localhost:3306/user";
        String username = "root";
        String password = "mysql";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            // Create a PreparedStatement with parameterized query
            String sql = "SELECT name, price FROM product WHERE id = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                // Set the parameter for the WHERE clause
                preparedStatement.setInt(1, selectedCarId);

                // Execute the query and get the result set
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    // Check if there is a result
                    if (resultSet.next()) {
                        // Retrieve the values from the result set
                        String name = resultSet.getString("name");
                        int price = resultSet.getInt("price");

                        // Set the values in your JTextFields
                        nameTextField.setText(name);
                        priceTextField.setText(String.valueOf(price));
                    } else {
                        // Handle the case where no result was found
                        // You might want to set default values or handle it according to your application logic
                        nameTextField.setText("N/A");
                        priceTextField.setText("N/A");
                    }
                }
            }
        } catch (SQLException e) {
            // Handle any potential SQL exceptions
            e.printStackTrace();
        }

        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
                // Lấy thông tin từ các ô input
String name = nameTextField.getText();
                String rentDate = rentDateTextField.getText();
                String returnDate = returnDateTextField.getText();
                String licenseNumber = licenseNumberTextField.getText();
                String price = priceTextField.getText();
                String email = emailTextField.getText();
                String CCCD = emailTextField.getText();
                
                
                
                // kết nối đến cơ sở dữ liệu
                String url = "jdbc:mysql://localhost:3306/user";
                String username = "root";
                String password = "mysql";

                try {
                    Connection connection = DriverManager.getConnection(url, username, password);
//                    System.out.println(connection);
                    String sql = "INSERT INTO booking ( nameuser, rent_date, return_date, license_number, price, email, CCCD) VALUES (?, ?, ?, ?, ?, ?, ?)";
                    
                    PreparedStatement statement = connection.prepareStatement(sql);
                    statement.setString(1, name);
                    statement.setString(2, rentDate);
                    statement.setString(3, returnDate);
                    statement.setString(4, licenseNumber);
                    statement.setString(5, price);
                    statement.setString(6, email);
                    statement.setString(7, CCCD);
                    
                    int rowsInserted = statement.executeUpdate();
                    if (rowsInserted > 0) {
                        System.out.println(statement);
                    }
                    payment payment = new payment(userId);
                    payment.setVisible(true);
                    dispose(); // Đóng trang sau đó chuyển sang payment
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	
                    Booking frame = new Booking();
                    frame.setVisible(true);
                    
                    
                    
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}