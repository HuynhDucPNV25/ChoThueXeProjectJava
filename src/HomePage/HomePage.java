package HomePage;
import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import BookingPage.Booking;
import LoginPage.LoginPage;
import user.UserProfile;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HomePage extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel allCarsPanel;
    private JTextField search;
    private JLabel allCarsLabel;
    private int colorIndex = 0;
    private int selectedImageId;
    private JList<Icon> imageList;
    private int userId;
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "mysql";

    private static final Map<String, String> carRules = new ConcurrentHashMap<>();

    static {
    	carRules.put("Tất cả", "SELECT * FROM product ");
        carRules.put("2", "SELECT * FROM product WHERE rule = '2'");
        carRules.put("4", "SELECT * FROM product WHERE rule = '4'");
        carRules.put("6", "SELECT * FROM product WHERE rule = '6'");
        carRules.put("8", "SELECT * FROM product WHERE rule = '8'");
        carRules.put("10", "SELECT * FROM product WHERE rule = '10'");
        carRules.put("12", "SELECT * FROM product WHERE rule = '12'");
        carRules.put("16", "SELECT * FROM product WHERE rule = '16'");
        carRules.put("18", "SELECT * FROM product WHERE rule = '18'");
        carRules.put("20", "SELECT * FROM product WHERE rule = '20'");
        carRules.put("24", "SELECT * FROM product WHERE rule = '24'");
        carRules.put("vip", "SELECT * FROM product WHERE rule = 'vip'");
        carRules.put("tai", "SELECT * FROM product WHERE rule = 'tai'");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
//                HomePage frame = new HomePage();
//                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public HomePage(int userId) {
    	System.out.println(userId);
        initializeUI();
        setupCarSelectionPanel();
        setupImageList();
        startColorChangingTimer();
        this.userId = userId;
    }

    private void initializeUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 1151, 641);
        setContentPane(createContentPane());
    }

    private JPanel createContentPane() {
        contentPane = new JPanel();
        contentPane.setBackground(new Color(192, 192, 192));
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(null);
        contentPane.add(createAllCarsPanel());
        return contentPane;
    }

    private JPanel createAllCarsPanel() {
        allCarsPanel = new JPanel();
        allCarsPanel.setBounds(0, 0, 1137, 54);
        allCarsPanel.setBackground(Color.PINK);
        allCarsPanel.setLayout(null);

        allCarsLabel = new JLabel("Thuê Xe Giá Rẻ An Toàn");
        allCarsLabel.setBounds(274, 9, 398, 34);
        allCarsLabel.setForeground(getNextColor());
        allCarsLabel.setFont(new Font("Verdana", Font.BOLD, 26));
        allCarsPanel.add(allCarsLabel);

        JButton btnLogout = new JButton("Đăng Xuất");
        btnLogout.setBounds(945, 11, 120, 40);
        btnLogout.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnLogout.setBackground(Color.ORANGE);
        btnLogout.addActionListener(e -> {
            LoginPage loginPage = new LoginPage();
            loginPage.setVisible(true);
            dispose();
        });
        allCarsPanel.add(btnLogout);
        
        JButton btnLogout1 = new JButton("Xem Profile");
        btnLogout1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
        });
        btnLogout1.setBounds(742, 15, 178, 33);
        btnLogout1.setFont(new Font("Times New Roman", Font.PLAIN, 18));
        btnLogout1.setBackground(Color.yellow);
        btnLogout1.addActionListener(e -> {
            UserProfile userProfile = new UserProfile(userId);
            userProfile.setVisible(true);
            dispose();
        });
        allCarsPanel.add(btnLogout1);

        return allCarsPanel;
    }

    private void setupCarSelectionPanel() {
        JPanel carSelectionPanel = new JPanel();
        carSelectionPanel.setBounds(35, 141, 385, 304);
        getContentPane().add(carSelectionPanel);
        carSelectionPanel.setLayout(new GridLayout(4, 3, 10, 10));

        String[] carButtonLabels = {"Tất cả", "2", "4", "6", "8", "10", "12", "16", "18", "20", "24", "vip", "tai"};
        for (String label : carButtonLabels) {
            JButton carButton = new JButton(label);
            carButton.addActionListener(e -> handleCarSelection(label));
            carSelectionPanel.add(carButton);
        }

        JButton searchButton = new JButton("Tìm Kiếm");
        searchButton.addActionListener(e -> handleSearch());

        search = new JTextField();
        carSelectionPanel.add(search);
        search.setColumns(10);
        carSelectionPanel.add(searchButton);
    }

    private void setupImageList() {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(455, 64, 650, 487);
        getContentPane().add(scrollPane);

        DefaultListModel<Icon> imageListModel = new DefaultListModel<>();
        imageList = new JList<>(imageListModel);
        scrollPane.setViewportView(imageList);
        
        JLabel lblNewLabel_1 = new JLabel("Chọn xe bạn muốn thuê!!");
        scrollPane.setColumnHeaderView(lblNewLabel_1);
        
        JLabel lblNewLabel_2 = new JLabel("Thuê Xe Ngay Thôi!!");
        scrollPane.setRowHeaderView(lblNewLabel_2);

        JPanel panel = new JPanel();
        panel.setBackground(Color.PINK);
        panel.setBounds(0, 550, 1137, 54);
        contentPane.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Chúc các bạn sẽ có trải nghiệm thú vị tại đây !!");
        lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        lblNewLabel.setBounds(341, 10, 416, 39);
        panel.add(lblNewLabel);

        imageList.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (SwingUtilities.isLeftMouseButton(e) && e.getClickCount() == 2) {
                    int selectedIndex = imageList.locationToIndex(e.getPoint());
                    Icon selectedIcon = imageList.getModel().getElementAt(selectedIndex);
                    selectedImageId = getImageIdFromIcon(selectedIcon);
                    System.out.println(selectedImageId);

                    detail detailpage = new detail(selectedImageId,userId);
                    detailpage.setVisible(true);
                    dispose();
                }
            }
        });

        DatabaseAccessor databaseAccessor = new DatabaseAccessor();
        databaseAccessor.loadImagesFromDatabase(imageListModel);
    }

    private void handleCarSelection(String carType) {
        String query = carRules.get(carType);
        System.out.println("Query: " + query); // In giá trị query để kiểm tra

        if (query != null) {
            loadImagesFromDatabaseWithQuery(query);
        } else {
            loadAllImagesFromDatabase();
        }
    }


    private void loadImagesFromDatabaseWithQuery(String query) {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query);
             ResultSet resultSet = preparedStatement.executeQuery()) {

            DefaultListModel<Icon> imageListModel = new DefaultListModel<>();
            DatabaseAccessor databaseAccessor = new DatabaseAccessor();
            databaseAccessor.loadImagesFromResultSet(resultSet, imageListModel);
            imageList.setModel(imageListModel);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void loadAllImagesFromDatabase() {
        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM product");
             ResultSet resultSet = preparedStatement.executeQuery()) {

            DefaultListModel<Icon> imageListModel = new DefaultListModel<>();
            DatabaseAccessor databaseAccessor = new DatabaseAccessor();
            databaseAccessor.loadImagesFromResultSet(resultSet, imageListModel);
            imageList.setModel(imageListModel);

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private void handleSearch() {
        String searchTerm = search.getText();
        String query = "SELECT * FROM product WHERE name LIKE ? OR price = ? OR rule = ?";

        try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
             PreparedStatement preparedStatement = connection.prepareStatement(query)) {

            preparedStatement.setString(1, "%" + searchTerm + "%");
            try {
                int price = Integer.parseInt(searchTerm);
                preparedStatement.setInt(2, price);
            } catch (NumberFormatException ignored) {
                preparedStatement.setNull(2, Types.INTEGER);
            }
            preparedStatement.setString(3, searchTerm);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                DefaultListModel<Icon> imageListModel = new DefaultListModel<>();
                DatabaseAccessor databaseAccessor = new DatabaseAccessor();
                databaseAccessor.loadImagesFromResultSet(resultSet, imageListModel);
                imageList.setModel(imageListModel);
            }

        } catch (SQLException | IOException e) {
            e.printStackTrace();
        }
    }

    private int getImageIdFromIcon(Icon selectedIcon) {
        return DatabaseAccessor.imageListIdMapping.getOrDefault(selectedIcon, -1);
    }

    private Color getNextColor() {
        Color[] colors = {Color.PINK, Color.BLUE, Color.RED, Color.BLACK};
        Color nextColor = colors[colorIndex];
        colorIndex = (colorIndex + 1) % colors.length;
        return nextColor;
    }

    private void startColorChangingTimer() {
        Timer timer = new Timer(200, e -> allCarsLabel.setForeground(getNextColor()));
        timer.start();
    }

    private static class DatabaseAccessor {
        private static final String JDBC_URL = "jdbc:mysql://localhost:3306/user";
        private static final String USERNAME = "root";
        private static final String PASSWORD = "mysql";
        private static final Map<Icon, Integer> imageListIdMapping = new ConcurrentHashMap<>();

        public void loadImagesFromDatabase(DefaultListModel<Icon> imageListModel) {
            ExecutorService executorService = Executors.newFixedThreadPool(10);

            executorService.submit(() -> {
                try (Connection connection = DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD)) {
                    String sql = "SELECT * FROM product";

                    try (PreparedStatement preparedStatement = connection.prepareStatement(sql);
                         ResultSet resultSet = preparedStatement.executeQuery()) {

                        loadImagesFromResultSet(resultSet, imageListModel);
                    }
                } catch (SQLException | IOException e) {
                    e.printStackTrace();
                }
            });

            executorService.shutdown();
            try {
                executorService.awaitTermination(10, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void loadImagesFromResultSet(ResultSet resultSet, DefaultListModel<Icon> imageListModel) throws SQLException, IOException {
            while (resultSet.next()) {
                String imageUrl = resultSet.getString("url");
                int idProduct = resultSet.getInt("id");
                loadAndAddImage(imageUrl, idProduct, imageListModel);
            }
        }

        private void loadAndAddImage(String imageUrl, int imageId, DefaultListModel<Icon> imageListModel) {
            try {
                URL url = new URL(imageUrl);
                BufferedImage image = ImageIO.read(url);

                if (image != null) {
                    ImageIcon icon = new ImageIcon(image.getScaledInstance(200, 100, Image.SCALE_SMOOTH));
                    SwingUtilities.invokeLater(() -> {
                        imageListModel.addElement(icon);
                        imageListIdMapping.put(icon, imageId);
                    });
                }
            } catch (IOException e) {
                e.printStackTrace();
                System.err.println("Error loading image from URL: " + imageUrl);
            }
        }
    }
}
