package LoginPage;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
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
        setBounds(100, 100, 600, 500);
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
        	}
        });
        button.setBackground(Color.ORANGE);
        button.setFont(new Font("Times New Roman", Font.PLAIN, 22));
        button.setBounds(347, 331, 150, 34);
        panel.add(button);
        
        
        JLabel lblRegister = new JLabel("Bạn đã có tài khoản?");
        lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        lblRegister.setBounds(108, 362, 173, 21);
        panel.add(lblRegister);

        JButton btnLogin = new JButton("Login");
        btnLogin.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnLogin.setBounds(108, 393, 130, 30);
        btnLogin.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LoginPage loginPage = new LoginPage();  // Tạo instance của trang login
                loginPage.setVisible(true);  // Hiển thị trang login
                dispose();  // Đóng trang register
            }
        });
        panel.add(btnLogin);
        
        JRadioButton rdbtnNewRadioButton = new JRadioButton("Đồng ý với các điều khoản của chúng tôi?");
        rdbtnNewRadioButton.setBounds(233, 295, 264, 21);
        panel.add(rdbtnNewRadioButton);
        
        passwordField_1 = new JPasswordField();
        passwordField_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        passwordField_1.setBounds(233, 176, 264, 33);
        panel.add(passwordField_1);
        
        JLabel lblNewLabel_3_1 = new JLabel("Mật Khẩu:");
        lblNewLabel_3_1.setForeground(new Color(105, 105, 105));
        lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_3_1.setBounds(108, 179, 103, 29);
        panel.add(lblNewLabel_3_1);
        
        JLabel lblNewLabel_2_1 = new JLabel("Họ:");
        lblNewLabel_2_1.setForeground(new Color(105, 105, 105));
        lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2_1.setBounds(140, 98, 36, 29);
        panel.add(lblNewLabel_2_1);
        
        textField_1 = new JTextField();
        textField_1.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField_1.setBounds(185, 98, 117, 29);
        panel.add(textField_1);
        textField_1.setColumns(10);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("Tên:");
        lblNewLabel_2_1_1.setForeground(new Color(105, 105, 105));
        lblNewLabel_2_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2_1_1.setBounds(312, 98, 47, 29);
        panel.add(lblNewLabel_2_1_1);
        
        textField_2 = new JTextField();
        textField_2.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField_2.setColumns(10);
        textField_2.setBounds(368, 98, 129, 29);
        panel.add(textField_2);
        
        JLabel lblNewLabel_2_1_2 = new JLabel("Số Điện Thoại:");
        lblNewLabel_2_1_2.setForeground(new Color(105, 105, 105));
        lblNewLabel_2_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 24));
        lblNewLabel_2_1_2.setBounds(71, 263, 150, 29);
        panel.add(lblNewLabel_2_1_2);
        
        textField_3 = new JTextField();
        textField_3.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        textField_3.setColumns(10);
        textField_3.setBounds(233, 264, 264, 29);
        panel.add(textField_3);
    }
}