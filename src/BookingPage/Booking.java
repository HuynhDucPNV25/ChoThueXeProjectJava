package BookingPage;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Booking extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField nameTextField;
    private JTextField rentDateTextField;
    private JTextField returnDateTextField;
    private JTextField licenseNumberTextField;
    private JTextField priceTextField;
    private JTextField emailTextField;

    

    public Booking() {
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

        // JLabel return date
        JLabel returnDateLabel = new JLabel("Return Date:");
        returnDateLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        returnDateLabel.setBounds(60, 200, 100, 30);
        contentPane.add(returnDateLabel);
        
        // ô input return date
        returnDateTextField = new JTextField();
        returnDateTextField.setBounds(220, 200, 200, 20);
        contentPane.add(returnDateTextField);

        // JLabel license number
        JLabel licenseNumberLabel = new JLabel("License Number:");
        licenseNumberLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        licenseNumberLabel.setBounds(60, 250, 120, 30);
        contentPane.add(licenseNumberLabel);
        
        // ô input license number
        licenseNumberTextField = new JTextField();
        licenseNumberTextField.setBounds(220, 250, 200, 20);
        contentPane.add(licenseNumberTextField);

        // JLabel price
        JLabel priceLabel = new JLabel("Price:");
        priceLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        priceLabel.setBounds(60, 300, 100, 30);
        contentPane.add(priceLabel);
        
        // ô input price
        priceTextField = new JTextField();
        priceTextField.setBounds(220, 300, 200, 20);
        contentPane.add(priceTextField);

        // JLabel email
        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        emailLabel.setBounds(60, 350, 100, 30);
        contentPane.add(emailLabel);
        
        // ô input email
        emailTextField = new JTextField();
        emailTextField.setBounds(220, 350, 200, 20);
        contentPane.add(emailTextField);
        
        
     // Tạo một JButton mới
        JButton button = new JButton("send!");

        // Thêm JButton vào JFrame
        contentPane.add(button);
        // thuộc tính
        button.setBackground(Color.RED); // Đặt màu nền là màu đỏ
        button.setForeground(Color.WHITE); // Đặt màu chữ là màu trắng
        button.setSize(100, 30); // Đặt kích thước
        button.setLocation(220, 400);
//        button.setBounds(300, 800, 100, 30);
        
        
        
     // Hình nền
        ImageIcon backgroundImage = new ImageIcon("src/hinhnenxe.jpg");
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(-75, -209, 1000, 800);
        contentPane.add(backgroundLabel);
        
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                //tạo ra form thông tin của người dùng khi nhập vào
            	JPanel resultPanel = new JPanel();
                resultPanel.setBounds(450, 100, 350, 200);
                resultPanel.setLayout(new GridLayout(0, 2));
                contentPane.add(resultPanel);
             // Thực thi hành động khi người dùng nhấp vào nút "send"
                // Lấy thông tin từ các ô input
                String name = nameTextField.getText();
                String rentDate = rentDateTextField.getText();
                String returnDate = returnDateTextField.getText();
                String licenseNumber = licenseNumberTextField.getText();
                String price = priceTextField.getText();
                String email = emailTextField.getText();

                // Xóa tất cả các thành phần hiện có trong resultPanel (nếu có)
                resultPanel.removeAll();
                resultPanel.add(new JLabel("Form Booking "));
                resultPanel.add(new JLabel( ));
                // Thêm các JLabel chứa thông tin người dùng vào resultPanel
                resultPanel.add(new JLabel("Name:"));
                resultPanel.add(new JLabel(name));
                resultPanel.add(new JLabel("Rent Date:"));
                resultPanel.add(new JLabel(rentDate));
                resultPanel.add(new JLabel("Return Date:"));
                resultPanel.add(new JLabel(returnDate));
                resultPanel.add(new JLabel("License Number:"));
                resultPanel.add(new JLabel(licenseNumber));
                resultPanel.add(new JLabel("Price:"));
                resultPanel.add(new JLabel(price));
                resultPanel.add(new JLabel("Email:"));
                resultPanel.add(new JLabel(email));
                JButton closeButton = new JButton("Đóng");
                JButton updateButton = new JButton("Cập nhật");
                closeButton.setBounds(50, 150, 100, 30);
                updateButton.setBounds(200, 150, 100, 30);
                resultPanel.add(closeButton);
                resultPanel.add(updateButton);
                // Cập nhật giao diện
                resultPanel.revalidate();
                resultPanel.repaint();
                
                closeButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	resultPanel.setVisible(false); // Đóng cửa sổ
                    }
                });

                updateButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                        // Thực hiện hành động cập nhật thông tin
                        // ...
                    }
                });
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
