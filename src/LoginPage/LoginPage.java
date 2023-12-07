package LoginPage;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import AdminPages.AdminPage;
import HomePage.HomePage;

public class LoginPage extends JFrame {
	
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JPasswordField passwordField;

    // Phương thức kiểm tra tài khoản và mật khẩu
    private Map<String, Object> authenticateUser(String username, String password) {
        Map<String, Object> result = new HashMap<>();
        String role = null;
        int userId = -1;

        String query = "SELECT idnew_table, role FROM useraccount WHERE useraccount = ? AND password = ?";
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/user", "root", "mysql");
                PreparedStatement pstmt = conn.prepareStatement(query)) {

            pstmt.setString(1, username);
            pstmt.setString(2, password);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    userId = rs.getInt("idnew_table");
                    role = rs.getString("role");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        result.put("role", role);
        result.put("idnew_table", userId);
        return result;
    }
 	
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    LoginPage frame = new LoginPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public LoginPage() {
        setTitle("Login");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 742, 552);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        panel.setBorder(UIManager.getBorder("ComboBox.border"));
        panel.setBackground(Color.PINK);
        contentPane.add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Đăng Nhập");
        lblNewLabel.setBounds(286, 100, 169, 37);
        panel.add(lblNewLabel);
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));

        JLabel lblNewLabel_2 = new JLabel("Tài Khoản:");
        lblNewLabel_2.setBounds(143, 177, 108, 29);
        lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        panel.add(lblNewLabel_2);

        textField = new JTextField();
        textField.setBounds(268, 173, 264, 32);
        textField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        panel.add(textField);
        textField.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("Mật Khẩu:");
lblNewLabel_3.setBounds(143, 248, 103, 29);
        lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        panel.add(lblNewLabel_3);

        passwordField = new JPasswordField();
        passwordField.setBounds(268, 245, 264, 33);
        passwordField.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        panel.add(passwordField);

        Button button = new Button("Login");
        button.setBounds(188, 320, 218, 34);
        button.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	    String username = textField.getText();
        	    String password = new String(passwordField.getPassword());

        	    try {
        	        Map<String, Object> role = authenticateUser(username, password);
        	        System.out.println(role);
        	        if (role != null) {
        	            navigateToHomePage(role);
        	        } else {
        	            showLoginError();
        	        }
        	    } catch (IOException ex) {
        	        handleException("Error during login", ex);
        	        showErrorMessage("Lỗi kết nối CSDL", "Lỗi đăng nhập");
        	    }
        	}

        	private void navigateToHomePage(Map<String, Object> role) throws IOException {
        	    String userRole = (String) role.get("role");
        	    int userId = (int) role.get("idnew_table");
        	    System.out.println(userRole);
        	    if ("admin".equals(userRole)) {
        	    	
        	        AdminPage AdminPage = new AdminPage();
        	        AdminPage.setVisible(true);					
        	    } else if (userRole==null) {
        	       showLoginError();
        	       
        	    } else {
        	    	HomePage homePage = new HomePage(userId);
         	        homePage.setVisible(true);
        	    }
        	    dispose(); // Close the login page
        	}

        	private void showLoginError() {
        	    JOptionPane.showMessageDialog(LoginPage.this, "Tài khoản hoặc mật khẩu không đúng", "Lỗi đăng nhập", JOptionPane.ERROR_MESSAGE);
        	    LoginPage loginPage = new LoginPage();
    	        loginPage.setVisible(true);		
        	}
          });
        
        button.setActionCommand("");
        button.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        button.setBackground(Color.ORANGE);
        panel.add(button);
        
        // Thêm label "Bạn chưa có tài khoản?"
        JLabel lblRegister = new JLabel("Bạn chưa có tài khoản?");
        lblRegister.setBounds(156, 397, 173, 21);
        lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        panel.add(lblRegister);
        
        Button button_1 = new Button("Register");
        button_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        button_1.setBounds(156, 428, 73, 21);
        button_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RegisterPage registerPage = new RegisterPage();
                registerPage.setVisible(true);
                dispose(); // Đóng trang đăng nhập sau khi chuyển đến trang đăng ký
            }
        });
        panel.add(button_1);
    }

	protected void showErrorMessage(String string, String string2) {
		// TODO Auto-generated method stub
		
	}

	protected void handleException(String string, Exception ex) {
		// TODO Auto-generated method stub
		
	}
}