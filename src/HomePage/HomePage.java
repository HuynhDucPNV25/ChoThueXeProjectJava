package HomePage;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.*;

import LoginPage.LoginPage;

import java.awt.*;
import java.awt.event.*;

public class HomePage extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel searchPanel;
	private JPanel titlePanel;
	private JPanel allCarsPanel;
	private JPanel footerPanel;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomePage frame = new HomePage();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomePage() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1367, 838);
		setContentPane(createContentPane());

		JTabbedPane Detail = new JTabbedPane(JTabbedPane.TOP);
		Detail.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
		Detail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
		Detail.setBounds(372, 64, 697, 453);
		contentPane.add(Detail);

	}

	private JPanel createContentPane() {
		contentPane = new JPanel();
		contentPane.setBackground(new Color(192, 192, 192));
		
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);

		contentPane.add(createSearchPanel());
		
		JSlider slider = new JSlider();
		slider.setBounds(63, 360, 224, 22);
		searchPanel.add(slider);
		
		JLabel lblGiTin = new JLabel("Loại xe:");
		lblGiTin.setEnabled(false);
		lblGiTin.setBounds(63, 180, 98, 29);
		searchPanel.add(lblGiTin);
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		Choice choice = new Choice();
		choice.setFont(new Font("Dialog", Font.PLAIN, 22));
		choice.setBounds(63, 212, 224, 18);
		searchPanel.add(choice);
		
		JLabel lblGiTin_1 = new JLabel("Giá tiền:");
		lblGiTin_1.setEnabled(false);
		lblGiTin_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblGiTin_1.setBounds(63, 328, 98, 29);
		searchPanel.add(lblGiTin_1);
		
		JLabel lblHngXe = new JLabel("Thương hiệu:");
		lblHngXe.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblHngXe.setEnabled(false);
		lblHngXe.setBounds(63, 252, 120, 29);
		searchPanel.add(lblHngXe);
		
		Choice choice_1 = new Choice();
		choice_1.setFont(new Font("Dialog", Font.PLAIN, 22));
		choice_1.setBounds(63, 284, 224, 34);
		searchPanel.add(choice_1);
		
		JLabel lblaim = new JLabel("Địa điểm:");
		lblaim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblaim.setEnabled(false);
		lblaim.setBounds(63, 108, 98, 29);
		searchPanel.add(lblaim);
		
		Choice choice_2 = new Choice();
		choice_2.setFont(new Font("Dialog", Font.PLAIN, 22));
		choice_2.setBounds(63, 140, 224, 34);
		searchPanel.add(choice_2);
		
		
		JLabel lblTmKim = new JLabel("Tìm kiếm:");
		lblTmKim.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTmKim.setEnabled(false);
		lblTmKim.setBounds(63, 27, 98, 29);
		searchPanel.add(lblTmKim);
		
		TextField textField = new TextField();
textField.setForeground(Color.GRAY);

		textField.setFont(new Font("Dialog", Font.PLAIN, 16));
		textField.setBounds(63, 64, 224, 38);
		searchPanel.add(textField);
		
				Button searchButton = new Button("Search");
				searchButton.setBackground(Color.PINK);
				searchButton.setBounds(99, 390, 153, 57);
				searchPanel.add(searchButton);
				searchButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						// Perform search action
					}
				});
				searchButton.setFont(new Font("Dialog", Font.PLAIN, 26));
				contentPane.add(createTitlePanel());
				contentPane.add(createAllCarsPanel());
				
				JButton btnNewButton = new JButton("Đăng Xuất");
				btnNewButton.setFont(new Font("Times New Roman", Font.PLAIN, 18));
				btnNewButton.setBounds(580, 6, 120, 40);
				btnNewButton.setBackground(Color.ORANGE);
				btnNewButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						 LoginPage loginPage = new LoginPage();  // Tạo instance của trang login
			                loginPage.setVisible(true);  // Hiển thị trang login
			                dispose(); 
					}
				});
				allCarsPanel.add(btnNewButton);
				contentPane.add(createFooterPanel());


			    JTabbedPane Detail = new JTabbedPane(JTabbedPane.TOP);
			    Detail.setBackground(Color.ORANGE);
			    Detail.setBorder(new LineBorder(new Color(255, 255, 255), 0, true));
			    Detail.setFont(new Font("Times New Roman", Font.PLAIN, 22));
			    Detail.setBounds(372, 64, 697, 453);
			    contentPane.add(Detail);


			    return contentPane;
			
	}

	private JPanel createSearchPanel() {
		searchPanel = new JPanel();
		searchPanel.setBackground(Color.ORANGE);
searchPanel.setBounds(0, 54, 362, 474);
		searchPanel.setLayout(null);

		return searchPanel;
	}

	private JPanel createTitlePanel() {
		titlePanel = new JPanel();
		titlePanel.setBounds(0, 0, 362, 54);
		titlePanel.setBackground(Color.PINK);
		titlePanel.setLayout(null);

		JLabel titleLabel = new JLabel("Tìm xe");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		titleLabel.setBounds(22, 10, 146, 34);
		titlePanel.add(titleLabel);

		return titlePanel;
	}

	private JPanel createAllCarsPanel() {
		allCarsPanel = new JPanel();
		allCarsPanel.setBounds(372, 0, 709, 54);
		allCarsPanel.setBackground(Color.PINK);
		allCarsPanel.setLayout(null);

		JLabel allCarsLabel = new JLabel("Tất cả xe");
		allCarsLabel.setBounds(10, 10, 146, 34);
		allCarsLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));
		allCarsPanel.add(allCarsLabel);

		return allCarsPanel;
	}

	private JPanel createFooterPanel() {
		footerPanel = new JPanel();
		footerPanel.setBounds(0, 527, 1081, 61);
		footerPanel.setLayout(null);
		footerPanel.setBackground(Color.PINK);

		JLabel footerLabel = new JLabel("Chúc các bạn sẽ có trải nghiệm thú vị tại đây !!");
		footerLabel.setBounds(250, 10, 557, 34);
		footerPanel.add(footerLabel);
		footerLabel.setFont(new Font("Tahoma", Font.PLAIN, 26));

		return footerPanel;
	}
}

