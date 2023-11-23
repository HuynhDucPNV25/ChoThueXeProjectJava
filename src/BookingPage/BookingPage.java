package BookingPage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class BookingPage extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField txtName;
    private JTextField txtPhone;
    private JTextField txtEmail;
    private JComboBox<String> comboBoxPackage;

    public BookingPage() {
        setTitle("Đặt thuê xe");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1182, 870);
        setResizable(false);

        contentPane = new JPanel();
        contentPane.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(contentPane);
        contentPane.setLayout(new BorderLayout(0, 0));

        JPanel panel = new JPanel();
        contentPane.add(panel, BorderLayout.CENTER);
        GridBagLayout gbl_panel = new GridBagLayout();
        gbl_panel.columnWidths = new int[]{0, 0, 0};
        gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
        gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
        gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
        panel.setLayout(gbl_panel);

        JLabel lblTitle = new JLabel("Đặt thuê xe");
        lblTitle.setFont(new Font("Tahoma", Font.BOLD, 18));
        GridBagConstraints gbc_lblTitle = new GridBagConstraints();
        gbc_lblTitle.gridwidth = 2;
        gbc_lblTitle.insets = new Insets(0, 0, 10, 0);
        gbc_lblTitle.gridx = 0;
        gbc_lblTitle.gridy = 0;
        panel.add(lblTitle, gbc_lblTitle);

        JLabel lblName = new JLabel("Họ và tên:");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblName = new GridBagConstraints();
        gbc_lblName.anchor = GridBagConstraints.EAST;
        gbc_lblName.insets = new Insets(0, 0, 10, 10);
        gbc_lblName.gridx = 0;
        gbc_lblName.gridy = 1;
        panel.add(lblName, gbc_lblName);

        txtName = new JTextField();
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_txtName = new GridBagConstraints();
        gbc_txtName.insets = new Insets(0, 0, 10, 0);
        gbc_txtName.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtName.gridx = 1;
        gbc_txtName.gridy = 1;
        panel.add(txtName, gbc_txtName);

        JLabel lblPhone = new JLabel("Số điện thoại:");
        lblPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblPhone = new GridBagConstraints();
        gbc_lblPhone.anchor = GridBagConstraints.EAST;
        gbc_lblPhone.insets = new Insets(0, 0, 10, 10);
        gbc_lblPhone.gridx = 0;
        gbc_lblPhone.gridy = 2;
        panel.add(lblPhone, gbc_lblPhone);

        txtPhone = new JTextField();
        txtPhone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_txtPhone = new GridBagConstraints();
        gbc_txtPhone.insets = new Insets(0, 0, 10, 0);
        gbc_txtPhone.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtPhone.gridx = 1;
        gbc_txtPhone.gridy = 2;
        panel.add(txtPhone, gbc_txtPhone);

        JLabel lblEmail = new JLabel("Email:");
        lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblEmail = new GridBagConstraints();
        gbc_lblEmail.anchor = GridBagConstraints.EAST;
        gbc_lblEmail.insets = new Insets(0, 0, 10, 10);
        gbc_lblEmail.gridx = 0;
        gbc_lblEmail.gridy = 3;
        panel.add(lblEmail, gbc_lblEmail);

        txtEmail = new JTextField();
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_txtEmail = new GridBagConstraints();
        gbc_txtEmail.insets = new Insets(0, 0, 10, 0);
        gbc_txtEmail.fill = GridBagConstraints.HORIZONTAL;
        gbc_txtEmail.gridx = 1;
        gbc_txtEmail.gridy = 3;
        panel.add(txtEmail, gbc_txtEmail);

        JLabel lblPackage = new JLabel("Gói thuê xe:");
        lblPackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GridBagConstraints gbc_lblPackage =new GridBagConstraints();
        gbc_lblPackage.anchor = GridBagConstraints.EAST;
        gbc_lblPackage.insets = new Insets(0, 0, 10, 10);
        gbc_lblPackage.gridx = 0;
        gbc_lblPackage.gridy = 4;
        panel.add(lblPackage, gbc_lblPackage);

        comboBoxPackage = new JComboBox<String>();
        comboBoxPackage.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBoxPackage.addItem("Gói 200k/1 ngày");
        comboBoxPackage.addItem("Gói 600k/1 tuần");
        GridBagConstraints gbc_comboBoxPackage = new GridBagConstraints();
        gbc_comboBoxPackage.insets = new Insets(0, 0, 10, 0);
        gbc_comboBoxPackage.fill = GridBagConstraints.HORIZONTAL;
        gbc_comboBoxPackage.gridx = 1;
        gbc_comboBoxPackage.gridy = 4;
        panel.add(comboBoxPackage, gbc_comboBoxPackage);

        JButton btnBook = new JButton("Đặt xe");
        btnBook.setFont(new Font("Tahoma", Font.BOLD, 16));
        GridBagConstraints gbc_btnBook = new GridBagConstraints();
        gbc_btnBook.gridwidth = 2;
        gbc_btnBook.insets = new Insets(0, 0, 0, 0);
        gbc_btnBook.gridx = 0;
        gbc_btnBook.gridy = 5;
        panel.add(btnBook, gbc_btnBook);

//        btnBook.addActionListener(new ActionListener() {
//            public void actionPerformed(ActionEvent e) {
//                String name = txtName.getText();
//                String phone = txtPhone.getText();
//                String email = txtEmail.getText();
//                String packageSelected = (String) comboBoxPackage.getSelectedItem();
//
//                if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
//                    JOptionPane.showMessageDialog(BookingPage.this, "Vui lòng điền đầy đủ thông tin");
//                } else {
//                    String message = "Họ và tên: " + name + "\n"
//                            + "Số điện thoại: " + phone + "\n"
//                            + "Email: " + email + "\n"
//                            + "Gói thuê xe: " + packageSelected;
//                    JOptionPane.showMessageDialog(BookingPage.this, message);
//                }
//            }
//        });
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    BookingPage frame = new BookingPage();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}