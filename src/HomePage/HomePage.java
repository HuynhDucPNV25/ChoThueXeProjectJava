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

	
}