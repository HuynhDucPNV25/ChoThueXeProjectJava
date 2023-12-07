package BookingPage;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import HomePage.HomePage;

public class payment extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static int userId;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment frame = new payment(userId);
					frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public payment(int userId) {
		this.userId = userId;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Tiêu đề trang
		JLabel title = new JLabel("Payment");
		title.setFont(new Font("Tahoma", Font.PLAIN, 26));
		title.setBounds(170, 10, 120, 30);
		contentPane.add(title);

		// Nút thanh toán bằng Momo
		JButton momoButton = new JButton("Pay with Momo");
		momoButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		momoButton.setBounds(30, 60, 150, 30);
		contentPane.add(momoButton);

		// Nút thanh toán qua ngân hàng
		JButton bankButton = new JButton("Pay with Bank");
		bankButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bankButton.setBounds(250, 60, 150, 30);
		contentPane.add(bankButton);

		// Hình ảnh mã QR cho thanh toán bằng Momo
		JLabel momoQRLabel = new JLabel();
		ImageIcon momoQRIcon = new ImageIcon("src/momo_qr.png"); // Đường dẫn đến hình ảnh QR của Momo
		Image momoQRImage = momoQRIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		momoQRLabel.setIcon(new ImageIcon(momoQRImage));
		momoQRLabel.setBounds(125, 100, 200, 200);
		momoQRLabel.setVisible(false);
		contentPane.add(momoQRLabel);

		// Hình ảnh mã QR cho thanh toán qua ngân hàng
		JLabel bankQRLabel = new JLabel();
		ImageIcon bankQRIcon = new ImageIcon("src/bank_qr.png"); // Đường dẫn đến hình ảnh QR của ngân hàng
		Image bankQRImage = bankQRIcon.getImage().getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		bankQRLabel.setIcon(new ImageIcon(bankQRImage));
		bankQRLabel.setBounds(125, 100, 200, 200);
		bankQRLabel.setVisible(false);
		contentPane.add(bankQRLabel);

		// Nút Hủy
		JButton cancelButton = new JButton("Cancel");
		cancelButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		cancelButton.setBounds(30, 220, 90, 30);
		cancelButton.setVisible(false);
		contentPane.add(cancelButton);

		// Nút Đã thanh toán
		JButton paidButton = new JButton("Paid");
		paidButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		paidButton.setBounds(330, 220, 90, 30);
		paidButton.setVisible(false);
		contentPane.add(paidButton);

		// Sự kiện khi nhấn nút thanh toán bằng Momo
		momoButton.addActionListener(e -> {
			momoQRLabel.setVisible(true);
			cancelButton.setVisible(true);
		});

		// Sự kiện khi nhấn nút thanh toán qua ngân hàng
		bankButton.addActionListener(e -> {
			bankQRLabel.setVisible(true);
			cancelButton.setVisible(true);
		});

		// Sự kiện khi nhấn nút Hủy
		cancelButton.addActionListener(e -> {
//			cancelButton.setVisible(false);
			 HomePage homePage = new HomePage(userId);
             homePage.setVisible(true);
             dispose(); 
			
		});
	}

}
