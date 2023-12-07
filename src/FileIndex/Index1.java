package FileIndex;

import javax.swing.SwingUtilities;

// Import class LoginPage hoặc tên class chứa trang login của bạn
import LoginPage.LoginPage;

public class Index1 {
    public static void main(String[] args) {
        // Sử dụng SwingUtilities để đảm bảo mã chạy trên EDT (Event Dispatch Thread)
        SwingUtilities.invokeLater(() -> {
            try {
                // Tạo một đối tượng trang login và hiển thị nó
                LoginPage loginPage = new LoginPage();
                loginPage.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
