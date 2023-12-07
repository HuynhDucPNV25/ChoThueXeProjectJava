package AdminPages;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import LoginPage.LoginPage;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

@SuppressWarnings("serial")
public class AdminPage extends JFrame {

    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    public AdminPage() {
        initializeUI();
        setupTabs();
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 800, 600);
    }

    private void setupTabs() {
        JTabbedPane tabbedPane = new JTabbedPane();

        // Booking Data Tab
        JPanel bookingPanel = new JPanel();
        bookingPanel.setLayout(new BorderLayout());
        displayBookingData(bookingPanel);

        // User Data Tab
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new BorderLayout());
        displayUserData(userPanel);
        setupUserActions(userPanel);

        // Product Data Tab
        JPanel productPanel = new JPanel();
        productPanel.setLayout(new BorderLayout());
        displayProductData(productPanel);

        tabbedPane.addTab("Booking Data", bookingPanel);
        tabbedPane.addTab("User Data", userPanel);
        tabbedPane.addTab("Product Data", productPanel);

        getContentPane().add(tabbedPane);
        // Add Logout Button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBackground(Color.RED);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                LoginPage loginFrame = new LoginPage();
                loginFrame.setVisible(true);
            }
        });

        getContentPane().add(logoutButton, BorderLayout.SOUTH);
    }

    private void displayBookingData(JPanel panel) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM booking");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            JTable bookingTable = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(bookingTable);
            panel.add(scrollPane, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayUserData(JPanel panel) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM useraccount");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            JTable userTable = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(userTable);
            panel.add(scrollPane, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void displayProductData(JPanel panel) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            JTable productTable = new JTable(buildTableModel(resultSet));
            JScrollPane scrollPane = new JScrollPane(productTable);
            panel.add(scrollPane, BorderLayout.CENTER);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private DefaultTableModel buildTableModel(ResultSet resultSet) throws SQLException {
        java.sql.ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();
        String[] columnNames = new String[columnCount];
        for (int column = 1; column <= columnCount; column++) {
            columnNames[column - 1] = metaData.getColumnName(column);
        }

        Object[][] data = new Object[100][columnCount];
        int row = 0;
        while (resultSet.next()) {
            for (int column = 1; column <= columnCount; column++) {
                data[row][column - 1] = resultSet.getObject(column);
            }
            row++;
        }

        return new DefaultTableModel(data, columnNames);
    }

    private void setupUserActions(JPanel panel) {
        JButton addUserButton = new JButton("Add User");
        addUserButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAddUserDialog();
                // Refresh user data after adding a new user
                refreshUserData(panel);
            }
        });

        panel.add(addUserButton, BorderLayout.SOUTH);
    }

    private void showAddUserDialog() {
        UserDataDialog dialog = new UserDataDialog(this, "Add User", true);
        dialog.setVisible(true);

        UserData newData = (UserData) dialog.getUserData();

        if (newData != null) {
            addUserData(newData);
        }
    }

    private void addUserData(UserData data) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO useraccount(useraccount, password, name, gmail, phone, role, address, idpesonnal) VALUES (?, ?, ?, ?, ?, ?, ?, ?)")) {

            preparedStatement.setString(1, data.getUserAccount());
            preparedStatement.setString(2, data.getPassword());
            preparedStatement.setString(3, data.getName());
            preparedStatement.setString(4, data.getGmail());
            preparedStatement.setString(5, data.getPhone());
            preparedStatement.setString(6, "user");
            preparedStatement.setString(7, data.getAddress());
            preparedStatement.setString(8, data.getIdPesonnal());
            preparedStatement.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
            showError("Error adding user data.");
        }
       
    }

    private void refreshUserData(JPanel panel) {
        panel.removeAll();
        displayUserData(panel);
        panel.revalidate();
        panel.repaint();
    }

    private void showError(String message) {
        JOptionPane.showMessageDialog(null, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    private void showInfo(String message) {
        JOptionPane.showMessageDialog(null, message, "Information", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                AdminPage adminPage = new AdminPage();
                adminPage.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
