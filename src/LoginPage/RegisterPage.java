package LoginPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.sql.*;
import java.awt.event.ActionEvent;

public class RegisterPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;
    private JButton button;
    private JPasswordField passwordField_1;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterPage frame = new RegisterPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public RegisterPage() {
        setFont(new Font("Times New Roman", Font.PLAIN, 20));
        setTitle("Register");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 686, 596);
        contentPane = new JPanel();
        contentPane.setBackground(Color.PINK);
        contentPane.setLayout(new BorderLayout());
        setContentPane(contentPane);

        JPanel panel = new JPanel();
        panel.setBorder(new EmptyBorder(5, 5, 5, 5));
        panel.setBackground(Color.PINK);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Register");
        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
        lblNewLabel.setBounds(233, 45, 130, 37);
        panel.add(lblNewLabel);

        JLabel lblNewLabel_2 = new JLabel("Tài Khoản:");
        lblNewLabel_2.setForeground(new Color(105, 105, 105));
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2.setBounds(108, 137, 108, 29);
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        textField.setBounds(233, 133, 264, 32);
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Nhập lại Mật Khẩu:");
        lblNewLabel_3.setForeground(new Color(105, 105, 105));
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_3.setBounds(26, 224, 190, 29);
        panel.add(lblNewLabel_3);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField.setBounds(233, 221, 264, 33);
        panel.add(passwordField);

        button = new JButton("Register");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                register();
            }
        });
        button.setBackground(Color.ORANGE);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        button.setBounds(357, 474, 150, 34);
        panel.add(button);


        JLabel lblRegister = new JLabel("Bạn đã có tài khoản?");
        lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblRegister.setBounds(62, 446, 173, 21);
        panel.add(lblRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnLogin.setBounds(108, 477, 130, 30);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
                dispose();
            }
        });
        panel.add(btnLogin);

        JRadioButton rdbtnNewRadioButton = new JRadioButton("Đồng ý với các điều khoản của chúng tôi?");
        rdbtnNewRadioButton.setBounds(243, 447, 264, 21);
        panel.add(rdbtnNewRadioButton);

        passwordField_1 = new JPasswordField();
        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField_1.setBounds(233, 176, 264, 33);
        panel.add(passwordField_1);
        JLabel lblNewLabel_3_1 = new JLabel("Mật Khẩu:");
        lblNewLabel_3_1.setForeground(new Color(105, 105, 105));
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_3_1.setBounds(108, 181, 108, 29);
        panel.add(lblNewLabel_3_1);

        JLabel lblNewLabel_4 = new JLabel("Họ và Tên:");
        lblNewLabel_4.setForeground(new Color(105, 105, 105));
        lblNewLabel_4.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_4.setBounds(108, 267, 108, 29);
        panel.add(lblNewLabel_4);

        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        textField_1.setBounds(233, 263, 264, 32);
        panel.add(textField_1);
        textField_1.setColumns(10);

        JLabel lblNewLabel_5 = new JLabel("Email:");
        lblNewLabel_5.setForeground(new Color(105, 105, 105));
        lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_5.setBounds(145, 307, 71, 29);
        panel.add(lblNewLabel_5);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        textField_2.setBounds(233, 306, 264, 32);
        panel.add(textField_2);
        textField_2.setColumns(10);

        JLabel lblNewLabel_6 = new JLabel("Số Điện Thoại:");
        lblNewLabel_6.setForeground(new Color(105, 105, 105));
        lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_6.setBounds(62, 98, 163, 29);
        panel.add(lblNewLabel_6);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        textField_3.setBounds(233, 91, 264, 32);
        panel.add(textField_3);
        textField_3.setColumns(10);
        
        JLabel lblNewLabel_7 = new JLabel("CCCD:");
        lblNewLabel_7.setForeground(new Color(105, 105, 105));
        lblNewLabel_7.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_7.setBounds(125, 395, 81, 29);
        panel.add(lblNewLabel_7);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        textField_4.setBounds(233, 351, 264, 32);
        panel.add(textField_4);
        textField_4.setColumns(10);
        
        JLabel lblNewLabel_7_1 = new JLabel("Address:");
        lblNewLabel_7_1.setForeground(new Color(105, 105, 105));
        lblNewLabel_7_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_7_1.setBounds(108, 346, 98, 29);
        panel.add(lblNewLabel_7_1);
        
        textField_5 = new JTextField();
        textField_5.setBounds(233, 395, 264, 28);
        panel.add(textField_5);
        textField_5.setColumns(10);
        
	        
    }
    private static final String DB_URL = "jdbc:mysql://localhost:3306/user";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "mysql";
    private JTextField textField_5;

    private void register() {
    	String username = textField.getText();
    	String password = new String(passwordField.getPassword());
    	String confirmPassword = new String(passwordField_1.getPassword());
    	String fullName = textField_1.getText();
    	String email = textField_2.getText();
    	String phoneNumber = textField_3.getText();
    	String address = textField_4.getText();
    	String cccd = textField_5.getText();
    	// Check for empty fields
    	if (username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty() || fullName.isEmpty()
    	        || email.isEmpty() || phoneNumber.isEmpty() || address.isEmpty() || cccd.isEmpty()) {
    	    showError("Vui lòng điền đầy đủ thông tin.");
    	    return;
    	}

    	
    	// Check if passwords match
    	if (!password.equals(confirmPassword)) {
    	    showError("Mật khẩu không khớp. Vui lòng thử lại.");
    	    return;
    	}

    	// Validate email
    	if (!isValidEmail(email)) {
    	    showError("Vui lòng nhập một địa chỉ email hợp lệ.");
    	    return;
    	}

    	// Validate phone number
    	if (!isValidPhoneNumber(phoneNumber)) {
    	    showError("Vui lòng nhập một số điện thoại hợp lệ.");
    	    return;
    	}

    	// Validate address (add additional validation if needed)

    	// Password strength check (add your own criteria)
    	if (password.length() < 8) {
    	    showError("Mật khẩu phải chứa ít nhất 8 ký tự.");
    	    return;
    	}
    	
		if (isDuplicate("gmail", email) || isDuplicate("phone", phoneNumber) || isDuplicate("idpesonnal", cccd)) {
	        showError("Thông tin đã tồn tại trong hệ thống. Vui lòng kiểm tra lại Gmail, Phone, CCCD của bạn!!");
	        return;
		}
		
		
        try {
            try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                 PreparedStatement statement = conn.prepareStatement("INSERT INTO useraccount (useraccount, password, name, gmail, phone,role, address,idpesonnal) VALUES (?,?, ?, ?, ?, ?,?,?)",
                                                                Statement.RETURN_GENERATED_KEYS)) {

                statement.setString(1, username);
                statement.setString(2, password);
                statement.setString(3, fullName);
                statement.setString(4, email);
                statement.setString(5, phoneNumber);
                statement.setString(6,"user");
                statement.setString(7,address);
                statement.setString(8,cccd);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    ResultSet generatedKeys = statement.getGeneratedKeys();
                    if (generatedKeys.next()) {
                        int userId = generatedKeys.getInt(1);
                        showInfo("Đăng ký thành công! User ID: " + userId);
                    } else {
                        showError("Lỗi khi lấy ID người dùng đã tạo.");
                    }
                    dispose();
                    new LoginPage().setVisible(true);
                } else {
                    showError("Đăng ký thất bại. Vui lòng thử lại.");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            showError("Đăng ký thất bại. Vui lòng thử lại.");
        }
    }

 // Validate email method
    private boolean isValidEmail(String email) {
        // You can replace this with your own email validation logic
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
        return email.matches(emailRegex);
    }

    // Validate phone number method
    private boolean isValidPhoneNumber(String phoneNumber) {
        // You can replace this with your own phone number validation logic
        String phoneRegex = "^[0-9]{10}$";
        return phoneNumber.matches(phoneRegex);
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String message) {
        JOptionPane.showMessageDialog(this, message);
    }
    private boolean isDuplicate(String columnName, String value) {
        String query = "SELECT * FROM useraccount WHERE " + columnName + " = ?";
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = conn.prepareStatement(query)) {
            statement.setString(1, value);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next(); // If the result set has any rows, it means there is a duplicate
            }
        } catch (SQLException e) {
            e.printStackTrace();
            showError("Lỗi khi kiểm tra trùng lặp dữ liệu.");
            return true; // Treat as duplicate to prevent insertion in case of an error
        }
    }
}