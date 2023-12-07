package BookingPage;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class CongratulationsPage extends JPanel {

    private Image[] images;
    private int currentImageIndex;

    // Constructor không có tham số
    public CongratulationsPage() {
        // Mảng mặc định của các đường dẫn hình ảnh
        String[] defaultImagePaths = {
                "src/image1.png",
                "src/image2.png",
                "src/image3.png",
                "src/image4.png"
        };

        images = new Image[defaultImagePaths.length];
        for (int i = 0; i < defaultImagePaths.length; i++) {
            String imagePath = defaultImagePaths[i];
            try {
                images[i] = ImageIO.read(new File(imagePath));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        currentImageIndex = 0;

        Timer timer = new Timer(1000, e -> {
            currentImageIndex = (currentImageIndex + 1) % images.length;
            repaint();
        });
        timer.start();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image currentImage = images[currentImageIndex];
        g.drawImage(currentImage, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        Image currentImage = images[currentImageIndex];
        return new Dimension(currentImage.getWidth(null), currentImage.getHeight(null));
    }

    public static void main(String[] args) {
    	
    	SwingUtilities.invokeLater(() -> {
    	    JFrame frame = new JFrame("Animated Image Display");
    	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	    frame.getContentPane().add(new CongratulationsPage());
    	    frame.pack();
    	    frame.setVisible(true);
    	});

    }
}
